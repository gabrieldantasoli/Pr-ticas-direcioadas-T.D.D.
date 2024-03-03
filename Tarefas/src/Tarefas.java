import java.time.LocalDate;
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
        String retorno = "";
        try {
            retorno = listaDeTarefas.get(index).getTitle();
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("tarefa inexistente");
        } 
        return retorno;
    }


    public void atualizarTarefa(int index, String title, String descricao, LocalDate vencimento, PRIORIDADE_ENUM prioridade) {
        Tarefa tarefa = null;
        try {
            tarefa = listaDeTarefas.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("tarefa inexistente");
        }

        tarefa.set(title, descricao, vencimento, prioridade);
    }


    public String getTarefaDescription(int index) {
        Tarefa tarefa = null;
        try {
            tarefa = listaDeTarefas.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("tarefa inexistente");
        }

        return tarefa.getDescription();
    }


    public Object getTarefaDeadLine(int index) {
        Tarefa tarefa = null;
        try {
            tarefa = listaDeTarefas.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("tarefa inexistente");
        }

        return tarefa.getDeadLine();
    }


    public Object getTarefaPriority(int index) {
        Tarefa tarefa = null;
        try {
            tarefa = listaDeTarefas.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("tarefa inexistente");
        }

        return tarefa.getPriority();
    }


    public void removerTarefa(int index) {
       listaDeTarefas.remove(index);
    }

}
