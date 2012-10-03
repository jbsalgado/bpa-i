/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
public class MessagesErrors {
    private static int OPCAO_SIM = 0;
    private static int OPCAO_NAO = 1;
    public static boolean exibeTelaContinuaErro(Component component,String fieldName,String msg,JTextField txtField){
          if(JOptionPane.showOptionDialog(component, fieldName+" "+msg+"\n CONTINUA (C/ ERRO)","Erro de validação!",
                               JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==OPCAO_NAO){
                txtField.setBackground(Color.RED);
                    return false;
                 }else{
                       txtField.setBackground(Color.RED);    
                       return true;
                       }
    }
    public static boolean exibeTelaQuestaoErro(Component component,String msg,JTextField txtField){
          if(JOptionPane.showOptionDialog(component,msg+"\n SAIR DO CAMPO?","Erro de validação!",
                               JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==OPCAO_NAO){
                        txtField.setBackground(Color.RED);
                        return false;
                 }else{ 
                        txtField.setBackground(Color.WHITE);
                        txtField.setText("");
                        return true;
                       }
    }
    
     public static boolean exibeTelaContinuaErro(Component component,String fieldName,String msg){
          if(JOptionPane.showOptionDialog(component, fieldName+" "+msg+"\n CONTINUA (C/ ERRO)","Erro de validação!",
                               JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==OPCAO_NAO){
                return false;
          }else{
                return true;
          }
    }
    
}
