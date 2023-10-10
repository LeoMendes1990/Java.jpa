package EntidadesDAO;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import Entidades.Login;
import Menu.Menu;

public class LoginDAO {
	EntityManager em;
	EntityManagerFactory emf;

	public LoginDAO() {
		super();
	}

	public LoginDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public void login(String cpf, String senha) throws SQLException {
		
		em = emf.createEntityManager();
		try {
			
			String JPQL = "SELECT l FROM Login l WHERE l.cpf = :cpf AND l.senha = :senha";
			
			TypedQuery<Login> query = em.createQuery(JPQL,Login.class);
			
			query.setParameter("cpf", cpf);
			query.setParameter("senha", senha);
			
			Login login = query.getSingleResult();
			
			System.out.println("Usuario Conectado!!");
			
			Menu menu = new Menu();
			menu.menuInicar();
			
		} catch (Exception e) {
		System.out.println("Senha ou Usuario Incorreto!! " + e.getMessage());
		}
		
		
	}

		

	public void cadastrarLogin(Login login) {

		em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(login);
		em.getTransaction().commit();
		em.close();

	}

	
	
	
	
	
	
	
//	em = emf.createEntityManager();
//
//	TypedQuery<Login> query = em.createQuery("SELECT l FROM Login l WHERE l.cpf = :cpf AND l.senha = :senha",Login.class);
//			
//	query.setParameter("cpf", cpf);
//	query.setParameter("senha", senha);
//
//	try {
//		Login usuarioAutenticado = query.getSingleResult();
//		// 
//		System.out.println("Usuário autenticado com sucesso ");
//		Menu menu = new Menu();
//		menu.menuInicar();
//	} catch (Exception e) {
//		System.out.println("  Usuário não encontrado ou senha incorreta" + e.getMessage());
//	}
//
//}
}
