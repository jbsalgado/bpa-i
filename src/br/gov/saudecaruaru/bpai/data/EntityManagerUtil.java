/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Albuquerque
 */
public class EntityManagerUtil {
    
    public static final String ENTITY_MANAGER_BPA_IPU="bpa";
    
    public static final String ENTITY_MANAGER_BPA_I="bpa-i";

    private static EntityManagerFactory emf;

    private static EntityManagerFactory emfI;
//    
//         public static EntityManager getEntityManager() {
//
//             if (emf == null){
//
//                          emf = Persistence.createEntityManagerFactory(EntityManagerUtil.ENTITY_MANAGER_BPA_IPU);
//
//                 }
//
//                 return emf.createEntityManager();
//
//         }
//         
//         public static EntityManager getEntityManagerI() {
//
//             if (emfI == null){
//
//                          emfI = Persistence.createEntityManagerFactory(EntityManagerUtil.ENTITY_MANAGER_BPA_I);
//
//                 }
//
//                 return emfI.createEntityManager();
//
//         }
}
