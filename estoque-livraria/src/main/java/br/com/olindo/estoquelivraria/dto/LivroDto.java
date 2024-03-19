package br.com.olindo.estoquelivraria.dto;

import br.com.olindo.estoquelivraria.model.Livro;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LivroDto {

	private Long id;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String autor;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String isbn;
	@NotNull
	private Integer anoPublicacao;
	private Long categoriaId;
	@NotNull
	private Integer numeroPaginas;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String editora;
	@NotNull
	
	public LivroDto() {

	}

	public LivroDto(Livro livro) {
		this.autor = livro.getAutor();
		this.isbn = livro.getIsbn();
		this.anoPublicacao = livro.getAnoPublicacao();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.editora = livro.getEditora();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Long categoriaId) {
		this.categoriaId = categoriaId;
	}

	

}
