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
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
  //classe validadora para o campo CNSUsuario
public class SexoVerifier extends CnsVerifier{
        private Component component=null;
        
        public SexoVerifier(Component component, String fieldName) {
            super(component, fieldName);
            this.component=component;
            
        }

        @Override
            public boolean verify(JComponent input) {
                JTextField sexo = (JTextField) input;
                //expressão regular para sexo (só permite M ou F)
                Pattern p = Pattern.compile("^[M|F]$");  
                Matcher m = p.matcher(sexo.getText());  
                if (!m.find()) {  
                   MessagesErrors.erro(component,sexo," Sexo Inválido!"); 
                   return false;  
                } 
                sexo.setBackground(Color.WHITE); 
                return true;
           }
}
