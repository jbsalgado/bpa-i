/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;


import br.gov.saudecaruaru.bpai.business.model.GestorCompetencia;
import br.gov.saudecaruaru.bpai.data.GestorCompetenciaDAO;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public class GestorCompetenciaController extends BasecController<GestorCompetencia> 

{

    public GestorCompetenciaController() {
        super(new GestorCompetenciaDAO());
    }
    
    
    public String getCompetenciaAtual(){
        
        List<GestorCompetencia> list = findAll();
        if(!list.isEmpty()){
            GestorCompetencia g=list.get(0);
            if(g instanceof GestorCompetencia && g!=null){
            String competencia = list.get(0).getCompetenciaMovimento();
                return competencia;
            }
        }
        return "";
    }
    
    
    
    
}
