import static org.junit.Assert.assertEquals;
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
}
