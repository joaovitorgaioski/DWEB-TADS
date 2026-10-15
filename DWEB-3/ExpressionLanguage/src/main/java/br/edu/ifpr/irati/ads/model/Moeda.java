package br.edu.ifpr.irati.ads.model;

public class Moeda {

    private String nome;
    private Double cotacao;

    public Moeda() {
        this.nome = "";
        this.cotacao = 0.0;
    }

    public Moeda(String nome, Double cotacao) {
        this.nome = nome;
        this.cotacao = cotacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getCotacao() {
        return cotacao;
    }

    public void setCotacao(Double cotacao) {
        this.cotacao = cotacao;
    }
}
