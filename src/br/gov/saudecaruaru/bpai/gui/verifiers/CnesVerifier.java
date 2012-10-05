/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import java.awt.Color;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class CnesVerifier extends InputVerifier {  
   private String fieldName; 
   private Component component;
   public CnesVerifier(Component component, String fieldName) {  
      this.fieldName = fieldName; 
      this.component=component;
   }  
  
    @Override
   public boolean verify(JComponent input) {  
      
      JTextComponent txtField = (JTextField) input; 
      String valor = txtField.getText();
      
       
          if(!validaCnes(valor)){
            JOptionPane.showMessageDialog(this.component,fieldName + " INCORRETO!",   
                "Erro de validação!", JOptionPane.ERROR_MESSAGE);
            txtField.setBackground(Color.RED);
            return false;  
         
          }
     
         
      txtField.setBackground(Color.WHITE);
      return true;  
    }  
    
      
        public static boolean validaCnes(String cns){
        if (cns.trim().length() != 7){
            return(false);
        }

        float soma;
        float resto, dv;
        String cod = new String("");
        String resultado = new String("");
        cod = cns.substring(0,6);
        //System.out.println("Cod "+cod);
      
        
        soma = ((Integer.valueOf(cod.substring(0,1)).intValue()) * 7) +
               ((Integer.valueOf(cod.substring(1,2)).intValue()) * 6) +
               ((Integer.valueOf(cod.substring(2,3)).intValue()) * 5) +
               ((Integer.valueOf(cod.substring(3,4)).intValue()) * 4) +
               ((Integer.valueOf(cod.substring(4,5)).intValue()) * 3) +
               ((Integer.valueOf(cod.substring(5,6)).intValue()) * 2);
         // System.out.println("Soma "+soma);
        resto = soma % 11;
        //  System.out.println("Resto "+resto);
        dv = 11 - resto;
         // System.out.println("DV "+dv);
        if (dv == 11 || dv==10){
            dv = 0;
        }

       
        resultado = cod+String.valueOf((int)dv);
         // System.out.println("Resultado "+resultado);

        if (! cns.equals(resultado)){
            return(false);
        }else {
        return(true);}
    }
        
        
        
       


}  
