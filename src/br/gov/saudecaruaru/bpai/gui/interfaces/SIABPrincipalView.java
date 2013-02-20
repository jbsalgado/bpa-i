/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.interfaces;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author Albuquerque
 */
public interface SIABPrincipalView {
    
    public void packAndShow();
    
    public void setMenuItemFamiliaActionListener(ActionListener actionListener);
    
    public void setMenuItemPacienteActionListener(ActionListener actionListener);
    
    public void setMenuItemSairActionListener(ActionListener actionListener);
    
    public void setMenuItemSairMouseListener(MouseListener mouseListener);
    
    public void setMenuItemFamiliaMouseListener(MouseListener mouseListener);
    
    public void setMenuItemPacienteMouseListener(MouseListener mouseListener);
    
    public void setMenuItemImportarCnesActionListener(ActionListener actionListener);
    public void setMenuItemImportarOcupacaoActionListener(ActionListener actionListener);
    
}
