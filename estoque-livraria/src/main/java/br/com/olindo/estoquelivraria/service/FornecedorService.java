package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.dto.ClienteDto;
import br.com.olindo.estoquelivraria.dto.FornecedorDto;
import br.com.olindo.estoquelivraria.exceptions.RegraDeNegocioException;
import br.com.olindo.estoquelivraria.model.Cliente;
import br.com.olindo.estoquelivraria.model.DadosCep;
import br.com.olindo.estoquelivraria.model.Fornecedor;
import br.com.olindo.estoquelivraria.repository.ClienteRepository;
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

}
