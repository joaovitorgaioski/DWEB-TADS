package br.edu.ifpr.irati.ads.rest.controller;

import br.edu.ifpr.irati.ads.model.Usuario;
import br.edu.ifpr.irati.ads.model.repository.UsuarioSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/usuariosnew")
public class UsuarioControllerNew {

    private UsuarioSpringDataRepository repository;

    public UsuarioControllerNew(@Autowired UsuarioSpringDataRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @GetMapping("{id}")
    public Usuario getUsuarioById(@PathVariable("id") Integer id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    // Buscar no banco antes de tentar deletar
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        repository.findById(id).map(u -> {
            repository.delete(u);
            return u;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    }

    @PutMapping("{id}")
    public void update(@RequestBody Usuario usuario, @PathVariable("id") Integer id) {
        repository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setId(id);
                    repository.save(usuario);
                    return usuarioExistente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));
    }

    // sisbib/api/usuarios?nome=o
    @GetMapping
    public ResponseEntity find(Usuario filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnorePaths("id")
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Usuario> example = Example.of(filtro, matcher);
        List<Usuario> usuarios = repository.findAll(example);
        return ResponseEntity.ok(usuarios);
    }
}
