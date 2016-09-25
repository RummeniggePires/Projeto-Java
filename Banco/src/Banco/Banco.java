package Banco;

import java.util.Scanner;

public class Banco {

	// declaração metodo construtor
	public static void main(String[] args) {

		// declaração de atributos
		String nome; // nome do titular
		float saldo, transacao;
		final int QNTUSO = 5;
		int numConta, op, sair = 1, cont = 0;
		String operacao[] = new String[100];
		float valor[] = new float[100];
		int qntUso[] = new int[QNTUSO];

		Scanner inputLine = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		Scanner inputFloat = new Scanner(System.in);

		// entrada de dados declarada pelo operador
		System.out.printf("Digite o nome do titular: ");
		nome = inputLine.nextLine();
		System.out.printf("Digite o numero da conta: ");
		numConta = inputInt.nextInt();
		System.out.printf("Digite o saldo inicial: ");
		saldo = inputFloat.nextFloat();

		Conta c = new Conta(nome, numConta, saldo);

		while (sair == 1) {

			try {

				System.out
						.printf("\n 1-Saque\n 2-Deposito\n 0-Sair\n Escolha a opcao desejada: ");
				op = inputInt.nextInt();

				switch (op) {

				case 1:
					System.out.printf("Digite o valor do saque: ");
					transacao = inputFloat.nextFloat();
					c.saque(transacao);
					operacao[cont] = "Saque---";
					valor[cont] = transacao;
					qntUso[cont]++;
					break;
				case 2:
					System.out.printf("Digite o valor do deposito: ");
					transacao = inputFloat.nextFloat();
					c.deposito(transacao);
					operacao[cont] = "Deposito";
					valor[cont] = transacao;
					qntUso[cont]++;
					break;
				default:
					sair = 0;
					break;

				}

				cont++;

				// c.extrato();

			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.printf("\n\nVoce ultrapassou o limite de transacoes...\n\n");

			}
		}

		System.out.printf("\n\n#########  EXTRATO DA CONTA  #########\n\n");

		for (int i = 0; i < cont - 1; i++) {
			System.out.printf("%s--------------R$ %.2f\n", operacao[i],
					valor[i]);
		}
			System.out.printf("Saldo Final-----------R$ %.2f\n", saldo);

		
	}
}
