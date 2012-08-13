/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Acesso;
import br.gov.saudecaruaru.bpai.data.AcessoDAO;

/**
 *
 * @author Junior Pires
 */
public class AcessoController extends BasecController<Acesso> {

    public AcessoController() {
        super(new AcessoDAO());
    }
    
    
}
