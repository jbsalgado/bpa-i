/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author juniorpires
 */
public class CadastroPacienteKeyListener {
    
    static class OcupacaoKeyListener implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_F2){
                
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
        }
    
    }
}