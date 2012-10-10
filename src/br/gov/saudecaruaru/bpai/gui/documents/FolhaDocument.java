/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.documents;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Junior Pires
 */
public class FolhaDocument extends PlainDocument{
    
    @Override 
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
       Pattern p = Pattern.compile("^[0-9]+$"); 
       Matcher m = p.matcher(str);
        if(this.getLength()>2 ||!m.find())
            return;
        
       // str = String.format("%03d", Integer.parseInt(str));
        super.insertString(offs,str, a);
    }
    
}
