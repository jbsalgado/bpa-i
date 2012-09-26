/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.formatter;

import br.gov.saudecaruaru.bpai.business.model.Equipe;
import com.towel.bean.Formatter;

/**
 *
 * @author Albuquerque
 */
public class EquipeFormatter implements Formatter{

    @Override
    public Object format(Object o) {
        if(o instanceof Equipe){
            Equipe e=(Equipe) o;
            return e.getEquipePK().getSequencia()+e.getArea()+" "+e.getNome();
        }
        return "";
    }

    @Override
    public Object parse(Object o) {
        return null;
    }

    @Override
    public String getName() {
        return "Equipe";
    }
    
}
