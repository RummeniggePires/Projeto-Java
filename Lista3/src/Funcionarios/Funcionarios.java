package Funcionarios;

import java.util.Scanner;

public class Funcionarios {

	public static void main(String[] args) {

		int qtde, continua = 1, op;
		double reajuste;

		Scanner input = new Scanner(System.in);
		Scanner inputDouble = new Scanner(System.in);

		System.out.printf("Quantos salarios seram ajustados: ");
		qtde = input.nextInt();

		System.out.printf("Qual o valor do reajuste salarial: ");
		reajuste = inputDouble.nextDouble() / 100;

		double[] salario = new double[qtde];
		double[] reajustado = new double[qtde];

		for (int i = 0; i < qtde; i++) {
			try {
				System.out.printf("Digite o salario do " + (i + 1) + "º funcionario: ");
				salario[i] = inputDouble.nextDouble();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("e " + e);
			}
		}

		Salario s = new Salario(qtde, salario, reajuste, reajustado);

		s.reajuste();

		while (continua == 1) {
			System.out
					.printf("\n######  MENU    ######\n1 - Listar salarios\n2 - Exibir media salarial\n\nDigite a opcao desejada: ");
			op = input.nextInt();

			switch (op) {

			case 1: {
				s.exibe();
				break;
			}
			case 2: {
				s.media();
				break;
			}
			case 0: {
				continua = 0;
				break;
			}
			default: {
				System.out.printf("\nOPCAO INCORRETA....\n");
				break;
			}
			
			}

		}
	}
}