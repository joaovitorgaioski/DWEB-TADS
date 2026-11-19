package br.edu.ifpr.irati.ads;

import br.edu.ifpr.irati.ads.model.Usuario;
import br.edu.ifpr.irati.ads.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Anotação que mostra ao Spring que esta classe inicia a aplicação
@SpringBootApplication
@RestController
public class BibliotecaApplication {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @Value("${application.shortName}")
    private String applicationShortName;

    @Value("${application.name}")
    private String applicationNameConf;

    @GetMapping("/name")
    public String helloWorld() {
        Usuario usuario = new Usuario();
        usuario.setNome("Joaquim");
        usuarioService.salvarUsuario(usuario);

        return applicationName;
    }

    @GetMapping("shortname")
    public String shortName() {
        return this.applicationShortName;
    }

    @GetMapping("nameconf")
    public String nameConf() {
        return this.applicationNameConf;
    }

    static void main(String[] args) {
        // O run da aplicação é dado por este comando
        SpringApplication.run(BibliotecaApplication.class, args);
    }
}
