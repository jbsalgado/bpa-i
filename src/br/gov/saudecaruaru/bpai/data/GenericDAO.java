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
import javax.persistence.EntityManager;
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
        //EntityTransaction tx = getEntityManager().getTransaction();
        Session session= this.getSession();

        try {
//            tx.begin();
//            getEntityManager().persist(entity);
//            tx.commit();
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (Throwable t) {
            t.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T entity) {
        //EntityTransaction tx = getEntityManager().getTransaction();
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        try {
            t.begin();
//            tx.begin();
//            getEntityManager().merge(entity);
//            tx.commit();
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
       // EntityTransaction tx = getEntityManager().getTransaction();
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        try {
            t.begin();
            session.delete(entity);
//            tx.begin();
//            getEntityManager().remove(entity);
//            tx.commit();
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
        return session.createCriteria(persistentClass).list();
    }
    
    
    @Override
    public List<T> findAllEqual(Serializable objeto){
        Session session= this.getSession();
        Criteria c=session.createCriteria(persistentClass);   
        Map<String, Object> restrictions=ModelUtil.getRestrictions(objeto);
        for(String key: restrictions.keySet()){
            if(key!=null){
                c.add(Restrictions.eq(key, restrictions.get(key)));
                        
            }
        }
        
        return c.list();
    }
    
//    public List<T> reflection(Criteria c,Object objeto){
//    Class classe = objeto.getClass();
//       
//        for (Field f : classe.getDeclaredFields()) {
//            f.setAccessible(true);
//            
//            try {
//                if(f.get(objeto)!=null){
//                   if(f.get(objeto).getClass().getPackage().equals("br.gov.saudecaruaru.bpai.business.model")){
//                        if(f.get(objeto).getClass().getDeclaredFields().length>0){
//                            reflection(c,f.get(objeto));
//                    }
//                    }else
//                        c.add(Restrictions.eq(f.getName(),f.get(objeto)));
//                   
//                        
//                }
//            } catch (IllegalArgumentException ex) {
//                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
//        return c.list();
//    }
    
//    private Map<String, Object> getRestrictions(Object object){
//        Class classes=object.getClass();
//
//        //Cria um map para armazenar os valores
//        Map<String, Object> restrictions= new HashMap<String, Object>();
//        //verifica se o objeto está dentro do pacote model
//        if(classes.getPackage().getName().equals(GenericDAO.PACOTE_MODEL)){
//            for(Field f: classes.getDeclaredFields()){
//                f.setAccessible(true);
//                //para cada campo declarado na classe vai varrê-lo
//                try {
//                    //verifica se o campo possui valor/referência
//                    Object obj=f.get(object);
//                    if(obj!=null){
//                        if(f.isAnnotationPresent(javax.persistence.EmbeddedId.class)||f.isAnnotationPresent(javax.persistence.Column.class) ){
//                            //verifica se o campo é um objeto de alguma classe do pacote model
//                            //se for,vai chamar o método novamente
//                            if(obj.getClass().getPackage().getName().equals(GenericDAO.PACOTE_MODEL)){
//                                //pega o map devolvido e monta o nome dos atributos com o valor
//                                Map<String, Object> m= this.getRestrictions(obj);
//                                for(String key: m.keySet()){
//                                    restrictions.put(f.getName()+"."+key, m.get(key));
//                                }
//                            }
//                            else{
//                                restrictions.put(f.getName(), f.get(object));
//                            }
//                        
//                     }
//                        
//                    }
//                } catch (IllegalArgumentException ex) {
//                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IllegalAccessException ex) {
//                    Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        
//        return restrictions;
//    }
    
    @Override
    public List<T> findAllEqual(Map<String,Object> restrictions){
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        Criteria c=session.createCriteria(persistentClass);
        for(String key: restrictions.keySet()){
            if(key!=null){
                c.add(Restrictions.eq(key, restrictions.get(key)));
                        
            }
        }
        return c.list();
    }
    
    @Override
    public List<T> findAllLike(Map<String,Object> restrictions){
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        Criteria c=session.createCriteria(persistentClass);
        for(String key: restrictions.keySet()){
            if(key!=null){
                c.add(Restrictions.like(key, restrictions.get(key).toString(), MatchMode.START));
                        
            }
        }
        return c.list();
    }


    @Override
    public T findEqual(Map<String, Object> restrictions) {
        Session session= this.getSession();
        Criteria c=session.createCriteria(persistentClass);
        for(String key: restrictions.keySet()){
            if(key!=null){
                c.add(Restrictions.eq(key, restrictions.get(key)));
                        
            }
        }
        return (T) c.uniqueResult();
    }
    
//    protected void close() {
//        if (getEntityManager().isOpen()) {
//            getEntityManager().close();
//        }
//        //shutdown();
//    }



    @Override
    public T findEqual(T object) {
      Session session= this.getSession();
        Criteria c=session.createCriteria(persistentClass);   
        Map<String, Object> restrictions=ModelUtil.getRestrictions(object);
        for(String key: restrictions.keySet()){
            if(key!=null){
                c.add(Restrictions.eq(key, restrictions.get(key)));
                        
            }
        }
        
        return (T) c.uniqueResult();
    }

}