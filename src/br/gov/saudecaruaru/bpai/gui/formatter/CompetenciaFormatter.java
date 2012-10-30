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
public class CompetenciaFormatter implements Formatter{

    @Override
    public Object format(Object o) {
        
        if(o != null){
            String s=o.toString();
            if (s.length() == 6){
                return s.substring(4, 6)+"/"+ s.substring(0, 4);
            }
        }
        return "ERRO";
    }

    @Override
    public Object parse(Object o) {
        return null;
    }

    @Override
    public String getName() {
        return "Competência";
    }
    
}
