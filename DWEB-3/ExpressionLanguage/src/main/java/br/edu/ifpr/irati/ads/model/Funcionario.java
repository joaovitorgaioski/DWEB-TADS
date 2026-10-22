package br.edu.ifpr.irati.ads.model;

import java.math.BigDecimal;

public class Funcionario {
    private String nome;
    private BigDecimal salario;
    private Departamento departamento;

    public Funcionario() {
        this.nome = "";
        this.salario = new BigDecimal("0");
        this.departamento = new Departamento();
    }

    public Funcionario(String nome, BigDecimal salario, Departamento departamento) {
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
