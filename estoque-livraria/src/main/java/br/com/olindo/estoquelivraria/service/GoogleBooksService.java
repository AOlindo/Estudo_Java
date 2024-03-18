package br.com.olindo.estoquelivraria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.olindo.estoquelivraria.client.GoogleBooksClient;
import br.com.olindo.estoquelivraria.client.response.ItemGoogleBooks;
import br.com.olindo.estoquelivraria.exceptions.RegraDeNegocioException;
import feign.FeignException.FeignClientException;

@Service
public class GoogleBooksService {

	@Autowired
	private GoogleBooksClient googleBooksClient;

	public ItemGoogleBooks retornaLivroPorIsbn(String isbn) {
		try {
			var googleBoos = googleBooksClient.books("isbn:" + isbn);
			if(googleBoos != null && !googleBoos.getBody().getItems().isEmpty()) {
				return googleBoos.getBody().getItems().get(0);
			}
			throw new RegraDeNegocioException("Livro não encontrado");
		} catch (FeignClientException e) {
			throw new RegraDeNegocioException("Erro na chamada da Api");
		}

	}
}
