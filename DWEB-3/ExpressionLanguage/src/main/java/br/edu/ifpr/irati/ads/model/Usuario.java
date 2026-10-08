package br.edu.ifpr.irati.ads.model;

import jakarta.persistence.*;

@Entity(name = "tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(
            generator = "sequence_usuario",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "sequence_usuario",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "token", nullable = true, length = 255)
    private String token;

    public Usuario() {
        this.id = 0L;
        this.email = "";
        this.senha = "";
        this.token = "";
    }

    public Usuario(Long id, String email, String senha, String token) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
