package br.edu.ifpr.irati.ads.model;

import java.math.BigDecimal;
import java.util.Random;

public class Produto {
    private String nome;
    private BigDecimal preco;
    private int percentualDesconto;

    public Produto() {
    }

    public Produto(String nome) {
        this.nome = nome;
        this.preco = BigDecimal.valueOf(new Random().nextDouble(0.1, 100));
        this.percentualDesconto = new Random().nextInt(0, 60);
    }

    public Produto(String nome, BigDecimal preco, int percentualDesconto) {
        this.nome = nome;
        this.preco = preco;
        this.percentualDesconto = percentualDesconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(int percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }
}
