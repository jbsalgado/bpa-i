/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimento;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoDAO;
/**
 *
 * @author Albuquerque
 */
public class BIProcedimentoController extends BasecController<BIProcedimento> {

    public BIProcedimentoController() {
        super(new BIProcedimentoDAO());
    }    
    
}
