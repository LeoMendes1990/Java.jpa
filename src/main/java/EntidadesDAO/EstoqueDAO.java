package EntidadesDAO;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import Entidades.Cliente;
import Entidades.Estoque;

public class EstoqueDAO {
	EntityManagerFactory emf;
	EntityManager em;

	public EstoqueDAO(EntityManagerFactory emf) {

		this.emf = emf;
	}

	public void inserirEstoque(Estoque estoque) {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(estoque);
			em.getTransaction().commit();
			em.close();
			System.out.println("Cadastrado!");
		} catch (Exception e) {
			System.out.println("Não Cadastrado!" + e.getMessage());
		}

	}

	public void consultaPneu(int pneu) throws SQLException {
		try {
			em = emf.createEntityManager();
			// findAll
			String findByJPQL = "SELECT e FROM Estoque e WHERE e.pneu = :pneu";
			TypedQuery<Cliente> consulta1 = em.createQuery(findByJPQL, Cliente.class);

			consulta1.setParameter("cpf", pneu);

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
}
