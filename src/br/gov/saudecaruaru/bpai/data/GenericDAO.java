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
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class GenericDAO<T extends Serializable> implements BasicDAO<T> {
    
    

    private final Class<T> persistentClass;
    private final Logger logger;

    public GenericDAO() {
        //this.entityManager = EntityManagerUtil.getEntityManager();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.logger=Logger.getLogger(persistentClass);
    }
    
    public Session getSession(){
        return HibernateUtil.getSession();
    }

    @Override
    public boolean save(T entity) {
        boolean sucess=false;
        Session session= this.getSession();
        Transaction tr=session.getTransaction();
        try {
            tr.begin();
            session.save(entity);
            tr.commit();
            sucess=true;
        } catch (Throwable t) {
            tr.rollback();
            this.logger.error("=> Erro ao tentar executar o método save. Objeto: "+entity);
            this.logger.error(t.getMessage());
            t.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
            return sucess;
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
            tr.rollback();
            this.logger.error("=> Erro ao tentar executar o método save [list]. Tamanho da lista: "+entity.size());
            this.logger.error(t.getMessage());
            t.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
            return entity;
        }
    }
    
    public T merge(T entity) {
        Session session= this.getSession();
        Transaction tr=session.getTransaction();

        try {
            tr.begin();
            entity=(T) session.merge(entity);
            session.flush();
            session.clear();
            tr.commit();
        } catch (Throwable t) {
            tr.rollback();
            this.logger.error("Erro ao tentar executar o método merge. Objeto: "+entity);
            this.logger.error(t.getMessage());
            t.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
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
            t.rollback();
            this.logger.error("Erro ao tentar executar o método merge [list]. Tamanho da lista: "+entity.size());
            this.logger.error(tr.getMessage());
            tr.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
            return entity;
        }
    }

    @Override
    public boolean update(T entity) {
        //EntityTransaction tx = getEntityManager().getTransaction();
        boolean sucess=false;
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        try {
            t.begin();
            session.update(entity);
            session.flush();
            session.clear();
            t.commit();
            sucess=true;
        } catch (Throwable tr) {
            t.rollback();
            this.logger.error("Erro ao tentar executar o método update. Objeto: "+entity);
            this.logger.error(tr.getMessage());
            tr.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
            return sucess;
        }

    }

    @Override
    public boolean remove(T entity) {
        boolean sucess=false;
        Session session= this.getSession();
        Transaction t=session.getTransaction();
        try {
            t.begin();
            session.delete(entity);
            t.commit();
            sucess=true;
        } catch (Throwable tr) {
            t.rollback();
            this.logger.error("Erro ao tentar executar o método remove. Objeto: "+entity);
            this.logger.error(tr.getMessage());
            tr.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
            return sucess;
        }
    }
    
    @Override
    public boolean removeAll(T entity){
        boolean sucess=false;
         Session session= this.getSession();
        Transaction t=session.getTransaction();
        try {
            t.begin();
            StringBuilder sql= new StringBuilder();
            
            sql.append("DELETE FROM ");
            sql.append(this.persistentClass.getCanonicalName());
            
            Map<String, Object> restrictions=ModelUtil.getRestrictions(entity);
            Set<String> l=restrictions.keySet();
            int size=l.size();
            if(size>0){
                int i=1;
                sql.append(" tb WHERE ");
                for(String key: l){
                    //campos que devem ser filtrados
                    sql.append(key);
                    sql.append(" = ");
                    sql.append(":");
                    sql.append(key.replace('.', '_'));
                    
                    //não é o último
                    if(i!=size){
                        sql.append(" AND ");
                    }
                    i++;
                }
            }
            //sql.append(" ")
            Query q=session.createQuery(sql.toString());
            if(size > 0){
                for(String key: l){
                    q.setParameter(key.replace('.', '_'), restrictions.get(key));
                }
            }
            q.executeUpdate();
            t.commit();
            sucess=true;
        } catch (Throwable tr) {
            t.rollback();
            this.logger.error("Erro ao tentar executar o método removeAll. Objeto: "+entity);
            this.logger.error(tr.getMessage());
            tr.printStackTrace();
        } finally {
            if(session != null){
                session.close();
            }
            return sucess;
        }
    }

    @Override
    public List<T> findAll()  {
        Session session= this.getSession();
        List<T> l=null;
        try{
            l= session.createCriteria(persistentClass).list();
        }catch(Exception ex){
            this.logger.error("Erro ao tentar executar o método findAll.");
            this.logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
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
            session.clear();
            l=c.list();
        }catch(Exception ex){
            this.logger.error("Erro ao tentar executar o método findAllEqual [serializable].");
            this.logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
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
            this.logger.error("Erro ao tentar executar o método findAllEqual [map<string,object>]");
            this.logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        finally{
           if(session != null){
                session.close();
            }
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
            this.logger.error("Erro ao tentar executar o método findAllLike [map<string, object>]");
            this.logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
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
            this.logger.error("Erro ao tentar executar o método findEqual [map<string,object>].");
            this.logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
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
            this.logger.error("Erro ao tentar executar o método findEqual [object].");
            this.logger.error(ex.getMessage());
            ex.printStackTrace();
        }
        finally{
            if(session != null){
                session.close();
            }
            return t;
        }
    }

    @Override
    public List<T> findAllEqual(Map<String, Object> restrictions, int firstResult, int maxResult) {
        Session session=this.getSession();
        List<T> list=null;
        try{
            StringBuilder sql=new StringBuilder();
            sql.append("FROM "+this.persistentClass.getName()+" tb");
            Set<String> l=restrictions.keySet();
            int size=l.size();
            if(size>0){
                int i=1;
                sql.append(" WHERE ");
                for(String key: l){
                    //campos que devem ser filtrados
                    sql.append("tb.");
                    sql.append(key);
                    sql.append(" = ");
                    sql.append(":");
                    sql.append(key.replace('.', '_'));
                    
                    //não é o último
                    if(i!=size){
                        sql.append(" AND ");
                    }
                    i++;
                }
            }
            Query q=session.createQuery(sql.toString());
            if(size > 0){
                for(String key: l){
                    q.setParameter(key.replace('.', '_'), restrictions.get(key));
                }
                //q.setProperties(restrictions);
            }
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResult);
            list=q.list();
        }catch(Exception ex){
            this.logger.error("Erro ao tentar executar o método findAllEqual [Map<String, Object>, int, int].");
            this.logger.error(ex.getMessage());
            ex.printStackTrace();
        }finally{
            if(session != null){
                session.close();
            }
            return list;
        }
    }

    @Override
    public List<T> findAllEqual(Serializable objeto, int firstResult, int maxResult) {
        Session session=this.getSession();
        List<T> list=null;
        try{
            StringBuilder sql=new StringBuilder();
            sql.append("FROM "+this.persistentClass.getName()+" tb");
            Map<String, Object> restrictions=ModelUtil.getRestrictions(objeto);
            Set<String> l=restrictions.keySet();
            int size=l.size();
            if(size>0){
                int i=1;
                sql.append(" WHERE ");
                for(String key: l){
                    //campos que devem ser filtrados
                    sql.append("tb.");
                    sql.append(key);
                    sql.append(" = ");
                    sql.append(":");
                    sql.append(key.replace('.', '_'));
                    
                    //não é o último
                    if(i!=size){
                        sql.append(" AND ");
                    }
                    i++;
                }
            }
            Query q=session.createQuery(sql.toString());
            if(size > 0){
                for(String key: l){
                    q.setParameter(key.replace('.', '_'), restrictions.get(key));
                }
            }
            q.setFirstResult(firstResult);
            q.setMaxResults(maxResult);
            list=q.list();
        }catch(Exception ex){
            this.logger.error("Erro ao tentar executar o método findAllEqual [Seriazable, int, int].");
            this.logger.error(ex.getMessage());
            ex.printStackTrace();
        }finally{
            if(session != null){
                session.close();
            }
            return list;
        }
    }

}