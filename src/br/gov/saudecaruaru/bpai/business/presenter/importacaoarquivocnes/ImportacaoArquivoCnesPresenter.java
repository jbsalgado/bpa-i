/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.importacaoarquivocnes;

import br.gov.saudecaruaru.bpai.business.model.ArquivoCnes;
import br.gov.saudecaruaru.bpai.business.presenter.bpaprincipal.SIABPrincipalActionListener;
import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.CadastroFamiliaPresenter;
import br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente.CadastroPacientePresenter;
import br.gov.saudecaruaru.bpai.gui.ImportacaoArquivoCnesWindow;
import br.gov.saudecaruaru.bpai.gui.SIABPrincipalWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.ImportacaoArquivoCnesView;
import br.gov.saudecaruaru.bpai.gui.interfaces.SIABPrincipalView;

import javax.swing.JFileChooser;

/**
 * Presenter da View SIABPrincipal
 * @author Albuquerque
 * 
 */
public class ImportacaoArquivoCnesPresenter {
    
    private ImportacaoArquivoCnesView view;
    
    /**
     * Cria uma view e a exibi
     */
    public void createView(java.awt.Frame parent, boolean modal){
        
        this.view=new ImportacaoArquivoCnesWindow(parent,modal);
        this.setUpListeners();
        this.view.packAndShow();
    }
    public ImportacaoArquivoCnesView getView(){
        return this.view;
    }
    /**
     * Inicia todos os listeners
     */
    public void setUpListeners(){
        //actionListener
        this.view.setEscolherArquivoActionListener(new ImportacaoArquivoCnesActionListener.ImportarArquivoCnesActionListener(this));
    }
    
    private String importarArquivoCnes(String path){
        ArquivoCnes arquivoCnes = new ArquivoCnes(path);
        return arquivoCnes.salvarDadosSiab();
         
    }
     public String escolherImportarArquivoCnes(){
         // TODO add your handling code here:
        JFileChooser fil= new JFileChooser();
        //fil.setDialogType(JFileChooser.OPEN_DIALOG);
        //fil.setFileFilter(new FileNameExtensionFilter("xml", ".xml"));
        fil.showSaveDialog((ImportacaoArquivoCnesWindow)this.view);
        //arquivo foi encontrado
        String path=fil.getSelectedFile() != null ? fil.getSelectedFile().getAbsolutePath() : null;
        if( path!=null){
            return importarArquivoCnes(path);
        }
        
        return "ARQUIVO INVÁLIDO";
     
     }
   
    
    
}
