package br.edu.ifpr.irati.ads.model.repository;

import br.edu.ifpr.irati.ads.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioSpringDataRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNome(String nome);
}
