/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Albuquerque
 */
public class ProcedimentoRealizadoDAO extends GenericDAO<ProcedimentoRealizado> {
    
        public List<ProcedimentoRealizado> findAllConsolidados(String competencia,int firstResult,int maxResult){
        List<Object[]> l=null;
        Session session= this.getSession();
        try{
//            example in SQL for get the procedimentos
//            ===> first X skip Y equivalent in Mysql at limit Y,X <===
//            select first 100 skip 50 pr.prd_cbo,pr.prd_uid,pr.prd_idade,p.pa_dc,p.pa_id,pr.prd_org,pr.prd_mvm,pr.prd_cmp, sum(pr.prd_qt_p) 
//            FROM s_prd pr inner join S_PA p on (p.pa_id||p.pa_dv=pr.prd_pa and  p.pa_idebpa='S' ) 
//            group by pr.prd_uid,pr.prd_cbo, p.pa_id,pr.prd_idade, p.pa_dc,pr.prd_org,pr.prd_cmp,pr.prd_mvm;

            StringBuilder sql=new StringBuilder();
            //campos a serem selecionados
            sql.append("SELECT  pro.procedimentoRealizadoPK.cnesUnidade, pro.procedimentoRealizadoPK.cboMedico,");
            sql.append("pro.idadePaciente, pro.codigoProcedimento, pro.biProcedimentoRealizadoPK.competencia,");
            //faz o somatório da quantidade de execuções
            sql.append("pro.prdMvm, SUM(pro.quantidadeRealizada) AS quantidadeRealizada");
            sql.append(" FROM ProcedimentoRealizado pro");
            //traz somente os procedimentos que devem ser consolidados
            sql.append(" WHERE (pro.origemProcedimento=:origem)");
            //agrupa
            sql.append(" GROUP BY pro.procedimentoRealizadoPK.cnesUnidade, pro.procedimentoRealizadoPK.cboMedico,");
            sql.append(" pro.codigoProcedimento,pro.idadePaciente,pro.biProcedimentoRealizadoPK.competencia,pro.prdMvm");
            //it's create query
            Query q=session.createQuery(sql.toString());
            q.setParameter("origem", "BPA");
            //paginacao dos resultados
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResult);
            l=q.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            List<ProcedimentoRealizado> list= new ArrayList<ProcedimentoRealizado>();
            if(l!=null){
                //cada objeto de l contém um vetor que representa os campos selecionados
                for(Object[] row:l){
                    ProcedimentoRealizado pro=new ProcedimentoRealizado(new ProcedimentoRealizadoPK());
                    
                    //o tamanho do vetor é igual a quantidade de campos do select
                    //o índíce do campo no select é igual ao do vetor, começando por zero.
                    pro.getProcedimentoRealizadoPK().setCnesUnidade((String)row[0]);
                    pro.getProcedimentoRealizadoPK().setCboMedico((String)row[1]);
                    pro.setIdadePaciente((String)row[2]);
                    pro.setCodigoProcedimento((String)row[3]);
                    pro.getProcedimentoRealizadoPK().setCompetencia((String)row[4]);
                    pro.setPrdMvm((String)row[5]);
                    pro.setQuantidadeRealizada((Double) row[6]);
                    
                    //valores padrões
                    
                    pro.setOrigemProcedimento("BPA");
                    String flag="0";
                    pro.setPrdFlca(flag);
                    pro.setPrdFlcbo(flag);
                    pro.setPrdFlcid(flag);
                    pro.setPrdFler(flag);
                    pro.setPrdFlida(flag);
                    pro.setPrdFlmun(flag);
                    pro.setPrdFlpa(flag);
                    pro.setPrdFlqt(flag);
                    
                    list.add(pro);
                }
            }
            return list;
        }
    }
    
       
    public void save(List<ProcedimentoRealizado> list) {
        Session session= this.getSession();
        Transaction tx=session.getTransaction();

        try {
            tx.begin();
            int size=list.size();
            for(int i=0;i<size;i++){
                session.merge(list.get(i));
                //divisível por 20
                if(i%20==0){
                    session.flush();
                    session.clear();
                }
                System.out.println(list.get(i));
            }
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            session.close();
        }
    }
   
}
