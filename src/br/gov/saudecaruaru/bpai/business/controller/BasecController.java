/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.data.GenericDAO;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Albuquerque
 */
public class BasecController < T extends Serializable>{
    
    private GenericDAO dao=null;
    
    public BasecController(GenericDAO dao){
        this.dao=dao;
    }
    
    public void salvar(T modelo){
        this.dao.save(modelo);
    }
    
    public void atualizar(T modelo){
        this.dao.update(modelo);
    }
    
    public void excluir(T modelo){
        this.dao.remove(modelo);
    }
    
    public List<T> findAll(){
        return this.dao.findAll();
    }
    
    public List<T> findAllEqual(T modelo){
        return this.dao.findAllEqual(modelo);
    }
    
    public List<T> findAllEqual(Map<String, Object> map){
        return this.dao.findAllEqual(map);
    }
    
    public T findEqual(Serializable modelo){
        return (T) this.dao.findEqual(modelo);
    }
    
    public T findEqual(Map<String, Object> map){
        return (T) this.dao.findEqual(map);
    }
}
