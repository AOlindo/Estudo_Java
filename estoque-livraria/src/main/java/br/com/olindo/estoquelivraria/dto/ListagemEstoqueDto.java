package br.com.olindo.estoquelivraria.dto;

import br.com.olindo.estoquelivraria.model.Estoque;

public class ListagemEstoqueDto {

	private Long livroId;
	private Double preco;
	private Integer quantidade;
	
	public ListagemEstoqueDto(Estoque estoque) {
		this.livroId = estoque.getId();
		this.preco = estoque.getPreco();
		this.quantidade = estoque.getQuantidade();
	}
	public Long getLivroId() {
		return livroId;
	}
	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}	
	
	
	
}
