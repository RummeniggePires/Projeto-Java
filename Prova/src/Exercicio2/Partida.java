package Exercicio2;

public class Partida {

	int publico1, publico2, gol1 = 0, gol2 = 0;
	String time1, time2;

	public Partida(String t1, String t2, int p1, int p2) {
		this.publico1 = p1;
		this.publico2 = p2;
		this.time1 = t1;
		this.time2 = t2;
	}

	public void golt1() {

		gol1++;
	}

	public void golt2() {
		gol2++;
	}

	public void parcial() {

		System.out.printf("\n%S %d X %S %d\n", this.time1, this.gol1,
				this.time2, this.gol2);
	}

	public void resultado() {
		
			System.out.printf("\n ######### RESULTADO FINAL ########\n\n%s %d gols X %s %d gols.\n",this.time1,this.gol1, this.time2, this.gol2);
			
			if (publico1 > publico2)
				System.out.printf("O %S obteve um publico maior com %d pessoas e o %S de %d pessoas.", this.time1, this.publico1,this.time2, this.publico2);
			else
				System.out.printf("O %S obteve um publico maior com %d pessoas e o %S de %d pessoas.", this.time2, this.publico2,this.time1, this.publico1);
				
	}
}