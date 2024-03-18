package br.com.olindo.estoquelivraria.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.olindo.estoquelivraria.client.response.DadosApiBooks;

@FeignClient(value = "GoogleBooks", url = "${url.google}")
public interface GoogleBooksClient {
	
	@GetMapping("v1/volumes")
	public ResponseEntity<DadosApiBooks> books (@RequestParam ("q") String q);
}
