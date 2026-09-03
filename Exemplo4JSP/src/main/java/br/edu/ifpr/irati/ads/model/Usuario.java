package br.edu.ifpr.irati.ads.model;

import jakarta.persistence.*;

@Entity(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence_usuario", allocationSize = 1)
    private Long id;
    @Column(name="nome", length = 100, nullable = false)
    private String nome;
    @Column(name="email", length = 100, nullable = false)
    private String email;
    @Column(name="senha", length = 100, nullable = false)
    private String senha;

    public Usuario() {
        this.id = 0L;
        this.nome = "";
        this.email = "";
        this.senha = "";
    }

    public Usuario(String nome, String email, String senha) {
        this.id = 0L;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}