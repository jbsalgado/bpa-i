/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.importacaoarquivoocupacao;

import br.gov.saudecaruaru.bpai.business.model.ArquivoCnes;
import br.gov.saudecaruaru.bpai.business.model.ArquivoOcupacao;
import br.gov.saudecaruaru.bpai.business.model.BIOcupacao;
import br.gov.saudecaruaru.bpai.business.presenter.bpaprincipal.SIABPrincipalActionListener;
import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.CadastroFamiliaPresenter;
import br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente.CadastroPacientePresenter;
import br.gov.saudecaruaru.bpai.data.BIOcupacaoDAO;
import br.gov.saudecaruaru.bpai.gui.ImportacaoArquivoCnesWindow;
import br.gov.saudecaruaru.bpai.gui.ImportacaoArquivoOcupacaoWindow;
import br.gov.saudecaruaru.bpai.gui.SIABPrincipalWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.ImportacaoArquivoCnesView;
import br.gov.saudecaruaru.bpai.gui.interfaces.ImportacaoArquivoOcupacaoView;
import br.gov.saudecaruaru.bpai.gui.interfaces.SIABPrincipalView;
import java.util.List;

import javax.swing.JFileChooser;

/**
 * Presenter da View SIABPrincipal
 * @author Albuquerque
 * 
 */
public class ImportacaoArquivoOcupacaoPresenter {
    
    private ImportacaoArquivoOcupacaoView view;
    
    /**
     * Cria uma view e a exibi
     */
    public void createView(java.awt.Frame parent, boolean modal){
        
        this.view=new ImportacaoArquivoOcupacaoWindow(parent,modal);
        this.setUpListeners();
        this.view.packAndShow();
    }
    public ImportacaoArquivoOcupacaoView getView(){
        return this.view;
    }
    /**
     * Inicia todos os listeners
     */
    public void setUpListeners(){
        //actionListener
        this.view.setEscolherArquivoActionListener(new ImportacaoArquivoOcupacaoActionListener.ImportarArquivoOcupacaoActionListener(this));
    }
    
    private String importarArquivoOcupacao(String path){
        ArquivoOcupacao arquivoOcupacao = new ArquivoOcupacao(path);
        List<BIOcupacao> list = arquivoOcupacao.lerArquivoOcupacao();
        
        BIOcupacaoDAO ocupacaoDAO = new BIOcupacaoDAO();
        for (BIOcupacao bIOcupacao : list) {
            try {
               ocupacaoDAO.merge(bIOcupacao);
            } catch (Exception e) {
                return "Um erro inesperado ocorreu. Entre em contato com os desenvolvedores";
            }
          
        }
        return "Importação realizada com sucesso!";
         
    }
     public String escolherImportarArquivoOcupacao(){
         // TODO add your handling code here:
        JFileChooser fil= new JFileChooser();
        //fil.setDialogType(JFileChooser.OPEN_DIALOG);
        //fil.setFileFilter(new FileNameExtensionFilter("xml", ".xml"));
        fil.showSaveDialog((ImportacaoArquivoOcupacaoWindow)this.view);
        //arquivo foi encontrado
        String path=fil.getSelectedFile() != null ? fil.getSelectedFile().getAbsolutePath() : null;
        if( path!=null){
            return importarArquivoOcupacao(path);
        }
        
        return "ARQUIVO INVÁLIDO";
     
     }
   
    
    
}
