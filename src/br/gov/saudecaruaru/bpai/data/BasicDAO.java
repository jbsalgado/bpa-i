/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import java.io.Serializable;
import java.util.List;
import net.priuli.filter.Filter;

/**
 *
 * @author Albuquerque
 */
public interface BasicDAO<T extends Serializable> {
    
    public void salve(T object);
    
    public T encontre(T object);
    
    public void atualize(T object);
    
    public void exclua(T object);
    
    public List<T> encontreTodos();
    
    public List<T> encontreTodos(Filter filter);
    
    public T encontre(Filter filter);
    
}
