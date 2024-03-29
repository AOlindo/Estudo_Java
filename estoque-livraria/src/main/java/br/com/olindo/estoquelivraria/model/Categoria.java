package br.com.olindo.estoquelivraria.model;

import br.com.olindo.estoquelivraria.dto.AtualizarCategoriaDto;
import br.com.olindo.estoquelivraria.dto.CategoriaDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	public Categoria() {

	}
	
	
	public Categoria(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}


	public Categoria(CategoriaDto dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
	}

	public void atualizarCategoria(AtualizarCategoriaDto categoria) {
		if (categoria.nome() != null) {
			this.nome = categoria.nome();
		}
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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categoria [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}

}
