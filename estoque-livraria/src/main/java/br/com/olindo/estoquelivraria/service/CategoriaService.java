package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.dto.CategoriaDto;
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
	
	public Categoria obterCategoriaPorId(Long id) {
		return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException());
	}
}
