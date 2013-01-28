/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente;


import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Junior Pires
 */
public class CadastroPacienteWindowMouseListener {
    
    static class SelecionarLinhaMouseListener implements MouseListener{
        private CadastroPacientePresenter presenter;

          
        public SelecionarLinhaMouseListener(CadastroPacientePresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void mouseClicked(MouseEvent e) {
          
            PacienteView view = this.presenter.getView();
            this.presenter.atualizarModeloDaJTable();
            this.presenter.habilitarEdicao(true);
            view.enableBtnEditar(true);
            view.enableBtnNovo(false);
            view.enableBtnConfirmar(false);
            view.enableTxtCns(false);
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
