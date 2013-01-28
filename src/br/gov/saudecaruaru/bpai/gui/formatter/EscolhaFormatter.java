/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.formatter;

import br.gov.saudecaruaru.bpai.business.model.Escolha;
import com.towel.bean.Formatter;

/**
 *
 * @author Albuquerque
 */
public class EscolhaFormatter implements Formatter{

    @Override
    public Object format(Object o) {
        
        if ( o instanceof Character){
            o=Escolha.MAP.get(o);
            
        }
        if(o instanceof Escolha ){
            Escolha p = (Escolha) o;
                return p.getDescricao();
        }
        
        return "";
    }

    @Override
    public Object parse(Object o) {
      return o;
    }

    @Override
    public String getName() {
        return "Escolha";
    }
    
}
