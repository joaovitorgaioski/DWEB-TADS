package br.edu.ifpr.irati.ads.model.repository;

import br.edu.ifpr.irati.ads.model.Emprestimo;
import br.edu.ifpr.irati.ads.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoSpringDataRepository extends JpaRepository<Emprestimo, Integer> {

    @Query("select e.livro from Emprestimo e where e.id = :id")
    Livro findLivroFetchEmprestimo(@Param("id") Integer id);

}
