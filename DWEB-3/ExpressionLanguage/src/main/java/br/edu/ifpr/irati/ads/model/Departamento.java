package br.edu.ifpr.irati.ads.model;

import java.util.Random;

public class Departamento {
    private String nome;
    private int numero;

    public Departamento() {
        this.nome = "";
        this.numero = new Random().nextInt(1, 5000);
    }

    public Departamento(String nome) {
        this.nome = nome;
        this.numero = new Random().nextInt(1, 5000);
    }
    public Departamento(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "#" + numero + " " + nome;
    }
}
