package br.edu.ifpr.irati.ads;

import br.edu.ifpr.irati.ads.model.Usuario;
import br.edu.ifpr.irati.ads.model.repository.UsuarioJPARepository;
import br.edu.ifpr.irati.ads.model.repository.UsuarioRepository;
import br.edu.ifpr.irati.ads.model.repository.UsuarioSpringDataRepository;
import br.edu.ifpr.irati.ads.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /*
    // CLR pra testar o Repository
    @Bean
    public CommandLineRunner init(@Autowired UsuarioSpringDataRepository usuarioRepository) {
        return args -> {
            Usuario usuario = new Usuario("João");
            Usuario usuario2 = new Usuario("Maurício");
            usuarioRepository.save(usuario);
            usuarioRepository.save(usuario2);

            List<Usuario> usuarios = usuarioRepository.findAll();
            usuarios.forEach(System.out::println);

            usuarios.get(0).setNome("João Vitor");
            usuarioRepository.save(usuarios.get(0));

            usuarios = usuarioRepository.findAll();
            usuarios.forEach(System.out::println);

            System.out.println(usuarioRepository.findByNome("Maurício"));
        };
    }
    */

    static void main(String[] args) {
        // O run da aplicação é dado por este comando
        SpringApplication.run(BibliotecaApplication.class, args);
    }
}
