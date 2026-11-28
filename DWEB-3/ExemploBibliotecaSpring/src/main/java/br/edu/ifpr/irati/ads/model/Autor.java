package br.edu.ifpr.irati.ads.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbautor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_completo", length = 100, nullable = false)
    private String nomeCompleto;

    public Autor() {

    }

    public Autor(int id, String nomeCompleto) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                '}';
    }
}
