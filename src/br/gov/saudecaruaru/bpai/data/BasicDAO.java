/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Albuquerque
 */
public interface BasicDAO<T extends Serializable> {
    
    public void save(T object);
    
    public void update(T object);
    
    public void remove(T object);
    
    public List<T> findAll();
    
    /*
     * Recebe um map, onde chave será a propriedade do objeto a ser filtrada e
     * o valor da chave será ovalor do atributo.
     * 
     */
    public T findEqual(Map<String,Object> restrictions);
    
     public T findEqual(T object);
    
    /*
     * Recebe um map, onde chave será a propriedade do objeto a ser filtrada e
     * o valor da chave será ovalor do atributo.
     * 
     */
    public List<T> findAllEqual(Map<String,Object> restrictions);
    
    public List<T> findAllEqual(Serializable objeto);
    
     public List<T> findAllLike(Map<String,Object> restrictions);
}
