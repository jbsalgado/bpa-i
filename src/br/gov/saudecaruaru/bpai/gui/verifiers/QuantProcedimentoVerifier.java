/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;


import br.gov.saudecaruaru.bpai.business.validators.ProcedimentoRealizadoValidator;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
import java.awt.Color;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
public class QuantProcedimentoVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private TelaCadastroI t;
    private ProcedimentoRealizadoValidator prv;
    
    
    public QuantProcedimentoVerifier(Component component,String fieldName,TelaCadastroI t) {
        this.fieldName = fieldName;
        this.component = component;
        this.t = t;

    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextField txtField = (JTextField) input; 
      String valor = txtField.getText().trim();
               if (valor.isEmpty() || valor.equals("0")) {  
                   txtField.setText("0"); 
                   MessagesErrors.erro(component,txtField,"ERRO! QUANTIDADE ZERADA! ");
                   return  false;
                    
                }
               if(t.getProcedimentoRealizado().getCodigoProcedimento()!=null){
                      //insere o valor no modelo
                      t.getProcedimentoRealizado().setQuantidadeRealizada(Double.parseDouble(valor));
                      //instancia o objeto validador com o modelo
                      prv = new ProcedimentoRealizadoValidator(t.getProcedimentoRealizado());
                      //chama metodo de validacao
                      String msg = prv.validQuantidadeMaximaProcedimento();
                      //vrifica se retornou alguma mensagem de erro
                      if(!msg.equals("")){
                            //exibe mensagem de erro
                            MessagesErrors.erro(component,txtField,msg); 
                            return false;
                      }
             }
                  txtField.setBackground(Color.WHITE);
                return true;
       }
        
      
    
}
