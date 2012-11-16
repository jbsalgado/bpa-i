/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.controller.SistemaController;
import br.gov.saudecaruaru.bpai.data.*;
import br.gov.saudecaruaru.bpai.gui.EscolhaBanco;
import br.gov.saudecaruaru.bpai.gui.ListaProcedimento;
import br.gov.saudecaruaru.bpai.gui.SearchGeneric;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Junior Pires
 */
public class BPAI {
    
    //CARREGA AS CONFIGURAÇÕES PARA O LOG
    static {
            String path=null;
            try {
                path=BPAI.class.getClassLoader().getResource("log4j-app.properties").toURI().getPath().substring(1);
                PropertyConfigurator.configure(path);
            } catch (URISyntaxException ex) {
                Logger.getLogger(BPAI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void initDatabaseConfiguration(){
        SistemaController.createConfiguration();
        EscolhaBanco banco= new EscolhaBanco();
        //vai pegar o caminho
        boolean con=SistemaController.testConnectionBPA();
        while(!con){
            banco.setVisible(false);
            HibernateUtil.PATH_DATABASE_BPA=banco.chooseFile("Indique onde está o arquivo BPAMAG.GDB");
            con=SistemaController.testConnectionBPA();
            if(!con){
                JOptionPane.showMessageDialog(banco, "Conexão falhou!");
            }
            else{
                JOptionPane.showMessageDialog(banco, "Conexão realizada com sucesso!");
               
            }
           
        }
        con=SistemaController.testConnectionBPAI();
        while(!con){
            banco.setVisible(false);
            HibernateUtil.PATH_DATABASE_BPA_I=banco.chooseFile("Indique onde está o arquivo TESTANDO.GDB");
            con=SistemaController.testConnectionBPAI();
            if(!con){
                JOptionPane.showMessageDialog(banco, "Conexão falhou!");
            }
            else{
                JOptionPane.showMessageDialog(banco, "Conexão realizada com sucesso!");
            }
           
        }
        String path=null;
        try {
             path=BPAI.class.getClassLoader().getResource("log4j-teste.properties").toURI().getPath().substring(1);
        } catch (URISyntaxException ex) {
            Logger.getLogger(BPAI.class.getName()).log(Level.SEVERE, null, ex);
        }
        PropertyConfigurator.configure(path);
        banco.dispose();
        SistemaController.updateConfigurations();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchGeneric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGeneric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGeneric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGeneric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       BPAI.initDatabaseConfiguration();
       ListaProcedimento principal= new ListaProcedimento();
       principal.setVisible(true);
       principal.setLocationRelativeTo(null);
       principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
