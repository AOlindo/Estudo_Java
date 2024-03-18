package br.com.olindo.estoquelivraria.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class FornecedorDto {
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String email;
	@Valid
	private CadastroEnderecoDto endereco;
	
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
	public CadastroEnderecoDto getEndereco() {
		return endereco;
	}
	public void setEndereco(CadastroEnderecoDto endereco) {
		this.endereco = endereco;
	}
	
	

}
