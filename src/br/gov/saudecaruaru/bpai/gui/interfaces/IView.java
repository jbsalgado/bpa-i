/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.interfaces;

import java.awt.event.MouseListener;
import java.io.Serializable;

/**
 *
 * @author Albuquerque
 */
public interface IView <T extends Serializable>{
    
    public T getModel();
    
    public void setModel(T model);
    
    public void addMouseListenerBotaoLogin(MouseListener listener);
}
