package br.com.olindo.estoquelivraria.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.olindo.estoquelivraria.client.ViaCepClient;
import br.com.olindo.estoquelivraria.client.response.DadosCep;
import br.com.olindo.estoquelivraria.dto.CadastroEnderecoDto;
import br.com.olindo.estoquelivraria.exceptions.RegraDeNegocioException;

@Service
public class ViaCepService {

	@Autowired
	private ObjectMapper mapper;


//	private RestTemplate restTemplate;

	@Autowired
	private ViaCepClient viaCep;
	
	@Value("${url}")
	private String url;
	
//	//Duas formas de usar
//	public DadosCep buscaEnderecoRestTemplate(String cep) throws RuntimeException {
//
//		URI endereco = URI.create(url + cep + "/json/");
//
//		ResponseEntity<DadosCep> response = restTemplate.getForEntity(endereco, DadosCep.class);
//
//		if (response.getStatusCode().value() >= 400) {
//			throw new RuntimeException("Endereço inválido! Digite o CEP sem ponto e sem traço");
//		} else if (response.getStatusCode().value() >= 500) {
//			throw new RuntimeException("Erro na busca do endereço");
//		}
//
//		return response.getBody();
//
//	}

	public DadosCep buscaEnderecoFeign(String cep) throws RegraDeNegocioException {

		ResponseEntity<DadosCep> response = viaCep.getEndereco(cep);

		if (response.getStatusCode().value() >= 400) {
			throw new RegraDeNegocioException("Endereço inválido! Digite o CEP sem ponto e sem traço");
		} else if (response.getStatusCode().value() >= 500) {
			throw new RegraDeNegocioException("Erro na busca do endereço");
		}

		return response.getBody();

	}

	

}
