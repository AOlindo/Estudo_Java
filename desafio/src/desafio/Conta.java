package desafio;

import java.util.Scanner;

public class Conta {

	public static void main(String[] args) {

		Scanner leitura = new Scanner(System.in);

		System.out.println("**************************************");
		System.out.println("Dados iniciais do cliente: ");
		System.out.print("Nome: ");
		String nome = leitura.nextLine();
		System.out.print("Tipo conta: ");
		String tipoConta = leitura.nextLine();
		System.out.print("Saldo inicial: ");
		double saldo = leitura.nextDouble();
		System.out.println("**************************************");

		System.out.println("Operações");
		System.out.println("");

		var opcao = -1;
		double saldoAtual = 0;
		while (opcao != 4) {
			var menu = """
					1 - Consultar saldo
					2 - Receber valor
					3 - Transferir valor
					4 - Sair
					""";

			System.out.println(menu);
			System.out.println("Digite a opção desejada: ");
			opcao = leitura.nextInt();
			leitura.nextLine();

			if (opcao == 1) {
				System.out.println("Saldo Inicial " + saldo);
				System.out.println("");
			} else if (opcao == 2) {
				System.out.println("Qual o valor que deseja depositar? ");
				double valorRecebido = leitura.nextDouble();
				saldoAtual = valorRecebido + saldo;
				System.out.println("Saldo atualizado: " + saldoAtual);
				System.out.println("");
			} else if (opcao == 3) {
				System.out.println("Informe o valor que deseja transferir: ");
				double valorTransferido = leitura.nextDouble();
				double saldoFinal = saldoAtual - valorTransferido;
				if(saldoAtual < valorTransferido) {
					System.out.println("Não há saldo para realizar a transferência.");
				}else {
					System.out.println("Saldo atualizado: " + saldoFinal);
				}
				
			} else if (opcao == 4) {
				System.out.println("Saindo...");
			} else {
				System.out.println("Opção inválida"); 
			}
		}
	}
}
