package br.com.olindo.estoquelivraria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.dto.ListagemVendasDto;
import br.com.olindo.estoquelivraria.dto.VendaDto;
import br.com.olindo.estoquelivraria.model.Cliente;
import br.com.olindo.estoquelivraria.model.Estoque;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.model.Venda;
import br.com.olindo.estoquelivraria.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private LivroService livroService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	public Venda inserirVenda(VendaDto vendaDto) {
		Venda venda = new Venda(vendaDto);
		Livro livro = livroService.obterLivroPorId(vendaDto.getLivroId());
		venda.setLivro(livro);
		Cliente cliente = clienteService.obterClientePorId(vendaDto.getClienteId());
		venda.setCliente(cliente);
		vendaRepository.save(venda);
		Estoque estoque = estoqueService.buscarLivroEstoque(vendaDto.getLivroId());
		estoque.setQuantidade(estoque.getQuantidade() - venda.getQuantidadeVendida() );
		estoqueService.salvarEstoque(estoque);
		return venda;

	}
	
	public List<ListagemVendasDto> listarVendas() {
		List<ListagemVendasDto> venda = vendaRepository.findAll().stream().map(vendas -> new ListagemVendasDto(vendas)).collect(Collectors.toList());
		return venda;
	}
}
