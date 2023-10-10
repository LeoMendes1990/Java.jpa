package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ESTOQUE")
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int qtdProduto;

	public Estoque() {
		super();
	}

	public Estoque(int id, int qtdProduto) {
		super();
		this.id = id;
		this.qtdProduto = qtdProduto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

}
