/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Albuquerque
 */
public class HibernateUtil {
   
    
    private static SessionFactory sessionFactory;
    private static SessionFactory sessionFactoryBpaI;
    
   static {
        try {
            // Create the SessionFactory from hibernate.cfg.xmlz
            sessionFactory =
                    new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
   static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactoryBpaI =
                    new AnnotationConfiguration().configure("hibernate-bpa-i.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
//        if(sessionFactory.getCurrentSession()==null){
//            sessionFactory.openSession();
//        }
        return sessionFactory.openSession();
    }
    
    public static Session getSessionBpaI() {
//        if(sessionFactoryBpaI.getCurrentSession()==null){
//            sessionFactoryBpaI.openSession().;
//        }
        return sessionFactoryBpaI.openSession();
    }

}
