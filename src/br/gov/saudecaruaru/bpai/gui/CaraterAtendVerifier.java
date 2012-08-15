/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.model.CaraterAtendimento;
import java.awt.Component;
import javax.swing.*;

/**
 *
 * @author Junior Pires
 */
public class CaraterAtendVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;

    public CaraterAtendVerifier(Component component,String fieldName) {
        this.fieldName = fieldName;
        this.component = component;
    }
   
    

    
    @Override
    public boolean verify(JComponent input) {
        JComboBox comboBoxField = (JComboBox) input;
        String valor = comboBoxField.getSelectedItem().toString();
        if(valor.equals(CaraterAtendimento.SEM_INFORMACAO.desc())){
             JOptionPane.showMessageDialog(this.component,fieldName + " INVÁLIDO!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE);
             return false;
        }
        return true;
    }
    
}
