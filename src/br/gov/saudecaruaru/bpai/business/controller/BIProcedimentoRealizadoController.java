/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoRealizadoDAO;
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
        //salvando uma lista de procedimentos
        for(ProcedimentoRealizado p : procedimentosRealizados){
            salvar(new BIProcedimentoRealizado(p));
        }
    }
    
    
    public void findAllProcedimentosConsolidadosAndSave(String competencia,ProcedimentoRealizadoDAO procedimentoDao, int maxResults){
        //folha a ser gerada
        int folha=1;
        int size=maxResults;
        int offset=0;
        int seq=1;
        BIProcedimentoRealizadoDAO dao= (BIProcedimentoRealizadoDAO)this.getDao();
        //list para armazenar os procedimentos consolidados
        List<ProcedimentoRealizado> list=null;
        while(size==maxResults){
            list=dao.findAllConsolidados(competencia, offset, maxResults);
            size=list.size();
            //gerar a sequência e a folha
            for(int i=0; i<size;i++){
                
               ProcedimentoRealizadoPK p=list.get(i).getProcedimentoRealizadoPK();
               p.setNumeroFolha(""+folha);
               p.setSequenciaFolha(""+seq);
                //incrementa a folha e inicia uma nova sequencia
                if(seq==20){
                    folha++;
                    seq=1;
                }
              //incrementa a sequência
               seq++;
            }
            procedimentoDao.save(list);
            //incrementa a pagicacao
            offset+=maxResults;
        }
    }
    
}
