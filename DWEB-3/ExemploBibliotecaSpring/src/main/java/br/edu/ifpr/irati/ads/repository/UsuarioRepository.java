package br.edu.ifpr.irati.ads.repository;

import br.edu.ifpr.irati.ads.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepository{
    public void salvar(Usuario usuario) {
        System.out.println("Usuário " + usuario.getNome() + " salvo!");
    }
}
