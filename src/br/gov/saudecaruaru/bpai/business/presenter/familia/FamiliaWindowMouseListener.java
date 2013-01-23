/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.familia;


import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Junior Pires
 */
public class FamiliaWindowMouseListener {
    
    static class SelecionarLinhaMouseListener implements MouseListener{
        private FamiliaPresenter presenter;  
          
        public SelecionarLinhaMouseListener(FamiliaPresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            FamiliaView view = this.presenter.getView();
            this.presenter.atualizarModeloDaJTable();
            this.presenter.habilitarEdicao(true);
            view.enableBtnEditar(true);
            view.enableBtnNovo(false);
            view.enableBtnConfirmar(false);
            
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
           
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           
        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }
    
    }
}
