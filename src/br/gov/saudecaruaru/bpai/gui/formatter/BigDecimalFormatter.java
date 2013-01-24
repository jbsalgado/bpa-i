/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.formatter;

import com.towel.bean.Formatter;
import java.math.BigDecimal;

/**
 *
 * @author Albuquerque
 */
public class BigDecimalFormatter implements Formatter{

    @Override
    public Object format(Object obj) {
        if (obj instanceof BigDecimal){
            return obj.toString();
        }
        return null;
    }

    @Override
    public Object parse(Object s) {
       return new BigDecimal(s.toString());
       
    }

    @Override
    public String getName() {
        return "BigDecimal";
    }
    
}
