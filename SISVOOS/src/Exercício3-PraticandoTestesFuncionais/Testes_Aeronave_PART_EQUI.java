import org.junit.Test;
import static org.junit.Assert.*;

public class Testes_Aeronave_PART_EQUI {

    @Test
    public void testNumeroVooNegativo() {
        try {
            new Voo("-10", null, null, null, 0, 0, 0, null);
            fail("ERRO");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO", e.getMessage());
        }
    }

    @Test
    public void testNumeroVooZero() {
        Voo voo = new Voo("0", null, null, null, 0, 0, 0, null);
        assertEquals("Voo nmr: 0", voo.getNumeroVoo());
    }

    @Test
    public void testNumeroVooPositivo() {
        Voo voo = new Voo("58", null, null, null, 0, 0, 0, null);
        assertEquals("Voo nmr: 58", voo.getNumeroVoo());
    }

    @Test
    public void testOrigemNula() {
        try {
            new Voo("17212", null, null, null, 0, 0, 0, null);
            fail("ERRO: origem não definida");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: origem não definida", e.getMessage());
        }
    }

    @Test
    public void testDestinoNulo() {
        try {
            new Voo("18", null, null, null, 0, 0, 0, null);
            fail("ERRO: destino não definido");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: destino não definido", e.getMessage());
        }
    }

    @Test
    public void testNumeroPassageirosDisponiveisNegativo() {
        try {
            new Voo("19", null, null, null, -1, 0, 0, null);
            fail("ERRO");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO", e.getMessage());
        }
    }

    @Test
    public void testSemAssentosDisponiveis() {
        Voo voo = new Voo("20", null, null, null, 0, 0, 0, null);
        assertEquals("Sem assentos disponíveis", voo.getNumeroPassageirosDisponiveisStatus());
    }

    @Test
    public void testAssentosDisponiveis() {
        Voo voo = new Voo("15", null, null, null, 0, 42, 0, null);
        assertEquals("42 assentos disponíveis", voo.getNumeroPassageirosDisponiveisStatus());
    }

    @Test
    public void testPrecoGratis() {
        Voo voo = new Voo("212", null, null, null, 32, 0, 0, null);
        assertEquals("Preço: gratis", voo.getPrecoStatus());
    }

    @Test
    public void testPrecoValor() {
        Voo voo = new Voo("33", null, null, null, 32, 120, 0, null);
        assertEquals("Preço: 120", voo.getPrecoStatus());
    }

    @Test
    public void testPrecoUm() {
        Voo voo = new Voo("424", null, null, null, 2, 1, 0, null);
        assertEquals("Preço: 1", voo.getPrecoStatus());
    }
}