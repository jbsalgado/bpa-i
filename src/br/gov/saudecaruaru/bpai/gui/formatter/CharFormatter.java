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
public class CharFormatter implements Formatter{

    @Override
    public Object format(Object obj) {
        if (obj instanceof Character){
            return obj.toString();
        }
        return null;
    }

    @Override
    public Object parse(Object s) {
        return Character.valueOf(s.toString().charAt(0));
    }

    @Override
    public String getName() {
        return "Character";
    }
    
}
