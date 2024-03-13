package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.dto.LivroDto;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.repository.LivroRepository;
import jakarta.validation.Valid;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public Livro inserirLivro(LivroDto dto) {
		Livro livro = new Livro(dto);
		return livroRepository.save(livro);
	}

}
