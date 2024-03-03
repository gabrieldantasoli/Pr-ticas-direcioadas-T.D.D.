import java.time.LocalDate;

public class Tarefa implements Comparable<Tarefa>{

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

    public LocalDate getDeadLine() {
        return this.vencimento;
    }

    public PRIORIDADE_ENUM getPriority() {
        return this.prioridade;
    }

    @Override
    public int compareTo(Tarefa outra) {
        int retorno = 2;

        int comparaVencimento = this.vencimento.compareTo(outra.getDeadLine());

        if (comparaVencimento != 0) {
            retorno = comparaVencimento;
        }

        if (this.prioridade.equals(outra.getPriority())) {
            retorno = 0;
        } else if (this.prioridade.equals(PRIORIDADE_ENUM.ALTA)) {
            retorno = -1;
        } else if (outra.getPriority().equals(PRIORIDADE_ENUM.ALTA)) {
            retorno = 1;
        } else if (this.prioridade.equals(PRIORIDADE_ENUM.MEDIA)) {
            retorno = -1;
        } else {
            retorno = 1;
        }

        return retorno;
    }
}
