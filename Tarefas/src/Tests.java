import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Tests {

    private Tarefas tarefas;

    @Before
    public void setUp() {
        Tarefas tarefas = new Tarefas();
    }

    @Test
    public void TasksListIsEmpty() {
        assertTrue(tarefas.isEmpty());
    }

}
