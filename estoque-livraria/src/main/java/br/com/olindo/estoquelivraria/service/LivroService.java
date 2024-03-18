package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.client.response.DadosApiBooks;
import br.com.olindo.estoquelivraria.client.response.ItemGoogleBooks;
import br.com.olindo.estoquelivraria.dto.AtualizarLivroDto;
import br.com.olindo.estoquelivraria.dto.LivroDto;
import br.com.olindo.estoquelivraria.exceptions.ObjectNotFoundException;
import br.com.olindo.estoquelivraria.model.Categoria;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	@Autowired
	private GoogleBooksService googleBooksService;
	
	public Livro inserirLivro(LivroDto dto) {
		ItemGoogleBooks itemApiBooks = googleBooksService.retornaLivroPorIsbn(dto.getIsbn());
			Livro livro = new Livro(dto);
		Categoria categoria = categoriaService.obterCategoriaPorId(dto.getCategoriaId());
			livro.setCategoria(categoria);
			
			livro.setTitulo(itemApiBooks.getVolumeInfo().getTitle());
		return livroRepository.save(livro);
	}

	public Livro atualizarLivro(Long id, AtualizarLivroDto atualizaDto) {
		Livro livro = obterLivroPorId(id);
		if (atualizaDto.categoriaId() != null) {
			Categoria categoria = categoriaService.obterCategoriaPorId(atualizaDto.categoriaId());
			livro.setCategoria(categoria);
		}
		livro.atualizaLivro(atualizaDto);
		return livroRepository.save(livro);

	}

	public Livro obterLivroPorId(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado"));
	}
	
//	public Livro fromDto(LivroDto dto) {
//		return new Livro(dto.getAutor(), dto.getIsbn(), dto.getAnoPublicacao(), dto.getCategoria(), dto.getNumeroPaginas(), dto.getEditora(), dto.getPreco(),  dto.getQuantidade());
//		
//	}

}
