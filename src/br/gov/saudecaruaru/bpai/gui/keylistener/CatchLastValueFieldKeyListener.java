/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.keylistener;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Albuquerque
 */
public class CatchLastValueFieldKeyListener extends KeyAdapter{
    
    private int keyCode;
    private JTextField txtfield;
    private String oldString;

    public CatchLastValueFieldKeyListener(int keyCode, JTextField txtfield) {
        this.keyCode = keyCode;
        this.txtfield = txtfield;
        //adiciona um lister para pegar o valor do campo
        this.txtfield.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                //são valores diferentes, então modifique
                String newString=CatchLastValueFieldKeyListener.this.txtfield.getText();
                String temp=CatchLastValueFieldKeyListener.this.oldString;
                if (! newString.equals(temp)){
                    CatchLastValueFieldKeyListener.this.oldString=newString;
                }
                super.focusLost(e);
            }
            
        });
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        if(e!= null){
            if (e.getKeyCode() == this.keyCode){
                 //coloca o valor antigo
                 if ( this.oldString == null? false : !this.oldString.isEmpty()){
                    this.txtfield.setText(this.oldString);
                 }
            }
        }
        super.keyPressed(e);
    }
    
    
    
}
