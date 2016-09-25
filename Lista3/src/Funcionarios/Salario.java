package Funcionarios;

public class Salario {
    int qtd;
    double[] sal = new double[qtd];
    private double[] reajustado = new double[qtd];
    double reajuste, aux=0, media;
    
    public double[] getSalReajustado(){
        return this.reajustado;
    }
  
    public Salario(int qt, double[] sa, double rea, double[] sRe){
        this.qtd = qt;
        this.sal = sa;
        this.reajuste = rea;
        this.reajustado = sRe;
    }
    
    public void reajuste(){
       for(int i=0; i<this.qtd; i++){
            this.reajustado[i] = (this.sal[i] * this.reajuste) + this.sal[i];
        } 
    }
    
    public void exibe(){
        for(int i=0; i<this.qtd; i++){
            System.out.printf("Salario funcionario " + (i+1) + " : %.2f \n", this.reajustado[i]);
        }
    }
    
    public void media(){
        for(int i=0; i<this.qtd; i++){
            this.aux += this.reajustado[i];
        }
        this.media = this.aux/this.qtd;
        System.out.printf("A media salarial eh: %.2f\n", this.media);
    }
    
    
}