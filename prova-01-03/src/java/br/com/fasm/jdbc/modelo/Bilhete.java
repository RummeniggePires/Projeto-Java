package br.com.fasm.jdbc.modelo;

import java.util.List;

public class Bilhete {
    private int bilhete;
    private String filme;
    private String horario;
    private String cliente;

    public int getBilhete() {
        return bilhete;
    }

    public void setBilhete(int bilhete) {
        this.bilhete = bilhete;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }


}
