/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;


import br.gov.saudecaruaru.bpai.business.model.Doenca;
import br.gov.saudecaruaru.bpai.data.DoencaDAO;


/**
 *
 * @author Junior Pires
 */
public class DoencaController extends BasecController<Doenca>{

    public DoencaController() {
        super(new DoencaDAO());
    }
    
}
