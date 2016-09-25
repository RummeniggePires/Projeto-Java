/*constante para determinar o numero de operacoes =5
 * caso o usuario informe mais de 5 operalçies lance uma excecao.
 */

package Banco;

import java.util.Scanner;

public class Banco {

	// declaração metodo construtor
	public static void main(String[] args) {

		// declaração de atributos
		String nome; // nome do titular
		float saldo, transacao;
		int numConta, cons, op, sair = 1, cont = 0;
		String operacao[] = new String[100];
		float valor[] = new float[100];
		final int MAXTRANS = (int) 5;

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

		cons = MAXTRANS;

		while (cons >= 0) {

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
					break;
				case 2:
					System.out.printf("Digite o valor do deposito: ");
					transacao = inputFloat.nextFloat();
					c.deposito(transacao);
					operacao[cont] = "Deposito";
					valor[cont] = transacao;
					break;
				default:
					sair = 0;
					break;

				}
				cons--;
			} catch (ArrayIndexOutOfBoundsException e) {

				System.err.printf("Voce ultrapassou o limite de transacoes... "
						+ e);
			}

			System.out.printf("\n\n#########  EXTRATO DA CONTA  #########\n\n");

			for (int i = 0; i < cont - 1; i++) {
				System.out.printf("%s--------------R$ %.2f\n", operacao[i],
						valor[i]);
			}
			System.out.printf("Saldo Final-----------R$ %.2f\n", saldo);
		}
	}
}
