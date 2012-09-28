/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Paciente;
import br.gov.saudecaruaru.bpai.data.PacienteDAO;

/**
 *
 * @author Albuquerque
 */
public class PacienteController extends BasecController<Paciente> {

    public PacienteController() {
        super(new PacienteDAO());
    }
   
    
}
