/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.business.validators.CnpjValidator;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
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
public class CnpjVerifier extends InputVerifier {
     private String fieldName; 
     private Component component;
     
      public CnpjVerifier(Component component, String fieldName) {  
        this.fieldName = fieldName; 
        this.component=component;
      }  
      
    @Override
    public boolean verify(JComponent input) {
         JTextComponent txtField = (JTextField) input; 
         String valor = txtField.getText();
         
         valor = valor.replaceAll("[/,.,-]","").trim();
         if(!valor.isEmpty()){
                if(!CnpjValidator.validaCnpj(valor)){
                        MessagesErrors.erro(component,txtField,fieldName + " INCORRETO!");  
                    return false;  
                }
       }  
         txtField.setBackground(Color.WHITE);
         return true;
    }
    
}
