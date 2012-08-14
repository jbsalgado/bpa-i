/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Medico;
import br.gov.saudecaruaru.bpai.data.MedicoDAO;

/**
 *
 * @author Albuquerque
 */
public class MedicoController extends BasecController<Medico> {

    public MedicoController() {
        super(new MedicoDAO());
    }
    
    
}
