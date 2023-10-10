package br.com.jpa;

import java.sql.SQLException;

import Menu.Menu;

public class APP {
	
	//private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
	//private static EntityManager em = emf.createEntityManager();

	public static void main(String[] args) throws SQLException {
		Menu menu = new Menu();
		//menu.menuInicar();
		menu.login();
		
		 
		
	}

}
