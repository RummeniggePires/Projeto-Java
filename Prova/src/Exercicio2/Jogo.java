package Exercicio2;

import java.util.Scanner;

import Exercicio1.Votos;

public class Jogo {
	
	public static void main(String[] args) {
		int publico1, publico2, op, sair=1;
		String time1, time2;
		
		Scanner inputInt = new Scanner(System.in);
		Scanner inputString = new Scanner(System.in);
		
		System.out.printf("Digite o nome do primeiro time: ");
		time1 = inputString.nextLine();
		System.out.printf("Digite o nome do segundo time: ");
		time2 = inputString.nextLine();
		System.out.printf("Digite o publico do primeiro time: ");
		publico1 = inputInt.nextInt();
		System.out.printf("Digite o publico do segundo time: ");
		publico2 = inputInt.nextInt();
		
		
		Partida p = new Partida(time1, time2, publico1, publico2);
		
		while (sair != 0) {

		
				System.out
						.printf("\n 1 - GOL DO %S\n 2 - GOL DO %S\n 3 - PLACAR PARCIAL\n 0 - FIM DE JOGO\n Escolha a opcao desejada: ", time1, time2);
				op = inputInt.nextInt();

				switch (op) {

				case 1:
					 
					p.golt1();
					break;
					
				case 2:
					p.golt2();
					break;
				case 3:
					p.parcial();
					break;
				case 0:
					sair = 0;
					break;
				default:
					System.out.printf("\n Opcao invalida...\n");
					break;

				}
					

		}
		p.resultado();
	}
}