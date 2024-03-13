package br.com.olindo.estoquelivraria.dto;

public record AtualizarLivroDto(Long id, String titulo, String autor, String isbn, Integer anoPublicacao, Long categoriaId, Integer numeroPaginas, String editora, Double preco, Integer quantidade) {

}
	