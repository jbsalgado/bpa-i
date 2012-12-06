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
public class OnlyUpperLettersDocument extends PlainDocument{
    
    @Override 
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
       Pattern p = Pattern.compile("^[a-z,A-Z, ,.,ã,á,à,â,ä,Ã,À,Â,Ä,ê,Ê,í,Í,ú,ü,Ú,Ü,ó,õ,Ó,Õ,é,É,ç,Ç,]+$");  
       Matcher m = p.matcher(str);
        if(!m.find())
            return;
        super.insertString(offs, str.toUpperCase(), a);
    }
    
}
