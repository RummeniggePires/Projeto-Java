package br.com.fasm.jdbc.modelo;

public class Funcionario {
    
    int codFunc;
    String nomeFunc ;
    int fk_codDep;
    int cpfFunc;
    int idade;
    String endFunc;

    public int getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(int codFunc) {
        this.codFunc = codFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    public int getFk_codDep() {
        return fk_codDep;
    }

    public void setFk_codDep(int fk_codDep) {
        this.fk_codDep = fk_codDep;
    }

    public int getCpfFunc() {
        return cpfFunc;
    }

    public void setCpfFunc(int cpfFunc) {
        this.cpfFunc = cpfFunc;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndFunc() {
        return endFunc;
    }

    public void setEndFunc(String endFunc) {
        this.endFunc = endFunc;
    }
    
    

}
