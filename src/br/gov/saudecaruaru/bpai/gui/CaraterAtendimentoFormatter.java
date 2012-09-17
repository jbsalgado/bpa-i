/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.model.CaraterAtendimento;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import com.towel.bean.Formatter;

/**
 *
 * @author Junior Pires
 */
public class CaraterAtendimentoFormatter implements Formatter{

    @Override
    public Object format(Object o) {
        CaraterAtendimento c= (CaraterAtendimento) o;
        if(c==null){
            return "";
        }
       return c.getCodigo()+" - "+c.getDescricao();
    }

    @Override
    public Object parse(Object o) {
       return null;
    }

    @Override
    public String getName() {
       return "CaraterAtendimento";
    }
    
}
