/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import java.awt.Color;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class OnlyLettersVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;

    public OnlyLettersVerifier(Component component,String fieldName) {
        this.fieldName = fieldName;
        this.component = component;
    }
    
    
    @Override
    public boolean verify(JComponent input) {
       JTextComponent txtField = (JTextField) input; 
      String valor = txtField.getText();
       Pattern p = Pattern.compile("^[a-z,A-Z, ,.,ã,á,à,â,ê,í,ú,õ,é]+$");  
                Matcher m = p.matcher(valor);  
                if (!m.find()) {  
                    MessagesErrors.erro(component,txtField,fieldName + " INCORRETO!"+" USE SOMENTE LETRAS"); 
                    return  false;
                }
                  txtField.setBackground(Color.WHITE);
                return true;
       }
    
}
