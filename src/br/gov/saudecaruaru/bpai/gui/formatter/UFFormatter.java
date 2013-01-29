/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.formatter;

import com.towel.bean.Formatter;

/**
 *
 * @author Albuquerque
 */
public class UFFormatter implements Formatter{

    @Override
    public Object format(Object o) {
        
        if ( o instanceof String){
            
            String p = (String) o;
                return p;
        }
        
        return "";
    }

    @Override
    public Object parse(Object o) {
      return o;
    }

    @Override
    public String getName() {
        return "UF";
    }
    
}
