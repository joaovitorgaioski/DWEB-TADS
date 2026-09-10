package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.model.Usuario;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class UsuarioDao {

    public Usuario buscarPorEmail(String email) {
        Usuario u = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
            Root<Usuario> root = cq.from(Usuario.class);

            cq.where(cb.equal(root.get("email"), email));
            u = session.createQuery(cq).getSingleResult();

            session.close();
            return u;
        } catch (NoResultException e) {
            return null;
        } catch (HibernateException | NullPointerException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

}
