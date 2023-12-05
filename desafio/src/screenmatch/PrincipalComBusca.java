package screenmatch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {

		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite um filme para busca: ");
		var busca = leitura.nextLine();

		String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + System.getenv("apikey");

		// Essas informações tem na documentação JavaDoc
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html
		// Requisição
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
		// Resposta
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String json = response.body();
		System.out.println(json);

		Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

		TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
		System.out.println(meuTituloOmdb);
		
		try {
			Titulo meuTitulo = new Titulo(meuTituloOmdb);
			System.out.println(meuTitulo);
		} catch (NumberFormatException e) {
			e.getMessage();
			System.out.println("Aconteceu um erro: ");
			System.out.println(e.getMessage());
		}

		System.out.println("Programa Finalizado!!!");

	}
}
