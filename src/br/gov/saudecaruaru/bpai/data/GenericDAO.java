package br.gov.saudecaruaru.bpai.data;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */





import br.gov.saudecaruaru.bpai.util.ModelUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GenericDAO<T extends Serializable> implements BasicDAO<T> {
    
    

    private final Class<T> persistentClass;

    public GenericDAO() {
        //this.entityManager = EntityManagerUtil.getEntityManager();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public Session getSession(){
        return HibernateUtil.getSession();
    }

    @Override
    public void save(T entity) {
        Session session= this.getSession();
        Transaction tr=session.getTransaction();
        try {
            tr.begin();
            session.save(entity);
            tr.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tr.rollback();
        } finally {
            session.close();
        }
    }
    
    public List<T> save(List<T> entity) {
        Session session= this.getSession();
        Transaction tr=session.getTransaction();
        try {
            tr.begin();
            int size=entity.size();
            for(int i=0;i<size;i++){
                //salva o objeto
                T obj=(T) session.save(entity.get(i));
                //limpa a sessao
                if((i+1)%20==0){
                    session.flush();
                    session.clear();
                }
                entity.set(i, obj);
            }
            tr.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tr.rollback();
        } finally {
            session.close();
            return entity;
        }
    }
    
    public T merge(T entity) {
        Session session= this.getSession();
        Transaction tr=session.getTransaction();

        try {
            tr.begin();
            entity=(T) session.merge(entity);
            tr.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tr.rollback();
        } finally {
            session.close();
            return entity;
        }
    }
    
   public List<T> merge(List<T> entity) {
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        try {
            t.begin();
            int size=entity.size();
            for(int i=0;i<size;i++){
                //salva o objeto
                T obj=(T) session.merge(entity.get(i));
                //limpa a sessao
                if((i+1)%20==0){
                    session.flush();
                    session.clear();
                }
                entity.set(i, obj);
            }
            t.commit();
        } catch (Throwable tr) {
            tr.printStackTrace();
            t.rollback();
        } finally {
            session.close();
            return entity;
        }
    }

    @Override
    public void update(T entity) {
        //EntityTransaction tx = getEntityManager().getTransaction();
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        try {
            t.begin();
            session.update(entity);
            t.commit();
        } catch (Throwable tr) {
            tr.printStackTrace();
            t.rollback();
        } finally {
            session.close();
        }

    }

    @Override
    public void remove(T entity) {
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        try {
            t.begin();
            session.delete(entity);
            t.commit();
        } catch (Throwable tr) {
            tr.printStackTrace();
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<T> findAll()  {
        Session session= this.getSession();
        List<T> l=null;
        try{
            l= session.createCriteria(persistentClass).list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            session.close();
            return l;
        }
    }
    
    
    @Override
    public List<T> findAllEqual(Serializable objeto){
        Session session= this.getSession();
        List<T> l=null;
        try{
            Criteria c=session.createCriteria(persistentClass);   
            Map<String, Object> restrictions=ModelUtil.getRestrictions(objeto);
            for(String key: restrictions.keySet()){
                if(key!=null){
                    c.add(Restrictions.eq(key, restrictions.get(key)));

                }
            }
            l=c.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            session.close();
            return l;
        }
    }
    
    
    @Override
    public List<T> findAllEqual(Map<String,Object> restrictions){
        Session session= this.getSession();
        List<T> l=null;
        try{
            Criteria c=session.createCriteria(persistentClass);
            for(String key: restrictions.keySet()){
                if(key!=null){
                    c.add(Restrictions.eq(key, restrictions.get(key)));

                }
            }
            l=c.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
           session.close();
           return l;
        }
    }
    
    
    @Override
    public List<T> findAllLike(Map<String,Object> restrictions){
        Session session= this.getSession();
        List<T> l=null;
        try{
            Criteria c=session.createCriteria(persistentClass);
            for(String key: restrictions.keySet()){
                if(key!=null){
                    c.add(Restrictions.like(key, restrictions.get(key).toString(), MatchMode.START));

                }
            }
            l = c.list();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            session.close();
            return l;
        }
    }


    @Override
    public T findEqual(Map<String, Object> restrictions) {
        Session session= this.getSession();
        T t=null;
        try{
            Criteria c=session.createCriteria(persistentClass);
            for(String key: restrictions.keySet()){
                if(key!=null){
                    c.add(Restrictions.eq(key, restrictions.get(key)));

                }
            }
            t=(T) c.uniqueResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            session.close();
            return t;
        }
    }
    


    @Override
    public T findEqual(T object) {
      Session session= this.getSession();
      T t=null;
        try{
            Criteria c=session.createCriteria(persistentClass);   
            Map<String, Object> restrictions=ModelUtil.getRestrictions(object);
            for(String key: restrictions.keySet()){
                if(key!=null){
                    c.add(Restrictions.eq(key, restrictions.get(key)));

                }
            }
             t=(T) c.uniqueResult();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            session.close();
            return t;
        }
    }

}