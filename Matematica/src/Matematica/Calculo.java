package Matematica;

public class Calculo {
	double diametro, circunferencia;
	final double pi = (double) 3.14;
	int saida;

	public Calculo(double di) {

		this.diametro = di;

		while (saida == 0) {
			try {
				circunferencia = pi * diametro;

			} catch (ArrayIndexOutOfBoundsException e) {

				System.err.println("e " + e);
			}
		saida++;
		}

		System.out.printf("A circunferencia eh: %.2f", circunferencia);

	}
}