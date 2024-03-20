import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class Test_Voo_FUNC {

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
            new Voo("18", null, "origem", null, 0, 0, 0, null);
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
        voo.setNumeroPassageirosDisponiveis(0);
        assertEquals("Sem assentos disponiveis", voo.getNumeroPassageirosDisponiveisStatus());
    }

    @Test
    public void testAssentosDisponiveis() {
        Voo voo = new Voo("15", null, null, null, 0, 0, 0, null);
        voo.setNumeroPassageirosDisponiveis(42);
        assertEquals("42 assentos disponíveis", voo.getNumeroPassageirosDisponiveisStatus());
    }

    @Test
    public void testPrecoGratis() {
        Voo voo = new Voo("212", null, null, null, 0, 0, 0, null);
        voo.setPreco(0);
        assertEquals("Preço: gratis", voo.getPrecoStatus());
    }

    @Test
    public void testPrecoPositivo() {
        Voo voo = new Voo("33", null, null, null, 0, 0, 120, null);
        assertEquals("Preço: 120", voo.getPrecoStatus());
    }
}