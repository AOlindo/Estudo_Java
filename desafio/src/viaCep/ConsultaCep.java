package viaCep;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaCep {

	public DadosCep buscaEndereco(String cep) {

		URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json/");

		HttpRequest request = HttpRequest.newBuilder().uri(endereco).build();

		try {
			HttpResponse<String> response = HttpClient.newHttpClient().send(request,
					HttpResponse.BodyHandlers.ofString());
			return new Gson().fromJson(response.body(), DadosCep.class);

		} catch (Exception e) {
			throw new RuntimeException("Endereço inválido! Digite o CEP sem ponto e sem traço");
		}
	}

}
