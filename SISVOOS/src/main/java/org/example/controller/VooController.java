package org.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.example.classes.Passageiro;
import org.example.classes.Voo;
import org.example.repository.VooRepository;

public class VooController {
    private VooRepository vooRepository;

    public VooController(VooRepository vooRepository) {
        this.vooRepository = vooRepository;
    }

    public List<Voo> pesquisarVoos(String origem, String destino, Date data, int numeroPassageiros) {
        return vooRepository.pesquisarVoos(origem, destino, data, numeroPassageiros);
    }

    public void reservarVoo(Voo voo, Passageiro passageiro, int numeroPassageiros, String informacoesContato) {
        vooRepository.reservarVoo(voo, passageiro, numeroPassageiros, informacoesContato);
    }

    public void cancelarReservaVoo(String codigoReserva, String identificacaoPessoal) {
        vooRepository.cancelarReservaVoo(codigoReserva, identificacaoPessoal);
    }
}