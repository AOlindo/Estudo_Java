package br.com.olindo.estoquelivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.olindo.estoquelivraria.dto.AtualizarLivroDto;
import br.com.olindo.estoquelivraria.dto.LivroDto;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.service.LivroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping
	public ResponseEntity<Livro> cadastrarLivro(@RequestBody LivroDto dto) {
		livroService.inserirLivro(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizarLivro(@RequestBody AtualizarLivroDto dto, @PathVariable Long id){
		livroService.atualizarLivro(id, dto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
