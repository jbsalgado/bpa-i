/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.documents;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Junior Pires
 */
public class DataDocument extends PlainDocument{

    private int size;
    public DataDocument() {
        super();
        this.size = 10;
    }
    
    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
       Pattern p = Pattern.compile("^[0-9]+$"); 
       Matcher m = p.matcher(str);
       
        if(m.find()){
            if (size <= 0)        // aceitara qualquer no. de caracteres  
            {  
                super.insertString(offs, str,a);  
                return;  
            }  

            int ilen = (getLength() + str.length());  
            if (ilen <= size){    // se o comprimento final for menor...
                //se o tamanho da string for 2 ou 5 insira uma '/' após 
                if(ilen==2 || ilen==5){
                    
                    str = str.concat("/");
                }
               //se o tamanho da string for 8 
               //(caso que pode ocorrer quando se carregar a string toda, como de um banco de dados por exemplo )
                if(str.length()==8){
                    String newStr="";
                    //transforme a string em um array de chars
                    char[] strArray = str.toCharArray();
                    //varra o array
                    for (char c : strArray) {
                        //caso o tamanho de newString for 2 ou 5 concatene uma barra(/)
                        if(newStr.length()==2 || newStr.length()==5 ){
                            newStr = newStr.concat("/"+String.valueOf(c));
                        }else
                            //senao concatene newString com o caracter do array
                            newStr = newStr.concat(String.valueOf(c));
                    }
    
                    str = newStr;
                }
                        
                    
                
                super.insertString(offs, str, a);   // ...aceita str  
            }else  
            {  
                if (getLength() == size) return; // nada a fazer  
                String newStr = str.substring(0, (size - getLength()));  

                super.insertString(offs, newStr, a);  
            }  
        
    }
    
    
 }
    
}
