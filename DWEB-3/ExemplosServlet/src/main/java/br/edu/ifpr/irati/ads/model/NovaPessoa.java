package br.edu.ifpr.irati.ads.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

// Notação para transformar em XML automaticamente
@XmlRootElement(name = "pessoa")
@XmlAccessorType(XmlAccessType.FIELD)
public class NovaPessoa {
    private String nome, sobrenome;

    public NovaPessoa() {
        this.nome = "";
        this.sobrenome = "";
    }

    public NovaPessoa(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
