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

public class UsuarioService implements Service {

    @Override
    public void findById(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        try {
            Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
            Session session = HibernateUtil.getSessionFactory().openSession();

            req.getSession().setAttribute("usuario", usuarioDao.buscarPorId(Long.parseLong(req.getParameter("id"))));
            req.getSession().setAttribute("usuarios", usuarioDao.buscarTodos(session));

            session.close();
            resp.sendRedirect("../formusuario.jsp");
        } catch (NumberFormatException e) {
            throw new ServiceException("id inválido");
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        try {
            Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
            Session session = HibernateUtil.getSessionFactory().openSession();

            req.getSession().setAttribute("usuario", new Usuario());
            req.getSession().setAttribute("usuarios", usuarioDao.buscarTodos(session));

            session.close();
            resp.sendRedirect("../formusuario.jsp");
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        try {
            Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
            Session session = HibernateUtil.getSessionFactory().openSession();

            Long id = Long.parseLong(req.getParameter("id"));
            String nome = req.getParameter("nome");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            Usuario usuario = new Usuario(id, nome, email, senha);

            usuarioDao.salvar(usuario);
            req.getSession().setAttribute("usuario", new Usuario());
            req.getSession().setAttribute("usuarios", usuarioDao.buscarTodos(session));

            session.close();
            resp.sendRedirect("../formusuario.jsp");
        } catch (NumberFormatException e) {
            throw new ServiceException("id inválido");
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        try {
            Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
            Session session = HibernateUtil.getSessionFactory().openSession();

            Long id = Long.parseLong(req.getParameter("id"));
            Usuario usuario = usuarioDao.buscarPorId(id);
            usuario.setNome(req.getParameter("nome"));
            usuario.setEmail(req.getParameter("email"));
            usuario.setSenha(req.getParameter("senha"));
            usuarioDao.alterar(usuario);

            req.getSession().setAttribute("usuario", new Usuario());
            req.getSession().setAttribute("usuarios", usuarioDao.buscarTodos(session));

            session.close();
            resp.sendRedirect("../formusuario.jsp");
        } catch (NumberFormatException e) {
            throw new ServiceException("id inválido");
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException {
        try {
            Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
            Session session = HibernateUtil.getSessionFactory().openSession();

            Long id = Long.parseLong(req.getParameter("id"));
            Usuario usuario = usuarioDao.buscarPorId(id);
            usuarioDao.excluir(usuario);

            req.getSession().setAttribute("usuario", new Usuario());
            req.getSession().setAttribute("usuarios", usuarioDao.buscarTodos(session));

            session.close();
            resp.sendRedirect("../formusuario.jsp");
        } catch (NumberFormatException e) {
            throw new ServiceException("id inválido");
        } catch (PersistenceException e) {
            throw new ServiceException(e.getMessage());
        }
    }

}
