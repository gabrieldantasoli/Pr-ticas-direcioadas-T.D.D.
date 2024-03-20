import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

public class Testes_Voo_PART_EQUI {

    @Test
    public void testVooNumeroVooInvalido() {
        try {
            new Voo("", new Aeronave("modelo", "companhia", 100), "New York", "Los Angeles", 100, 80, 500.00, new Date());
            fail("ERRO: Nmr de Voo Inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Nmr de Voo Inválido", e.getMessage());
        }
    }

    @Test
    public void testVooOrigemInvalida() {
        try {
            new Voo("AA123", new Aeronave("modelo", "companhia", 100), "", "London", 150, 100, 800.00, new Date());
            fail("ERRO: Origem inválida");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Origem inválida", e.getMessage());
        }
    }

    @Test
    public void testVooDestinoInvalido() {
        try {
            new Voo("BB456", new Aeronave("modelo", "companhia", 100), "Paris", "", 200, 150, 1000.00, new Date());
            fail("ERRO: Destino inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Destino inválido", e.getMessage());
        }
    }

    @Test
    public void testVooNumeroPassageirosInvalido() {
        try {
            new Voo("CC789", new Aeronave("modelo", "companhia", 100), "Tokyo", "Sydney", -1, 50, 1200.00, new Date());
            fail("ERRO: Nmr de passageiros inválidos");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Nmr de passageiros inválidos", e.getMessage());
        }
    }

    @Test
    public void testVooNumeroPassageirosDisponiveisInvalido() {
        try {
            new Voo("DD012", new Aeronave("modelo", "companhia", 100), "Rome", "Madrid", 300, -10, 1500.00, new Date());
            fail("ERRO: Nmr de passageiros disponíveis inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Nmr de passageiros disponíveis inválido", e.getMessage());
        }
    }

    @Test
    public void testVooPrecoInvalido() {
        try {
            new Voo("EE345", new Aeronave("modelo", "companhia", 100), "Berlin", "Amsterdam", 400, 200, -100.00, new Date());
            fail("ERRO: Preço inválido");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: Preço inválido", e.getMessage());
        }
    }

    @Test
    public void testVooDataInvalidaAntes() {
        try {
            new Voo("FF678", new Aeronave("modelo", "companhia", 100), "Moscow", "Seoul", 500, 300, 2000.00, new Date(121, 0, 1)); // Ano 2021 (ano - 1900), mês 1 (janeiro), dia 1
            fail("ERRO: DATA Inválida");
        } catch (IllegalArgumentException e) {
            assertEquals("ERRO: DATA Inválida", e.getMessage());
        }
    }
}