/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.buscafamilia;

import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.*;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author juniorpires
 */
public class BuscaFamiliaActionListener {
    static class BuscaActionListener implements ActionListener{
        private BuscaFamiliaPresenter presenter;  
          
        public BuscaActionListener(BuscaFamiliaPresenter presenter) {  
            this.presenter = presenter;  
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            FamiliaView view = (FamiliaView) this.presenter.getView(); 
            this.presenter.buscarFamilias();    
                 
        }
    }
    
}
