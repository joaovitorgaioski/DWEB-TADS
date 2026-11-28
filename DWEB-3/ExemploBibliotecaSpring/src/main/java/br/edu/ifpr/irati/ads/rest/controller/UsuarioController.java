package br.edu.ifpr.irati.ads.rest.controller;

import br.edu.ifpr.irati.ads.model.Usuario;
import br.edu.ifpr.irati.ads.model.repository.UsuarioSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UsuarioController {

    private UsuarioSpringDataRepository repository;

    public UsuarioController(@Autowired UsuarioSpringDataRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/api/usuarios")
    public ResponseEntity save(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = repository.save(usuario);
        return ResponseEntity.ok(usuarioSalvo);
    }

    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity getUsuarioById(@PathVariable("id") Integer id) {
        Optional<Usuario> usuario = repository.findById(id);

        if (usuario.isPresent()) return ResponseEntity.ok(usuario.get());
        return ResponseEntity.notFound().build();
    }

    // Buscar no banco antes de tentar deletar
    @DeleteMapping("/api/usuarios/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        Optional<Usuario> usuario = repository.findById(id);

        if (usuario.isPresent()) {
            repository.delete(usuario.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/usuarios/{id}")
    @ResponseBody
    public ResponseEntity update(@RequestBody Usuario usuario, @PathVariable("id") Integer id) {
        return repository
                .findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setId(id);
                    repository.save(usuario);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // sisbib/api/usuarios?nome=o
    @GetMapping("/api/usuarios")
    @ResponseBody
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
