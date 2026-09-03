package br.edu.ifpr.irati.ads.service;

import br.edu.ifpr.irati.ads.dao.Dao;
import br.edu.ifpr.irati.ads.dao.GenericDao;
import br.edu.ifpr.irati.ads.dao.HibernateUtil;
import br.edu.ifpr.irati.ads.exception.ServiceException;
import br.edu.ifpr.irati.ads.model.Usuario;
import jakarta.persistence.PersistenceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import java.io.IOException;

public class ProdutoService implements Service {

    @Override
    public void findById(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        throw new ServiceException("findById de Produto");
    }

    @Override
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        throw new ServiceException("findAll de Produto");
    }

    @Override
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        throw new ServiceException("create de Produto");
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        throw new ServiceException("update de Produto");
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        throw new ServiceException("delete de Produto");
    }

}
