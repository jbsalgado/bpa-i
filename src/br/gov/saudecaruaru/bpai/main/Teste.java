/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.controller.SistemaController;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoServico;
import br.gov.saudecaruaru.bpai.data.DiversasDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoServicoDAO;
import java.awt.SystemColor;

/**
 *
 * @author Albuquerque
 */
public class Teste {
    public static void main(String[] args){
        SistemaController.loadConfigurations();
        testeDiversasServicos();
        testeDiversasTabelaClassificacaoServico();
    }
    
    public static void testeDiversasServicos(){
        DiversasDAO di= new DiversasDAO();
        ProcedimentoRealizado pro= new ProcedimentoRealizado(new ProcedimentoRealizadoPK());
        pro.getProcedimentoRealizadoPK().setCompetencia("201208");
        pro.setCodigoProcedimento("0102010420");
        for(Diversas d: di.findAllServicos(pro)){
            System.out.println(d.getDiversasPK().getCodigoItemTabela()+d.getDescricaoItemTabela());
        }
    }
    public static void testeDiversasTabelaClassificacaoServico(){
        DiversasDAO di= new DiversasDAO();
        ProcedimentoRealizado pro= new ProcedimentoRealizado(new ProcedimentoRealizadoPK());
        pro.getProcedimentoRealizadoPK().setCompetencia("201208");
        pro.setCodigoProcedimento("0102010420");
        for(Diversas d: di.findAllClassificacaoServico(pro)){
            System.out.println(d.getDiversasPK().getCodigoItemTabela()+d.getDescricaoItemTabela());
        }

        
    }
}
