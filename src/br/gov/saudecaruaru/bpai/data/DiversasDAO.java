/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoServico;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Junior Pires
 */
public class DiversasDAO extends GenericDAO<Diversas> {
 
    /**
     * Pega todos os serviços que o procedimento tenha
     * @param pro ProcedimentoRealizado: usa o código do procedimento e a competência
     * @return lista com todos os serviços
     */
    public List<Diversas> findAllServicos(ProcedimentoRealizado pro){
        List<Diversas> diver= new ArrayList<Diversas>();
        List<Object[]> objects=null;
        Session session=this.getSession();
        try{
            StringBuilder sql= new StringBuilder();
            sql.append(" SELECT di.diversasPK.codigoTabela,di.diversasPK.codigoItemTabela,di.descricaoItemTabela, ");
            sql.append(" pro.temAuxiliar FROM Diversas di, br.gov.saudecaruaru.bpai.business.model.ProcedimentoServico pro ");
            sql.append(" WHERE (di.diversasPK.codigoTabela=:tabela AND di.diversasPK.codigoItemTabela=pro.procedimentoServicoPK.servico");
            sql.append(" AND pro.procedimentoServicoPK.codigoProcedimento=:procedimento )");//AND pro.procedimentoServicoPK.competencia=:competencia)");
//            sql.append(" WHERE (di.diversasPK.codigoTabela='"+Diversas.TABELA_SERVICO+"' AND di.diversasPK.codigoItemTabela=pro.procedimentoServicoPK.servico");
//            sql.append(" AND pro.procedimentoServicoPK.codigoProcedimento='"+pro.getCodigoProcedimento().substring(0, 9)+"' AND pro.procedimentoServicoPK.competencia='"+pro.getProcedimentoRealizadoPK().getCompetencia()+"')");
            Query query=session.createQuery(sql.toString());
            query.setParameter("tabela", Diversas.TABELA_SERVICO);
            query.setParameter("procedimento", pro.getCodigoProcedimento().substring(0, 9));
            //query.setParameter("competencia", pro.getProcedimentoRealizadoPK().getCompetencia());
            objects=query.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            session.close();
            if(!objects.isEmpty()){
                for(Object[] vet:objects){
                    Diversas di= new Diversas(new DiversasPK((String)vet[0],(String) vet[1]));
                    di.setDescricaoItemTabela((String)vet[2]);
                    diver.add(di);
                }
            }
            return diver;
        }
        
    }

    /**
     * Pega todas as classificações de um serviço
     * @param pro ProcedimentoRealizado - vai usar o codigo do procedimento e a competência
     * @return Devolve a lista de classificações do serviço
     */
    public List<Diversas> findAllClassificacaoServico(ProcedimentoRealizado pro){
        List<Diversas> diver= new ArrayList<Diversas>();
        List<Object[]> objects=null;
        Session session=this.getSession();
        try{
            StringBuilder sql= new StringBuilder();
            sql.append(" SELECT di.diversasPK.codigoTabela,di.diversasPK.codigoItemTabela,di.descricaoItemTabela");
            sql.append(" FROM Diversas di, br.gov.saudecaruaru.bpai.business.model.ProcedimentoServico pro ");
            sql.append(" WHERE (di.diversasPK.codigoTabela=:tabela AND di.diversasPK.codigoItemTabela=concat(pro.procedimentoServicoPK.servico,concat(pro.procedimentoServicoPK.classificacaoServico,'  '))");
            sql.append(" AND pro.procedimentoServicoPK.codigoProcedimento=:procedimento )");//AND pro.procedimentoServicoPK.competencia=:competencia)");
            Query query=session.createQuery(sql.toString());
            query.setParameter("tabela", Diversas.TABELA_CLASSIFICACAO_SERVICO);
            query.setParameter("procedimento", pro.getCodigoProcedimento().substring(0, 9));
            //query.setParameter("competencia", pro.getProcedimentoRealizadoPK().getCompetencia());
            objects=query.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            session.close();
            if(!objects.isEmpty()){
                for(Object[] vet:objects){
                    Diversas di= new Diversas(new DiversasPK((String)vet[0],(String) vet[1]));
                    di.setDescricaoItemTabela((String)vet[2]);
                    diver.add(di);
                }
            }
            return diver;
        }
        
    }
}
