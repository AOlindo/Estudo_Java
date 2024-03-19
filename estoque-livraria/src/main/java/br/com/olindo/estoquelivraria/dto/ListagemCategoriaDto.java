package br.com.olindo.estoquelivraria.dto;

import br.com.olindo.estoquelivraria.model.Categoria;

public class ListagemCategoriaDto {

	private Long id;
	private String nome;
	
	public ListagemCategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
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
	
	
}
