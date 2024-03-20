import org.junit.Test;
import static org.junit.Assert.*;

public class Testes_Aeronave_FUNC {

    @Test
    public void testCapacidadePassageirosNegativa() {
        Aeronave aeronave = new Aeronave("modelo", "companhia", -10);
        assertEquals("ERRO", aeronave.getCapacidadePassageiros(), -10);
    }

    @Test
    public void testCapacidadePassageirosZero() {
        Aeronave aeronave = new Aeronave("modelo", "companhia", 0);
        assertEquals("Aeronave de carga cadastrada", aeronave.getCapacidadePassageiros(), 0);
    }

    @Test
    public void testCapacidadePassageirosLimite() {
        Aeronave aeronave = new Aeronave("modelo", "companhia", 1500);
        assertEquals("Aeronave com 1500 assentos cadastrada", aeronave.getCapacidadePassageiros(), 1500);
    }

    @Test
    public void testCapacidadePassageirosLimiteMaisUm() {
        try {
            new Aeronave("modelo", "companhia", 1501);
            fail("ERRO: As normas só permitem até 1500 assentos");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: As normas só permitem até 1500 assentos", e.getMessage());
        }
    }

    @Test
    public void testModeloInvalido() {
        try {
            new Aeronave(null, "companhia", 100);
            fail("Nome de modelo inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome de modelo inválido", e.getMessage());
        }
    }

    @Test
    public void testCompanhiaInvalida() {
        try {
            new Aeronave("modelo", null, 100);
            fail("Nome da companhia inválida");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome da companhia inválida", e.getMessage());
        }
    }

    @Test
    public void testAeronaveCriada() {
        Aeronave aeronave = new Aeronave("modelo", "companhia", 50);
        assertEquals("Aeronave com 50 assentos criada", aeronave.getCapacidadePassageiros(), 50);
    }
}