
public class Usuario extends Pessoa{
	private int id;
	
	public Usuario() {}
	
	public Usuario(String nome, int id) {
		super(nome);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return "Usuário: " + getNome() + "\n" + "ID: " + id;
	}
}
