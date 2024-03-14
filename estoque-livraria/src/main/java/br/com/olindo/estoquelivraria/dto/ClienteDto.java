package br.com.olindo.estoquelivraria.dto;

public class ClienteDto {

	private String nome;
	private String telefone;
	private String email;
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
	public void setEndereco(CadastroEnderecoDto enderecoDto) {
		this.endereco = enderecoDto;
	}
	
	
}
