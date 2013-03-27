/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;


import br.gov.saudecaruaru.bpai.business.model.BIGestorCompetencia;
import br.gov.saudecaruaru.bpai.data.BIGestorCompetenciaDAO;
import br.gov.saudecaruaru.bpai.data.GestorCompetenciaDAO;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public class BIGestorCompetenciaController extends BasecController<BIGestorCompetencia> 

{

    public BIGestorCompetenciaController() {
        super(new BIGestorCompetenciaDAO());
    }
    
    
    public String getCompetenciaAtual(){
        
        List<BIGestorCompetencia> list = findAll();
        if( list == null ? false : !list.isEmpty()){
            BIGestorCompetencia g=list.get(0);
            if(g instanceof BIGestorCompetencia && g!=null){
            String competencia = list.get(0).getCompetenciaMovimento();
                return competencia;
            }
        }
        return "";
    }
    
    public boolean haveCompetencia(){
        List<BIGestorCompetencia> list = findAll();
        if(list.isEmpty()){
            return false;
        }
        return true;
    }
    
    public boolean comparaCompetencias(){
        
        if(!this.getCompetenciaAtual().equals(new GestorCompetenciaDAO().getCompetenciaMovimento())){
            return false;
        }
        return true;
    }
    
    
}
