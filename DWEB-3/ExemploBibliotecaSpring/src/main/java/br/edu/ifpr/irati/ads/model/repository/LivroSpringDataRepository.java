package br.edu.ifpr.irati.ads.model.repository;

import br.edu.ifpr.irati.ads.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroSpringDataRepository extends JpaRepository<Livro, Integer> {
}
