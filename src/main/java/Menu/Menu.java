package Menu;

import java.sql.SQLException;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidades.Cliente;
import Entidades.Estoque;
import Entidades.Login;
import Entidades.Produto;
import EntidadesDAO.ClienteDAO;
import EntidadesDAO.EstoqueDAO;
import EntidadesDAO.LoginDAO;
import EntidadesDAO.ProdutoDAO;

public class Menu {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("leo");
	EntityManager em = emf.createEntityManager();

	public void login() throws SQLException {
		Scanner in = new Scanner(System.in);
		LoginDAO daoo = new LoginDAO(emf);
		// Vendedor vendedor = new Vendedor();
		Login loginn = new Login();
		Menu menu = new Menu();
		int opcaoo = 0;
		do {
			System.out.println("==============================");
			System.out.println("==== FAÇA O LOGIN! ====");
			System.out.println("==============================\n");
			System.out.println("\n");
			System.out.println("1 - Login ");
			System.out.println("2 - Cadastro ");
			System.out.println("3 - Sair");
			opcaoo = in.nextInt();

			switch (opcaoo) {
			case 1:
				System.out.println("Digite seu CPF: ");
				loginn.setCpf(in.next());

				System.out.println("Digite sua Senha: ");
				loginn.setSenha(in.next());

				daoo.login(loginn.getCpf(), loginn.getSenha());

				break;

			case 2:

				System.out.println("Digite seu CPF: ");
				loginn.setCpf(in.next());
				System.out.println("Digite sua Senha: ");
				loginn.setSenha(in.next());

				daoo.cadastrarLogin(loginn);

				break;

			default:
				System.out.println("Opção Invalida!!");

				break;

			}

		} while (opcaoo != 3);

		System.out.println("Obrigado!!");

	}

	public void menuInicar() throws SQLException {
		Menu menu = new Menu();

		Scanner in = new Scanner(System.in);
		int opcao = 0;
		do {
			System.out.println("            +============================+");
			System.out.println("              -----  DHERYCK MOTOS  -----  ");
			System.out.println("            +============================+");
			System.out.println();
			System.out.println("       -----  ESCOLHA ALGUMAS DAS OPCÕES  -----  ");
			System.out.println("   +======================================================================+");
			System.out.println("   1 - Cliente 2 - Produto 3 - NFs 4 - Fornecedores 5 - Vendas 6 - Estoque ");
			System.out.println("   +======================================================================+");
			opcao = in.nextInt();
			switch (opcao) {
			case 1:
				menu.cadastrarCliente();
				break;

			case 2:
				menu.CadastrarEstoque();

				break;
			case 3:
				menu.nfs();
				break;
			default:
				System.out.println("opcao invalida");
				break;
			}

		} while (opcao != 5);

	}

