/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.MedicoCboCnes;
import br.gov.saudecaruaru.bpai.data.MedicoCboCnesDAO;

/**
 *
 * @author Albuquerque
 */
public class MedicoCboCnesController extends BasecController<MedicoCboCnes> {

    public MedicoCboCnesController() {
        super(new MedicoCboCnesDAO());
    }
    
}
