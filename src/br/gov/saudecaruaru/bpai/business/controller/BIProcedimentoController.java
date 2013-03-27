/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimento;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoPK;
import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoDAO;
import br.gov.saudecaruaru.bpai.data.BIGestorCompetenciaDAO;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Albuquerque
 */
public class BIProcedimentoController extends BasecController<BIProcedimento> {

    public BIProcedimentoController() {
        super(new BIProcedimentoDAO());
    }    
    
    
    public void insereProcedimentosSemReferencia(){
        BIProcedimentoRealizadoController prc = new BIProcedimentoRealizadoController();
        ProcedimentoController pc = new ProcedimentoController();
        BIGestorCompetenciaController competenciaController = new BIGestorCompetenciaController();
        
        
        
        //busca todos os procedimentos sem referencia na tabela procedimento 
        List<String> listProcedimentos = prc.getAllCodigoProcedimentoSemReferencia(competenciaController.getCompetenciaAtual());
        if(!listProcedimentos.isEmpty()){
            //map com o nome do campo e os valores que se deseja buscar
            HashMap<String,List<String>> restrictions = new HashMap<String, List<String>>();
            List<String> competencias = new ArrayList<String>();
            competencias.add(ModelUtil.COMPETENCIA_MAIS_RECENTE);
            restrictions.put("procedimentoPk.id",listProcedimentos);
            restrictions.put("procedimentoPk.competencia",competencias);
            
            //busca esses procedimentos
            List<Procedimento> procedimentos = pc.findAllEqualInMap(restrictions);
            if(!procedimentos.isEmpty()){
                List<BIProcedimento> listBIProcedimentos = new ArrayList<BIProcedimento>();
                //transforma os procedimentos em BIProcedimentos
                for (Procedimento procedimento : procedimentos) {
                    listBIProcedimentos.add(new BIProcedimento(procedimento));
                }

                //salva ou atualiza esses procedimentos no banco
                this.merge(listBIProcedimentos);
            }
        }
    }
    
}
