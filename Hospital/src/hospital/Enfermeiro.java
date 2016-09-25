/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital;

/**
 *
 * @author kamikaze
 */
public class Enfermeiro extends Funcionario{
    protected String cre;

    public Enfermeiro(String nome, String cpf, double salario, String cre){
        super.setNome(nome);
        super.setCpf(cpf);
        super.setSalario(salario);
        this.setCre(cre);
    }
    
    
    public String getCre() {
        return cre;
    }

    public void setCre(String cre) {
        this.cre = cre;
    }
    
   
}
