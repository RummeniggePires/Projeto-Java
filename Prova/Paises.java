package Paises;

public class Paises {
    private String iso, pais; 
    private double populacao, dimensao;
    double densidade;
    String fronteira[] = new String[10];
    
    public Paises(String is, String no, double po, double di){
        this.iso = is;
        this.pais = no;
        this.populacao = po;
        this.dimensao = di;
    }
    
    public String getIso(){
        return this.iso; 
    }
    public String getNome(){
        return this.pais; 
    }
    public double getPopulacao(){
        return this.populacao; 
    }
    public double getDimensao(){
        return this.dimensao; 
    }
    
    public void verifica(String iso){
        if(this.iso.equals(iso)){
            System.err.println("Mesmo pais..."); 
        }else{
            System.out.println("Paises diferentes...");
        }
    }
    
    public void divisa(String verDivisa, String fronteira[]){
        for(int i=0; i<=10; i++){
            if(verDivisa.equals(fronteira[i])){
                System.out.println("O Pais faz divisa");
            }
        }
    }
    
    public void exibir(){
        densidade = this.populacao/this.dimensao;
        System.out.printf("A densidade do pais " + this.pais + " é: " + this.dimensao);
    }
    
    public void vizinhos(String Pais[]){
        for (int i=0; i<=10; i++){
            for (int k=0; k<=10; k++){
                if(fronteira[i].equals(Pais[k])){
                    System.out.printf("O Pais: " + Pais[k] + " é vizinho.");
                }
            }
        }
    }
}