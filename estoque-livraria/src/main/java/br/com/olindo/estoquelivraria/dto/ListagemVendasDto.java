package br.com.olindo.estoquelivraria.dto;

import br.com.olindo.estoquelivraria.model.Venda;

public class ListagemVendasDto {

	private ListagemLivroDto livroId;
	private Integer quantidadeVendida;
	private Double preco;
	private ListagemClienteDto clienteId;

	public ListagemVendasDto(Venda venda) {
		this.livroId = new ListagemLivroDto(venda.getLivro());
		this.quantidadeVendida = venda.getQuantidadeVendida();
		this.preco = venda.getPreco();
		this.clienteId = new ListagemClienteDto(venda.getCliente());
	}

	public Integer getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public void setQuantidadeVendida(Integer quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public ListagemLivroDto getLivroId() {
		return livroId;
	}

	public void setLivroId(ListagemLivroDto livroId) {
		this.livroId = livroId;
	}

	public ListagemClienteDto getClienteId() {
		return clienteId;
	}

	public void setClienteId(ListagemClienteDto clienteId) {
		this.clienteId = clienteId;
	}

}
