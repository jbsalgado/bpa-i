/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;


import br.gov.saudecaruaru.bpai.util.DateUtil;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class DataVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;

    public DataVerifier(Component component,String fieldName) {
        this.fieldName = fieldName;
        this.component = component;
    }
    
    

    @Override
    public boolean verify(JComponent input) {
       JTextField txtField = (JTextField) input;
       String valor = txtField.getText();
       //VALIDA O FORMATO DA DATA 
       if(!DateUtil.isValidBrDate(valor)){
           JOptionPane.showMessageDialog(this.component,fieldName+" INCORRETO!"
                   +"\n FORMATO INVALIDO","Erro de validação!", JOptionPane.ERROR_MESSAGE);
         txtField.setBackground(Color.RED);    
           return false;
       }
       txtField.setBackground(Color.WHITE);
       return true;
    }
    
}
