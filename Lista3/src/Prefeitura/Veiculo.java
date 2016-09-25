package Prefeitura;

public class Veiculo {
	String marca, modelo, placa;
	int kilometragem;

	public  Veiculo(String ma, String mo, String p, int km) {
		this.marca=ma;
		this.modelo=mo;
		this.placa = p;
		this.kilometragem = km;
	}

	public void zerar(){
		this.kilometragem = 0;
	}

	public void incrementa(int valorDigitado){
		this.kilometragem += valorDigitado;
	}
	
	public void exibe(){
		System.out.printf("\n\n Marca...: %s\n Modelo.: %s\n Placa..: %s\n Kilometragem: %d \n\n ",this.marca, this.modelo,this.placa, this.kilometragem);
	}

}
