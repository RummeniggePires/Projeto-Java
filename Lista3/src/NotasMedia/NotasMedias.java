package NotasMedia;

import java.util.Scanner;

public class NotasMedias {
	
	public static void main(String[] args) {
		
		
		int notasDigitadas;
		float media, soma=0;
		
		Scanner inputInt = new Scanner(System.in);
		Scanner inputFloat = new Scanner(System.in);
		
		
		System.out.printf("Digite quantas notas seram lancadas: ");
		notasDigitadas = inputInt.nextInt();

		float entradas[] = new float [notasDigitadas];
		String saida[] = new String [notasDigitadas];
		
		for (int i = 0; i < notasDigitadas; i++) {
			System.out.printf("Digite o valor da nota %d: ",i);
			entradas[i] = inputFloat.nextFloat();
		}
		
		
		for (int i = 0; i < notasDigitadas; i++) {
			
			soma = soma + entradas[i];
						
		}
		media = soma/ notasDigitadas;
		
		System.out.printf("Nota media: %.2f \n\n", media);
		
		for (int i = 0; i < notasDigitadas; i++) {

			
			if (entradas[i] > media) {
				System.out.printf("Nota acima da media: " + entradas[i] + "\n" );
			}else {
				System.out.printf("Nota abaixo da media: " + entradas[i] + "\n" );
			}
			
		}
	
	}

}
