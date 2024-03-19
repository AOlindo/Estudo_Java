package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.dto.PedidoDto;
import br.com.olindo.estoquelivraria.model.Fornecedor;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.model.Pedido;
import br.com.olindo.estoquelivraria.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private LivroService livroService;
	
	public Pedido inserirPedido(PedidoDto pedidoDto) {
		Livro livro = livroService.obterLivroPorId(pedidoDto.getLivroId());
		Pedido pedido = new Pedido(pedidoDto);
		pedido.setLivro(livro);
		return pedidoRepository.save(pedido);
		
	}

}
