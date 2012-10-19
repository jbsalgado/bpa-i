/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.EquipeController;
import br.gov.saudecaruaru.bpai.business.controller.SistemaController;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.Equipe;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.data.DiversasDAO;
import br.gov.saudecaruaru.bpai.data.HibernateUtil;
import br.gov.saudecaruaru.bpai.data.ProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import org.apache.log4j.Logger;
/**
 *
 * @author Albuquerque
 */
public class Teste {
    public static void main(String[] args){
//        SistemaController.loadConfigurations();
//        HibernateUtil.createIndices();
//        testeExportacaoProcedimentosIndividuais();
//        testeExportacaoProcedimentosCosolidados();
//        testeEquipes();
        //init();
        Logger log= Logger.getLogger(Teste.class);
        log.debug("testando pow...");
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
    
    public static void testeExportacaoProcedimentosIndividuais(){
        BIProcedimentoRealizadoController con= new BIProcedimentoRealizadoController();
        //con.findAllProcedimentosIndividuaisAndSave(null, new ProcedimentoRealizadoDAO(), 50);
    }
    
    public static void testeExportacaoProcedimentosCosolidados(){
        BIProcedimentoRealizadoController con= new BIProcedimentoRealizadoController();
        //con.findAllProcedimentosConsolidadosAndSave(null, new ProcedimentoRealizadoDAO(), 50);
    }
    
    public static void testeEquipes(){
        EquipeController equipe= new EquipeController();
        for(Equipe e: equipe.findAll()){
            System.out.println(e);
        }
    }
    
    public static void init(){
        HibernateUtil.createIndices();
    }
    
    
}
