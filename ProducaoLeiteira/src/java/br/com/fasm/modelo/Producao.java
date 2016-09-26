package br.com.fasm.modelo;

import java.util.Calendar;

public class Producao {

    private int producao_id;
    private float kg_leite;
    private float teor_gordura;
    private float acidez;
    private Calendar data_registro;
    private int animal_id;
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getProducao_id() {
        return producao_id;
    }

    public void setProducao_id(int producao_id) {
        this.producao_id = producao_id;
    }

    public float getKg_leite() {
        return kg_leite;
    }

    public void setKg_leite(float kg_leite) {
        this.kg_leite = kg_leite;
    }

    public float getTeor_gordura() {
        return teor_gordura;
    }

    public void setTeor_gordura(float teor_gordura) {
        this.teor_gordura = teor_gordura;
    }

    public float getAcidez() {
        return acidez;
    }

    public void setAcidez(float acidez) {
        this.acidez = acidez;
    }

    public Calendar getData_registro() {
        return data_registro;
    }

    public void setData_registro(Calendar data_registro) {
        this.data_registro = data_registro;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }
    
    
}
