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
}
