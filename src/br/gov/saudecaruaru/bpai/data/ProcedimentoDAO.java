/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoDAO extends GenericDAO<Procedimento>{

    public String getMaxCompetencia(){
        Session session=this.getSession();
        String comp=null;
        try{
            StringBuilder sql= new StringBuilder("SELECT MAX(procedimentoPk.competencia) FROM Procedimento ");
            Query q=session.createQuery(sql.toString());
            comp=q.uniqueResult().toString();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            return comp;
        }
    }
}
