package br.edu.ifpr.irati.ads.model.repository;

import br.edu.ifpr.irati.ads.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UsuarioJPARepository {

    @Autowired
    private EntityManager entityManager;

    // Anotação para usar transações
    @Transactional
    public Usuario salvar(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    @Transactional
    public Usuario atualizar(Usuario usuario) {
        return entityManager.merge(usuario);
    }

    @Transactional
    public void deletar(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    @Transactional
    public List<Usuario> obterTodos() {
        return entityManager.createQuery("from tbusuario", Usuario.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Usuario> buscarPorNome(String nome) {
        String jpaQuery = "SELECT u FROM tbusuario u WHERE u.nome LIKE :nome";

        TypedQuery<Usuario> query = entityManager.createQuery(jpaQuery, Usuario.class);
        query.setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }

}
