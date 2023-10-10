package br.com.dto;

public class ClienteDTO {
	
	private int id;
	private String cpf;
	
	// construtor
	public ClienteDTO(int id, String cpf) {
		
		this.id = id;
		this.cpf = cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	
	

}
