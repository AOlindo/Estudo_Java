package br.com.olindo.estoquelivraria.dto;

public class EstoqueDto {

	private Long livroId;
	private Double preco;
	private Integer quantidade;	
	
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
