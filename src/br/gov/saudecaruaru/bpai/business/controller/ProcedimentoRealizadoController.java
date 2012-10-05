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

    public ProcedimentoRealizadoController() {
        super(new ProcedimentoRealizadoDAO());
    }
    
    public List<ProcedimentoRealizado> findAllOnlyHeader(){
        return ((ProcedimentoRealizadoDAO)this.getDao()).findAllOnlyHeader();
    }
    
    public List<String> validate(ProcedimentoRealizado p){
        List<String> list = new ArrayList<String>();
        ProcedimentoRealizadoValidator prv = new ProcedimentoRealizadoValidator(p);
        //if(!prv.existeProcedimento().isEmpty())
            list.add(prv.validExisteProcedimento());
        
        return list;
        
        
    }
}
