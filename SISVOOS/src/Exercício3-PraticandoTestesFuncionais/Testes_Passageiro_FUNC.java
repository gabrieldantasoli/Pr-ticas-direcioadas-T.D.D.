import org.junit.Test;
import static org.junit.Assert.*;

public class Testes_Passageiro_FUNC {

    @Test
    public void testIdadeNegativa() {
        try {
            new Passageiro(null, null, -10, null);
            fail("ERRO");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO", e.getMessage());
        }
    }

    @Test
    public void testIdadeZero() {
        Passageiro passageiro = new Passageiro(null, null, 0, null);
        assertEquals("Bebê de colo", passageiro.getIdadeStatus());
    }

    @Test
    public void testIdade5() {
        Passageiro passageiro = new Passageiro(null, null, 5, null);
        assertEquals("Criança", passageiro.getIdadeStatus());
    }

    @Test
    public void testIdade17() {
        Passageiro passageiro = new Passageiro(null, null, 17, null);
        assertEquals("adolescente", passageiro.getIdadeStatus());
    }

    @Test
    public void testIdade18() {
        Passageiro passageiro = new Passageiro(null, null, 18, null);
        assertEquals("adulto", passageiro.getIdadeStatus());
    }

    @Test
    public void testIdade19() {
        Passageiro passageiro = new Passageiro(null, null, 19, null);
        assertEquals("adulto", passageiro.getIdadeStatus());
    }

    @Test
    public void testIdade20SemNome() {
        try {
            new Passageiro(null, null, 20, "str1");
            fail("Não é possível identificar passageiro");
        } catch (IllegalArgumentException e) {
            assertEquals("Não é possível identificar passageiro", e.getMessage());
        }
    }

    @Test
    public void testIdade15SemNome() {
        try {
            new Passageiro(null, null, 15, "str2");
            fail("Passageiro sem nome");
        } catch (IllegalArgumentException e) {
            assertEquals("Passageiro sem nome", e.getMessage());
        }
    }

    @Test
    public void testPassageiroIdentificado() {
        Passageiro passageiro = new Passageiro("str1", "str2", 21, "str3");
        assertEquals("Passegeiro Identificado", passageiro.getIdadeStatus());
    }
}
