/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.formatter;


import br.gov.saudecaruaru.bpai.business.model.Mes;
import com.towel.bean.Formatter;

/**
 *
 * @author Junior Pires
 */
public class MesFormatter implements Formatter{

    @Override
    public Object format(Object o) {
        Mes m= (Mes) o;
        if(m==null){
            return "";
        }
       return m.getDescricao();
    }

    @Override
    public Object parse(Object o) {
       return null;
    }

    @Override
    public String getName() {
       return "Mes";
    }
    
}
