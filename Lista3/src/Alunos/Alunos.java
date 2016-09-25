package Alunos;

import java.util.Scanner;

public class Alunos {
	
	public static void main(String[] args) {
		String aluno[] = new String [5];
		double notas[] = new double [5];
		double media=0;

		Scanner inputLine = new Scanner(System.in);
		Scanner inputDouble = new Scanner(System.in);

		
		for (int i = 0; i < 5; i++) {
			
			System.out.printf("Digite o nome do aluno: ");
			aluno[i] = inputLine.nextLine();
			System.out.printf("Digite a nota do %s :", aluno);
			notas[i] = inputDouble.nextDouble();			
		
			media = notas[i] + media;
		
		}
		
		media = media/5;
		System.out.printf("\n\nA media da turma foi: " + media +"\n\n");
		
		for (int i = 0; i < 5; i++) {
			
			if (notas[i] > media) {
				System.out.printf("O aluno %s", aluno[i] + " obteve nota " + notas[i]+ "\n");
				
			}
		}
	}

	
}
