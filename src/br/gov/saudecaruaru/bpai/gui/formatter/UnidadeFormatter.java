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
public class UnidadeFormatter implements Formatter{

    @Override
    public Object format(Object o) {
       if(o != null){
           return o.toString();
       }
       
       return "ERRO";
    }

    @Override
    public Object parse(Object o) {
        return null;
    }

    @Override
    public String getName() {
        return "CNES";
    }
    
}
