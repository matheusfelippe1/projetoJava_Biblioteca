import java.util.Date;

public abstract class Transacao {
	private Date dataTransacao;
	
	public Transacao() {}
	
	public Transacao(Date dataTransacao) {
		this.dataTransacao = new Date();
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	
	public String toString() {
		return "Transacao dataTransacao: " + dataTransacao;
	}
}
