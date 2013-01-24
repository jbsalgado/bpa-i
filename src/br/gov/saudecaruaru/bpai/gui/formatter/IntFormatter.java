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
public class IntFormatter implements Formatter{

    @Override
    public Object format(Object obj) {
        if (obj instanceof Integer){
            return obj.toString();
        }
        return null;
    }

    @Override
    public Object parse(Object s) {
        return Integer.valueOf(s.toString());
    }

    @Override
    public String getName() {
        return "integer";
    }
    
}
