package screenmatch;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner leitura = new Scanner(System.in);
		System.out.println("Digite um filme para busca: ");
		var busca = leitura.nextLine();

		String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=" + System.getenv("apikey");

		//Essas informações tem na documentação JavaDoc https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/HttpRequest.html
		//Requisição
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
		//Resposta
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	}
}
