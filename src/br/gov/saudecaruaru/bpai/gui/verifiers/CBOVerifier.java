/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.business.validators.ProcedimentoRealizadoValidator;
import br.gov.saudecaruaru.bpai.gui.CadastroIndividualizado;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
import java.awt.Color;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class CBOVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private ProcedimentoRealizadoValidator prv;
    private TelaCadastroI t;
    public CBOVerifier(Component component,String fieldName,TelaCadastroI t) {
        this.fieldName = fieldName;
        this.component = component;
        this.t=t;
        prv = new ProcedimentoRealizadoValidator(t.getProcedimentoRealizado());
    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextComponent txtField = (JTextField) input; 
      String valor = txtField.getText();
                boolean jaValidado = CadastroIndividualizado.ARRAY_CBO.contains(valor);
                if(!jaValidado){
                    //insere o valor no modelo
                    t.getProcedimentoRealizado().getProcedimentoRealizadoPK().setCboMedico(valor);
                    //instancia o validador com o modelo 
                    prv = new ProcedimentoRealizadoValidator(t.getProcedimentoRealizado());
                    //executa validador
                    String msg = prv.validExisteCBO();
                    //verifica se retornou alguma mensagem de erro
                    if(!msg.equals("")){
                          //exibe mensagem de erro
                          MessagesErrors.erro(component,txtField,msg); 
                         return false;
                     }
                    //vai adicionar o CBO a esse array para futuras consultas
                    CadastroIndividualizado.ARRAY_CBO.add(valor);
                }
                txtField.setBackground(Color.WHITE);
                return true;
       }
    
}
