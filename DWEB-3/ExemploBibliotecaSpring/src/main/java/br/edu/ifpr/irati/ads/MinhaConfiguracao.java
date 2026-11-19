package br.edu.ifpr.irati.ads;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

// Anotação personalizada criada por nós para definir configurações no perfil desenvolvedor
@Development
public class MinhaConfiguracao {

    @Bean(name = "applicationName")
    public String applicationName() {
        return "Sistema da Biblioteca";
    }

    // Código executado assim que a aplicação inicia (quando esta classe é instanciada)
    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("Executando a configuração de desenvolvimento.");
        };
    }
}
