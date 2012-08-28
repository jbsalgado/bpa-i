/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.Acesso;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Junior Pires
 */
public class AcessoDAO extends GenericDAO<Acesso> implements BasicDAO<Acesso> {
    @Override
    public void save(Acesso object){
    
    }
    
    @Override
    public void update(Acesso object){
    }
    
    @Override
    public void remove(Acesso object){
    }
    
    @Override
    public List<Acesso> findAll(){
        return super.findAll();
    }
    
    /*
     * Recebe um map, onde chave será a propriedade do objeto a ser filtrada e
     * o valor da chave será ovalor do atributo.
     * 
     */
    @Override
    public Acesso findEqual(Map<String,Object> restrictions){
        return null;
    }
    
    /*
     * Recebe um map, onde chave será a propriedade do objeto a ser filtrada e
     * o valor da chave será ovalor do atributo.
     * 
     */
    @Override
    public List<Acesso> findAllEqual(Map<String,Object> restrictions){
        return null;
    }
    
}
