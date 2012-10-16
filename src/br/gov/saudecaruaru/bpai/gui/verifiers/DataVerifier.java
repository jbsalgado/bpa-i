/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;


import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.util.DateUtil;
import java.awt.Color;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
public class DataVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;

    public DataVerifier(Component component,String fieldName) {
        this.fieldName = fieldName;
        this.component = component;
    }
    
    

    @Override
    public boolean verify(JComponent input) {
       JTextField txtField = (JTextField) input;
       String valor = txtField.getText();
       //VALIDA O FORMATO DA DATA 
       if(!DateUtil.isValidBrDate(valor)){
           MessagesErrors.erro(component,txtField,fieldName+" INCORRETO!"); 
           return false;
       }
       txtField.setBackground(Color.WHITE);
       return true;
    }
    
}
