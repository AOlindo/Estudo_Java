package br.com.olindo.estoquelivraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.olindo.estoquelivraria.dto.PedidoDto;
import br.com.olindo.estoquelivraria.model.Pedido;
import br.com.olindo.estoquelivraria.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> cadastrarPedido(@RequestBody PedidoDto pedidoDto){
		pedidoService.inserirPedido(pedidoDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
