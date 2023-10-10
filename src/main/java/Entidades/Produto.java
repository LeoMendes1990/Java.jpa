package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String marca;
	private String tipoProduto;
	private int qtdDisponivel;
	private double precoProduto;

	public Produto() {
		super();
	}

	
	public Produto(int id, String marca, String tipoProduto, int qtdDisponivel, double precoProduto) {
		super();
		this.id = id;
		this.marca = marca;
		this.tipoProduto = tipoProduto;
		this.qtdDisponivel = qtdDisponivel;
		this.precoProduto = precoProduto;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getTipoProduto() {
		return tipoProduto;
	}


	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}


	public int getQtdDisponivel() {
		return qtdDisponivel;
	}


	public void setQtdDisponivel(int qtdDisponivel) {
		this.qtdDisponivel = qtdDisponivel;
	}


	public double getPrecoProduto() {
		return precoProduto;
	}


	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}




}
