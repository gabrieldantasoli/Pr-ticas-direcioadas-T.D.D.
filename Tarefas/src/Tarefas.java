import java.util.ArrayList;
import java.util.List;

public class Tarefas {

    private List listaDeTarefas;


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

}
