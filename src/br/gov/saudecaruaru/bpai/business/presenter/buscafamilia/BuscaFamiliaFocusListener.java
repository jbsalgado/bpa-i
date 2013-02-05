/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.buscafamilia;

import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.*;
import br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente.*;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author juniorpires
 */
public class BuscaFamiliaFocusListener {
  
  
       
    
  
  static class CompletarComZerosFocusListener implements FocusListener{ 
        private String quantZeros; 
        
        public  CompletarComZerosFocusListener(String quantZeros) {  
            this.quantZeros = quantZeros;
        }

        @Override
        public void focusGained(FocusEvent e) {
           
        }

        @Override
        public void focusLost(FocusEvent e) {
             if(e.getComponent()instanceof JTextField){
                 //pega a referencia ao textField
                 JTextField field = (JTextField) e.getComponent();
                 //pega o valor do campo
                 String valor = field.getText();
                 if(!valor.isEmpty()){
                    //completa com zeros a esquerda se necessario
                    String formatado = String.format("%0"+this.quantZeros+"d",Integer.parseInt(valor));
                    //seta o novo valor no campo
                    field.setText(formatado);
                 }
             }
        }
       
    }
}
