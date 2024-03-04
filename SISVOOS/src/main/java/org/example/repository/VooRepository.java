package org.example.repository;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.example.classes.Passageiro;
import org.example.classes.Voo;

public class VooRepository {
    private List<Voo> voos;

    public VooRepository() {
        this.voos = new ArrayList<>();
    }

    public void adicionarVoo(Voo voo) {
        voos.add(voo);
    }

    public List<Voo> pesquisarVoos(String origem, String destino, Date data, int numeroPassageiros) {
        List<Voo> voosDisponiveis = new ArrayList<>();
        for (Voo voo : voos) {
            if (voo.getOrigem().equals(origem) && voo.getDestino().equals(destino) && voo.getData().equals(data)
                    && voo.getNumeroPassageirosDisponiveis() >= numeroPassageiros) {
                voosDisponiveis.add(voo);
            }
        }
        return voosDisponiveis;
    }

    public void reservarVoo(Voo voo, Passageiro passageiro, int numeroPassageiros, String informacoesContato) {
        voo.alocarPassageiro(passageiro);
    }

    public void cancelarReservaVoo(String codigoReserva, String identificacaoPessoal) {
        for (Voo item : voos) {
            if (item.getNumeroVoo().equals(codigoReserva)) {
                item.desalocarPassageiro(identificacaoPessoal);
                break;
            }
        }        
    }
}