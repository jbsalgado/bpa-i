/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia;

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
public class CadastroFamiliaFocusListener {
  
  static class FamiliaFocusListener implements FocusListener{
        private CadastroFamiliaPresenter presenter;  
          
        public  FamiliaFocusListener(CadastroFamiliaPresenter presenter) {  
            this.presenter = presenter;  
        }

        @Override
        public void focusGained(FocusEvent e) {
           
        }

        @Override
        public void focusLost(FocusEvent e) {
             FamiliaView view = this.presenter.getView();
             if(this.presenter.exibeFamilia()){
                 view.enableBtnNovo(false);
                 view.enableBtnConfirmar(false);
                 view.enableBtnEditar(true);
                 view.enableBtnCancelar(true);
                
                 this.presenter.desabilitaCabecalho();
             }
             
        }
       
    }
  
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
                 //completa com zeros a esquerda se necessario
                 String formatado = String.format("%0"+this.quantZeros+"d",Integer.parseInt(valor));
                 //seta o novo valor no campo
                 field.setText(formatado);
             }
        }
       
    }
}
