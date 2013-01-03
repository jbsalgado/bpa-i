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
    private int size;
 
    public OnlyUpperLettersDocument() {
        this.size = 0;
    }
    
    public  OnlyUpperLettersDocument(int size) {
        super();
        this.size = size;
    }
    
    
    @Override 
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
       Pattern p = Pattern.compile("^[a-z,A-Z, ,.,ã,á,à,â,ä,Ã,À,Â,Ä,ê,Ê,í,Í,ú,ü,Ú,Ü,ó,õ,Ó,Õ,é,É,ç,Ç,]+$");  
       Matcher m = p.matcher(str);
      if(m.find()){
            if (size <= 0)        // aceitara qualquer no. de caracteres  
            {  
                super.insertString(offs, str.toUpperCase(),a);  
                return;  
            }  

            int ilen = (getLength() + str.length());  
            if (ilen <= size)    // se o comprimento final for menor...  
                super.insertString(offs, str.toUpperCase(), a);   // ...aceita str  
            else  
            {  
                if (getLength() == size) return; // nada a fazer  
                String newStr = str.substring(0, (size - getLength()));  

                super.insertString(offs, newStr.toUpperCase(), a);  
            }  
        
        }
    
    }
    
}
