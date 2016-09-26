package br.com.fasm.modelo;

import java.util.Calendar;

public class Animal {

    private int animal_id;
    private String nome;
    private int numeracao_brinco;
    private Calendar data_nascimento;

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeracao_brinco() {
        return numeracao_brinco;
    }

    public void setNumeracao_brinco(int numeracao_brinco) {
        this.numeracao_brinco = numeracao_brinco;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    
    
    
}
