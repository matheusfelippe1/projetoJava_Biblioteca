import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Biblioteca biblioteca = new Biblioteca();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String opcao = "Sair";
		do {
			opcao = exibirMenu(scanner);
			
			switch (opcao) {
				case "Cadastrar Livro":
					cadastrarLivro(scanner);
					break;
				case "Cadastrar Usuário":
					cadastrarUsuario(scanner);
					break;
				case "Listar Livros":
					listarLivros(scanner);
					break;
				case "Listar Autores":
					listarAutores(scanner);
					break;
				case "Listar Usuários":
					listarUsuarios(scanner);
					break;
				case "Realizar Empréstimo":
					realizarEmprestimo(scanner);
					break;
				case "Listar Empréstimos":
					listarEmprestimos(scanner);
					break;
				case "Devolver Livro":
					devolverLivro(scanner);
					break;
				case "Excluir Livro":
					excluirLivro(scanner);
					break;
				case "Editar Livro":
					editarLivro(scanner);
					break;
				case "Excluir Autor":
					excluirAutor(scanner);
					break;
				case "Editar Autor":
					editarAutor(scanner);
					break;
				case "Excluir Usuário":
					excluirUsuario(scanner);
					break;
				case "Editar Usuário":
					editarUsuario(scanner);
					break;
				case "Sair":
					System.out.println("Saindo do sistema...");
					break;
				default:
					System.out.println("Opção inválida!");
			}
		}while (!opcao.equals("Sair"));
		
		scanner.close();
	
	}

	private static String exibirMenu(Scanner scanner) {
		ArrayList<String> opcoesMenu = new ArrayList<>();
        opcoesMenu.add("===== MENU =====");
        opcoesMenu.add("Cadastrar Livro");
        opcoesMenu.add("Cadastrar Usuário");
        opcoesMenu.add("Listar Livros");
        opcoesMenu.add("Listar Autores");
        opcoesMenu.add("Listar Usuários");
        opcoesMenu.add("Realizar Empréstimo");
        opcoesMenu.add("Listar Empréstimos");
        opcoesMenu.add("Devolver Livro");
        opcoesMenu.add("Excluir Livro");
        opcoesMenu.add("Editar Livro");
        opcoesMenu.add("Excluir Autor");
        opcoesMenu.add("Editar Autor");
        opcoesMenu.add("Excluir Usuário");
        opcoesMenu.add("Editar Usuário");
        opcoesMenu.add("Sair");
        
        for(int i=0; i < opcoesMenu.size();i++) {
        	if(i == 0) {
        		System.out.println(opcoesMenu.get(i));
        	}else {
        		System.out.println(i + ". " + opcoesMenu.get(i));
        	}
        }
        System.out.println("Escolha uma opcção: ");
        int opcao = scanner.nextInt();
		scanner.nextLine();
		return opcoesMenu.get(opcao);
    }

	private static void cadastrarLivro(Scanner scanner) {
		System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o ISBN do livro: ");
        String isbn = scanner.nextLine();
        System.out.print("Digite o nome do autor do livro: ");
        String nomeAutor = scanner.nextLine();
        System.out.print("Digite a nacionalidade do autor: ");
        String nacionalidadeAutor = scanner.nextLine();

        Autor autor = new Autor(nomeAutor, nacionalidadeAutor);
        Livro livro = new Livro(titulo, isbn, autor);

        biblioteca.cadastrarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
		
	}
	
	private static void cadastrarUsuario(Scanner scanner) {
		 System.out.print("Digite o nome do usuário: ");
	        String nome = scanner.nextLine();
	        System.out.print("Digite o ID do usuário: ");
	        int id = scanner.nextInt();
	        scanner.nextLine();

	        Usuario usuario = new Usuario(nome, id);
	        biblioteca.cadastrarUsuario(usuario);
	        System.out.println("Usuário cadastrado com sucesso!");
	}
	
	private static void listarLivros(Scanner scanner) {
		biblioteca.listarLivros();
		
	}
	
	private static void listarAutores(Scanner scanner) {
        biblioteca.listarAutores();
		
	}

    private static void listarUsuarios(Scanner scanner) {
        biblioteca.listarUsuarios();
    }
    
    private static void realizarEmprestimo(Scanner scanner) {
    	System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite o título do livro: ");
        String tituloLivro = scanner.nextLine();

        Usuario usuario = biblioteca.cadastrarUsuario(nomeUsuario);
        Livro livro = biblioteca.buscarLivro(tituloLivro);

        if (usuario != null && livro != null) {
            Emprestimo emprestimo = new Emprestimo(livro, usuario);
            biblioteca.realizarEmprestimo(emprestimo);
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Usuário ou livro não encontrado.");
        }
    }
    
    private static void listarEmprestimos(Scanner scanner) {
    	biblioteca.listarEmprestimos();
	}
    
    private static void devolverLivro(Scanner scanner) {
    	System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Digite o título do livro para devolver: ");
        String tituloLivro = scanner.nextLine();

        Usuario usuario = biblioteca.buscarUsuario(nomeUsuario);
        Livro livro = biblioteca.buscarLivro(tituloLivro);

        if (usuario != null && livro != null) {
            biblioteca.devolverLivro(usuario, livro);
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Usuário ou livro não encontrado.");
        }
    }
    
    private static void excluirLivro(Scanner scanner) {
    	System.out.print("Digite o título do livro a ser excluído: ");
        String titulo = scanner.nextLine();
        biblioteca.excluirLivro(titulo);
    }
    
	private static void editarLivro(Scanner scanner) {
		System.out.print("Digite o título do livro a ser editado: ");
        String titulo = scanner.nextLine();
        
        Livro livroExistente = biblioteca.buscarLivro(titulo);
        if (livroExistente != null) {
            System.out.print("Digite o novo título do livro: ");
            String novoTitulo = scanner.nextLine();
            System.out.print("Digite o novo ISBN do livro: ");
            String novoIsbn = scanner.nextLine();
            System.out.print("Digite o novo nome do autor do livro: ");
            String novoNomeAutor = scanner.nextLine();
            System.out.print("Digite a nova nacionalidade do autor: ");
            String novaNacionalidadeAutor = scanner.nextLine();

            Autor novoAutor = new Autor(novoNomeAutor, novaNacionalidadeAutor);
            Livro novoLivro = new Livro(novoTitulo, novoIsbn, novoAutor);

            biblioteca.editarLivro(titulo, novoLivro);
            System.out.println("Autor editado com sucesso!");
        } else {
            System.out.println("Autor não encontrado.");
        }
    }
	
	private static void excluirAutor(Scanner scanner) {
		System.out.print("Digite o nome do autor a ser excluído: ");
        String nome = scanner.nextLine();
        biblioteca.excluirAutor(nome);
        System.out.println("Autor excluído com sucesso!");
    }
	
	private static void editarAutor(Scanner scanner) {
		System.out.print("Digite o nome do autor a ser editado: ");
        String nome = scanner.nextLine();
        
        Autor autorExistente = biblioteca.buscarAutor(nome);
        if (autorExistente != null) {
            System.out.print("Digite o novo nome do autor: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite a nova nacionalidade do autor: ");
            String novaNacionalidade = scanner.nextLine();

            Autor novoAutor = new Autor(novoNome, novaNacionalidade);

            biblioteca.editarAutor(nome, novoAutor);
            System.out.println("Autor editado com sucesso!");
        } else {
            System.out.println("Autor não encontrado.");
        }
    }
	
	private static void excluirUsuario(Scanner scanner) {
		System.out.print("Digite o nome do usuário a ser excluído: ");
        String nome = scanner.nextLine();
        biblioteca.excluirUsuario(nome);
        System.out.println("Usuário excluído com sucesso!");
    }
	
	private static void editarUsuario(Scanner scanner) {
		System.out.print("Digite o nome do usuário a ser editado: ");
        String nome = scanner.nextLine();
        
        Usuario usuarioExistente = biblioteca.buscarUsuario(nome);
        if (usuarioExistente != null) {
            System.out.print("Digite o novo nome do usuário: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo ID do usuário: ");
            int novoId = scanner.nextInt();
            scanner.nextLine();

            Usuario novoUsuario = new Usuario(novoNome, novoId);

            biblioteca.editarUsuario(nome, novoUsuario);
            System.out.println("Usuário editado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

}
