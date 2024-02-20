package viaCep;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GeradorDeArquivo {
	
	public void salvaJson(DadosCep endereco) throws IOException {
		//setPrettyPrinting() - serve para indentar o Json, deixando mais legivel
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escrita = new FileWriter(endereco.cep() + ".json");
        escrita.write(gson.toJson(endereco));
        escrita.close();

    }
	
}
