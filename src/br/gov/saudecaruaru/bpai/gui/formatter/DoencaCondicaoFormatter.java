/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.formatter;

import br.gov.saudecaruaru.bpai.business.model.DoencaCondicao;
import br.gov.saudecaruaru.bpai.business.model.Escolha;
import com.towel.bean.Formatter;

/**
 *
 * @author Albuquerque
 */
public class DoencaCondicaoFormatter implements Formatter{

    @Override
    public Object format(Object o) {
        
//        if ( o instanceof DoencaCondicao){
//            o=Escolha.MAP.get(o);
//            
//        }
        if(o instanceof DoencaCondicao ){
            DoencaCondicao p = (DoencaCondicao) o;
                return p.getCodigo()+" - "+p.getDescricao();
        }
        
        return "";
    }

    @Override
    public Object parse(Object o) {
        DoencaCondicao p = (DoencaCondicao) o;
        return p.getCodigo();
        
    }

    @Override
    public String getName() {
        return "DoencaCondicao";
    }
    
}
