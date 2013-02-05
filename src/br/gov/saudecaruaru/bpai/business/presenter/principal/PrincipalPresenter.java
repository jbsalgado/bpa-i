/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.principal;

import br.gov.saudecaruaru.bpai.gui.ListaProcedimento;
import br.gov.saudecaruaru.bpai.gui.PacienteWindow;
import br.gov.saudecaruaru.bpai.gui.PrincipalWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.PrincipalView;
import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author Albuquerque
 */
public class PrincipalPresenter {
    
    private PrincipalView view;

    public void createView(){
        this.view= new PrincipalWindow();
        
        this.setUpListeners();
        this.view.packAndShow();
        this.view.setVersao("Beta 0.1");
    }
    /**
     * Inicia todos os listeners
     */
    private void setUpListeners(){
        //mouselisteners
        this.view.setBPAIMouseListener(new PrincipalMouseListener.BPAIMouseListener(this));
        this.view.setSIABMouseListener(new PrincipalMouseListener.SIABMouseListener(this));
        this.view.setSobreMouseListener(new PrincipalMouseListener.SobreMouseListener(this));
        this.view.setContatoMouseListener(new PrincipalMouseListener.ContatoMouseListener(this));
        
        //actionlisteners
        this.view.setContatoActionListener(new PrincipalActionListener.ContatoActionListener(this));
        this.view.setSobreActionListener(new PrincipalActionListener.SobreActionListener(this));
    
    }
    
    /**
     * Abre o módulo BPAI
     */
    protected void abrirBPAI(){
        ListaProcedimento tela= new ListaProcedimento();
        tela.setVisible(true);
        
    }
    
    /**
     * Abre o módulo SIAB
     */
    protected void abrirSIAB(){
    
    }
    /**
     * Abre uma tela que fornece informações sobre o sistema
     */
    protected void abrirSobre(){
    }
    /**
     * Abre uma tela sobre contato com os desenvolvedores do sistema
     */
    protected void abrirContato(){
    }
}
