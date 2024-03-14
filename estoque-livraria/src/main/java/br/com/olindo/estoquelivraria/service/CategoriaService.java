package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.dto.AtualizarCategoriaDto;
import br.com.olindo.estoquelivraria.dto.CategoriaDto;
import br.com.olindo.estoquelivraria.exceptions.ObjectNotFoundException;
import br.com.olindo.estoquelivraria.model.Categoria;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria inserirCategoria(CategoriaDto dto) {
		Categoria cat = new Categoria(dto);
		return categoriaRepository.save(cat);
	}

	public Categoria atualizarCategoria(Long id, AtualizarCategoriaDto atualizarDto) {
		Categoria categoria = obterCategoriaPorId(id);
		categoria.atualizarCategoria(atualizarDto);
		return categoriaRepository.save(categoria);

	}

	public Categoria obterCategoriaPorId(Long id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrado"));
	}
}
