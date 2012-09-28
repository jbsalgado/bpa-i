/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Usuario;
import br.gov.saudecaruaru.bpai.data.UsuarioDAO;

/**
 *
 * @author Albuquerque
 */
public class UsuarioController extends BasecController<Usuario> {

    public UsuarioController() {
        super(new UsuarioDAO());
    }
    
    
}
