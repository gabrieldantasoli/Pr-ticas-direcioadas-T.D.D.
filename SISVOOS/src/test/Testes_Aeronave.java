import main.java.org.example.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Test_Aeronave {

    private AeronaveController aeronaveController;
    private AeronaveRepository aeronaveRepository;

    @Before
    public void setUp() {
        aeronaveRepository = new AeronaveRepository();
        aeronaveController = new AeronaveController(aeronaveRepository);
    }

    @Test
    public void testAdicionarAeronave() {
        Aeronave aeronave = new Aeronave("Boeing 737", "Exemplo Airlines", 150);
        aeronaveController.adicionarAeronave(aeronave);
        assertNotNull(aeronaveRepository.buscarAeronavePorModelo("Boeing 737"));
    }

    @Test
    public void testRemoverAeronave() {
        Aeronave aeronave = new Aeronave("Boeing 737", "Exemplo Airlines", 150);
        aeronaveController.adicionarAeronave(aeronave);
        aeronaveController.removerAeronave("Boeing 737");
        assertNull(aeronaveRepository.buscarAeronavePorModelo("Boeing 737"));
    }

    @Test
    public void testListarAeronaves() {
        Aeronave aeronave1 = new Aeronave("Boeing 737", "Exemplo Airlines", 150);
        Aeronave aeronave2 = new Aeronave("Airbus A320", "Outra Companhia", 200);
        aeronaveController.adicionarAeronave(aeronave1);
        aeronaveController.adicionarAeronave(aeronave2);
        List<Aeronave> aeronaves = aeronaveController.listarAeronaves();
        assertEquals(2, aeronaves.size());
    }

    @Test
    public void testBuscarAeronavePorModelo() {
        Aeronave aeronave = new Aeronave("Boeing 737", "Exemplo Airlines", 150);
        aeronaveController.adicionarAeronave(aeronave);
        Aeronave aeronaveEncontrada = aeronaveController.buscarAeronavePorModelo("Boeing 737");
        assertNotNull(aeronaveEncontrada);
        assertEquals("Boeing 737", aeronaveEncontrada.getModelo());
    }
}
