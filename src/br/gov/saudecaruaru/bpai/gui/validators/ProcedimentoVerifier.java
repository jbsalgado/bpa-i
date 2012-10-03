/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;


import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoCboController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoController;
import br.gov.saudecaruaru.bpai.business.model.*;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
import br.gov.saudecaruaru.bpai.util.DateUtil;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class ProcedimentoVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private ProcedimentoController procedimentoController;
    private  Procedimento procedimento;
    private ProcedimentoPK  procedimentoPk;
    private JTextField procNome;
    private TelaCadastroI t;
   
    
    private ProcedimentoCbo procedimentoCbo;
    private ProcedimentoCboPK procedimentoCboPK;
    private ProcedimentoCboController procedimentoCboController;
    
    
    public ProcedimentoVerifier(Component component,String fieldName,JTextField procNome,TelaCadastroI t) {
        this.fieldName = fieldName;
        this.component = component;
        this.procNome = procNome;
        this.t = t;
        //instancia o controlador de  municipio
         procedimentoController = new  ProcedimentoController();
        //instancia o modelo  MunicipioPk
         this.procedimento= new   Procedimento();
         procedimentoPk = new   ProcedimentoPK();
         this.procedimento.setProcedimentoPk(procedimentoPk);
         
         
         this.procedimentoCboPK = new ProcedimentoCboPK();
         this.procedimentoCbo = new ProcedimentoCbo(procedimentoCboPK);
         
         this.procedimentoCboController = new ProcedimentoCboController();
        
        
    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextField txtField = (JTextField) input; 
      Procedimento procedimentosSearchead = null;
      ProcedimentoRealizado proRealizado = t.getProcedimentoRealizado(); 
      String valor = txtField.getText();
      
      
      
      
      if(valor.trim().isEmpty() || valor.trim().length()<10){
          JOptionPane.showMessageDialog(this.component,"PROCEDIMENTO INVÁLIDO!"
                                        ,"Erro de validação!", JOptionPane.ERROR_MESSAGE);
                                txtField.setBackground(Color.RED); 
                                return  false;
      
      }
                                
      //pega os sete primeiros digitos (que representam o codigo do procedimento)
      String codProc = valor.substring(0,9);
       //pega o oitavo digito (que representam o digito verificador)
      Character digitoVerificador = valor.charAt(9);
    
      procedimento.getProcedimentoPk().setId(codProc);
      procedimento.setDigitoVerificador(digitoVerificador);
      procedimento.getProcedimentoPk().setCompetencia(proRealizado.getProcedimentoRealizadoPK().getCompetencia());
      
     
      //faz a busca pelo Procedimento  digitado, se nao encontra notifica ao usuário
      procedimentosSearchead = procedimentoController.findEqual(this.procedimento);
                //verifica se o procedimento existe
                if (procedimentosSearchead==null) {  
                    
                   JOptionPane.showMessageDialog(this.component,"PROCEDIMENTO NÃO ENCONTRADO!"
                                        ,"Erro de validação!", JOptionPane.ERROR_MESSAGE);
                                txtField.setBackground(Color.RED); 
                                return  false;
                 
                }else {
                    
                       
                        
                        
                        int idadePaciente = 1000;
                        
                        int idadeMaxima = procedimentosSearchead.getIdadeMaximaPaciente();
                        int idadeMinima = procedimentosSearchead.getIdadeMinimaPaciente();
                        //if(proRealizado.getDataNascimentoPaciente()!=null && proRealizado.getDataAtendimento()!=null ){
                        if(proRealizado.getIdadePaciente()!=null)    
                            idadePaciente = Integer.parseInt(proRealizado.getIdadePaciente());  //DateUtil.getAge(proRealizado.getDataNascimentoPaciente(),proRealizado.getDataAtendimento());
                       // }
                      
                    
                        
                        // verifica se o procedimento é compativel com o CBO
                        if(!temProcedimentoECbo(valor.substring(0, 9),proRealizado.getProcedimentoRealizadoPK().getCboMedico())){
                                        JOptionPane.showMessageDialog(this.component,"PROCED. INCOMPATIVEL COM CBO!", 
                                        "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                                        txtField.setBackground(Color.RED);
                                            return false;
                        }
                        //verifica se o procedimento exige sexo
                        if(procedimentosSearchead.exigeSexo()){
                            String sexo =proRealizado.getSexoPaciente();
                            //verifica se o sexo digitado é compativel com o exigido
                            if(!procedimentosSearchead.getSexo().toString().equals(sexo)){
                                    return MessagesErrors.exibeTelaQuestaoErro(component,"PROCED. INCOMPATIVEL COM O SEXO!"
                               , txtField);
                                   
                            }

                        } 
                            
                        if((idadePaciente<idadeMinima) || (idadePaciente>idadeMaxima)){
                                   return MessagesErrors.exibeTelaQuestaoErro(component,"PROCED. INCOMPATIVEL COM A IDADE!"+"\n IDADE MÍNIMA: "+idadeMinima+"\n IDADE MÁXIMA: "+idadeMaxima
                                , txtField);
                               
                        } 
                        if(!procedimentosSearchead.isBPA() && !procedimentosSearchead.isBPI()){
                                JOptionPane.showMessageDialog(this.component,"TIPO INVÁLIDO INVÁLIDO! (PERMITIDO SOMENTE BPA OU BPI)"
                                        ,"Erro de validação!", JOptionPane.ERROR_MESSAGE);
                                txtField.setBackground(Color.RED); 
                                return  false;
                            }
                        //exibe a descricao do Procedimento no campo de descricao 
                        procNome.setText(procedimentosSearchead.getDescricao());
                  }
                  txtField.setBackground(Color.WHITE);
                  procNome.setText(procedimentosSearchead.getDescricao());
                return true;
       }
    
    
     private boolean temProcedimentoECbo(String codProc,String cbo){
        procedimentoCbo.getProcedimentoCboPK().setProcedimentoCodigo(codProc);
        procedimentoCbo.getProcedimentoCboPK().setCodigoCbo(cbo);
        
        if(procedimentoCboController.findAllEqual(procedimentoCbo).isEmpty()){
            return false;
        }
        
        return true;
    }
}
