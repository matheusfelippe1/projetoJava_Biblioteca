
public class Livro extends Item{
	private String isbn;
	private Autor autor;
	
	public Livro() {}
	
	public Livro(String titulo, String isbn, Autor autor) {
		super(titulo);
		this.isbn = isbn;
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String toString() {
		return "Livro: " + getTitulo() + "\n" + "isbn: " + isbn + "\n" + "Autor: " + autor.getNome() + "\n" + "Nacionalidade: " + autor.getNacionalidade();
	}
}
