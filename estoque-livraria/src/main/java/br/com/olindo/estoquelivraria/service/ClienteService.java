package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.dto.ClienteDto;
import br.com.olindo.estoquelivraria.exceptions.RegraDeNegocioException;
import br.com.olindo.estoquelivraria.model.Cliente;
import br.com.olindo.estoquelivraria.model.DadosCep;
import br.com.olindo.estoquelivraria.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ViaCepService viaCepService;

	public void inserirCliente(ClienteDto clienteDto) {
		DadosCep dadosCep = viaCepService.buscaEnderecoFeign(clienteDto.getEndereco().getCep());
		
		if (dadosCep.getCep() == null) {
			throw new RegraDeNegocioException("Endereço inválido! Digite o CEP sem ponto e sem traço");
		}
		
		Cliente cliente = new Cliente(clienteDto);

		//Esses dados vem da Api externa
		cliente.getEndereco().setBairro(dadosCep.getBairro());
		cliente.getEndereco().setCidade(dadosCep.getLocalidade());
		cliente.getEndereco().setUf(dadosCep.getUf());
		cliente.getEndereco().setLogradouro(dadosCep.getLogradouro());
		
		clienteRepository.save(cliente);
	}

}
