package Salario;

public class SalarioLiquido {
    private double salarioBruto;
    private int numeroDependentes;
    private double valorDesconto;
    private double salarioLiquido;

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double taxaDesconto) {
        this.valorDesconto = this.salarioBruto * taxaDesconto;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido() {
        this.salarioLiquido = this.salarioBruto - this.valorDesconto;
    }
    
}
