package viaCep;

import java.io.IOException;
import java.util.Scanner;

public class ApiViaCep {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner leitura = new Scanner(System.in);

		ConsultaCep consultaCep = new ConsultaCep();

		System.out.println("Digite o cep para busca: ");
		var cep = leitura.nextLine();

		try {
			DadosCep dadosCep = consultaCep.buscaEndereco(cep);
			System.out.println(dadosCep);
			GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvaJson(dadosCep);

		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			System.out.println("");
			System.out.println("Aplicação finalizada");
		}

	}

}
