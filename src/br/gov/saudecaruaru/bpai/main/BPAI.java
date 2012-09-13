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
import javax.swing.JOptionPane;

/**
 *
 * @author Junior Pires
 */
public class BPAI {

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
        
    }
}
