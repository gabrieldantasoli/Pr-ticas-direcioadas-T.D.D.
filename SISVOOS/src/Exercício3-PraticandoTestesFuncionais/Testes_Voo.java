import main.java.org.example.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Testes_Voo {

    private Voo voo;
    private Passageiro passageiro1;
    private Passageiro passageiro2;

    @BeforeEach
    public void setUp() {
        Aeronave aeronave = new Aeronave("Boeing 737", "Exemplo Airlines", 150);
        Date data = new Date();
        voo = new Voo("123ABC", aeronave, "Origem", "Destino", 100, 100, 1000.0, data);
        passageiro1 = new Passageiro("João", "Silva", 30, "ABC123");
        passageiro2 = new Passageiro("Maria", "Souza", 25, "DEF456");
    }

    @Test
    public void testAlocarPassageiro() {
        voo.alocarPassageiro(passageiro1);
        Map<String, Passageiro> passageiros = new HashMap<>();
        passageiros.put("ABC123", passageiro1);
        assertEquals(passageiros, voo.getPassageiros());
        assertEquals(99, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testDesalocarPassageiro() {
        voo.alocarPassageiro(passageiro1);
        voo.alocarPassageiro(passageiro2);
        voo.desalocarPassageiro("ABC123");
        Map<String, Passageiro> passageiros = new HashMap<>();
        passageiros.put("DEF456", passageiro2);
        assertEquals(passageiros, voo.getPassageiros());
        assertEquals(99, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testAlocarPassageiro_AssentosIndisponiveis() {
        // Preencher todos os assentos disponíveis
        for (int i = 0; i < 100; i++) {
            voo.alocarPassageiro(new Passageiro("Passageiro" + i, "Sobrenome", 30, "DOC" + i));
        }
        // Tentar alocar mais um passageiro
        voo.alocarPassageiro(new Passageiro("Extra", "Passageiro", 40, "EXTRA001"));
        // Deve imprimir "Não há assentos disponíveis."
        assertEquals(0, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testDesalocarPassageiro_PassageiroNaoEncontrado() {
        // Tentar desalocar um passageiro que não está no voo
        voo.desalocarPassageiro("NaoExiste");
        // Deve imprimir "Passageiro não encontrado neste voo."
        assertEquals(100, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testAlocarPassageiro_DoisPassageiros() {
        // Tentar alocar dois passageiros
        voo.alocarPassageiro(passageiro1);
        voo.alocarPassageiro(passageiro2);
        Map<String, Passageiro> passageiros = new HashMap<>();
        passageiros.put("ABC123", passageiro1);
        passageiros.put("DEF456", passageiro2);
        assertEquals(passageiros, voo.getPassageiros());
        assertEquals(98, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testDesalocarPassageiro_UltimoPassageiro() {
        // Alocar e desalocar um único passageiro
        voo.alocarPassageiro(passageiro1);
        voo.desalocarPassageiro("ABC123");
        assertTrue(voo.getPassageiros().isEmpty());
        assertEquals(100, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testAlocarPassageiro_SemPassageiros() {
        // Tentar desalocar um passageiro quando não há passageiros alocados
        voo.desalocarPassageiro("ABC123");
        assertTrue(voo.getPassageiros().isEmpty());
        assertEquals(100, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testAlocarPassageiro_PassageiroRepetido() {
        // Tentar alocar um passageiro com o mesmo documento que já está no voo
        voo.alocarPassageiro(passageiro1);
        voo.alocarPassageiro(passageiro1);
        Map<String, Passageiro> passageiros = new HashMap<>();
        passageiros.put("ABC123", passageiro1);
        assertEquals(passageiros, voo.getPassageiros());
        assertEquals(99, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testDesalocarPassageiro_Invalido() {
        // Tentar desalocar um passageiro com documento inválido
        voo.desalocarPassageiro("DocumentoInvalido");
        assertEquals(100, voo.getNumeroPassageirosDisponiveis());
    }

    @Test
    public void testConstrutor() {
        assertNotNull(voo);
    }

    @Test
    public void testSetNumeroVoo() {
        voo.setNumeroVoo("456DEF");
        assertEquals("456DEF", voo.getNumeroVoo());
    }

    @Test
    public void testSetOrigem() {
        voo.setOrigem("Nova Origem");
        assertEquals("Nova Origem", voo.getOrigem());
    }

    @Test
    public void testSetDestino() {
        voo.setDestino("Novo Destino");
        assertEquals("Novo Destino", voo.getDestino());
    }

    @Test
    public void testSetPreco() {
        voo.setPreco(1500.0);
        assertEquals(1500.0, voo.getPreco());
    }

    @Test
    public void testSetData() {
        Date newData = new Date();
        voo.setData(newData);
        assertEquals(newData, voo.getData());
    }

    @Test
    public void testSetPassageiros() {
        Map<String, Passageiro> newPassageiros = new HashMap<>();
        newPassageiros.put("ABC123", passageiro1);
        voo.setPassageiros(newPassageiros);
        assertEquals(newPassageiros, voo.getPassageiros());
    }

    @Test
    public void testGetNumeroPassageiros() {
        assertEquals(100, voo.getNumeroPassageiros());
    }

    @Test
    public void testGetAeronave() {
        assertEquals("Boeing 737", voo.getAeronave().getModelo());
    }
}