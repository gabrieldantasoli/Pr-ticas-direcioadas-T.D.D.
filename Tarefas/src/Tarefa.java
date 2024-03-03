import java.time.LocalDate;

public class Tarefa {

    private String titulo;
    private String descricao;
    private LocalDate vencimento;
    private PRIORIDADE_ENUM prioridade;

    public Tarefa(String titulo, String descricao, LocalDate vencimento, PRIORIDADE_ENUM prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.vencimento = vencimento;
        this.prioridade = prioridade;
    }

	public String getTitle() {
		return (this.titulo);
	}

    public void set(String title, String descripton, LocalDate deadLine, PRIORIDADE_ENUM priority) {
        this.titulo = title;
        this.descricao = descripton;
        this.vencimento = deadLine;
        this.prioridade = priority;
    }

    public String getDescription() {
        return this.descricao;
    }

    public Object getDeadLine() {
        return this.vencimento;
    }

    public Object getPriority() {
        return this.prioridade;
    }
}
