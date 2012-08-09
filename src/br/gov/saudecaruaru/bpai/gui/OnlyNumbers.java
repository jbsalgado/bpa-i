/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
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
public class OnlyNumbers extends InputVerifier{
    private String fieldName; 
    private Component component;

    public OnlyNumbers(Component component,String fieldName) {
        this.fieldName = fieldName;
        this.component = component;
    }
    
    

    @Override
    public boolean verify(JComponent input) {
       JTextField txtField = (JTextField) input;
       String valor = txtField.getText();
       
       Pattern p = Pattern.compile("^[0-9]+$"); 
       Matcher m = p.matcher(valor);
       if(!m.find()){
           JOptionPane.showMessageDialog(this.component,fieldName+" INCORRETO!"
                   +"\n USE SOMENTE NÚMEROS","Erro de validação!", JOptionPane.ERROR_MESSAGE);
         txtField.setBackground(Color.RED);    
           return false;
       }
       txtField.setBackground(Color.WHITE);
       return true;
    }
    
}
