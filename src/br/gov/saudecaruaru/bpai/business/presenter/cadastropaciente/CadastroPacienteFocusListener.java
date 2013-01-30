/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente;

import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author juniorpires
 */
public class CadastroPacienteFocusListener {
  
        static class CnsFocusListener implements FocusListener{
        private CadastroPacientePresenter presenter;  
          
        public  CnsFocusListener(CadastroPacientePresenter presenter) {  
            this.presenter = presenter;  
        }

        @Override
        public void focusGained(FocusEvent e) {
           
        }

        @Override
        public void focusLost(FocusEvent e) {
             PacienteView view = this.presenter.getView();
             if(this.presenter.exibePaciente(view.getCns())){
                 view.enableBtnNovo(false);
                 view.enableBtnConfirmar(false);
                 view.enableBtnEditar(true);
                 view.enableBtnCancelar(true);
             }
             
        }
       
    }
}
