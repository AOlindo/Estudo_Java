package br.com.olindo.estoquelivraria.model;

import java.time.LocalDateTime;

import br.com.olindo.estoquelivraria.dto.PedidoDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "data_compra")
	private LocalDateTime dataCompra;

	@ManyToOne
	@JoinColumn(name = "livro_id")
	private Livro livro;

	private Integer quantidade;
	
	@Column(name = "preco_unico")
	private Double precoUni;

	public Pedido() {
		
	}
	
	public Pedido(PedidoDto pedidoDto) {
		this.id = pedidoDto.getId();
		this.dataCompra = LocalDateTime.now();
		this.quantidade = pedidoDto.getQuantidade();
		this.precoUni = pedidoDto.getPrecoUnico();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUni() {
		return precoUni;
	}

	public void setPrecoUni(Double precoUni) {
		this.precoUni = precoUni;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		this.dataCompra = dataCompra;
	}

}
