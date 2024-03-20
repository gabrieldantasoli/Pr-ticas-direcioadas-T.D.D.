import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class functionalTests {

    private Tarefas tarefas;    
    private Tarefa tarefa1;
    private Tarefa tarefa4;
    private Tarefa tarefa5;
    private Tarefa tarefa6;

    @Before
    public void setUp() {
        tarefas = new Tarefas();
        tarefa1 = new Tarefa("Praticar TDD", "Implementar um gerenciador de tarefas usando TDD", LocalDate.now().plusDays(5), PRIORIDADE_ENUM.ALTA);
    }
    
    /* Teste de AVL */

    /*
     * Testa se o deadline é maior ou igual a data atual ao criar uma tarefa
     */
    @Test
    public void validDeadline() {
        tarefa1 = new Tarefa("Praticar TDD", "Implementar um gerenciador de tarefas usando TDD", LocalDate.now().plusDays(5), PRIORIDADE_ENUM.ALTA);
        assertTrue(tarefa1.getDeadLine().compareTo(LocalDate.now()) > 0);
    }

    @Test
    public void validDeadlineNow() {
        tarefa5 = new Tarefa("Realizar testes", "realizar testes funcionais no projeto Java", LocalDate.now().minusDays(0), PRIORIDADE_ENUM.BAIXA);
        assertTrue(tarefa5.getDeadLine().compareTo(LocalDate.now()) == 0);
    }

    @Test
    public void invalidDeadlineYesterday() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {new Tarefa("Realizar testes", "realizar testes funcionais no projeto Java", LocalDate.now().minusDays(1), PRIORIDADE_ENUM.BAIXA);});
        assertTrue(exception.getMessage().contains("A data de vencimento não pode ser no passado."));
    }

    @Test
    public void invalidDeadline5DaysBefore() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {new Tarefa("Realizar testes", "realizar testes funcionais no projeto Java", LocalDate.now().minusDays(5), PRIORIDADE_ENUM.BAIXA);});
        assertTrue(exception.getMessage().contains("A data de vencimento não pode ser no passado."));
    }

    /* Teste Partição de Equivalência */

    @Test
    public void testSortingByDeadlineAndPriority() {
        // Criação das tarefas para os casos de teste
        Tarefa tarefa1 = new Tarefa("Tarefa 1", "Descrição da Tarefa 1", LocalDate.now().plusDays(1), PRIORIDADE_ENUM.ALTA);
        Tarefa tarefa2 = new Tarefa("Tarefa 2", "Descrição da Tarefa 2", LocalDate.now(), PRIORIDADE_ENUM.MEDIA);
        Tarefa tarefa3 = new Tarefa("Tarefa 3", "Descrição da Tarefa 3", LocalDate.now().plusDays(3), PRIORIDADE_ENUM.BAIXA);
        Tarefa tarefa4 = new Tarefa("Tarefa 4", "Descrição da Tarefa 4", LocalDate.now().plusDays(4), PRIORIDADE_ENUM.ALTA);
        Tarefa tarefa5 = new Tarefa("Tarefa 5", "Descrição da Tarefa 5", LocalDate.now().plusDays(3), PRIORIDADE_ENUM.MEDIA);
        Tarefa tarefa6 = new Tarefa("Tarefa 6", "Descrição da Tarefa 6", LocalDate.now().plusDays(4), PRIORIDADE_ENUM.BAIXA);
        Tarefa tarefa7 = new Tarefa("Tarefa 7", "Descrição da Tarefa 7", LocalDate.now().plusDays(2), PRIORIDADE_ENUM.ALTA);
        Tarefa tarefa8 = new Tarefa("Tarefa 8", "Descrição da Tarefa 8", LocalDate.now().plusDays(2), PRIORIDADE_ENUM.MEDIA);
        Tarefa tarefa9 = new Tarefa("Tarefa 9", "Descrição da Tarefa 9", LocalDate.now().plusDays(2), PRIORIDADE_ENUM.BAIXA);

        // Adição das tarefas à lista de tarefas
        tarefas.adicionaTarefa(tarefa1);
        tarefas.adicionaTarefa(tarefa2);
        tarefas.adicionaTarefa(tarefa3);
        tarefas.adicionaTarefa(tarefa4);
        tarefas.adicionaTarefa(tarefa5);
        tarefas.adicionaTarefa(tarefa6);
        tarefas.adicionaTarefa(tarefa7);
        tarefas.adicionaTarefa(tarefa8);
        tarefas.adicionaTarefa(tarefa9);
        
        // Verificação da ordem das tarefas após a ordenação
        assertEquals("Tarefa 2", tarefas.getTarefa(0).getTitle());
        assertEquals("Tarefa 1", tarefas.getTarefa(1).getTitle());
        assertEquals("Tarefa 7", tarefas.getTarefa(2).getTitle());
        assertEquals("Tarefa 8", tarefas.getTarefa(3).getTitle());
        assertEquals("Tarefa 9", tarefas.getTarefa(4).getTitle());
        assertEquals("Tarefa 5", tarefas.getTarefa(5).getTitle());
        assertEquals("Tarefa 3", tarefas.getTarefa(6).getTitle());
        assertEquals("Tarefa 4", tarefas.getTarefa(7).getTitle());
        assertEquals("Tarefa 6", tarefas.getTarefa(8).getTitle());
    }
}
