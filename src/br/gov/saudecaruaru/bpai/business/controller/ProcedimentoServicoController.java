/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoServico;
import br.gov.saudecaruaru.bpai.data.ProcedimentoServicoDAO;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoServicoController extends BasecController<ProcedimentoServico> {

    public ProcedimentoServicoController() {
        super(new ProcedimentoServicoDAO());
    }
    
    
}
