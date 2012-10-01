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
public class SexoDocument extends PlainDocument{
    
    @Override 
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
       //expressão regular para sexo (só permite M ou F)
       Pattern p = Pattern.compile("^[(mM)|(fF)]$");  
       Matcher m = p.matcher(str);
        if(this.getLength()>0 ||!m.find())
            return;
        super.insertString(offs, str.toUpperCase(), a);
    }
    
}
