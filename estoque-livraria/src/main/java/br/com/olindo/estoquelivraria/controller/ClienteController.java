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

import br.com.olindo.estoquelivraria.dto.ClienteDto;
import br.com.olindo.estoquelivraria.dto.ListagemClienteDto;
import br.com.olindo.estoquelivraria.dto.LivroDto;
import br.com.olindo.estoquelivraria.model.Cliente;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody ClienteDto dto) {
		Cliente obj = clienteService.fromDto(dto);
		clienteService.inserirCliente(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@GetMapping
	public List<ListagemClienteDto> listarCliente(){
		List<ListagemClienteDto> lista = clienteService.listarCliente();
		return lista;
	}
	
}
