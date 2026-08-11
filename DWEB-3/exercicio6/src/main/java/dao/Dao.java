package dao;

import jakarta.persistence.PersistenceException;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

    public T buscarPorId(Serializable id) throws PersistenceException;

    public void salvar(T t) throws PersistenceException;

    public void alterar(T t) throws PersistenceException;

    public void excluir(T t) throws PersistenceException;

    public List<T> buscarTodos(Session session) throws PersistenceException;
}
