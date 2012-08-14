/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoCid;
import br.gov.saudecaruaru.bpai.data.GenericDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoCidDAO;
import java.io.Serializable;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoCidController extends BasecController<ProcedimentoCid> {

    public ProcedimentoCidController() {
        super(new ProcedimentoCidDAO());
    }
    
    
}
