/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoDoencaController;
import br.gov.saudecaruaru.bpai.business.controller.SistemaController;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoenca;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoencaPK;
import br.gov.saudecaruaru.bpai.data.HibernateUtil;
import br.gov.saudecaruaru.bpai.gui.EscolhaBanco;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Junior Pires
 */
public class TEST {
    
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
    public static void main(String[] args){
       BPAI.initDatabaseConfiguration();
        
       ProcedimentoDoencaController controller = new ProcedimentoDoencaController();
       ProcedimentoDoencaPK  procedimentoDoencaPK = new ProcedimentoDoencaPK(); 
       ProcedimentoDoenca procedimentoDoenca = new ProcedimentoDoenca(procedimentoDoencaPK);
       
        procedimentoDoenca.getProcedimentoDoencaPK().setProcedimentoCodigo("030206001");
        procedimentoDoenca.getProcedimentoDoencaPK().setCodigoCid("G800");
        procedimentoDoenca.getProcedimentoDoencaPK().setCompetencia("201203");
        
        
         ProcedimentoDoenca  p = controller.findEqual(procedimentoDoenca);
         if(p!=null){
             System.out.println(p);
         }else
             System.out.println("NULL");
           
      
    }
}
