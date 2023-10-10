package Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_LOGIN")
public class Login {
	@Id
	private Integer id;
	private String cpf;
	private String senha;
	

	public Login() {
		super();
	}

	public Login(Integer id, String cpf, String senha) {
		this.id = id;
		this.cpf = cpf;
		this.senha = senha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
