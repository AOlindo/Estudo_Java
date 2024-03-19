package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.dto.EstoqueDto;
import br.com.olindo.estoquelivraria.exceptions.ObjectNotFoundException;
import br.com.olindo.estoquelivraria.model.Estoque;
import br.com.olindo.estoquelivraria.model.Livro;
import br.com.olindo.estoquelivraria.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;

	private VendaService vendaService;

	@Autowired
	private LivroService livroService;

	public Estoque inserirCadastro(EstoqueDto estoqueDto) {
		Estoque estoque = new Estoque(estoqueDto);
		Livro livro = livroService.obterLivroPorId(estoqueDto.getLivroId());
		estoque.setLivro(livro);
		return estoqueRepository.save(estoque);

	}

	public Estoque buscarLivroEstoque(Long idLivro) {
		return estoqueRepository.buscarEstoquePeloIdLivro(idLivro);

	}

	public void salvarEstoque(Estoque estoque) {
		estoqueRepository.save(estoque);
	}

}
