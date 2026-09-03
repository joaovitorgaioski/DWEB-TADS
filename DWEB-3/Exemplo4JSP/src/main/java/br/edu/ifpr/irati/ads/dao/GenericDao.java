package br.edu.ifpr.irati.ads.dao;

import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class GenericDao<T> implements Dao<T> {

    protected final Class classePersistente;

    public GenericDao(Class classePersistente){
        this.classePersistente = classePersistente;
    }

    @Override
    public T buscarPorId(Serializable id) throws PersistenceException {
        T t = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            t = (T) session.find(classePersistente, id);
            session.close();
            return t;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void salvar(T t) throws PersistenceException {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.persist(t);
            transaction.commit();
            session.close();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void alterar(T t) throws PersistenceException {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.merge(t);
            transaction.commit();
            session.close();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public void excluir(T t) throws PersistenceException {
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.remove(t);
            transaction.commit();
            session.close();
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public List<T> buscarTodos(Session session) throws PersistenceException {
        try{
            String hql = "from " + this.classePersistente.getCanonicalName();
            Query query = session.createQuery(hql, this.classePersistente);
            List results = query.getResultList();
            return results;
        }catch (HibernateException | NullPointerException e){
            throw new PersistenceException(e.getMessage());
        }
    }
}
