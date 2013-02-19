/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.importacaoarquivocnes;

import br.gov.saudecaruaru.bpai.business.presenter.bpaprincipal.SIABPrincipalPresenter;
import br.gov.saudecaruaru.bpai.business.presenter.principal.*;
import br.gov.saudecaruaru.bpai.gui.ImportacaoArquivoCnesWindow;
import br.gov.saudecaruaru.bpai.gui.SIABPrincipalWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Albuquerque
 */
public class ImportacaoArquivoCnesActionListener {
    
    public static class ImportarArquivoCnesActionListener implements ActionListener{
        private ImportacaoArquivoCnesPresenter presenter;

        public ImportarArquivoCnesActionListener(ImportacaoArquivoCnesPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
          ImportacaoArquivoCnesWindow view = (ImportacaoArquivoCnesWindow) this.presenter.getView();
          String msg =  this.presenter.escolherImportarArquivoCnes();
          JOptionPane.showMessageDialog(view,msg);
        }
        
        
    }
}
