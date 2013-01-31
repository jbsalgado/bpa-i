/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia;

import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author juniorpires
 */
public class CadastroFamiliaActionListener {
    static class NovoActionListener implements ActionListener{
        private CadastroFamiliaPresenter presenter;  
          
        public NovoActionListener(CadastroFamiliaPresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            FamiliaView view = (FamiliaView) this.presenter.getView(); 
                 this.presenter.habilitarEdicao(true);
                 this.presenter.novaFamilia();
                 view.clearFields();
                 
                 view.enableBtnEditar(false);
                 view.enableBtnCancelar(true);
                 view.enableBtnConfirmar(true);
                 view.enableBtnNovo(false);
                 
                 this.presenter.setOperacao(this.presenter.INSERT_STRATEGY);  
                 
        }
    }
    
    
    static class ConfirmarActionListener implements ActionListener{
        private CadastroFamiliaPresenter presenter;  
          
        public ConfirmarActionListener(CadastroFamiliaPresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            FamiliaView view = (FamiliaView) this.presenter.getView(); 
                 this.presenter.habilitarEdicao(false);
                 //view.enableBtnConfirmar(false);
                 view.enableBtnCancelar(false);
                 view.enableBtnEditar(false);
                 view.enableBtnNovo(true);
                 view.enableBtnConfirmar(false);
                 
                 //executa a operaçao escolhida
                 this.presenter.getOperacao().execute();
                 view.clearFields();
        }
    }
    
     static class EditarActionListener implements ActionListener{
        private CadastroFamiliaPresenter presenter;  
          
        public EditarActionListener(CadastroFamiliaPresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            FamiliaView view = (FamiliaView) this.presenter.getView(); 
                 this.presenter.habilitarEdicao(true);
                 view.enableBtnConfirmar(true);
                 view.enableBtnCancelar(true);
                 this.presenter.habilitarEdicao(false);
                 
                 this.presenter.setOperacao(this.presenter.UPDATE_STRATEGY);  
                 
                 
        }
    }
     
       static class CancelarActionListener implements ActionListener{
        private CadastroFamiliaPresenter presenter;  
          
        public CancelarActionListener(CadastroFamiliaPresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
           FamiliaView view = (FamiliaView) this.presenter.getView(); 
                 view.clearFields();
                 this.presenter.habilitarEdicao(false);
                 view.enableBtnConfirmar(false);
                 view.enableBtnEditar(false);
                 view.enableBtnCancelar(false);
                 view.enableBtnNovo(true);
                 
                 
        }
    }
       
       
}
