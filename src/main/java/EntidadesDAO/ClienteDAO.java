package EntidadesDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entidades.Cliente;
import br.com.dto.ClienteDTO;

public class ClienteDAO {
	private EntityManagerFactory emf;
	private EntityManager em;

	public ClienteDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public void inserirCliente(Cliente cliente) {

		em = emf.createEntityManager();

		try {

			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			em.close();

			System.out.println("Cadastrado!");

		} catch (Exception e) {

			System.out.println("Não Cadastrado " + e.getMessage());

		}
	}

	public void deletarClientePorId(int id) {

		em = emf.createEntityManager();

		try {

			em.getTransaction().begin();
			Cliente cliente = em.find(Cliente.class, id);
			em.remove(cliente);
			em.getTransaction().commit();
			em.close();

			System.out.println("Cadastro Excluido!");

		} catch (Exception e) {
			System.out.println("Não Excluido!" + e.getMessage());
		}

	}

	// consultar todos
	public void findAll() {

		em = emf.createEntityManager();
		// findAll
		String findAllJPQL = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> consulta = em.createQuery(findAllJPQL, Cliente.class);

		List<Cliente> resultado = consulta.getResultList();

		for (Cliente cliente : resultado) {
			System.out.println("Codigo:  " + cliente.getId());
			System.out.println("Nome " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("RG: " + cliente.getRg());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("");
		}
	}

	// return null;
	// consulta por cpf
	public void consultaPorCpf(String cpf2) throws SQLException {
		try {
			em = emf.createEntityManager();
			// findAll
			String findByJPQL = "SELECT c FROM Cliente c WHERE c.cpf = :cpf";
			TypedQuery<Cliente> consulta1 = em.createQuery(findByJPQL, Cliente.class);

			consulta1.setParameter("cpf", cpf2);

			List<Cliente> resultado1 = consulta1.getResultList();

			for (Cliente cliente1 : resultado1) {
				System.out.println("Codigo  " + cliente1.getId());
				System.out.println("Nome " + cliente1.getNome());
				System.out.println("CPF: " + cliente1.getCpf());
				System.out.println("RG: " + cliente1.getRg());
				System.out.println("Telefone: " + cliente1.getTelefone());
				System.out.println("Email: " + cliente1.getEmail());

			}

		} catch (Exception e) {
			System.out.println("CPF não existe!" + e.getMessage());
			// Menu menu = new Menu();
			// menu.cadastrarCliente();
		}
	}

	public void consultaPorId(int id) throws SQLException {
		try {
			em = emf.createEntityManager();
			// findAll
			String findByJPQL = "SELECT c FROM Cliente c WHERE c.id = :id";
			TypedQuery<Cliente> consulta2 = em.createQuery(findByJPQL, Cliente.class);

			consulta2.setParameter("id", id);

			List<Cliente> resultado1 = consulta2.getResultList();

			for (Cliente cliente1 : resultado1) {
				System.out.println("Codigo  " + cliente1.getId());
				System.out.println("Nome " + cliente1.getNome());
				System.out.println("CPF: " + cliente1.getCpf());
				System.out.println("RG: " + cliente1.getRg());
				System.out.println("Telefone: " + cliente1.getTelefone());
				System.out.println("Email: " + cliente1.getEmail());

			}

		} catch (Exception e) {
			System.out.println("ID não existe!" + e.getMessage());
			// Menu menu = new Menu();
			// menu.cadastrarCliente();
		}

	}

	// consultar cpf e id

	public List<ClienteDTO> findClienteDTOById(String cpf) {
		em = emf.createEntityManager();

		String findByDto = "SELECT new br.com.dto.ClienteDTO(c.id ,c.cpf)FROM Cliente c where c.cpf = : cpf";

		TypedQuery<ClienteDTO> consulta2 = em.createQuery(findByDto, ClienteDTO.class);

		consulta2.setParameter("cpf", cpf);

		List<ClienteDTO> resultado2 = consulta2.getResultList();

		for (ClienteDTO clienteDTO : resultado2) {
			System.out.println("CPF" + clienteDTO.getCpf());
			System.out.println("ID" + clienteDTO.getId());
		}

		return resultado2;

	}

	public void atualizarClientePorId(String cpf) {

		try {
			em = emf.createEntityManager();
			// findAll
			String findByJPQL = "SELECT c FROM Cliente c WHERE c.cpf = :cpf";
			TypedQuery<Cliente> consulta1 = em.createQuery(findByJPQL, Cliente.class);

			consulta1.setParameter("cpf", cpf);

			List<Cliente> resultado1 = consulta1.getResultList();

			for (Cliente cliente1 : resultado1) {
				System.out.println("Codigo  " + cliente1.getId());
				System.out.println("Nome " + cliente1.getNome());
				System.out.println("CPF: " + cliente1.getCpf());
				System.out.println("RG: " + cliente1.getRg());
				System.out.println("Telefone: " + cliente1.getTelefone());
				System.out.println("Email: " + cliente1.getEmail());
				System.out.println("");
				System.out.println("");
				Cliente clienteNovo = new Cliente();
				Scanner in = new Scanner(System.in);
				System.out.println(" ===== Atualize o Cliente!! ====== ");
				System.out.println("Digite o ID: ");
				clienteNovo.setId(in.nextInt());
				System.out.println("Digite o Nome do Cliente: ");
				clienteNovo.setNome(in.next());
				System.out.println("Digite o CPF: ");
				clienteNovo.setCpf(in.next());
				System.out.println("Digite o RG: ");
				clienteNovo.setRg(in.next());
				System.out.println("Digite o Telefone: ");
				clienteNovo.setTelefone(in.next());
				System.out.println("Digite o EMAIL: ");
				clienteNovo.setEmail(in.next());

				em.getTransaction().begin();
				em.merge(clienteNovo);
				em.getTransaction().commit();
				em.close();

			}

		} catch (Exception e) {
			System.out.println("CPF não existe!" + e.getMessage());
			// Menu menu = new Menu();
			// menu.cadastrarCliente();
		}
	}

	public void deletarTodosCliente() {

		try {
			em = emf.createEntityManager();

			 em.getTransaction().begin();

		        Query query = em.createQuery("DELETE FROM Cliente");
		        int numRegistrosExcluidos = query.executeUpdate();

		        em.getTransaction().commit();
		        System.out.println("Número de registros excluídos: " + numRegistrosExcluidos);

			System.out.println("Dados da Tabela Excluido! ");
		} catch (Exception e) {
			System.out.println("Algo de errado " + e);
		}

	}
}
