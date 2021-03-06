/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Albuquerque
 */
public class BIProcedimentoRealizadoDAO extends GenericDAO<BIProcedimentoRealizado> {

    private static Logger logger = Logger.getLogger(BIProcedimentoRealizadoDAO.class);

    public BIProcedimentoRealizadoDAO() {
        //super(EntityManagerUtil.getEntityManagerI());
    }

    public String getNextFolha(BIProcedimentoRealizado BIProcedimentoRealizado) {
        Session session = this.getSession();
        List l = null;
        try {
            StringBuilder sql = new StringBuilder();
            //campos a serem selecionados
            sql.append("select MAX(pro.biProcedimentoRealizadoPK.numeroFolha)");
            sql.append(" FROM BIProcedimentoRealizado pro");
            //traz somente os procedimentos que devem ser consolidados
            sql.append(" WHERE (pro.biProcedimentoRealizadoPK.cnesUnidade=:cnesUnidade)");
            sql.append(" AND (pro.biProcedimentoRealizadoPK.competencia=:competencia)");
            sql.append(" AND (pro.biProcedimentoRealizadoPK.cboMedico=:cbo)");
            sql.append(" AND (pro.biProcedimentoRealizadoPK.cnsMedico=:cnsMedico)");

            //it's create query
            Query q = session.createQuery(sql.toString());
            q.setParameter("cnesUnidade", BIProcedimentoRealizado.getBiProcedimentoRealizadoPK().getCnesUnidade());
            q.setParameter("competencia", BIProcedimentoRealizado.getBiProcedimentoRealizadoPK().getCompetencia());
            q.setParameter("cbo", BIProcedimentoRealizado.getBiProcedimentoRealizadoPK().getCboMedico());
            q.setParameter("cnsMedico", BIProcedimentoRealizado.getBiProcedimentoRealizadoPK().getCnsMedico());

            l = q.list();
            String f = "";
            String folha = null;
            for (Object row : l) {
                folha = (String) row;
            }
            if (folha != null) {
                int nextFolha = (Integer.parseInt(folha) + 1);
                f = String.format("%03d", nextFolha);
            }
            return f;
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ao executar o método getNextFolha " + ex.getMessage());
            return "";
        }
    }

