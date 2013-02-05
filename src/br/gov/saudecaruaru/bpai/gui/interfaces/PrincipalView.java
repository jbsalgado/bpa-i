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
public interface PrincipalView {

    public void packAndShow();

    public void setVersao(String versao);

    public void setBPAIMouseListener(MouseListener mouseListener);

    public void setSIABMouseListener(MouseListener mouseListener);

    public void setSobreMouseListener(MouseListener mouseListener);

    public void setContatoMouseListener(MouseListener mouseListener);

    public void setSobreActionListener(ActionListener actionListener);

    public void setContatoActionListener(ActionListener actionListener);
}
