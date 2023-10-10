package EntidadesDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Entidades.Produto;

public class ProdutoDAO {
	
	EntityManager em;
	EntityManagerFactory emf;
	
	
	public ProdutoDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}


	public void inserirProduto(Produto produto) {
		
		em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
		
	}

}
