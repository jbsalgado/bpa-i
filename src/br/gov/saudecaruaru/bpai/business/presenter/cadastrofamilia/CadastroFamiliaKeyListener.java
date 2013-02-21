/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author juniorpires
 */
public class CadastroFamiliaKeyListener {
    
    static class TxtAreaKeyKistener implements KeyListener{
        CadastroFamiliaPresenter presenter;

        public TxtAreaKeyKistener(CadastroFamiliaPresenter presenter) {
            this.presenter = presenter;
        }
        
        
        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
          if(e.getKeyCode()==KeyEvent.VK_F1){
              this.presenter.selecionarArea();
          }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    
    }
    
    
    static class TxtMicroareaKeyKistener implements KeyListener{
        CadastroFamiliaPresenter presenter;

        public TxtMicroareaKeyKistener(CadastroFamiliaPresenter presenter) {
            this.presenter = presenter;
        }
        
        
        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
          if(e.getKeyCode()==KeyEvent.VK_F1){
              this.presenter.selecionarMicroarea();
          }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    
    }
    
     static class TxtSegmentoKeyKistener implements KeyListener{
        CadastroFamiliaPresenter presenter;

        public TxtSegmentoKeyKistener(CadastroFamiliaPresenter presenter) {
            this.presenter = presenter;
        }
        
        
        @Override
        public void keyTyped(KeyEvent e) {
           
        }

        @Override
        public void keyPressed(KeyEvent e) {
          if(e.getKeyCode()==KeyEvent.VK_F1){
              this.presenter.selecionarSegmento();
          }
        }

        @Override
        public void keyReleased(KeyEvent e) {
           
        }
    
    }
}
