package br.com.olindo.estoquelivraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//A anotação abaixo habilita o feignClients
@EnableFeignClients
@SpringBootApplication
public class EstoqueLivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueLivrariaApplication.class, args);
	}

}