	public void cadastrarCliente() throws SQLException {
		Cliente c1 = new Cliente();
		Scanner in = new Scanner(System.in);
		int opcao1 = 0;

		System.out.println("       -----  CLIENTE  -----  ");
		System.out.println();
		System.out.println("	1 - Cadastrar Cliente.");
		System.out.println("	2 - Consultar Cliente");
		System.out.println("	3 - Atualizar Cliente ");
		System.out.println("	4 - Excluir Cliente");
		System.out.println("    5 - Voltar o Menu Inicial");
		System.out.println("	6 - Sair.");

		opcao1 = in.nextInt();

		switch (opcao1) {

		case 1:

			System.out.println("Digite o Nome do Cliente: ");
			c1.setNome(in.next());
			System.out.println("Digite o CPF: ");
			c1.setCpf(in.next());
			System.out.println("Digite o RG: ");
			c1.setRg(in.next());
			System.out.println("Digite o Telefone: ");
			c1.setTelefone(in.next());
			System.out.println("Digite o EMAIL: ");
			c1.setEmail(in.next());

			ClienteDAO clienteDao = new ClienteDAO(emf);
			clienteDao.inserirCliente(c1);
			cadastrarCliente();

			break;

		case 2:
			int opcao4 = 0;

			do {

				System.out.println("1 - Consultar por CPF: ");
				System.out.println("2 - Consultar por ID: ");
				System.out.println("3 - Consultar Todos Cliente: ");
				System.out.println("4 - Voltar o Menu Anterior: ");
				System.out.println("5 - Sair: ");
				opcao4 = in.nextInt();
				switch (opcao4) {
				case 1:
					System.out.println("Digite o CPF do Cliente: ");
					String cpf = in.next();
					ClienteDAO dao1 = new ClienteDAO(emf);
					dao1.consultaPorCpf(cpf);

					break;
				case 2:

					System.out.println("Digite o ID a ser Consultado: ");
					int id = in.nextInt();
					ClienteDAO dao2 = new ClienteDAO(emf);
					dao2.consultaPorId(id);

					break;

				case 3:
					ClienteDAO dao3 = new ClienteDAO(emf);
					dao3.findAll();
					break;

				case 4:
					Menu menu = new Menu();
					menu.cadastrarCliente();
					break;
				default:
					System.out.println("Opcção invalida!!");
					break;
				}

			} while (opcao4 != 5);
			Menu menu1 = new Menu();
			menu1.cadastrarCliente();

			break;
		case 3:
			// atualizar
			System.out.println("Digite o CPF a ser Atualizado!");
			String cpf2 = in.next();
			ClienteDAO dao4 = new ClienteDAO(emf);
			dao4.atualizarClientePorId(cpf2);

			break;
		case 4:
			int opcao3 = 0;
			do {
				System.out.println("------------------------------ ");
				System.out.println("--------Deletar Cliente------- ");
				System.out.println("------------------------------ ");
				System.out.println("1 - Excluir Cliente por ID:    ");
				System.out.println("2 - Excluir Todos os Clientes: ");
				opcao3 = in.nextInt();
				switch (opcao3) {
				case 1:

					ClienteDAO dao5 = new ClienteDAO(emf);

					System.out.println("Qual o CPF  deseja Excluir: ");
					String cpf = in.next();
					dao5.consultaPorCpf(cpf);

					System.out.println("Digite o ID do Cliente a ser Excluido: ");
					int id = in.nextInt();
					dao5.deletarClientePorId(id);

					break;
				case 2:
					ClienteDAO dao7 = new ClienteDAO(emf);
					dao7.deletarTodosCliente();

					break;

				default:
					System.out.println("Opcão Incorreta!!");
					break;
				}

			} while (opcao3 != 3);

			Menu menu = new Menu();
			menu.cadastrarCliente();
			break;

		case 5:

			Menu menu2 = new Menu();
			menu2.menuInicar();
			break;
		case 6:

			break;
		case 7:
			System.out.println("Digite o ID: ");
			String cpf4 = in.next();
			ClienteDAO dao6 = new ClienteDAO(emf);
			dao6.findClienteDTOById(cpf4);
			break;
		default:
			System.out.println("Opcção invalida!!");
			break;
		}
		while (opcao1 != 8)
			;
		Menu menu = new Menu();
		menu.menuInicar();
	}

	public void CadastrarEstoque() throws SQLException {
		Scanner in = new Scanner(System.in);
		// Estoque e1 = new Estoque();
		// EstoqueDAO estoqueDao = new EstoqueDAO(emf);
		System.out.println("       -----  PRODUTO  -----  ");
		System.out.println("");
		System.out.println("	1 - Cadastrar Produto.");
		System.out.println("	2 - Consultar Produto");
		System.out.println("	3 - Atualizar Produto ");
		System.out.println("	4 - Excluir Produto");
		System.out.println("    5 - Menu Anterior");
		System.out.println("	6 - Sair.");

		int opcao2 = in.nextInt();

		switch (opcao2) {
		case 1:
			ProdutoDAO p_dao = new ProdutoDAO(emf);
			Produto produto = new Produto();

			System.out.println("Digite o tipo do Produto: ");
			produto.setTipoProduto(in.next());

			System.out.println("Digite a Marca do Produto: ");
			produto.setMarca(in.next());

			System.out.println("Digite o Preço do Produto: ");
			produto.setPrecoProduto(in.nextDouble());
			
			
			p_dao.inserirProduto(produto);
			EstoqueDAO estoquedao = new EstoqueDAO(emf);
			
			Estoque estoque = new Estoque();
		
			System.out.println("Digite a quantidade de Produtos: ");
			estoque.setQtdProduto(in.nextInt());
			
			estoquedao.inserirEstoque(estoque);
			
			
			CadastrarEstoque();

			break;
		case 2:

			int opcao5;
			do {
				System.out.println("1 - Consultar Pneu: ");
				System.out.println("2 - Consultar Pastilha: ");
				System.out.println("3 - Consultar Todos Cliente: ");
				System.out.println("4 - Voltar o Menu Anterior: ");
				System.out.println("5 - Sair: ");

				opcao5 = in.nextInt();

				switch (opcao5) {
				case 1:
					EstoqueDAO estoque1 = new EstoqueDAO(emf);
					// estoque1.consultaPneu();

					break;

				default:
					break;
				}

			} while (opcao5 != 5);
			break;
		case 5:
			menuInicar();

		default:

			System.out.println("Opção Invalida! ");
			break;
		}

	}

	public void nfs() {

		System.out.println("       -----  NFs  -----  ");
		System.out.println();
		System.out.println("	1 - Cadastrar NFs.");
		System.out.println("	2 - Consultar Nfs");
		System.out.println("	3 - Atualizar NFs ");
		System.out.println("	4 - Excluir NFs");
		System.out.println("    5 - Menu Anterior");
		System.out.println("	6 - Sair.");

	}

}
