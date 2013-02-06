/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.bpaprincipal;

import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.CadastroFamiliaPresenter;
import br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente.CadastroPacientePresenter;
import br.gov.saudecaruaru.bpai.gui.SIABPrincipalWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.SIABPrincipalView;

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
    
    /**
     * Inicia todos os listeners
     */
    public void setUpListeners(){
        //actionListener
        this.view.setMenuItemFamiliaActionListener(new SIABPrincipalActionListener.MenuItemFamiliaActionListener(this));
        this.view.setMenuItemPacienteActionListener(new SIABPrincipalActionListener.MenuItemPacienteActionListener(this));
    }
    /**
     * Abre uma nova janela para cadastro de paciente
     */
    public void abrirCadastroPaciente(){
        CadastroPacientePresenter pacientePresenter = new CadastroPacientePresenter();
        pacientePresenter.createView();
    }
    
    /**
     * Abre uma nova janela para cadastro de família
     */
    public void abrirCadastroFamilia(){
        CadastroFamiliaPresenter familiaPresenter = new CadastroFamiliaPresenter();
        familiaPresenter.createView();
    }
}
