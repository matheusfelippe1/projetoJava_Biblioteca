import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Livro> livros;
	private List<Usuario> usuarios;
	private List<Emprestimo> emprestimos;
	
	public Biblioteca() {
		livros = new ArrayList<>();
		usuarios = new ArrayList<>();
		emprestimos = new ArrayList<>();
	}
	
	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	

	public String toString() {
		return "Biblioteca [livros=" + livros + ", usuarios=" + usuarios + ", emprestimos="
				+ emprestimos + "]";
	}

	public void cadastrarLivro(Livro livro) {
		livros.add(livro);
		
	}

	public void cadastrarUsuario(Usuario usuario) {
		usuarios.add(usuario);
		
	}

	public void listarLivros() {
		System.out.println("Lista de Livros:");
        for (Livro livro : livros) {
            System.out.println(livro);
        }		
	}

	public void listarAutores() {
		System.out.println("Lista de Autores:");
        for (Livro livro : livros) {
            System.out.println(livro.getAutor());
        }
	}
	
	 public void listarUsuarios() {
	        System.out.println("Lista de Usuários:");
	        for (Usuario usuario : usuarios) {
	            System.out.println(usuario);
	    }
	}

	public void realizarEmprestimo(Emprestimo emprestimo) {
		emprestimos.add(emprestimo);
		
	}

	public Livro buscarLivro(String tituloLivro) {
		 for (Livro livro : livros) {
	            if (livro.getTitulo().equals(tituloLivro)) {
	                return livro;
	            }
	        }
		return null;
	}

	public void listarEmprestimos() {
		System.out.println("Lista de Empréstimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

	public void devolverLivro(Usuario usuario, Livro livro) {
		Emprestimo emprestimoParaRemover = null;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario) && emprestimo.getLivroEmprestimo().equals(livro)) {
                emprestimoParaRemover = emprestimo;
                break;
            }
        }
        if (emprestimoParaRemover != null) {
            emprestimos.remove(emprestimoParaRemover);
        }
    }

	public Usuario buscarUsuario(String nomeUsuario) {
		for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                return usuario;
            }
        }
		return null;
	}
	
	public void excluirLivro(String titulo) {
		Livro livroParaRemover = null;
		for(Livro livro : livros) {
			if(livro.getTitulo().equals(titulo)) {
				livroParaRemover = livro;
				break;
			}
		}
		if(livroParaRemover != null) {
			livros.remove(livroParaRemover);
			System.out.println("Livro excluído com sucesso!");
		}else {
			System.out.println("Livro não encontrado.");
		}
			
	}

	public void editarLivro(String titulo, Livro novoLivro) {
		Livro livroParaEditar = null;
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                livroParaEditar = livro;
                break;
            }
        }
        if (livroParaEditar != null) {
            livroParaEditar.setTitulo(novoLivro.getTitulo());
            livroParaEditar.setIsbn(novoLivro.getIsbn());
            livroParaEditar.setAutor(novoLivro.getAutor());
            System.out.println("Livro editado com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

	public void excluirAutor(String nome) {
		Autor autorParaRemover = null;
        for (Livro livro : livros) {
            if (livro.getAutor().getNome().equals(nome)) {
                autorParaRemover = livro.getAutor();
                break;
            }
        }
        if (autorParaRemover != null) {
            for (Livro livro : livros) {
                if (livro.getAutor() != (autorParaRemover)) {
                    livros.remove(livro);
                }
            }
            System.out.println("Autor e seus livros excluídos com sucesso!");
        } else {
            System.out.println("Autor não encontrado.");
        }
    }

	public void editarAutor(String nome, Autor novoAutor) {
		for (Livro livro : livros) {
            if (livro.getAutor().getNome().equals(nome)) {
                livro.getAutor().setNome(novoAutor.getNome());
                livro.getAutor().setNacionalidade(novoAutor.getNacionalidade());
            }
        }
    }

	public Autor buscarAutor(String nome) {
		for (Livro livro : livros) {
            if (livro.getAutor().getNome().equals(nome)) {
                return livro.getAutor();
            }
        }
		return null;
	}

	public void excluirUsuario(String nome) {
		Usuario usuarioParaRemover = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                usuarioParaRemover = usuario;
                break;
            }
        }
        if (usuarioParaRemover != null) {
            usuarios.remove(usuarioParaRemover);
            System.out.println("Usuário excluído com sucesso!");
        }
    }

	public void editarUsuario(String nome, Usuario novoUsuario) {
		Usuario usuarioParaEditar = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                usuarioParaEditar = usuario;
                break;
            }
        }
        if (usuarioParaEditar != null) {
            usuarioParaEditar.setNome(novoUsuario.getNome());
            usuarioParaEditar.setId(novoUsuario.getId());
            System.out.println("Usuário editado com sucesso!");
        }
    }

	public Usuario cadastrarUsuario(String nomeUsuario) {
		int id = usuarios.size() + 1; // Gera um ID automático
        Usuario usuario = new Usuario(nomeUsuario, id);
        usuarios.add(usuario);
        return usuario;
    }
}
