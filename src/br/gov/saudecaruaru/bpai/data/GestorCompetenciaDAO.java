/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.GestorCompetencia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Junior Pires
 */
public class GestorCompetenciaDAO extends GenericDAO<GestorCompetencia> {
     @Override
    public Session getSession() {
        return HibernateUtil.getSession();
    }
     
     public String getCompetenciaMovimento(){
         List<GestorCompetencia> list = this.findAll();
         if(!list.isEmpty()){
             return list.get(0).getGestorCompetenciaPK().getCompetenciaMovimento();
         }
         return "000000";
//        Session session=this.getSession();
//        String comp=null;
//        try{
//            StringBuilder sql= new StringBuilder("SELECT distinct (gestorCompetenciaPK.competenciaMovimento) FROM GestorCompetencia");
//            Query q=session.createQuery(sql.toString());
//            comp=q.uniqueResult().toString();
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        finally{
//            return comp;
//        }
    }
}
