/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.validators.ProcedimentoRealizadoValidator;
import br.gov.saudecaruaru.bpai.data.ProcedimentoRealizadoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoRealizadoController extends BasecController<ProcedimentoRealizado> {
    private List<String> listErros;
    
    public ProcedimentoRealizadoController() {
        super(new ProcedimentoRealizadoDAO());
    }
    
    public List<ProcedimentoRealizado> findAllOnlyHeader(){
        return ((ProcedimentoRealizadoDAO)this.getDao()).findAllOnlyHeader();
    }
    
    public String validateProcedimento(ProcedimentoRealizado p){
        listErros = new ArrayList<String>();
        ProcedimentoRealizadoValidator prv = new ProcedimentoRealizadoValidator(p);
        //if(!prv.existeProcedimento().isEmpty())
            String msgs ="";
            this.addListErros(prv.validProcedimentoSexo());
            this.addListErros(prv.validProcedimentoIdadeMaxMin());
            this.addListErros(prv.validProcedimentoDoenca());
            this.addListErros(prv.validDoencaIncompativelProcedimento());
            if(!listErros.isEmpty()){
                for(String msg :listErros){
                    msgs+=msg+"\n";
                }
            }     
        
        return msgs;
        
        
    }
    
     public List<String> validateList(ProcedimentoRealizado p){
        listErros = new ArrayList<String>();
        ProcedimentoRealizadoValidator prv = new ProcedimentoRealizadoValidator(p);
        //if(!prv.existeProcedimento().isEmpty())  
            this.addListErros(prv.validProcedimentoSexo());
            this.addListErros(prv.validProcedimentoIdadeMaxMin());
            this.addListErros(prv.validProcedimentoDoenca());
            this.addListErros(prv.validDoencaIncompativelProcedimento());
            
        
        return listErros;
        
        
    }

    /**
     * @param listErros the listErros to set
     */
    public void addListErros(String item) {
        if( this.listErros!=null){
            if(item!=null){
                if(!item.equals("")){
                    this.listErros.add(item);
                }
            }
        }
    }
}
