/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.data.DiversasDAO;
import java.util.List;



/**
 *
 * @author Junior Pires
 */
public class DiversasController extends BasecController<Diversas> {

    public DiversasController() {
        super(new DiversasDAO());
    }
    
    /**
     * Pega todos os serviços que o procedimento tenha
     * @param pro ProcedimentoRealizado: usa o código do procedimento e a competência
     * @return lista com todos os serviços
     */
    public List<Diversas> findAllServicos(ProcedimentoRealizado pro){
        return ((DiversasDAO)this.getDao()).findAllServicos(pro);
    }
    
    /**
     * Pega todas as classificações de um serviço
     * @param pro ProcedimentoRealizado - vai usar o codigo do procedimento e a competência
     * @return Devolve a lista de classificações do serviço
     */
    public List<Diversas> findAllClassificacaoServico(ProcedimentoRealizado pro){
        return ((DiversasDAO)this.getDao()).findAllClassificacaoServico(pro);    
    }
}
