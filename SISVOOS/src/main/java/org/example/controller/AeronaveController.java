package org.example.controller;

import java.util.List;

import org.example.classes.Aeronave;
import org.example.repository.AeronaveRepository;

public class AeronaveController {
    private AeronaveRepository aeronaveRepository;

    public AeronaveController(AeronaveRepository aeronaveRepository) {
        this.aeronaveRepository = aeronaveRepository;
    }

    public void adicionarAeronave(Aeronave aeronave) {
        aeronaveRepository.adicionarAeronave(aeronave);
    }

    public void removerAeronave(String modelo) {
        aeronaveRepository.removerAeronave(modelo);
    }

    public List<Aeronave> listarAeronaves() {
        return aeronaveRepository.listarAeronaves();
    }

    public Aeronave buscarAeronavePorModelo(String modelo) {
        return aeronaveRepository.buscarAeronavePorModelo(modelo);
    }
}
