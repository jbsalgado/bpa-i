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
      List<Procedimento> procedimentosSearchead = null;
      String valor = txtField.getText();
       //pega os sete primeiros digitos (que representam o codigo do procedimento)
      String codProc = valor.substring(0,9);
       //pega o oitavo digito (que representam o digito verificador)
      Character digitoVerificador = valor.charAt(9);
    
      procedimento.getProcedimentoPk().setId(codProc);
      procedimento.setDigitoVerificador(digitoVerificador);
      
      //faz a busca pelo Procedimento  digitado, se nao encontra notifica ao usuário
      procedimentosSearchead = procedimentoController.findAllEqual(this.procedimento);
                //verifica se o procedimento existe
                if (procedimentosSearchead.isEmpty()) {  
                    return  MessagesErrors.exibeTelaContinuaErro(component, fieldName,"NÃO ENCONTRADO!", txtField);
                 // verifica se o procedimento é compativel com o CBO
                }else {
                        Procedimento pro = procedimentosSearchead.get(0);
                        ProcedimentoRealizado proRealizado = t.getProcedimentoRealizado(); 
                        int idadeMaxima = procedimentosSearchead.get(0).getIdadeMaximaPaciente();
                        int idadeMinima = procedimentosSearchead.get(0).getIdadeMinimaPaciente();
                        int idadePaciente = DateUtil.getAge(proRealizado.getDataNascimentoPaciente(),proRealizado.getProcedimentoRealizadoPK().getDataAtendimento());
                    
                    
                    
                        if(!temProcedimentoECbo(valor.substring(0, 9),proRealizado.getProcedimentoRealizadoPK().getCboMedico())){
                            return  MessagesErrors.exibeTelaContinuaErro(component,"","PROCED. INCOMPATIVEL COM CBO!", txtField);
                            //verifica se o procedimento exige sexo
                        }else if(pro.exigeSexo()){
                            String sexo =proRealizado.getSexoPaciente();
                            //verifica se o sexo digitado é compativel com o exigido
                        if(!pro.getSexo().toString().equals(sexo)){
                                return  MessagesErrors.exibeTelaContinuaErro(component,"","PROCED. INCOMPATIVEL COM O SEXO!", txtField);
                        }

                        }else  if(idadePaciente<idadeMinima || idadePaciente>idadeMaxima){
                                return  MessagesErrors.exibeTelaContinuaErro(component,"","PROCED. INCOMPATIVEL COM A IDADE!"+"\n IDADE MÍNIMA: "+idadeMinima+"\n IDADE MÁXIMA: "+idadeMaxima, txtField);
                            }
                  }
                  txtField.setBackground(Color.WHITE);
                  procNome.setText(procedimentosSearchead.get(0).getDescricao());
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
