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

import br.com.olindo.estoquelivraria.dto.ListagemVendasDto;
import br.com.olindo.estoquelivraria.dto.PedidoDto;
import br.com.olindo.estoquelivraria.dto.VendaDto;
import br.com.olindo.estoquelivraria.model.Pedido;
import br.com.olindo.estoquelivraria.model.Venda;
import br.com.olindo.estoquelivraria.service.PedidoService;
import br.com.olindo.estoquelivraria.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	private VendaService vendaService;

	@PostMapping
	public ResponseEntity<Venda> cadastrarVenda(@RequestBody VendaDto vendaDto) {
		vendaService.inserirVenda(vendaDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<List<ListagemVendasDto>> findAll(){
		List<ListagemVendasDto> vendas = vendaService.listarVendas();
		return ResponseEntity.ok(vendas);
		
	}
}
