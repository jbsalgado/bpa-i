/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
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
                JTextField textField = (JTextField) input;
                String valor = textField.getText().trim();
                if (valor.equals("000") || valor.isEmpty()) {  
                      JOptionPane.showMessageDialog(component," Folha Inválida!",   
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                //seta cor vermelha
                textField.setBackground(Color.RED);  
                return false;  
                } 
                //seta cor branca
                textField.setBackground(Color.WHITE); 
                return true;
            }
}
