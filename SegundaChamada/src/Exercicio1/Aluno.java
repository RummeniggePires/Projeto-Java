package Exercicio1;

import java.util.Scanner;

public class Aluno {
	private static String nome;
	private static int idade;
	private static int matricula;
	private static int qntNotas = 0;
	private static double nota, media;
	public static double notas[] = new double[qntNotas];

	public static void main(String[] args) {

		Scanner inputLine = new Scanner(System.in);
		Scanner inputDouble = new Scanner(System.in);
		Scanner inputInt = new Scanner(System.in);

		System.out.printf("Digite o nome do aluno: ");
		nome = inputLine.nextLine();
		System.out.printf("Digite a idade do aluno: ");
		idade = inputInt.nextInt();
		System.out.printf("Digite a matricula do aluno: ");
		matricula = inputInt.nextInt();
		System.out.printf("Digite quantas notas seram lancadas: ");
		qntNotas = inputInt.nextInt();

		for (int i = 0; i < qntNotas; i++) {

			System.out.printf("Digite a nota: ");
			notas[i] = inputDouble.nextDouble();

			nota = nota + notas[i];

		}
		calculeMedia(nota);

	}

	public static void calculeMedia(double m) {
		this.media = m;

		this.media = this.media / qntNotas;

		if (this.media > 6)
			System.out.printf("%S esta Aprovado...", this.aluno);
		else
			System.out.printf("%S esta Reprovado...", this.aluno);
	}

}