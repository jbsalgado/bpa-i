/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.data.HibernateUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;

/**
 *
 * @author Albuquerque
 */
public class SistemaController {
    
    public static boolean testConnectionBPA(String pathBanco){
        HibernateUtil.PATH_DATABASE_BPA=pathBanco;
        Session s=null;
        boolean sucess=false;
        try{
            s=HibernateUtil.getSession();
            Transaction t=s.beginTransaction();
            t.rollback();
            sucess=true;
        }catch(GenericJDBCException ex){
            HibernateUtil.restartSessionFactory();
            sucess=false;
            //ex.printStackTrace();
        }
        finally{
            if(s!=null)
            if(s.isOpen()){
                s.close();
            }
            return sucess;
        }
    }
    
   public static boolean testConnectionBPA(){
       return testConnectionBPA(HibernateUtil.PATH_DATABASE_BPA);
   }
    
   public static boolean testConnectionBPAI(String pathBanco){
        HibernateUtil.PATH_DATABASE_BPA_I=pathBanco;
        Session s=HibernateUtil.getSessionBpaI();
        boolean sussess=false;
        try{
            Transaction t=s.beginTransaction();
            t.rollback();
            sussess=true;
        }catch(GenericJDBCException ex){
            HibernateUtil.restartSessionFactoryBpaI();
            sussess=false;
            //ex.printStackTrace();
        }
        finally{
            if(s.isOpen()){
                s.close();
            }
            return sussess;
        }
    }
    
   public static boolean testConnectionBPAI(){
       return testConnectionBPAI(HibernateUtil.PATH_DATABASE_BPA_I);
   }
   
   public static void createConfiguration(){
       Properties prop = new Properties();  
          
        try {  
  
            File f = new File( "./configs.conf" );  
              
            // se não existe o arquivo, cria, caso contrário carrega  
            if ( !f.exists() ) {  
                                      
                prop.setProperty("bpa.database.path", HibernateUtil.PATH_DATABASE_BPA);  
                prop.setProperty("bpai.database.path", HibernateUtil.PATH_DATABASE_BPA_I);
                FileOutputStream out=new FileOutputStream( f );
                prop.store( out,   
                        "Esse arquivo não deve ser modificado!" );  
                out.close();
                loadConfigurations(); 
                  
            } else {  
                  
                loadConfigurations(); 
                  
            }  
              
        } catch ( IOException exc ) {   
            
        } 
   }
   
   public static void loadConfigurations(){
        Properties prop = new Properties();  
                      
        try {  
              
            File f = new File( "./configs.conf" );  
            FileInputStream in= new FileInputStream( f );
            prop.load(in );  
            
            //configuraçoes do banco
            HibernateUtil.PATH_DATABASE_BPA=prop.getProperty("bpa.database.path");
            HibernateUtil.PATH_DATABASE_BPA_I=prop.getProperty("bpai.database.path");
            
            //libera recursos
            in.close();
            //f.
        } catch ( IOException exc ) {                          
        } 
   }
   
   public static void updateConfigurations(){
        Properties prop = new Properties();  
          
        try {  
  
            File f = new File( "./configs.conf" );  
            FileInputStream in=new FileInputStream(f);
            prop.load(in); 
            //atualiza
            prop.setProperty("bpa.database.path", HibernateUtil.PATH_DATABASE_BPA);  
            prop.setProperty("bpai.database.path", HibernateUtil.PATH_DATABASE_BPA_I); 
            
            FileOutputStream out= new FileOutputStream(f);
            prop.store(out,null);
            in.close();
            out.close();
        } catch ( IOException exc ) {                                      
        }
   }
}
