package Exercicio1;

import java.util.Scanner;

public class Eleicao {
	
	public static void main(String[] args) {
		int numVotos, votoSim, votoNao, op;
		
		Scanner inputInt = new Scanner(System.in);
		
		System.out.printf("Digite quantos votos serao efetuados: ");
		numVotos = inputInt.nextInt();
		
		Votos v = new Votos(numVotos);
		
		while (numVotos != 0) {

			try {

				System.out
						.printf("\n 1 - Sim\n 2 - Nao\n 3 - Parciais\n 0 - Sair\n Escolha a opcao desejada: ");
				op = inputInt.nextInt();

				switch (op) {

				case 1:
					votoSim = 1;
					v.votosSim(votoSim);
					break;
					
				case 2:
					votoNao = 1;
					v.votosNao(votoNao);
					break;
				case 3:
					v.parcial();
					break;
				case 0:
					numVotos = 0;
					break;
				default:
					System.out.printf("\n Opcao invalida...\n");
					break;

				}
					

			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.printf("\n\nVoce ultrapassou o limite de votos...\n\n");

			}
			numVotos --;
		}
		v.resultado();
	}
}
