package br.com.olindo.estoquelivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olindo.estoquelivraria.dto.CategoriaDto;
import br.com.olindo.estoquelivraria.model.Categoria;
import br.com.olindo.estoquelivraria.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<Categoria> cadastrandoCategoria(@RequestBody CategoriaDto dto){
		categoriaService.inserirCategoria(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
}
