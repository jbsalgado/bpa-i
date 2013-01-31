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
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
  //classe validadora para o campo CNSUsuario
public class CepVerifier extends InputVerifier{
        private Component component=null;
        private String fieldName;
        public CepVerifier(Component component, String fieldName) {
            this.component=component;
            this.fieldName = fieldName;
            
        }

       @Override
            public boolean verify(JComponent input) {
                JTextField field = (JTextField) input;
                //expressão regular para mês
                Pattern p = Pattern.compile("^[0-9]{2}.[0-9]{3}-[0-9]{3}$");  
                Matcher m = p.matcher(field.getText());  
                if (!m.find()) {  
                     MessagesErrors.erro(component,field,this.fieldName+" Inválido!"); 
                return false;  
                } 
                //seta cor branca
                field.setBackground(Color.WHITE); 
                return true;
           }
}
