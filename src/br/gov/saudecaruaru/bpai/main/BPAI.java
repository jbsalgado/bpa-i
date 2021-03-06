/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.controller.SistemaController;
import br.gov.saudecaruaru.bpai.business.model.ArquivoCnes;
import br.gov.saudecaruaru.bpai.business.model.BIDoencaCondicao;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.presenter.principal.PrincipalPresenter;
import br.gov.saudecaruaru.bpai.data.BIDoencaCondicaoDAO;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.data.HibernateUtil;
import br.gov.saudecaruaru.bpai.gui.EscolhaBanco;
import br.gov.saudecaruaru.bpai.gui.SearchGeneric;
import br.gov.saudecaruaru.bpai.util.Recurso;
import com.sun.jersey.api.client.Client;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Junior Pires
 */
public class BPAI {
 
    
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
//        BIProcedimentoRealizadoDAO dao = new BIProcedimentoRealizadoDAO();
//        List<BIProcedimentoRealizado> list = dao.findAllEqual(new HashMap<String, Object>(), 1364, 1753);
//        for (BIProcedimentoRealizado bIProcedimentoRealizado : list) {
//            bIProcedimentoRealizado.setCompetenciaMovimento("201303");
//        }
//        dao.mergePaginado(list,250);
        //ArquivoCnes arquivoCnes = new ArquivoCnes("C:\\Users\\juniorpires\\Documents\\Trabalho\\BPA\\SIAB\\TXT_SIAB\\CN201212.txt");
        //arquivoCnes.salvarDadosSiab();
//        BIDoencaCondicao doencaCondicao1 = new BIDoencaCondicao("ALC", "Alcoolismo");
//        BIDoencaCondicao doencaCondicao2 = new BIDoencaCondicao("CHA", "Chagas");
//        BIDoencaCondicao doencaCondicao3 = new BIDoencaCondicao("DEF", "Deficiência");
//        BIDoencaCondicao doencaCondicao4 = new BIDoencaCondicao("DIA", "Diabetes");
//        BIDoencaCondicao doencaCondicao5 = new BIDoencaCondicao("EPI", "Eplepsia");
//        BIDoencaCondicao doencaCondicao6 = new BIDoencaCondicao("GES", "Gestação");
//        BIDoencaCondicao doencaCondicao7 = new BIDoencaCondicao("HA", "Hipertensão Arterial");
//        BIDoencaCondicao doencaCondicao8 = new BIDoencaCondicao("TB", "Turbeculose");
//        BIDoencaCondicao doencaCondicao9 = new BIDoencaCondicao("HAN", "Hanseníase");
//        BIDoencaCondicao doencaCondicao10 = new BIDoencaCondicao("MAL", "Malária");
//        BIDoencaCondicaoDAO dao = new BIDoencaCondicaoDAO();
//        dao.save(doencaCondicao1);
//        dao.save(doencaCondicao2);
//        dao.save(doencaCondicao3);
//        dao.save(doencaCondicao4);
//        dao.save(doencaCondicao5);
//        dao.save(doencaCondicao6);
//        dao.save(doencaCondicao7);
//        dao.save(doencaCondicao8);
//        dao.save(doencaCondicao9);
//        dao.save(doencaCondicao10);
    }
    
    public void start(){
        //atualiza os arquivos necessários
        SistemaController sistema=  SistemaController.getnstance();
        Client client = Client.create();
        List<Recurso> list=sistema.getRecursosASeremAtualizados(client);
        if (list!= null){
        for (Recurso r : list) {
            sistema.atualizarRecurso(client, r);
       
        }
        }
        //verifica se o banco ja existe, senão vai baixar
        if ( !(new File(SistemaController.DIRETORIO_DEFAULT_BANCO+ "/TESTANDO.GDB").exists()) ){
            sistema.baixarBancoDeDados(client);
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
       //CRIA OS ÍNDICES
       HibernateUtil.createIndices();
       HibernateUtil.createIndicesBPAI();
       
       PrincipalPresenter presenter=new PrincipalPresenter();
       presenter.createView();
    }
    
    private static void criarDiretorioPadrao(){
        File dir=new File(SistemaController.DIRETORIO_DEFAULT_BANCO);
        if (!dir.exists()){
            dir.mkdirs();
        }
        dir=new File(SistemaController.DIRETORIO_DEFAULT_LOG);
        if (!dir.exists()){
            dir.mkdirs();
        }
    }
    
    
}
