package Prefeitura;

import java.util.Scanner;

public class Prefeitura {

	public static void main(String[] args) {

		// declaracao de atributos.
		String placa, marca, modelo;
		int kilometragem,op=1, sair = 1, valorDigitado;

		Scanner inputLine = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);

		System.out.printf("Digite o marca do veiculo: ");
		marca = inputLine.nextLine();
		System.out.printf("Digite o modelo do veiculo: ");
		modelo = inputLine.nextLine();
		System.out.printf("Digite o placa do veiculo: ");
		placa = inputLine.nextLine();
		System.out.printf("Digite o Km inicial do veiculo: ");
		kilometragem = inputInt.nextInt();

		Veiculo v = new Veiculo(marca, modelo, placa, kilometragem);
		
		while (sair==1) {
		
		System.out.printf(" 1 - Zerar Kilometragem\n 2 - Adicionar valor a Kilometragem\n 3 - Exibir Valores\n 0 - Sair\n \n"
				+ " Digite a opcao desejada:");
		op = inputInt.nextInt();
	
		switch (op) {
		
			case 1:
				v.zerar();
				break;
			case 2:
				System.out.printf("Digite o valor a ser adicionado ao Km");
				valorDigitado = inputInt.nextInt();
				v.incrementa(valorDigitado);
				break;
			case 3:
				v.exibe();
				break;
			default:
				sair =0;
				break;
			}

		}

	}
}