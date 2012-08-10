package br.gov.saudecaruaru.bpai.data;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import br.gov.saudecaruaru.bpai.data.EntityManagerUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import net.priuli.filter.Filter;
import net.priuli.filter.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GenericDAO<T extends Serializable> implements BasicDAO<T> {

    @PersistenceContext(unitName = EntityManagerUtil.ENTITY_MANAGER_BPA_IPU)
    private final EntityManager entityManager;
    private final Class<T> persistentClass;

    public GenericDAO() {
        this.entityManager = EntityManagerUtil.getEntityManager();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public void save(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().persist(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }

    @Override
    public void update(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().merge(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }

    }

    @Override
    public void remove(T entity) {
        EntityTransaction tx = getEntityManager().getTransaction();

        try {
            tx.begin();
            getEntityManager().remove(entity);
            tx.commit();
        } catch (Throwable t) {
            t.printStackTrace();
            tx.rollback();
        } finally {
            close();
        }
    }

    @Override
    public List<T> findAll()  {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(persistentClass).list();
    }
    
    @Override
    public List<T> findAllEqual(Map<String,Object> restrictions){
        Session session = (Session) getEntityManager().getDelegate();
        Criteria c=session.createCriteria(persistentClass);
        for(String key: restrictions.keySet()){
            if(key!=null){
                c.add(Restrictions.eq(key, restrictions.get(key)));
                        
            }
        }
        return c.list();
    }


    @Override
    public T findEqual(Map<String, Object> restrictions) {
        Session session = (Session) getEntityManager().getDelegate();
        Criteria c=session.createCriteria(persistentClass);
        for(String key: restrictions.keySet()){
            if(key!=null){
                c.add(Restrictions.eq(key, restrictions.get(key)));
                        
            }
        }
        return (T) c.uniqueResult();
    }
    
    private void close() {
        if (getEntityManager().isOpen()) {
            getEntityManager().close();
        }
        shutdown();
    }

    private void shutdown() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createNativeQuery("SHUTDOWN").executeUpdate();
        em.close();
    }

}