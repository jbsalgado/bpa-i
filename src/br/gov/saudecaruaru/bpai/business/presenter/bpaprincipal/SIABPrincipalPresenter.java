/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.bpaprincipal;

import br.gov.saudecaruaru.bpai.business.model.ArquivoCnes;
import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.CadastroFamiliaPresenter;
import br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente.CadastroPacientePresenter;
import br.gov.saudecaruaru.bpai.business.presenter.importacaoarquivocnes.ImportacaoArquivoCnesPresenter;
import br.gov.saudecaruaru.bpai.business.presenter.importacaoarquivoocupacao.ImportacaoArquivoOcupacaoPresenter;
import br.gov.saudecaruaru.bpai.gui.SIABPrincipalWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.SIABPrincipalView;
import java.awt.Frame;
import javax.swing.JFileChooser;

/**
 * Presenter da View SIABPrincipal
 * @author Albuquerque
 * 
 */
public class SIABPrincipalPresenter {
    
    private SIABPrincipalView view;
    
    /**
     * Cria uma view e a exibi
     */
    public void createView(){
        
        this.view=new SIABPrincipalWindow();
        this.setUpListeners();
        this.view.packAndShow();
    }
    public SIABPrincipalView getView(){
        return this.view;
    }
    /**
     * Inicia todos os listeners
     */
    public void setUpListeners(){
        //actionListener
        this.view.setMenuItemFamiliaActionListener(new SIABPrincipalActionListener.MenuItemFamiliaActionListener(this));
        this.view.setMenuItemPacienteActionListener(new SIABPrincipalActionListener.MenuItemPacienteActionListener(this));
        this.view.setMenuItemImportarCnesActionListener(new SIABPrincipalActionListener.MenuItemImportarCnesActionListener(this));
        this.view.setMenuItemImportarOcupacaoActionListener(new SIABPrincipalActionListener.MenuItemImportarOcupacaoActionListener(this));
    }
    
    private String importarArquivoCnes(String path){
        ArquivoCnes arquivoCnes = new ArquivoCnes(path);
        arquivoCnes.salvarDadosSiab();
        return "OK";
    }
     public String escolherImportarArquivoCnes(){
         // TODO add your handling code here:
        JFileChooser fil= new JFileChooser();
        //fil.setDialogType(JFileChooser.OPEN_DIALOG);
        //fil.setFileFilter(new FileNameExtensionFilter("xml", ".xml"));
        fil.showSaveDialog((SIABPrincipalWindow)this.view);
        //arquivo foi encontrado
        String path=fil.getSelectedFile() != null ? fil.getSelectedFile().getAbsolutePath() : null;
        if( path!=null){
            return importarArquivoCnes(path);
        }
        
        return "ARQUIVO INVÃ�LIDO";
     
     }
    /**
     * Abre uma nova janela para cadastro de paciente
     */
    public void abrirCadastroPaciente(){
        CadastroPacientePresenter pacientePresenter = new CadastroPacientePresenter();
        pacientePresenter.createView();
    }
    
    /**
     * Abre uma nova janela para cadastro de famÃ­lia
     */
    public void abrirCadastroFamilia(){
        CadastroFamiliaPresenter familiaPresenter = new CadastroFamiliaPresenter();
        familiaPresenter.createView();
    }
    
     /**
     * Abre uma nova janela para importacao do arquivo cnes
     */
    public void abrirImportacaoCnes(){
        ImportacaoArquivoCnesPresenter cnesPresenter = new ImportacaoArquivoCnesPresenter();
        cnesPresenter.createView((Frame)this.getView(), true);
    }
    
    /**
     * Abre uma nova janela para importacao do arquivo ocupacao
     */
    public void abrirImportacaoOcupacao(){
        ImportacaoArquivoOcupacaoPresenter ocupacaoPresenter = new ImportacaoArquivoOcupacaoPresenter();
        ocupacaoPresenter.createView((Frame)this.getView(), true);
    }
}
