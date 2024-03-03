import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class Tests {

    private Tarefas tarefas;
    private Tarefa tarefa1;

    @Before
    public void setUp() {
        tarefas = new Tarefas();
        tarefa1 = new Tarefa("Praticar TDD", "Implementar um gerenciador de tarefas usando TDD", LocalDate.now().plusDays(5), PRIORIDADE_ENUM.ALTA);
    }

    @Test
    public void TasksListIsEmpty() {
        assertTrue(tarefas.isEmpty());
    }

    @Test
    public void addTaskTest() {
        tarefas.adicionaTarefa(tarefa1);
        assertEquals(tarefa1.getTitle(), tarefas.getTarefaTitle(0));
    }

    @Test
    public void getTaskIndexOutOfBoundsTest() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class, () -> {tarefas.getTarefaTitle(10);});
        assertTrue(exception.getMessage().contains("tarefa inexistente"));
    }

    @Test
    public void updateTaskTest() {
        tarefas.atualizarTarefa(0, "Novo Título", "Nova Descrição", LocalDate.now().plusDays(1), PRIORIDADE_ENUM.MEDIA);
        assertEquals("Novo Título", tarefas.getTarefaTitle(0));
        assertEquals("Nova Descrição", tarefas.getTarefaDescription(0));
        assertEquals(LocalDate.now().plusDays(1), tarefas.getTarefaDeadLine(0));
        assertEquals(PRIORIDADE_ENUM.MEDIA, tarefas.getTarefaPriority(0));
    }
}
