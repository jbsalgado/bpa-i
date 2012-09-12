/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Albuquerque
 */
public class HibernateUtil {
   
    
    /**
     * Fábrica de conexão para o banco de dados do BPA
     */
    private static SessionFactory sessionFactory;
    /**
     * Fábrica de conexão com o banco de dados do sistema
     */
    private static SessionFactory sessionFactoryBpaI;
    /**
     * guarda o caminho do banco de dados do BPA
     */
    public static String PATH_DATABASE_BPA="";
    /**
     * Guarda o caminho do banco de dados do sistema
     */
    public static String PATH_DATABASE_BPA_I="";
    /**
     * URL de conexão do banco de dados
     */
    public static final String URL="jdbc:firebirdsql://localhost:3050/";

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    /**
     * Reinicia a sessionFactory
     */
    public static void restartSessionFactory() {
        HibernateUtil.sessionFactory = null;
    }

    public static SessionFactory getSessionFactoryBpaI() {
        return sessionFactoryBpaI;
    }
    /**
     * Reinicia a sessionFactoryBpaI
     */
    public static void restartSessionFactoryBpaI() {
        HibernateUtil.sessionFactoryBpaI = null;
    }
    
    
//   static {
//        try {
//            // Create the SessionFactory from hibernate.cfg.xmlz
//            AnnotationConfiguration configure = new AnnotationConfiguration().configure("hibernate.cfg.xml");
//            configure.setProperty("hibernate.connection.url", URL+PATH_DATABASE_BPA);
//            sessionFactory =configure.buildSessionFactory();
//                    //new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//   static {
//        try {
//            // Create the SessionFactory from hibernate.cfg.xml
//            sessionFactoryBpaI =
//                    new AnnotationConfiguration().configure("hibernate-bpa-i.cfg.xml").buildSessionFactory();
//        } catch (Throwable ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }

    public static Session getSession() {
//        if(sessionFactory.getCurrentSession()==null){
//            sessionFactory.openSession();
//        }
        if(sessionFactory==null){
            try {
                // Create the SessionFactory from hibernate.cfg.xmlz
                AnnotationConfiguration configure = new AnnotationConfiguration().configure("hibernate.cfg.xml");
                configure.setProperty("hibernate.connection.url", URL+PATH_DATABASE_BPA);
                sessionFactory =configure.buildSessionFactory();
                    //new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory.openSession();
    }
    
    public static Session getSessionBpaI() {
        if(sessionFactoryBpaI==null){
            try {
                // Create the SessionFactory from hibernate.cfg.xml
                AnnotationConfiguration configure=new AnnotationConfiguration().configure("hibernate-bpa-i.cfg.xml");
                configure.setProperty("hibernate.connection.url", URL+PATH_DATABASE_BPA_I);
                sessionFactoryBpaI =
                        configure.buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactoryBpaI.openSession();
    }

}
