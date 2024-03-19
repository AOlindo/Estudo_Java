package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.client.response.DadosCep;
import br.com.olindo.estoquelivraria.dto.FornecedorDto;
import br.com.olindo.estoquelivraria.exceptions.RegraDeNegocioException;
import br.com.olindo.estoquelivraria.model.Fornecedor;
import br.com.olindo.estoquelivraria.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private ViaCepService viaCepService;

	public void inserirFornecedor(FornecedorDto fornecedorDto) {
		DadosCep dadosCep = viaCepService.buscaEnderecoFeign(fornecedorDto.getEndereco().getCep());
		
		if (dadosCep.getCep() == null) {
			throw new RegraDeNegocioException("Endereço inválido! Digite o CEP sem ponto e sem traço");
		}
		
		Fornecedor fornecedor = new Fornecedor(fornecedorDto);

		//Esses dados vem da Api externa
		fornecedor.getEndereco().setBairro(dadosCep.getBairro());
		fornecedor.getEndereco().setCidade(dadosCep.getLocalidade());
		fornecedor.getEndereco().setUf(dadosCep.getUf());
		fornecedor.getEndereco().setLogradouro(dadosCep.getLogradouro());
		
		fornecedorRepository.save(fornecedor);
	}

	public Fornecedor fromDto(FornecedorDto dto) {
		return new Fornecedor(dto.getNome(), dto.getTelefone(), dto.getEmail(), dto.getEndereco());
		
	}
	
	public Fornecedor findById(Long id) {
		Fornecedor fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new RegraDeNegocioException("Id do fornecedor não encontrado"));
		return fornecedor;
	}
}
