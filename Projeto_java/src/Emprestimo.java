
public class Emprestimo extends Transacao{
	private Livro livroEmprestimo;
	private Usuario usuario;
	
	public Emprestimo() {}
	
	public Emprestimo(Livro livro, Usuario usuario) {
		this.livroEmprestimo = livro;
		this.usuario = usuario;
	}

	public Livro getLivroEmprestimo() {
		return livroEmprestimo;
	}

	public void setLivroEmprestimo(Livro livroEmprestimo) {
		this.livroEmprestimo = livroEmprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String toString() {
		return "Usuario: " + usuario.getNome() + "\n" + "ID: " + usuario.getId();
	}
}
