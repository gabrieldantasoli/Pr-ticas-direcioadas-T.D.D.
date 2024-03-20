import org.junit.Test;
import static org.junit.Assert.*;

public class Testes_Passageiro_PART_EQUI {

    @Test
    public void testNomeInvalido() {
        try {
            new Passageiro("", "Doe", 25, "AB123456");
            fail("ERRO: Nome inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Nome inválido", e.getMessage());
        }
    }

    @Test
    public void testSobrenomeInvalido() {
        try {
            new Passageiro("John", "", 30, "CD987654");
            fail("ERRO: Sobrenome inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Sobrenome inválido", e.getMessage());
        }
    }

    @Test
    public void testIdadeInvalida() {
        try {
            new Passageiro("Alice", "Smith", -1, "EF456789");
            fail("ERRO: Idade inválida");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Idade inválida", e.getMessage());
        }
    }

    @Test
    public void testIdadeLimite() {
        Passageiro passageiro = new Passageiro("Bob", "Jones", 150, "GH987654");
        assertEquals("Passageiro identificado", passageiro.getIdadeStatus());
    }

    @Test
    public void testDocumentoInvalido() {
        try {
            new Passageiro("Charlie", "Brown", 35, "");
            fail("ERRO: Documento inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Documento inválido", e.getMessage());
        }
    }

    @Test
    public void testPassageiroIdentificado() {
        Passageiro passageiro = new Passageiro("David", "Lee", 40, "IJ3456789");
        assertEquals("Passageiro identificado", passageiro.getIdadeStatus());
    }
}
