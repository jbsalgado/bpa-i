/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Albuquerque
 */
public class BIProcedimentoRealizadoDAO extends GenericDAO<BIProcedimentoRealizado> {

    public BIProcedimentoRealizadoDAO() {
        super(EntityManagerUtil.getEntityManagerI());
        
    }

    @Override
    public EntityManager getEntityManager() {
        if(!this.entityManager.isOpen()){
            this.entityManager=EntityManagerUtil.getEntityManagerI();
        }
        return entityManager;
    }
    
    
    
    
    
    
    
}
