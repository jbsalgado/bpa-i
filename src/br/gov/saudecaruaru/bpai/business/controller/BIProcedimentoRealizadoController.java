/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public class BIProcedimentoRealizadoController extends BasecController<BIProcedimentoRealizado> {

    public BIProcedimentoRealizadoController() {
        super(new BIProcedimentoRealizadoDAO());
    }
    
    public List<ProcedimentoRealizado> findAllOnlyHeader(String competencia){
        return ((BIProcedimentoRealizadoDAO)this.getDao()).findAllOnlyHeader(competencia);
    }
    
    public List<ProcedimentoRealizado> findAllOnlyHeaderEqual(BIProcedimentoRealizado p){
        return ((BIProcedimentoRealizadoDAO)this.getDao()).findAllOnlyHeaderEqual(p);
    }
    
    public String getNextFolha(BIProcedimentoRealizado BIProcedimentoRealizado){
        return ((BIProcedimentoRealizadoDAO)this.getDao()).getNextFolha(BIProcedimentoRealizado);
    }
    

    
    
    public boolean findAllProcedimentosConsolidadosAndSave(String competenciaMovimento, String cnesUnidade,ProcedimentoRealizadoDAO procedimentoDao, int maxResults){
        //folha a ser gerada
        boolean sucess=false;
            try{
            int folha=1;
            int size=maxResults;
            int offset=0;
            int seq=1;
            BIProcedimentoRealizadoDAO dao= (BIProcedimentoRealizadoDAO)this.getDao();
            //list para armazenar os procedimentos consolidados
            List<ProcedimentoRealizado> list=null;
            while(size==maxResults){
                list=dao.findAllConsolidados(competenciaMovimento, cnesUnidade, offset, maxResults);
                size=list.size();
                //gerar a sequência e a folha
                for(int i=0; i<size;i++){

                   ProcedimentoRealizadoPK p=list.get(i).getProcedimentoRealizadoPK();
                   p.setNumeroFolha(ModelUtil.completar(""+folha, 3, '0'));
                   p.setSequenciaFolha(ModelUtil.completar(""+seq, 2, '0'));

                    //incrementa a folha e inicia uma nova sequencia
                    if(seq==ProcedimentoRealizado.MAXIMA_QUANTIDADE_SEQUENCIA){
                        //verifica se a quantidade de folhas chegou ao limite
                        if(folha==ProcedimentoRealizado.MAXIMA_QUANTIDADE_FOLHA){
                            folha=0;
                        }
                        //incrementa a folha
                        folha++;
                        seq=0;
                    }
                  //incrementa a sequência
                   seq++;
                }
                //salva a lista no banco de dados
                procedimentoDao.save(list);
                list.clear();
                //incrementa a pagicacao
                offset+=maxResults;
            }
            sucess=true;
        }catch(Exception ex){
            
        }
        finally{
            return sucess;
        }
    }
    
    public boolean findAllProcedimentosIndividuaisAndSave(String competenciaMovimento, String cnesUnidade,ProcedimentoRealizadoDAO procedimentoDao, int maxResults){
        boolean sucess=false;
        try{
        BIProcedimentoRealizadoDAO dao=(BIProcedimentoRealizadoDAO)this.getDao();
        
        int size=maxResults;
        int offset=0;
        List<ProcedimentoRealizado> list=null;
        
        while(size==maxResults){
            list=dao.findAllProcedimentosIndividuais(competenciaMovimento, cnesUnidade, offset, maxResults);
            size=list.size();
            //salva os procedimentos no banco de dados do BPA
            procedimentoDao.save(list);
            //incremeta a linha que deve ser buscada
            offset+=maxResults;
            list.clear();
        }
        sucess=true;
        }catch(Exception ex){
        
        }
        finally{
            return sucess;
        }
    }
    public List<BIProcedimentoRealizado> parserProcedimentoRealizadoToBIProcedimentoRealizado(List<ProcedimentoRealizado> list){
        List<BIProcedimentoRealizado> l= new ArrayList<BIProcedimentoRealizado>();
        for(ProcedimentoRealizado p: list){
            l.add(new BIProcedimentoRealizado(p));
        }
        return l;
    }
    
    public List<ProcedimentoRealizado> parserBIProcedimentoRealizadoToProcedimentoRealizado(List<BIProcedimentoRealizado> list){
        List<ProcedimentoRealizado> l= new ArrayList<ProcedimentoRealizado>();
        for(BIProcedimentoRealizado p: list){
            l.add(new ProcedimentoRealizado(p));
        }
        return l;
    }
    
    public List<String> getTodasCompetenciaMovimento(){
        return ((BIProcedimentoRealizadoDAO)this.getDao()).getAllCompetenciaMovimento();
    }
    
    public List<String> getAllUnidade(){
        return ((BIProcedimentoRealizadoDAO)this.getDao()).getAllUnidade();
    }
}
