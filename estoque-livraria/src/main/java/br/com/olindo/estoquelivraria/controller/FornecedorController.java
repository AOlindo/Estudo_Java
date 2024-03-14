package br.com.olindo.estoquelivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olindo.estoquelivraria.dto.FornecedorDto;
import br.com.olindo.estoquelivraria.model.Fornecedor;
import br.com.olindo.estoquelivraria.service.FornecedorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@PostMapping
	public ResponseEntity<Fornecedor> cadastrarFornecedor(@Valid @RequestBody FornecedorDto dto) {
		fornecedorService.inserirFornecedor(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
