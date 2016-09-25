package Banco;

public class Conta {
	
	private String titular;
	private int numConta;
	private float saldo;
	
	public  Conta(String t, int nc, float s) {
		this.titular = t;
		this.numConta = nc;
		this.saldo = s;
	}

	public void deposito(float valorDeposito){
		this.saldo += valorDeposito;
	}

	public void saque(float valorSaque){
		this.saldo -= valorSaque;
	}

	/*public void extrato(){
		System.out.printf("O(a) senhor(a) %s dono da conta %d tem saldo de R$ %.2f", this.titular,this.numConta, this.saldo);
	}*/
	
	
		
		
	



}
