package Contador;

public class Contador {

private int cont;
	
	public  Contador(int c) {
		
		this.cont = c;
	}

	public void zerar(){
		this.cont = 0;
	}

	public void incrementa(){
		this.cont ++;
	}
	
	public void exibe(){
		System.out.printf(" O valor do contador esta em: %d ", this.cont);
	}

}
