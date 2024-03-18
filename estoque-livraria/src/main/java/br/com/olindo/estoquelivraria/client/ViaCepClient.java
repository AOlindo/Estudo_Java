package br.com.olindo.estoquelivraria.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.olindo.estoquelivraria.client.response.DadosCep;


@FeignClient(value = "ViaCepClient", url = "${url}")
public interface ViaCepClient {
	
	@GetMapping("/{cep}/json")
	public ResponseEntity<DadosCep> getEndereco(@PathVariable String cep);
}
