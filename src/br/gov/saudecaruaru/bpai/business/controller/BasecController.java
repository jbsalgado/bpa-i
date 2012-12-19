/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.data.GenericDAO;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Albuquerque
 */
public class BasecController < T extends Serializable>{
    
    private GenericDAO dao=null;
    
    public BasecController(GenericDAO<T> dao){
        this.dao=dao;
    }
    
     public boolean removeAll(T entity){
         return this.dao.removeAll(entity);
     }
    public boolean salvar(T modelo){
        return this.dao.save(modelo);
    }
    
    public List<T> salvar(List<T> list){
        return this.dao.save(list);
    }
    
    public T merge(T entity){
        return (T) this.dao.merge(entity);
    }
    
    public List<T> merge(List<T> entityList){
        return this.dao.merge(entityList);
    }
    
    public boolean atualizar(T modelo){
        return this.dao.update(modelo);
    }
    
    public boolean excluir(T modelo){
        return this.dao.remove(modelo);
    }
    
    public List<T> findAll(){
        return this.dao.findAll();
    }
    
    public List<T> findAllEqual(T modelo){
        return this.dao.findAllEqual(modelo);
    }
    
    public List<T> findAllEqualOrderBy(T modelo,String desc){
        return this.dao.findAllEqualOrderBy(modelo,desc);
    }
    
    public List<T> findAllEqual(Map<String, Object> map){
        return this.dao.findAllEqual(map);
    }
    
    public List<T> findAllLike(Map<String, Object> map){
        return this.dao.findAllLike(map);
    }
    
    public T findEqualWithDisjunction(Map<String, Object> restrictions){
        return (T)this.dao.findEqualWithDisjunction(restrictions);
    }
    
    public List<T> findAllLikeWithDisjunction(Map<String,Object> restrictions){
        return this.dao.findAllLikeWithDisjunction(restrictions);
    }
    
    public List<T> findAllEqualWithDisjunction(Map<String,Object> restrictions){
        return (List<T>) this.dao.findEqualWithDisjunction(restrictions);
    }
    
    public List<T> findAllEqualIn(Map<String,Collection> restrictions){
        return this.dao.findAllEqualIn(restrictions);
    }
    public T findEqual(T modelo){
        return (T) this.dao.findEqual(modelo);
    }
    
    public T findEqual(Map<String, Object> map){
        return (T) this.dao.findEqual(map);
    }

    public GenericDAO getDao() {
        return dao;
    }

    public void setDao(GenericDAO dao) {
        this.dao = dao;
    }
    
    public List<T> findAllEqual(Map<String,Object> restrictions, int firstResult, int maxResult){
        return this.dao.findAllEqual(restrictions, firstResult, maxResult);
    }
    
    public List<T> findAllEqual(T objeto, int firstResult, int maxResult){
        return this.dao.findAllEqual(objeto, firstResult, maxResult);
    }
}
