/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoenca;
import br.gov.saudecaruaru.bpai.data.GenericDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoDoencaDAO;
import java.io.Serializable;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoDoencaController extends BasecController<ProcedimentoDoenca> {

    public ProcedimentoDoencaController() {
        super(new ProcedimentoDoencaDAO());
    }
    
    
}
