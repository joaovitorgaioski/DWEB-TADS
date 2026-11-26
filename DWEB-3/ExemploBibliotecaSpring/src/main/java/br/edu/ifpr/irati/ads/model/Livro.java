package br.edu.ifpr.irati.ads.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tblivro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "autores", length = 300, nullable = false)
    private String autores;

    @Column(name = "edicao", length = 10)
    private String edicao;

    @Column(name = "editora", length = 100, nullable = false)
    private String editora;

    @Column(name = "isbn", length = 13)
    private String isbn;

    public Livro() {
    }

    public Livro(int id, String titulo, String autores, String edicao, String editora, String isbn) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.edicao = edicao;
        this.editora = editora;
        this.isbn = isbn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

