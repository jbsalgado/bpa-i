/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.FocusListener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Junior Pires
 */
public class ChangeBackgroundFieldFocusListener implements FocusListener{

    @Override
    public void focusGained(FocusEvent e) {
          Component c = ((Component)e.getComponent());
                if(!c.getBackground().equals(Color.RED) || !c.getBackground().equals(Color.red))
                    ((Component)e.getComponent()).setBackground(Color.GREEN);
    }

    @Override
    public void focusLost(FocusEvent e) {
        ((Component)e.getComponent()).setBackground(Color.WHITE);
    }
    
}
