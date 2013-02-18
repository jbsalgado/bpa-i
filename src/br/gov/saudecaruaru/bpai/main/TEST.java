/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;


import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoDoencaController;
import br.gov.saudecaruaru.bpai.business.controller.SistemaController;
import br.gov.saudecaruaru.bpai.business.model.ArquivoCnes;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoenca;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoencaPK;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.validators.ProcedimentoRealizadoValidator;
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
        
        ArquivoCnes arquivoCnes = new ArquivoCnes("C:\\Users\\juniorpires\\Documents\\Trabalho\\BPA\\SIAB\\TXT_SIAB\\CN201212.txt");
        arquivoCnes.salvarDadosSiab();
//       BPAI.initDatabaseConfiguration();
//       String msg ="";
//       ProcedimentoRealizado p = new ProcedimentoRealizado();
//       p.setCodigoProcedimento("0701090090");
//       p.getProcedimentoRealizadoPK().setCboMedico("223505");
//       p.setIdadePaciente("11");
//       p.getProcedimentoRealizadoPK().setCompetencia("201212");
//       p.setEtniaPaciente("123456");
//       p.setCidDoencaprocedimento("A000");
//       p.setCodigoIBGECidadePaciente("260410");
//       p.setNacionalidadePaciente("010");
//       p.setQuantidadeRealizada(23.0);
//       
//       
//       ProcedimentoRealizadoValidator prv = new ProcedimentoRealizadoValidator(p);
//       List<String> list = prv.runValidate();
//       if(!list.isEmpty()){
//           for(String m:list){
//               msg+=m+"\n";
//           }
//           System.out.println("ERRO: "+msg);
//       }else
//           System.out.println(msg+"CORRETO, PARABÉNS!");
//      
//       
       
//       msg += prv.existeCBO()+"\n";
//       msg+=prv.existeProcedimento()+"\n";
//       msg+=prv.validaProcedimentoIdadeMaxMin()+"\n";
//       msg+=prv.validaProcedimentoECbo()+"\n";
//       msg+=prv.validaProcedimentoTipo()+"\n";
//       msg+=prv.validaCompetencia()+"\n";
//       msg+=prv.existeDoenca()+"\n";
//       msg+=prv.procedimentoDoenca()+"\n";
//       msg+=prv.doencaPertenceSubCategoria()+"\n";
//       msg+=prv.doencaIncompativelProcedimento()+"\n";
//       msg+=prv.existeEtnia()+"\n";
//       msg+=prv.existeMunicipio()+"\n";
//       msg+=prv.existeNacionalidade()+"\n";
//       msg+=prv.quantidadeMaximaProcedimento()+"\n";
       
    }
}
