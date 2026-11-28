package br.edu.ifpr.irati.ads.model.repository;

import br.edu.ifpr.irati.ads.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorSpringDataRepository extends JpaRepository<Autor, Integer> {

}
