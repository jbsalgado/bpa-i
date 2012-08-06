/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public interface BasicDAO<T extends Serializable> {
    
    public void salvar(T object);
    
    public void find(T object);
    
    public void atualizar(T object);
    
    public void deletar(T object);
    
    public List<T> findAll();
    
}
