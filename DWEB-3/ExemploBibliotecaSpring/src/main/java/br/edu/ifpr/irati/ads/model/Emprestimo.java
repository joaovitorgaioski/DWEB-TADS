package br.edu.ifpr.irati.ads.model;

import java.time.LocalDateTime;

public class Emprestimo {

    private Usuario usuario;
    private Livro livro;
    private LocalDateTime dataHora;

    public Emprestimo() {
    }

    public Emprestimo(Usuario usuario, Livro livro, LocalDateTime dataHora) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataHora = dataHora;
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
}

