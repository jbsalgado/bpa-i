/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import java.awt.Color;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
  //classe validadora para o campo CNSUsuario
public class MesVerifier extends CnsVerifier{
        private Component component=null;
        
        public MesVerifier(Component component, String fieldName) {
            super(component, fieldName);
            this.component=component;
            
        }

       @Override
            public boolean verify(JComponent input) {
                JTextField mes = (JTextField) input;
                //expressão regular para mês
                Pattern p = Pattern.compile("([0-9]|0[1-9]|[1][0-2])");  
                Matcher m = p.matcher(mes.getText());  
                if (!m.find()) {  
                      JOptionPane.showMessageDialog(component," Mês Inválido!",   
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                //seta cor vermelha
                mes.setBackground(Color.RED);  
                return false;  
                } 
                //seta cor branca
                mes.setBackground(Color.WHITE); 
                return true;
           }
}
