package org.example.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.classes.Aeronave;

public class AeronaveRepository {
    private Map<String, Aeronave> aeronaves;

    public AeronaveRepository() {
        this.aeronaves = new HashMap<>();
    }

    public void adicionarAeronave(Aeronave aeronave) {
        aeronaves.put(aeronave.getModelo(), aeronave);
    }

    public void removerAeronave(String modelo) {
        aeronaves.remove(modelo);
    }

    public List<Aeronave> listarAeronaves() {
        return new ArrayList<>(aeronaves.values());
    }

    public Aeronave buscarAeronavePorModelo(String modelo) {
        return aeronaves.get(modelo);
    }
}
