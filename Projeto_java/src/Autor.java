
public class Autor extends Pessoa{
	private String nacionalidade;
	
	public Autor() {}
	
	public Autor(String nome, String nacionalidade) {
		super(nome);
		this.nacionalidade = nacionalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String toString() {
		return "Autor: " + getNome()  + "\n" + "Nacionalidade = " + nacionalidade;
	}
}
