package Mecanica;

public class Servico {

	String descricao1, descricao2;
	float valor1, valor2;

	public Servico(String d1, float v1, String d2, float v2) {
		this.descricao1 = d1;
		this.valor1 = v1;
		this.descricao2 = d2;
		this.valor2 = v1;

	}

	public void Finalizar(Veiculo n) {

		System.out.printf(
				"\n\n\nVeiculo..: %s - Placa: %s \nServico 1: %s - Valor: %.2f \nServico 2: %s - Valor: %.2f",
				n.nome, n.placa, this.descricao1, this.valor1, this.descricao2, this.valor2
		);

	}

}