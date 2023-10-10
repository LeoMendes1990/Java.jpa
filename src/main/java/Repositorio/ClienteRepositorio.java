package Repositorio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entidades.Cliente;

public class ClienteRepositorio {

	public List<Cliente> findAll(EntityManager em) {

		String findAllJPQL = "SELECT c FROM Cliente c";
		TypedQuery<Cliente> consulta = em.createQuery(findAllJPQL, Cliente.class);

		List<Cliente> resultado = consulta.getResultList();

		return resultado;

	}

}
