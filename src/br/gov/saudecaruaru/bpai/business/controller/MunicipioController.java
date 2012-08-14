/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Municipio;
import br.gov.saudecaruaru.bpai.data.MunicipioDAO;

/**
 *
 * @author Albuquerque
 */
public class MunicipioController extends BasecController<Municipio> {

    public MunicipioController() {
        super(new MunicipioDAO());
    }
    
    
}
