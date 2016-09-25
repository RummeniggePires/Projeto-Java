package Exercicio1;

public class Votos {
	int qntVoto;
	float resSim, resNao;
	private int sim;
	private int nao;

	public Votos(int v) {
		this.qntVoto = v;
	}

	public void votosSim(int s) {

		this.sim += s;
	}

	public void votosNao(int n) {
		this.nao += n;
	}

	public void parcial() {

		resSim = this.sim * 100 / qntVoto;
		resNao = this.nao * 100 / qntVoto;

		System.out
				.printf("\nOs votos sim receberam %.2f dos %d votos.\nOs votos nao receberam %.2f dos %d votos.\n",
						resSim, qntVoto, resNao, qntVoto);
	}

	public void resultado() {
	
		if (resNao > 60)
			System.out.printf("\n PROCESSO ARQUIVADO...");

		else
			System.out.printf("\n O IMPEACHMENT PROSSEGUIRA...");
	}
}
