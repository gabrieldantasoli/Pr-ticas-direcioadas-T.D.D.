package org.example.classes;

public class Passageiro {
    private String nome;
    private String sobrenome;
    private int idade;
    private String documento;

    public Passageiro(String nome, String sobrenome, int idade, String documento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.documento = documento;
    }

    // Getters e Setters
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}

