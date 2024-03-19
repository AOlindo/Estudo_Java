package br.com.olindo.estoquelivraria.dto;

public class PedidoDto {

	private Long id;
	private Long livroId;
	private Integer quantidade;
	private Double precoUnico;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLivroId() {
		return livroId;
	}

	public void setLivroId(Long livroId) {
		this.livroId = livroId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnico() {
		return precoUnico;
	}

	public void setPrecoUnico(Double precoUnico) {
		this.precoUnico = precoUnico;
	}



}
