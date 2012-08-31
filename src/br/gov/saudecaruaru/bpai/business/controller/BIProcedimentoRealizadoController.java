/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public class BIProcedimentoRealizadoController extends BasecController<BIProcedimentoRealizado> {

    public BIProcedimentoRealizadoController() {
        super(new BIProcedimentoRealizadoDAO());
    }
    
    
    public void salvar(List<ProcedimentoRealizado> procedimentosRealizados){
        for(ProcedimentoRealizado p : procedimentosRealizados){
            salvar(new BIProcedimentoRealizado(p));
        }
    }
    
    
    
}
