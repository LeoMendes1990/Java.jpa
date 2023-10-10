package EntidadesDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import Entidades.Vendedor;

public class VendedorDAO {

	EntityManager em;
	EntityManagerFactory emf;

	public VendedorDAO() {
		super();
	}

	public VendedorDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public void CadastroLogin(Vendedor vendedor) {

		em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(vendedor);
		em.getTransaction().commit();
		em.close();

	}
	


}