    /**
     * Pega todos os procedimentos consolidados de forma páginada, mas de forma agrupada pelos seguintes campos:
     * Cnes da unidade, CBO do profissional, Idade do paciente, código do procedimento e competência
     * @param competencia - competência dos registros
     * @param firstResult - o index do primeiro registro
     * @param maxResult -  a quantidade máxima de resultados resultados
     * @return  Lista de com os procedimentos realizados
     */
    public List<ProcedimentoRealizado> findAllConsolidados(String competenciaMovimento, String cnesUnidade, int firstResult, int maxResult) {
        List<Object[]> l = null;
        Session session = this.getSession();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.cboMedico,");
            sql.append(" pro.codigoProcedimento, pro.biProcedimentoRealizadoPK.competencia, pro.competenciaMovimento, ");
            //faz o somatório da quantidade de execuções
            sql.append("SUM(pro.quantidadeRealizada) AS quantidadeRealizada");
            sql.append(" FROM BIProcedimentoRealizado pro,BIProcedimento p");
            //traz somente os procedimentos que devem ser consolidados
            sql.append(" WHERE (pro.origemProcedimento=:origem AND p.exigeIdadeBPA=:exige");
            sql.append(" AND pro.competenciaMovimento=:competenciaMovimento ");
            sql.append(" AND pro.codigoProcedimento=concat(p.bIprocedimentoPk.id,p.bIprocedimentoPk.digitoVerificador)");
            //sql.append(" AND pro.competenciaMovimento=p.bIprocedimentoPk.competencia ");
            sql.append(" AND pro.biProcedimentoRealizadoPK.cnesUnidade=:cnesUnidade )");
            //agrupa
//            sql.append(" GROUP BY pro.biProcedimentoRealizadoPK.competencia,pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.cboMedico,");
//            sql.append(" pro.codigoProcedimento,pro.competenciaMovimento");
            sql.append(" GROUP BY pro.competenciaMovimento,pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.cboMedico,");
            sql.append(" pro.codigoProcedimento,pro.biProcedimentoRealizadoPK.competencia");
            //ordena
            sql.append(" ORDER BY pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.competencia");
            //it's create query
            Query q = session.createQuery(sql.toString());
            q.setParameter("origem", ProcedimentoRealizado.ORIGEM_CONSOLIDADO);
            q.setParameter("exige", Procedimento.NAO_EXIGE_IDADE);
            q.setParameter("competenciaMovimento", competenciaMovimento);
            q.setParameter("cnesUnidade", cnesUnidade);
            //paginacao dos resultados
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResult);
            l = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ao executar o método findAllConsolidados " + ex.getMessage());
        } finally {
            //session.flush();
            session.close();
            List<ProcedimentoRealizado> list = new ArrayList<ProcedimentoRealizado>();
            if (l != null) {
                //cada objeto de l contém um vetor que representa os campos selecionados
                for (Object[] row : l) {
                    ProcedimentoRealizado pro = new ProcedimentoRealizado(new ProcedimentoRealizadoPK());

                    //o tamanho do vetor é igual a quantidade de campos do select
                    //o índíce do campo no select é igual ao do vetor, começando por zero.
                    pro.getProcedimentoRealizadoPK().setCnesUnidade((String) row[0]);
                    pro.getProcedimentoRealizadoPK().setCboMedico((String) row[1]);
                    pro.setIdadePaciente("000");
                    pro.setCodigoProcedimento((String) row[2]);
                    pro.getProcedimentoRealizadoPK().setCompetencia((String) row[3]);
                    pro.setCompetenciaMovimento((String) row[4]);
                    pro.setQuantidadeRealizada((Double) row[5]);

                    //valores padrões

                    pro.setOrigemProcedimento(ProcedimentoRealizado.ORIGEM_CONSOLIDADO);
                    pro.preencherAtributosVazios();

                    list.add(pro);
                }
                l.clear();
            }
            return list;
        }
    }

    public List<ProcedimentoRealizado> findAllConsolidadosPorIdade(String competenciaMovimento, String cnesUnidade, int firstResult, int maxResult) {
        List<Object[]> l = null;
        Session session = this.getSession();
        try {
            StringBuilder sql = new StringBuilder();
            //campos a serem selecionados
            sql.append("SELECT  pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.cboMedico,");
            sql.append("pro.idadePaciente, pro.codigoProcedimento, pro.biProcedimentoRealizadoPK.competencia, pro.competenciaMovimento, ");
            //faz o somatório da quantidade de execuções
            sql.append("SUM(pro.quantidadeRealizada) AS quantidadeRealizada");
            sql.append(" FROM BIProcedimentoRealizado pro,BIProcedimento p");
            //traz somente os procedimentos que devem ser consolidados
            sql.append(" WHERE (pro.origemProcedimento=:origem AND p.exigeIdadeBPA=:exige");
            sql.append(" AND pro.competenciaMovimento=:competenciaMovimento ");
            sql.append(" AND pro.codigoProcedimento=concat(p.bIprocedimentoPk.id,p.bIprocedimentoPk.digitoVerificador)");
            //sql.append(" AND pro.competenciaMovimento=p.bIprocedimentoPk.competencia ");
            sql.append(" AND pro.biProcedimentoRealizadoPK.cnesUnidade=:cnesUnidade )");
            //agrupa
//            sql.append(" GROUP BY pro.biProcedimentoRealizadoPK.competencia,pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.cboMedico,");
//            sql.append(" pro.codigoProcedimento,pro.idadePaciente,pro.competenciaMovimento");
            sql.append(" GROUP BY pro.competenciaMovimento,pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.cboMedico,");
            sql.append(" pro.codigoProcedimento,pro.idadePaciente,pro.biProcedimentoRealizadoPK.competencia");
            //ordena
            sql.append(" ORDER BY pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.competencia");
            //it's create query
            Query q = session.createQuery(sql.toString());
            q.setParameter("origem", ProcedimentoRealizado.ORIGEM_CONSOLIDADO);
            q.setParameter("exige", Procedimento.EXIGE_IDADE);
            q.setParameter("competenciaMovimento", competenciaMovimento);
            q.setParameter("cnesUnidade", cnesUnidade);
            //paginacao dos resultados
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResult);
            l = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ao executar o método findAllConsolidadosPorIdade " + ex.getMessage());
        } finally {
            //session.flush();
            session.close();
            List<ProcedimentoRealizado> list = new ArrayList<ProcedimentoRealizado>();
            if (l != null) {
                //cada objeto de l contém um vetor que representa os campos selecionados
                for (Object[] row : l) {
                    ProcedimentoRealizado pro = new ProcedimentoRealizado(new ProcedimentoRealizadoPK());

                    //o tamanho do vetor é igual a quantidade de campos do select
                    //o índíce do campo no select é igual ao do vetor, começando por zero.
                    pro.getProcedimentoRealizadoPK().setCnesUnidade((String) row[0]);
                    pro.getProcedimentoRealizadoPK().setCboMedico((String) row[1]);
                    pro.setIdadePaciente((String) row[2]);
                    pro.setCodigoProcedimento((String) row[3]);
                    pro.getProcedimentoRealizadoPK().setCompetencia((String) row[4]);
                    pro.setCompetenciaMovimento((String) row[5]);
                    pro.setQuantidadeRealizada((Double) row[6]);

                    //valores padrões

                    pro.setOrigemProcedimento(ProcedimentoRealizado.ORIGEM_CONSOLIDADO);
                    pro.preencherAtributosVazios();

                    list.add(pro);
                }
                l.clear();
            }
            return list;
        }
    }

    /**
     * Pega todos os procedimentos realizados que são individuais de forma páginada
     * @param competencia - competência dos registros
     * @param firstResult - o index do primeiro registro
     * @param maxResult -  a quantidade máxima de resultados resultados
     * @return  Lista de com os procedimentos realizados
     */
    public List<ProcedimentoRealizado> findAllProcedimentosIndividuais(String competenciaMovimento, String cnesUnidade, int firstResult, int maxResult) {
        List<ProcedimentoRealizado> list = new ArrayList<ProcedimentoRealizado>();
        List<BIProcedimentoRealizado> l = null;
        Session session = this.getSession();
        try {

            StringBuilder sql = new StringBuilder();
            //campos a serem selecionados
            sql.append("");
            //faz o somatório da quantidade de execuções
            sql.append(" FROM BIProcedimentoRealizado pro");
            //traz somente os procedimentos que devem ser consolidados
            sql.append(" WHERE (pro.origemProcedimento=:origem ");
            sql.append(" AND pro.competenciaMovimento=:competenciaMovimento ");
            sql.append(" AND pro.biProcedimentoRealizadoPK.cnesUnidade=:cnesUnidade )");
            //ordena
            sql.append(" ORDER BY pro.biProcedimentoRealizadoPK.cnesUnidade,pro.biProcedimentoRealizadoPK.cnsMedico, ");
            sql.append(" pro.biProcedimentoRealizadoPK.cboMedico, ");
            sql.append(" pro.biProcedimentoRealizadoPK.numeroFolha, ");
            sql.append(" pro.biProcedimentoRealizadoPK.sequenciaFolha ");

            //it's create query
            Query q = session.createQuery(sql.toString());
            q.setParameter("origem", ProcedimentoRealizado.ORIGEM_INDIVIDUALIZADO);
            q.setParameter("competenciaMovimento", competenciaMovimento);
            q.setParameter("cnesUnidade", cnesUnidade);
            //paginacao dos resultados
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResult);
            l = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ao executar o método findAllProcedimentosIndividuais " + ex.getMessage());
        } finally {
            //session.flush();
            session.close();
            if (l != null) {
                //cada objeto de l contém um vetor que representa os campos selecionados
                for (BIProcedimentoRealizado row : l) {
                    ProcedimentoRealizado pro = new ProcedimentoRealizado(row);
                    pro.preencherAtributosVazios();
                    list.add(pro);
                }
                l.clear();
            }
            return list;
        }

    }

    @Override
    public Session getSession() {
        return HibernateUtil.getSessionBpaI();
    }

    /**
     * Devolve todos os procedimentos somente com os campos d cabeçalho preenchido.
     * A saber: CNES da Unidade, CBO do profissional, Número da Folha, Competência e CNS do médico.
     * Em outras palavaras: agrupa os resgistros pelos campos descritos acima.
     * @return List<ProcedimentoRealizado> - A lista de todos os procedimentos encontrados
     */
    public List<ProcedimentoRealizado> findAllOnlyHeader(String competenciaMovimento) {
        List<Object[]> l = null;
        Session session = this.getSession();
        try {

            StringBuilder sql = new StringBuilder();
            //campos a serem selecionados
            sql.append("SELECT  pro.biProcedimentoRealizadoPK.cnesUnidade, pro.biProcedimentoRealizadoPK.cboMedico,");
            sql.append(" pro.biProcedimentoRealizadoPK.numeroFolha, pro.biProcedimentoRealizadoPK.competencia,");
            //faz o somatório da quantidade de execuções
            sql.append("pro.biProcedimentoRealizadoPK.cnsMedico, COUNT(pro.biProcedimentoRealizadoPK.sequenciaFolha) AS VOID");
            sql.append(" FROM BIProcedimentoRealizado pro");
            //traz somente os procedimentos que devem ser consolidados
            sql.append(" WHERE (pro.competenciaMovimento=:competencia)");
            //agrupa
            sql.append(" GROUP BY pro.biProcedimentoRealizadoPK.competencia, pro.biProcedimentoRealizadoPK.cnesUnidade,");
            sql.append(" pro.biProcedimentoRealizadoPK.cnsMedico,pro.biProcedimentoRealizadoPK.cboMedico,pro.biProcedimentoRealizadoPK.numeroFolha");
            //it's create query
            Query q = session.createQuery(sql.toString());
            q.setParameter("competencia", competenciaMovimento);
            //paginacao dos resultados
            l = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ao executar o método findAllOnlyHeader " + ex.getMessage());
        } finally {
            List<ProcedimentoRealizado> list = new ArrayList<ProcedimentoRealizado>();
            if (l != null) {
                //cada objeto de l contém um vetor que representa os campos selecionados
                for (Object[] row : l) {
                    ProcedimentoRealizado pro = new ProcedimentoRealizado(new ProcedimentoRealizadoPK());

                    //o tamanho do vetor é igual a quantidade de campos do select
                    //o índíce do campo no select é igual ao do vetor, começando por zero.
                    pro.getProcedimentoRealizadoPK().setCnesUnidade((String) row[0]);
                    pro.getProcedimentoRealizadoPK().setCboMedico((String) row[1]);
                    pro.getProcedimentoRealizadoPK().setNumeroFolha((String) row[2]);
                    pro.getProcedimentoRealizadoPK().setCompetencia((String) row[3]);
                    pro.getProcedimentoRealizadoPK().setCnsMedico((String) row[4]);

                    list.add(pro);
                }
            }
            session.close();
            return list;
        }
    }

 
    public List<ProcedimentoRealizado> findAllOnlyHeaderEqual(BIProcedimentoRealizado BIprocedimentoRealizado) {
        List<Object[]> l = null;
        List<String> listGroupBy = new ArrayList<String>();
        listGroupBy.add("biProcedimentoRealizadoPK.competencia");
        listGroupBy.add("biProcedimentoRealizadoPK.cnesUnidade");
        listGroupBy.add("biProcedimentoRealizadoPK.cnsMedico");
        listGroupBy.add("biProcedimentoRealizadoPK.cboMedico");
        listGroupBy.add("biProcedimentoRealizadoPK.numeroFolha");
        try{
            l = this.findAllEqualGroupBy(BIprocedimentoRealizado,listGroupBy);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally {
            List<ProcedimentoRealizado> list = new ArrayList<ProcedimentoRealizado>();
            if (l != null) {
                //cada objeto de l contém um vetor que representa os campos selecionados
                for (Object[] row : l) {
                    ProcedimentoRealizado pro = new ProcedimentoRealizado(new ProcedimentoRealizadoPK());

                    //o tamanho do vetor é igual a quantidade de campos do select
                    //o índíce do campo no select é igual ao do vetor, começando por zero.
                    pro.getProcedimentoRealizadoPK().setCompetencia((String) row[0]);
                    pro.getProcedimentoRealizadoPK().setCnesUnidade((String) row[1]);
                    pro.getProcedimentoRealizadoPK().setCnsMedico((String) row[2]);
                    pro.getProcedimentoRealizadoPK().setCboMedico((String) row[3]);
                    pro.getProcedimentoRealizadoPK().setNumeroFolha((String) row[4]);
                   
                    

                    list.add(pro);
                }
            }
            return list;
        }
//        List<ProcedimentoRealizado> list = new ArrayList<ProcedimentoRealizado>();
//        if (l != null) {
//            //cada objeto de l contém um vetor que representa os campos selecionados
//            for (BIProcedimentoRealizado row : l) {
//                ProcedimentoRealizado pro = new ProcedimentoRealizado(new ProcedimentoRealizadoPK());
//                if (row != null) {
//                    //o tamanho do vetor é igual a quantidade de campos do select
//                    //o índíce do campo no select é igual ao do vetor, começando por zero.
//                    pro.getProcedimentoRealizadoPK().setCnesUnidade(row.getBiProcedimentoRealizadoPK().getCnesUnidade());
//                    pro.getProcedimentoRealizadoPK().setCboMedico(row.getBiProcedimentoRealizadoPK().getCboMedico());
//                    pro.getProcedimentoRealizadoPK().setNumeroFolha(row.getBiProcedimentoRealizadoPK().getNumeroFolha());
//                    pro.getProcedimentoRealizadoPK().setCompetencia(row.getBiProcedimentoRealizadoPK().getCompetencia());
//                    pro.getProcedimentoRealizadoPK().setCnsMedico(row.getBiProcedimentoRealizadoPK().getCnsMedico());
//
//                    list.add(pro);
//                }
//            }
//        }
        //return list;
    }

    public List<String> getAllCompetenciaMovimento() {
        List list = new ArrayList<String>();
        Session session = this.getSession();
        try {
            Query q = session.createQuery("SELECT DISTINCT(competenciaMovimento) FROM BIProcedimentoRealizado ");
            list = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ao executar o método getAllCompetenciaMovimento " + ex.getMessage());
        } finally {
            return list;
        }

    }

    public List<String> getAllUnidade() {
        List list = new ArrayList<String>();;
        Session session = this.getSession();
        try {
            Query q = session.createQuery("SELECT DISTINCT(biProcedimentoRealizadoPK.cnesUnidade) FROM BIProcedimentoRealizado ");
            list = q.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ao executar o método getAllUnidade " + ex.getMessage());
        } finally {
            return list;
        }

    }

    public List<String> getAllCodigoProcedimentoSemReferencia(String competenciaMovimento) {
        List<String> list = new ArrayList<String>();
        Session session = this.getSession();
        try {
            StringBuilder str = new StringBuilder();
            //PRIMEIRO PEGA OS PROCEDIMENTOS
            str.append("SELECT DISTINCT(pro.codigoProcedimento) FROM BIProcedimentoRealizado pro");
            str.append(" WHERE pro.competenciaMovimento=:competencia");
//            str.append(" GROUP BY pro.codigoProcedimento");
//            Query query=session.createQuery(str.toString());
//            query.setParameter("competencia", competencia);
//            list=query.list();
//            
           // str.append(" AND (SELECT DISTINCT(p.bIprocedimentoPk.id) FROM BIProcedimento p");
            //str.append(" WHERE pro.codigoProcedimento=concat(p.bIprocedimentoPk.id,p.digitoVerificador) ");
            //str.append(" AND p.bIprocedimentoPk.competencia=:");
          //  str.append(" AND pro.competenciaMovimento=p.bIprocedimentoPk.competencia) IS NULL");


            Query query = session.createQuery(str.toString());
            query.setParameter("competencia", competenciaMovimento);
            list = query.list();
            if (list == null ? false : !list.isEmpty()) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    String s=list.get(i).substring(0, 9);
                    list.set(i, s);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Ao executar o método getAllUCodigoProcedimentoSemReferencia " + ex.getMessage());
        } finally {
            if (session == null ? false : session.isOpen()) {
                session.close();
            }
            return list;
        }
    }
    
     public void mergePaginado(List<BIProcedimentoRealizado> list,int paginacao){
        if(paginacao<=list.size()){
            int i=0;
            while(i<list.size()){
                if(i+paginacao<=list.size()){
                    this.merge(list.subList(i,i+paginacao));
                }else{
                      this.merge(list.subList(i,list.size()-1));
                }    
                i+=paginacao; 
                
            }
        }else{
            this.merge(list);
        }
    }
}
