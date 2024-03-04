package org.example.classes;

public class Aeronave {
    private String modelo;
    private String companhiaAerea;
    private int capacidadePassageiros;

    public Aeronave(String modelo, String companhiaAerea, int capacidadePassageiros) {
        this.modelo = modelo;
        this.companhiaAerea = companhiaAerea;
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }
}