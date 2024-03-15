package br.com.olindo.estoquelivraria.dto;

import jakarta.validation.constraints.NotEmpty;

public class CadastroEnderecoDto {

	@NotEmpty(message = "Preenchimento obrigatório")
	private String numero;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cep;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String complemento;

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
}
