package EntidadesDAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Entidades.Produto;
import Entidades.Vendas;

public class VendasDAO {

	EntityManager em;
	EntityManagerFactory emf;

	Scanner in = new Scanner(System.in);

	public void realizarVenda(Produto produto, int quantidadeVendida) {
		try {
			em.getTransaction().begin();

			// Verifica se há estoque suficiente
//			if (produto.getQuantidadeDisponivel() >= quantidadeVendida) {
//				// Cria uma nova venda
//				Vendas venda = new Vendas();
//				venda.setProduto(produto);
//				venda.setQuantidade(quantidadeVendida);
//				venda.setValorTotal(quantidadeVendida * produto.getPrecoProduto());
//
//				// Atualiza o estoque
//				produto.setQtdDisponivel(produto.getQtdDisponivel() - quantidadeVendida);
//
//				// Persiste a venda e atualiza o estoque
//				em.persist(venda);
//				em.merge(produto);
//
//				em.getTransaction().commit();
//			} else {
//				// Não há estoque suficiente
//				System.out.println("Não há estoque suficiente para realizar a venda.");
//			}
		} finally {
			em.close();
			emf.close();
		}

	}

}
