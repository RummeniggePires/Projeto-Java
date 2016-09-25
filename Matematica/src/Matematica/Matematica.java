/*criar uma constante pi = 3.14
 * usuario entra com valor do diametro.
 * chamada do metodo calcule voce deve incluir no bloco try/catch
 * esse metodo retorna o valor do calculo.
 */

package Matematica;

import java.util.Scanner;

public class Matematica {

	public static void main(String[] args) {

		double diametro;

		Scanner inputDouble = new Scanner(System.in);

		System.out.printf("Digite o a tamanho do diametro: ");
		diametro = inputDouble.nextDouble();

		Calculo c = new Calculo(diametro);

	}

}
