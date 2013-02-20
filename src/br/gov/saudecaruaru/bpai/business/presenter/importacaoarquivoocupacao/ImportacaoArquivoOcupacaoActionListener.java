/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.importacaoarquivoocupacao;

import br.gov.saudecaruaru.bpai.business.presenter.bpaprincipal.SIABPrincipalPresenter;
import br.gov.saudecaruaru.bpai.business.presenter.principal.*;
import br.gov.saudecaruaru.bpai.gui.ImportacaoArquivoCnesWindow;
import br.gov.saudecaruaru.bpai.gui.ImportacaoArquivoOcupacaoWindow;
import br.gov.saudecaruaru.bpai.gui.SIABPrincipalWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Albuquerque
 */
public class ImportacaoArquivoOcupacaoActionListener {
    
    public static class ImportarArquivoOcupacaoActionListener implements ActionListener{
        private ImportacaoArquivoOcupacaoPresenter presenter;

        public ImportarArquivoOcupacaoActionListener(ImportacaoArquivoOcupacaoPresenter presenter) {
            this.presenter = presenter;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
          ImportacaoArquivoOcupacaoWindow view = (ImportacaoArquivoOcupacaoWindow) this.presenter.getView();
          String msg =  this.presenter.escolherImportarArquivoOcupacao();
          JOptionPane.showMessageDialog(view,msg);
        }
        
        
    }
}
