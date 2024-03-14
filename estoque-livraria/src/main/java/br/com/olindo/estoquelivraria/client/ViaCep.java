package br.com.olindo.estoquelivraria.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.olindo.estoquelivraria.model.DadosCep;


@FeignClient(value = "ViaCepClient", url = "${url}")
public interface ViaCep {
	
	@GetMapping("/{cep}/json")
	public ResponseEntity<DadosCep> getEndereco(@PathVariable String cep);
}
