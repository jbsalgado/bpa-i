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

/**
 *
 * @author Junior Pires
 */
public class AnoCompetenciaVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;

    public AnoCompetenciaVerifier(Component component,String fieldName) {
        this.fieldName = fieldName;
        this.component = component;
    }
    
    

    @Override
    public boolean verify(JComponent input) {
       JTextField txtField = (JTextField) input;
       String valor = txtField.getText();
       
       Pattern p = Pattern.compile("[0-9][0-9][0-9][0-9]"); 
       Matcher m = p.matcher(valor);
       if(valor.trim().isEmpty()){
           MessagesErrors.erro(component,txtField,fieldName+" INVALIDO!");    
           return false;
       }
       if(!m.find()){
           MessagesErrors.erro(component,txtField,fieldName+" INVALIDO!");  
           return false;
       }
       
       if(Integer.parseInt(valor)<2007){
           MessagesErrors.erro(component,txtField,fieldName+" INVALIDO!\n"
                   + "NÃO PERMITIDO VALORES ANTERIORES A 2007");
           return false;
       }
       txtField.setBackground(Color.WHITE);
       return true;
    }
    
}
