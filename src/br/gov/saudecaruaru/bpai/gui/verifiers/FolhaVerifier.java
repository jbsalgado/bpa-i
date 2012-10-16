/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
  //classe validadora para o campo CNSUsuario
public class FolhaVerifier extends CnsVerifier{
        private Component component=null;
        
        public FolhaVerifier(Component component, String fieldName) {
            super(component, fieldName);
            this.component=component;
            
        }

        @Override
            public boolean verify(JComponent input) {
                JTextField txtField = (JTextField) input;
                String valor = txtField.getText().trim();
                if (valor.equals("000") || valor.isEmpty()) {  
                     MessagesErrors.erro(component,txtField," Folha Inválida!");  
                return false;  
                } 
                //seta cor branca
                txtField.setBackground(Color.WHITE); 
                return true;
            }
}
