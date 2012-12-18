/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import java.awt.Color;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 *
 * @author Junior Pires
 */
  //classe validadora para comboBoxs
public class ClassificacaoVerifier extends InputVerifier{
        private Component component=null;
        private String fieldName; 
        private JComboBox jComboServico;
        
        
        public ClassificacaoVerifier(Component component,JComboBox jComboServico, String fieldName) {
            this.component=component;
            this.fieldName = fieldName;
            this.jComboServico = jComboServico;
            
        }

        @Override
            public boolean verify(JComponent input) {
                JComboBox jComboBox = (JComboBox) input;
                
                if (this.jComboServico.getSelectedItem() != null  && jComboBox.getSelectedItem() ==null) {  
                     MessagesErrors.erro(component,jComboBox,fieldName+" Obrigatório");
                     jComboBox.setBackground(Color.red);
                return false;  
                } 
                //seta cor branca
                jComboBox.setBackground(Color.GRAY); 
                return true;
            }
}
