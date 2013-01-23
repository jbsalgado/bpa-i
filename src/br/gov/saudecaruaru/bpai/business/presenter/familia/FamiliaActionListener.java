/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.familia;

import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juniorpires
 */
public class FamiliaActionListener {
    static class NovoActionListener implements ActionListener{
        private FamiliaPresenter presenter;  
          
        public NovoActionListener(FamiliaPresenter presenter) {  
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
                 
                 this.presenter.setOperacao(this.presenter.INSERT_STRATEGY);  
                 
        }
    }
    
    
    static class ConfirmarActionListener implements ActionListener{
        private FamiliaPresenter presenter;  
          
        public ConfirmarActionListener(FamiliaPresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            FamiliaView view = (FamiliaView) this.presenter.getView(); 
                 this.presenter.habilitarEdicao(false);
                 view.enableBtnConfirmar(false);
                 view.enableBtnCancelar(false);
                 
                 //executa a operaçao escolhida
                 this.presenter.getOperacao().execute();
                 view.clearFields();
        }
    }
}
