package br.edu.ifpr.irati.ads.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbemprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Usuario usuario;

    @OneToOne
    private Livro livro;

    @Column(name = "datahora")
    private LocalDateTime dataHora;

    public Emprestimo() {
    }

    public Emprestimo(Usuario usuario, Livro livro, LocalDateTime dataHora) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataHora = dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", livro=" + livro +
                ", dataHora=" + dataHora +
                '}';
    }
}