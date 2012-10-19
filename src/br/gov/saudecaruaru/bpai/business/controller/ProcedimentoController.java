/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.data.ProcedimentoDAO;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoController extends BasecController<Procedimento> {

    
    public ProcedimentoController() {
        super(new ProcedimentoDAO());
    }
    
    
    public String getMaxCompetencia(){
        return ((ProcedimentoDAO)this.getDao()).getMaxCompetencia();
    }
    
}
