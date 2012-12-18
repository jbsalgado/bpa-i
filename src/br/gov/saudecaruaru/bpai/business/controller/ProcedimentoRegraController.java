/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRegra;
import br.gov.saudecaruaru.bpai.data.ProcedimentoRegraDAO;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoRegraController extends BasecController<ProcedimentoRegra> {

    public ProcedimentoRegraController() {
        super(new ProcedimentoRegraDAO());
    }

}
