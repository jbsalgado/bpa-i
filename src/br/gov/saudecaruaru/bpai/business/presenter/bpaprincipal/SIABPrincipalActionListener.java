/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.bpaprincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Albuquerque
 */
public class SIABPrincipalActionListener {
    
    public static class MenuItemPacienteActionListener implements ActionListener{
        private SIABPrincipalPresenter presenter;

        public MenuItemPacienteActionListener(SIABPrincipalPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.presenter.abrirCadastroPaciente();
        }
        
        
    }
    
    public static class MenuItemFamiliaActionListener implements ActionListener{
        private SIABPrincipalPresenter presenter;

        public MenuItemFamiliaActionListener(SIABPrincipalPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            this.presenter.abrirCadastroFamilia();
        }
        
        
    }
}
