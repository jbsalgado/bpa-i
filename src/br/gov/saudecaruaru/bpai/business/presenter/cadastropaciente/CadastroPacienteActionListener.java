/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente;

import br.gov.saudecaruaru.bpai.business.presenter.buscafamilia.BuscaFamiliaPresenter;
import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.CadastroFamiliaPresenter;
import br.gov.saudecaruaru.bpai.gui.PacienteWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author juniorpires
 */
public class CadastroPacienteActionListener {
    static class NovoActionListener implements ActionListener{
        private CadastroPacientePresenter presenter;  
          
        public NovoActionListener(CadastroPacientePresenter presenter) {  
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
        private CadastroPacientePresenter presenter;  
          
        public ConfirmarActionListener(CadastroPacientePresenter presenter) {  
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
        private CadastroPacientePresenter presenter;  
          
        public EditarActionListener(CadastroPacientePresenter presenter) {  
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
     
     static class FamiliaActionListener implements ActionListener{
        private CadastroPacientePresenter presenter;  
          
        public FamiliaActionListener(CadastroPacientePresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
           PacienteWindow view = (PacienteWindow) this.presenter.getView(); 
              BuscaFamiliaPresenter buscaFamiliaPresenter = new BuscaFamiliaPresenter();
              buscaFamiliaPresenter.createView(view);
                 
                 
        }
    }
     
     static class CancelarActionListener implements ActionListener{
        private CadastroPacientePresenter presenter;  
          
        public CancelarActionListener(CadastroPacientePresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
          PacienteView view = (PacienteView) this.presenter.getView(); 
                 view.clearFields();
                 this.presenter.habilitarEdicao(false);
                 view.enableBtnConfirmar(false);
                 view.enableBtnCancelar(false);
                 
                 
        }
    }
}
