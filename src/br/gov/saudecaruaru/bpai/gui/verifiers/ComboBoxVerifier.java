/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import java.awt.Color;
import java.awt.Component;
import java.lang.reflect.Field;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
  //classe validadora para comboBoxs
public class ComboBoxVerifier extends InputVerifier{
        private Component component=null;
        private String fieldName; 
        public ComboBoxVerifier(Component component, String fieldName) {
            this.component=component;
            this.fieldName = fieldName;
            
        }

        @Override
            public boolean verify(JComponent input) {
                JComboBox jComboBox = (JComboBox) input;
                
                if (jComboBox.getModel().getSize()!=0 && jComboBox.getSelectedItem()==null ) {  
                      JOptionPane.showMessageDialog(component,fieldName+" Obrigatório",   
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                //seta cor vermelha
               jComboBox.setBackground(Color.RED);  
                return false;  
                } 
                //seta cor branca
                jComboBox.setBackground(Color.GRAY); 
                return true;
            }
}
