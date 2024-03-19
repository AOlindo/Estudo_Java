package br.com.olindo.estoquelivraria.dto;

import br.com.olindo.estoquelivraria.model.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class ListagemClienteDto {

	private Long id;
	private String nome;
	private String telefone;
	private String email;

	public ListagemClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
