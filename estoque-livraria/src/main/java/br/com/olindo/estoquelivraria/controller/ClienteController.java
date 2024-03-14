package br.com.olindo.estoquelivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olindo.estoquelivraria.dto.ClienteDto;
import br.com.olindo.estoquelivraria.dto.LivroDto;
import br.com.olindo.estoquelivraria.model.Cliente;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteDto dto) {
		clienteService.inserirCliente(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
