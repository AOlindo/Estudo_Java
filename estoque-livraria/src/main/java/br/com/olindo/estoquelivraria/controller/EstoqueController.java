package br.com.olindo.estoquelivraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olindo.estoquelivraria.dto.EstoqueDto;
import br.com.olindo.estoquelivraria.dto.ListagemEstoqueDto;
import br.com.olindo.estoquelivraria.model.Estoque;
import br.com.olindo.estoquelivraria.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

	@Autowired
	private EstoqueService estoqueService;
	
	@PostMapping
	public ResponseEntity<Estoque> cadastrarProduto(@RequestBody EstoqueDto estoqueDto){
		estoqueService.inserirCadastro(estoqueDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@GetMapping
	public ResponseEntity<List<ListagemEstoqueDto>> listarInfEstoque(){
		List<ListagemEstoqueDto> listar = estoqueService.listarEstoque();
		return ResponseEntity.ok(listar);
	}

}
