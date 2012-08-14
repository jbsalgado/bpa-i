/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.data.DiversasDAO;



/**
 *
 * @author Junior Pires
 */
public class DiversasController extends BasecController<Diversas> {

    public DiversasController() {
        super(new DiversasDAO());
    }
    
}
