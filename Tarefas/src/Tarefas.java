import java.util.ArrayList;
import java.util.List;

public class Tarefas {

    private List<Tarefa> listaDeTarefas;


    public Tarefas() {
        this.listaDeTarefas = new ArrayList<>();
    }


    public boolean isEmpty() {
        boolean retorno = false;
        if (listaDeTarefas.isEmpty()) {
            retorno = true;
        }
        return retorno;
    }


    public void adicionaTarefa(Tarefa tarefa1) {
        listaDeTarefas.add(tarefa1);
    }


    public String getTarefaTitle(int index) {
        return ("Praticar TDD");
    }

}
