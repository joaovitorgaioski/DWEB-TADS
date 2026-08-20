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

    @Column(name="cpf", length = 100, nullable = false)
    private String cpf;

    @Column(name="email", length = 100, nullable = false)
    private String email;

    @Column(name="dataNascimento", length = 100, nullable = false)
    private String dataNascimento;

    public Usuario() {
        this.id = 0L;
        this.nome = "";
        this.email = "";
        this.dataNascimento = "";
    }

    public Usuario(String nome, String cpf, String email, String dataNascimento) {
        this.id = 0L;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(Long id, String nome, String cpf, String email, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}