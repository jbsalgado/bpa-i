/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.model.Diversas;
import com.towel.bean.Formatter;

/**
 *
 * @author Junior Pires
 */
public class DiversasFormatter implements Formatter{

    @Override
    public Object format(Object o) {
        Diversas d= (Diversas) o;
        if(o==null){
            return "";
        }
       return d.getDiversasPK().getCodigoItemTabela().trim()+" "+d.getDescricaoItemTabela();
    }

    @Override
    public Object parse(Object o) {
       return null;
    }

    @Override
    public String getName() {
       return "RacaCor";
    }
    
}
