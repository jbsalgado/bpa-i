/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;


import br.gov.saudecaruaru.bpai.business.model.GestorCompetencia;
import br.gov.saudecaruaru.bpai.business.model.GestorCompetenciaPK;
import br.gov.saudecaruaru.bpai.data.GestorCompetenciaDAO;
import java.io.Serializable;
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
        GestorCompetenciaPK competenciaPK= new GestorCompetenciaPK();
        GestorCompetencia gestorCompetencia = new GestorCompetencia();
        
        List<GestorCompetencia> list = findAll();
        String competencia = list.get(0).getGestorCompetenciaPK().getCompetenciaMovimento();
      
        
        return competencia;
    }
    
    
    
    
}
