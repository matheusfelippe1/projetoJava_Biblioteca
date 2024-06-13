
public abstract class Item {
	private String titulo;
	
	public Item() {}
	
	public Item(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String toString() {
		return "Item [titulo=" + titulo + "]";
	}
}
