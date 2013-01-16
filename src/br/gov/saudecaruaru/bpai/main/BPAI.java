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
import br.gov.saudecaruaru.bpai.util.Manager;
import br.gov.saudecaruaru.bpai.util.Recurso;
import com.sun.jersey.api.client.Client;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Junior Pires
 */
public class BPAI {
    
    public static String DIRETORIO_BANCO;
    public static String DIRETORIO_LOG;
    
    //CARREGA AS CONFIGURAÇÕES PARA O LOG
    static {
        try {
                //carega arquivo
                InputStream file=BPAI.class.getClassLoader().getResourceAsStream("log4j-app.properties");
                Properties pro= new Properties();
                pro.load(file);
                PropertyConfigurator.configure(pro);
                file.close();
                BPAI.criarDiretorioPadrao();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
    }
    
    public static void initDatabaseConfiguration(){
        
            
            
        try{
        SistemaController.createConfiguration();
        EscolhaBanco banco= new EscolhaBanco();
        //vai pegar o caminho
        boolean con=SistemaController.testConnectionBPA();
        while(!con){
            banco.setVisible(false);
            HibernateUtil.PATH_DATABASE_BPA=banco.chooseFile("Indique onde está o arquivo BPAMAG");
            con=SistemaController.testConnectionBPA();
            if(!con){
                int resposta=JOptionPane.showConfirmDialog(banco, "Conexão falhou! Tentar Novamente?", "Conexão com o Banco BPAMAG", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(resposta == JOptionPane.NO_OPTION){
                    //cancelou a execução do programa, então vai encerrá-lo
                    System.exit(1);
                }
            }
            else{
                JOptionPane.showMessageDialog(banco, "Conexão realizada com sucesso!");
                //JOptionPane.showo
               
            }
           
        }
        con=SistemaController.testConnectionBPAI();
        while(!con){
            banco.setVisible(false);
            HibernateUtil.PATH_DATABASE_BPA_I=banco.chooseFile("Indique onde está o arquivo TESTANDO.GDB");
            con=SistemaController.testConnectionBPAI();
            if(!con){
                int resposta=JOptionPane.showConfirmDialog(banco, "Conexão falhou! Tentar Novamente?", "Conexão com o Banco TESTANDO", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(resposta == JOptionPane.NO_OPTION){
                    //cancelou a execução do programa, então vai encerrá-lo
                    System.exit(1);
                }
            }
            else{
                JOptionPane.showMessageDialog(banco, "Conexão realizada com sucesso!");
            }
           
        }
        banco.dispose();
        SistemaController.updateConfigurations();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BPAI home= new BPAI();
        home.start();
        
    }
    
    public void start(){
        //atualiza os arquivos necessários
        Manager ini= new Manager();
        Client client = Client.create();
        List<Recurso> list=ini.getRecursosASeremAtualizados(client);
        if (list!= null){
        for (Recurso r : list) {
            ini.atualizarRecurso(client, r);
       
        }
        }
        //verifica se o banco ja existe, senão vai baixar
        if ( !(new File("C:/BPAI/banco/TESTANDO.GDB").exists()) ){
            ini.baixarBancoDeDados(client);
        }
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
    
    private static void criarDiretorioPadrao(){
        File dir=new File("C:/BPAI/banco");
        if (!dir.exists()){
            dir.mkdirs();
            DIRETORIO_BANCO=dir.getAbsolutePath();
        }
        dir=new File("C:/BPAI/log");
        if (!dir.exists()){
            dir.mkdirs();
            DIRETORIO_LOG=dir.getAbsolutePath();
        }
    }
    
    
}
