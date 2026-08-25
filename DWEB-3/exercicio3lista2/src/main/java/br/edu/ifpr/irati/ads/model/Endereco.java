package br.edu.ifpr.irati.ads.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="logradouro", length = 100, nullable = false)
    private String logradouro;

    @Column(name="numero", length = 100, nullable = false)
    private String numero;

    @Column(name="bairro", length = 100, nullable = false)
    private String bairro;

    @Column(name="cidade", length = 100, nullable = false)
    private String cidade;

    @Column(name="estado", length = 100, nullable = false)
    private String estado;

    @Column(name="cep", length = 100, nullable = false)
    private String cep;

    @OneToMany(mappedBy = "endereco")
    private List<Usuario> usuarios;

    public Endereco() {
        this.logradouro = "";
        this.numero = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
        this.cep = "";
        this.usuarios = new ArrayList<>();
    }

    public Endereco(String logradouro, String numero, String bairro, String cidade, String estado, String cep, List<Usuario> usuarios) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.usuarios = usuarios;
    }

    public Endereco(Long id, String logradouro, String numero, String bairro, String cidade, String estado, String cep, List<Usuario> usuarios) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.usuarios = usuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
