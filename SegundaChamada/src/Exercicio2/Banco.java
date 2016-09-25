package Exercicio2;

import java.util.Scanner;

public class Banco {

	// declaração metodo construtor
	public static void main(String[] args) {

		// declaração de atributos
		String nome, cond;
		float saldo, transacao;
		int sair = 1, saque, deposito;

		Scanner inputLine = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);
		Scanner inputFloat = new Scanner(System.in);

		// entrada de dados declarada pelo operador
		System.out.printf("Digite o nome do titular: ");
		nome = inputLine.nextLine();
		System.out.printf("Digite o saldo inicial: ");
		saldo = inputFloat.nextFloat();

		while (sair == 1) {

			System.out
					.printf("\n S-Saque\n D-Deposito\n Escolha a opcao desejada: ");
			cond = inputLine.nextLine();
			
			switch (cond) {

			case d:

				System.out.printf("Digite o valor do saque: ");
				transacao = inputInt.nextInt();
				saldo = saldo + transacao;
				saque++;

				break;

			case s:

				System.out.printf("Digite o valor do deposito: ");
				transacao = inputInt.nextInt();
				saldo = saldo + transacao;
				deposito++;

			default:
				sair = 0;
				break;
			}

			if (deposito > saque)
				System.out.printf(
						"O cliente %S tem um saldo %.2f e teve mais depositos",
						nome, saldo);
			else
				System.out.printf(
						"O cliente %S tem um saldo %.2f e teve mais saque",
						nome, saldo);
		}
	}
}