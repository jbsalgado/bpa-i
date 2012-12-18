/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Equipe;
import br.gov.saudecaruaru.bpai.data.EquipeDAO;

/**
 *
 * @author Albuquerque
 */
public class EquipeController extends BasecController<Equipe>{

    public EquipeController() {
        super(new EquipeDAO());
    }
    
        
    public String getMaximaCompetencia(){
        EquipeDAO dao= (EquipeDAO)this.getDao();
        return dao.getMaxCompetencia();
    }
}
