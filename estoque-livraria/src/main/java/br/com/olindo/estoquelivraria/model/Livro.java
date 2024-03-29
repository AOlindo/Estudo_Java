package br.com.olindo.estoquelivraria.model;

import java.util.Objects;

import br.com.olindo.estoquelivraria.dto.AtualizarLivroDto;
import br.com.olindo.estoquelivraria.dto.CategoriaDto;
import br.com.olindo.estoquelivraria.dto.LivroDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String autor;
	private String isbn;

	@Column(name = "ano_publicacao")
	private Integer anoPublicacao;

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	@Column(name = "numero_paginas")
	private Integer numeroPaginas;
	private String editora;

	public Livro() {

	}

	public Livro(String titulo, String autor, String isbn, Integer anoPublicacao, Categoria categoria,
			Integer numeroPaginas, String editora) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.anoPublicacao = anoPublicacao;
		this.categoria = categoria;
		this.numeroPaginas = numeroPaginas;
		this.editora = editora;
	}


	public Livro(LivroDto dto) {
		this.id = dto.getId();
//		this.titulo = dto.getTitulo();
		this.autor = dto.getAutor();
		this.isbn = dto.getIsbn();
		this.anoPublicacao = dto.getAnoPublicacao();
		this.numeroPaginas = dto.getNumeroPaginas();
		this.editora = dto.getEditora();
		
	}

	public void atualizaLivro(AtualizarLivroDto dto) {
		if (dto.titulo() != null) {
			this.titulo = dto.titulo();
		}
		if (dto.autor() != null) {
			this.autor = dto.autor();
		}
		if (dto.isbn() != null) {
			this.anoPublicacao = dto.anoPublicacao();
		}
		if (dto.numeroPaginas() != null) {
			this.numeroPaginas = dto.numeroPaginas();
		}
		if (dto.editora() != null) {
			this.editora = dto.editora();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}

}
