package br.edu.ifpr.irati.ads.dao;

import jakarta.persistence.*;

@Entity
@Table(name="tb_telefone")
public class Telefone {

    @Id
    @GeneratedValue(
            generator = "sequence_telefone",
            strategy = GenerationType.SEQUENCE
    )
    @SequenceGenerator(
            name = "sequence_telefone",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "numero", length = 20, nullable = false)
    private String numero;

    public Telefone() {
        id = Long.valueOf(0);
    }

    public Telefone(Long id, String numero) {
        this.id = id;
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return id + " " + numero;
    }
}
