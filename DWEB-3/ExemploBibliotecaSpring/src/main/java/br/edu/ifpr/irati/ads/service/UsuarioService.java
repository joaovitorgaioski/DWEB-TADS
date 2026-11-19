package br.edu.ifpr.irati.ads.service;

import br.edu.ifpr.irati.ads.model.Usuario;
import br.edu.ifpr.irati.ads.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    // Essa anotação indica que o repository vem do container de IOC
    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.salvar(usuario);
    }

    public void validarUsuario(Usuario usuario) {
    }

}
