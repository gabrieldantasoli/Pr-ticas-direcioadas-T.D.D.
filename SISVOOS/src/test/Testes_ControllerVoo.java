import main.java.org.example.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Testes_ControllerVoo {

    private VooController vooController;
    private VooRepository vooRepository;
    private List<Voo> voos;

    @Before
    public void setUp() {
        voos = new ArrayList<>();
        vooRepository = new VooRepository(voos);
        vooController = new VooController(vooRepository);
    }

    @Test
    public void testPesquisarVoos() {
        Aeronave aeronave = new Aeronave("Boeing 737", "Exemplo Airlines", 150);
        Date data = new Date();
        Voo voo1 = new Voo("E123", aeronave, "Origem", "Destino", 150, 100, 200.0, data);
        Voo voo2 = new Voo("E456", aeronave, "Origem", "Destino", 200, 150, 250.0, data);
        voos.add(voo1);
        voos.add(voo2);

        List<Voo> voosEncontrados = vooController.pesquisarVoos("Origem", "Destino", data, 2);
        assertEquals(2, voosEncontrados.size());
    }

    @Test
    public void testReservarVoo() {
        Aeronave aeronave = new Aeronave("Boeing 737", "Exemplo Airlines", 150);
        Date data = new Date();
        Voo voo = new Voo("E123", aeronave, "Origem", "Destino", 150, 100, 200.0, data);
        voos.add(voo);

        Passageiro passageiro = new Passageiro("João", "123456789");
        vooController.reservarVoo(voo, passageiro);

        assertEquals(99, voo.getNumeroPassageirosDisponiveis());
        assertEquals(1, voo.getPassageiros().size());
        assertNotNull(voo.getPassageiros().get("123456789"));
    }

    @Test
    public void testCancelarReservaVoo() {
        Aeronave aeronave = new Aeronave("Boeing 737", "Exemplo Airlines", 150);
        Date data = new Date();
        Voo voo = new Voo("E123", aeronave, "Origem", "Destino", 150, 100, 200.0, data);
        voos.add(voo);

        Passageiro passageiro = new Passageiro("João", "123456789");
        vooController.reservarVoo(voo, passageiro);
        vooController.cancelarReservaVoo(voo, passageiro);

        assertEquals(100, voo.getNumeroPassageirosDisponiveis());
        assertEquals(0, voo.getPassageiros().size());
        assertNull(voo.getPassageiros().get("123456789"));
    }
}