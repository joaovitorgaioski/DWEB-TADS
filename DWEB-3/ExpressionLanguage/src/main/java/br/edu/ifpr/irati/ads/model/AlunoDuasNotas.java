package br.edu.ifpr.irati.ads.model;

import java.util.Random;

public class AlunoDuasNotas {
    private String nome;
    private double nota1, nota2;

    public AlunoDuasNotas() {
    }

    public AlunoDuasNotas(String nome) {
        this.nome = nome;
        this.nota1 = gerarNotaAleatoria();
        this.nota2 = gerarNotaAleatoria();
    }

    public AlunoDuasNotas(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    private double gerarNotaAleatoria() {
        return new Random().nextDouble(20, 100);
    }
}
