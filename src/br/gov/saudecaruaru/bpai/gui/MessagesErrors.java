/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
public class MessagesErrors {
  
    public static boolean continuaErro(Component component,String fieldName,String msg,JTextField txtField){
          if(JOptionPane.showOptionDialog(component, fieldName+" "+msg+"\n CONTINUA (C/ ERRO)","Erro de validação!",
                               JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==JOptionPane.NO_OPTION){
                txtField.setBackground(Color.RED);
                    return false;
                 }else{
                       txtField.setBackground(Color.RED);    
                       return true;
                       }
    }
    
     public static boolean continuaErro(Component component,String fieldName,String msg){
          if(JOptionPane.showOptionDialog(component, fieldName+" "+msg+"\n CONTINUA (C/ ERRO)","Erro de validação!",
                               JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==JOptionPane.NO_OPTION){
                return false;
          }else{
                return true;
          }
    }
     
     public static void erro(Component component,JComponent field,String msg){
         JOptionPane.showMessageDialog(component,msg,"Erro de validação!", JOptionPane.ERROR_MESSAGE); 
         field.setBackground(Color.RED);
     }
     
     
    
    
}
