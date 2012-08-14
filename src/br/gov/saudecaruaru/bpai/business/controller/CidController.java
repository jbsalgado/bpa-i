/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Cid;
import br.gov.saudecaruaru.bpai.data.CidDAO;
import br.gov.saudecaruaru.bpai.data.GenericDAO;

/**
 *
 * @author Junior Pires
 */
public class CidController extends BasecController<Cid>{

    public CidController() {
        super(new CidDAO());
    }
    
}
