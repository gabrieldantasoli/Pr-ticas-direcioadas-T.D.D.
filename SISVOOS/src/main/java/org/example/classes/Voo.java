package org.example.classes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Voo {
    private String numeroVoo;
    private Aeronave aeronave;
    private String origem;
    private String destino;
    private int numeroPassageiros;
    private int numeroPassageirosDisponiveis;
    private double preco;
    private Date data;
    private Map<String, Passageiro> passageiros;

    public Voo(String numeroVoo, Aeronave aeronave, String origem, String destino, int numeroPassageiros, int numeroPassageirosDisponiveis, double preco, Date data) {
        this.numeroVoo = numeroVoo;
        this.aeronave = aeronave;
        this.origem = origem;
        this.destino = destino;
        this.numeroPassageiros = numeroPassageiros;
        this.numeroPassageirosDisponiveis = numeroPassageirosDisponiveis;
        this.preco = preco;
        this.data = data;
        this.passageiros = new HashMap<>();
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(String numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(int numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    public int getNumeroPassageirosDisponiveis() {
        return numeroPassageirosDisponiveis;
    }

    public void setNumeroPassageirosDisponiveis(int numeroPassageirosDisponiveis) {
        this.numeroPassageirosDisponiveis = numeroPassageirosDisponiveis;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Map<String, Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(Map<String, Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public void alocarPassageiro(Passageiro passageiro) {
        if (this.numeroPassageirosDisponiveis > 0) {
            this.passageiros.put(passageiro.getDocumento(), passageiro);
            this.numeroPassageirosDisponiveis--;
        } else {
            System.out.println("Não há assentos disponíveis.");
        }
    }

    public void desalocarPassageiro(String documento) {
        if (this.passageiros.containsKey(documento)) {
            this.passageiros.remove(documento);
            this.numeroPassageirosDisponiveis++;
        } else {
            System.out.println("Passageiro não encontrado neste voo.");
        }
    }
}