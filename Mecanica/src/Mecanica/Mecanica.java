package Mecanica;

import java.util.Scanner;

public class Mecanica {

	public static void main(String[] args) {

		// declaracao de atributos.
		String nome, placa, servico1 = "", servico2 = "";
		float valor1 = 0, valor2 = 0;

		Scanner inputLine = new Scanner(System.in);
		Scanner inputFloat = new Scanner(System.in);

		System.out.printf("Digite o nome do veiculo: ");
		nome = inputLine.nextLine();
		System.out.printf("Digite o placa do veiculo: ");
		placa = inputLine.nextLine();

		Veiculo v = new Veiculo(nome, placa);

		System.out.printf("Digite o primeiro servico do veiculo: ");
		servico1 = inputLine.nextLine();
		System.out.printf("Digite o valor do primeiro servico: ");
		valor1 = inputFloat.nextFloat();
		System.out.printf("Digite o segundo servico do veiculo: ");
		servico2 = inputLine.nextLine();
		System.out.printf("Digite o valor do segundo servico: ");
		valor2 = inputFloat.nextFloat();

		Servico s = new Servico(servico1, valor1, servico2, valor2);

		s.Finalizar(v);
	}

}