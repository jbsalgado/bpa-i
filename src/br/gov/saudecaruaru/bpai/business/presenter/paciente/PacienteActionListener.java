/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.paciente;

import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juniorpires
 */
public class PacienteActionListener {
    static class NovoActionListener implements ActionListener{
        private PacientePresenter presenter;  
          
        public NovoActionListener(PacientePresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            PacienteView view = (PacienteView) this.presenter.getView(); 
                 this.presenter.habilitarEdicao(true);
                 this.presenter.novoPaciente();
                 view.clearFields();
                 
                 view.enableBtnEditar(false);
                 view.enableBtnCancelar(true);
                 
                 this.presenter.setOperacao(this.presenter.INSERT_STRATEGY);  
                 
        }
    }
    
    
    static class ConfirmarActionListener implements ActionListener{
        private PacientePresenter presenter;  
          
        public ConfirmarActionListener(PacientePresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            PacienteView view = (PacienteView) this.presenter.getView(); 
                 this.presenter.habilitarEdicao(false);
                 //view.enableBtnConfirmar(false);
                 view.enableBtnCancelar(false);
                 view.enableBtnEditar(false);
                 view.enableBtnNovo(true);
                 
                 //executa a operaçao escolhida
                 this.presenter.getOperacao().execute();
                 view.clearFields();
        }
    }
    
     static class EditarActionListener implements ActionListener{
        private PacientePresenter presenter;  
          
        public EditarActionListener(PacientePresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
           PacienteView view = (PacienteView) this.presenter.getView(); 
                 this.presenter.habilitarEdicao(true);
                 view.enableBtnConfirmar(true);
                 view.enableBtnCancelar(true);
                 this.presenter.habilitarEdicao(false);
                 
                 this.presenter.setOperacao(this.presenter.UPDATE_STRATEGY);  
                 
                 
        }
    }
}
