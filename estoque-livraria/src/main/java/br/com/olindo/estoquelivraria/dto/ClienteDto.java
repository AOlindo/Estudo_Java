package br.com.olindo.estoquelivraria.dto;

import br.com.olindo.estoquelivraria.model.Cliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class ClienteDto {

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;
	@NotEmpty(message = "O email deve ser válido")
	private String email;
	@Valid
	private CadastroEnderecoDto endereco;
	
	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.telefone = cliente.getTelefone();
		this.email = cliente.getEmail();
		this.endereco = new CadastroEnderecoDto();
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
	public CadastroEnderecoDto getEndereco() {
		return endereco;
	}
	public void setEndereco(CadastroEnderecoDto enderecoDto) {
		this.endereco = enderecoDto;
	}
	
	
}
