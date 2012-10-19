/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoCbo;
import br.gov.saudecaruaru.bpai.data.ProcedimentoCboDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoDAO;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoCboController extends BasecController<ProcedimentoCbo> {

    public ProcedimentoCboController() {
        super(new ProcedimentoCboDAO());
    }
    
}
