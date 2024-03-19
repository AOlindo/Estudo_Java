package br.com.olindo.estoquelivraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olindo.estoquelivraria.dto.AtualizarCategoriaDto;
import br.com.olindo.estoquelivraria.dto.AtualizarLivroDto;
import br.com.olindo.estoquelivraria.dto.CategoriaDto;
import br.com.olindo.estoquelivraria.dto.ListagemCategoriaDto;
import br.com.olindo.estoquelivraria.model.Categoria;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody CategoriaDto dto) {
		categoriaService.inserirCategoria(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizarCategoria(@RequestBody AtualizarCategoriaDto dto, @PathVariable Long id) {
		categoriaService.atualizarCategoria(id, dto);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping
	public ResponseEntity<List<ListagemCategoriaDto>>lista(){
		List<ListagemCategoriaDto> categoria = categoriaService.listarCategoria();
		return ResponseEntity.ok(categoria);
		
	}
}
