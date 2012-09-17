/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;

import br.gov.saudecaruaru.bpai.business.model.CaraterAtendimento;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
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
        int index = comboBoxField.getSelectedIndex();
        if(index==0){
             return  MessagesErrors.exibeTelaContinuaErro(component, fieldName,"INVÁLIDO!");
        }
        return true;
    }
    
}
