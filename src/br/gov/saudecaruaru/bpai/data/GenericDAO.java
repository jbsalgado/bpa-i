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
import net.priuli.filter.Filter;
import net.priuli.filter.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class GenericDAO<T extends Serializable> {

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

    protected void save(T entity) {
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

    protected void update(T entity) {
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

    protected void delete(T entity) {
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

    protected List<T> findAll() throws Exception {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(persistentClass).list();
    }
    
    protected List<T> findAll(Filter filter) throws Exception {
        Session session = (Session) getEntityManager().getDelegate();
        Criteria criteria=HibernateUtils.buildCriteria(filter, session, persistentClass);
        return criteria.list();
    }
    
    protected T find(Filter filter) throws Exception {
        Session session = (Session) getEntityManager().getDelegate();
        Criteria criteria=HibernateUtils.buildCriteria(filter, session, persistentClass);
        return (T) criteria.uniqueResult();
    }

    protected T findByName(String nome) {
        Session session = (Session) getEntityManager().getDelegate();
        return (T) session.createCriteria(persistentClass).add(Restrictions.eq("nome", nome).ignoreCase()).uniqueResult();
    }

    protected T findById(long id) {
        Session session = (Session) getEntityManager().getDelegate();
        return (T) session.createCriteria(persistentClass).add(Restrictions.eq("id", id)).uniqueResult();
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