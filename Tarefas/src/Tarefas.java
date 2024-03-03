import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(listaDeTarefas);
    }


    public String getTarefaTitle(int index) {
        Tarefa tarefa = this.getTarefa(index);

        return tarefa.getTitle();
    }


    public void atualizarTarefa(int index, String title, String descricao, LocalDate vencimento, PRIORIDADE_ENUM prioridade) {
        Tarefa tarefa = this.getTarefa(index);

        tarefa.set(title, descricao, vencimento, prioridade);
        
        Collections.sort(listaDeTarefas);
    }


    public String getTarefaDescription(int index) {
        Tarefa tarefa = this.getTarefa(index);

        return tarefa.getDescription();
    }


    public Object getTarefaDeadLine(int index) {
        Tarefa tarefa = this.getTarefa(index);

        return tarefa.getDeadLine();
    }


    public Object getTarefaPriority(int index) {
        Tarefa tarefa = this.getTarefa(index);

        return tarefa.getPriority();
    }


    public void removerTarefa(int index) {
       listaDeTarefas.remove(index);
    }


    public List<Tarefa> getTarefas() {
        return this.listaDeTarefas;
    }

    public Tarefa getTarefa(int index) {
        Tarefa tarefa = null;
        try {
            tarefa = listaDeTarefas.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("tarefa inexistente");
        }

        return tarefa;
    }

}
