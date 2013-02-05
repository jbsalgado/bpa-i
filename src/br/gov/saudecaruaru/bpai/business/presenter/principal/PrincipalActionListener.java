/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.principal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Albuquerque
 */
public class PrincipalActionListener {
    
    public static class ContatoActionListener implements ActionListener{
        private PrincipalPresenter presenter;

        public ContatoActionListener(PrincipalPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
        
    }
    
    public static class SobreActionListener implements ActionListener{
        private PrincipalPresenter presenter;

        public SobreActionListener(PrincipalPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
        
    }
}
