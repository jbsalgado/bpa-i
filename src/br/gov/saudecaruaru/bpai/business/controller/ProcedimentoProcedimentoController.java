/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoProcedimento;
import br.gov.saudecaruaru.bpai.data.ProcedimentoProcedimentoDAO;
/**
 *
 * @author Albuquerque
 */
public class ProcedimentoProcedimentoController extends BasecController<ProcedimentoProcedimento> {

    public ProcedimentoProcedimentoController() {
        super(new ProcedimentoProcedimentoDAO());
    }
    
    
}
