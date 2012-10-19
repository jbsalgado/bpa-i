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
    
    /**
     * Salva o objeto (mapeado) no banco de dados
     * @param object - entidade que deve ser persistida
     * @return true se salvou com sucesso
     */
    public boolean save(T object);
    
    /**
     * Salva a lista de objetos (mapeados) no banco de dados 
     * @param entityList - a lista de objetos a ser persistida
     * @return entityList a mesma lista com os objetos já persistidos
     */
    public List<T> save(List<T> entityList);
    
    /**
     * Salva a entidade ou atualiza casa ela já exista no banco de dados
     * @param entity - a entidade a ser persistida ou atualizada
     * @return entity - a mesma entidade já persistida
     */
    public T merge(T entity);
    
    /**
     * Salva todos os objetos da lista ou atualiza aqueles que existam.
     * @param entityList -  a lista com os objetos a serem salvos ou atualizado
     * @return entityList -  a mesma lista recebida, mas com os objetos salvos ou atualizados
     */
    public List<T> merge(List<T> entityList);
            
    /**
     * Atualiza o objeto (mapeado) no banco de dados
     * @param object - o objeto que deve ser atualizado
     * @return true se atualizou com sucesso
     */
    public boolean update(T object);
    
    /**
     * Deleta o objeto (mapeado) no banco de dados
     * @param object - objeto que deve ser removido do banco de dados
     * @return true se removeu o objeto com sucesso
     */
    public boolean remove(T object);
    
    /**
     * Devolve todos os registros do banco de dados
     * @return List contendo todos os registros
     */
    public List<T> findAll();
    
    /**
     * Busca o objeto no banco de dados que respeite as restrições.
     * Utiliza "=" para cada campo e o operador lógico "and"
     * Exemplo: sendo a chave "endereco.cep" e o valor "55380000" vai buscar o endereço que
     * contém o CEP: 55380000. Isto é, chave é o campo do objeto e o valor da chave é o valor do atributo
     * @param restrictions - Map contendo os campos a serem
     * @return Objetc encontrado
     */
    public T findEqual(Map<String,Object> restrictions);
    
    
    /**
     * Pega o objeto de acordo com sua chave primária
     * @param object - objeto contendo a chave primária settada
     * @return devolve o objeto com os atributos preenchidos de acordo com o que está no banco de dados
     */
    public T findEqual(T object);
    
     /**
     * Busca todos os objetos no banco de dados que respeitem as restrições.
     * Utiliza "=" para cada campo e o operador lógico "and"
     * Exemplo: sendo a chave "endereco.cep" e o valor "55380000" vai buscar todos os endereços que
     * contém o CEP: 55380000. Isto é, chave é o campo do objeto e o valor da chave é o valor do atributo
     * @param restrictions - Map contendo os campos a serem
     * @return List com todos os objetos que satisfaçam a condição
     */
    public List<T> findAllEqual(Map<String,Object> restrictions);
    
     public boolean removeAll(T entity);
    
    public List<T> findAllEqual(Map<String,Object> restrictions, int firstResult, int maxResult);
    
    /**
     * Encontra todos os objetos que satisfaçam as condições, ou seja,
     * os atributos preenchidos no objeto passado como parãmetro serão as restrições.
     * Utiliza o "=" para cada campo e o operador lógico "and"
     * Exemplo. Tendo o objeto endereco com o atributo tipoLogradouro setado como AV,
     * todos os os endereços que tenham o tipoLogradouro AV serão devolvidos
     * @param objeto - objeto que representa as restrições
     * @return List de objetos que satisfaçam as restrições
     */
    public List<T> findAllEqual(Serializable objeto);
    
    public List<T> findAllEqual(Serializable objeto, int firstResult, int maxResult);
    
    /**
     * Busca todos os objetos no banco de dados que satisfaçam as restrições.
     * Utiliza "like" para cada campo e o operador lógico "and"
     * Exemplo: sendo a chave "endereco.cep" e o valor "55380" vai buscar todos os endereços que
     * contém o número 55380 no seu CEP. Isto é, a chave é o campo do objeto e o valor da chave é o valor do atributo
     * @param restrictions - Map contendo os campos que faram parta da clausula where
     * @return List com todos os objetos que satisfaçam a condição
     */
    public List<T> findAllLike(Map<String,Object> restrictions);
}
