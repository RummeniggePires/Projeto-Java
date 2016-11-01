package br.com.fasm.jdbc.modelo;

public class Servicos {
    
    int codServico;
    String nomeServ;
    float preco;
    String descricao;

    public int getCodServico() {
        return codServico;
    }

    public void setCodServico(int codServico) {
        this.codServico = codServico;
    }

    public String getNomeServ() {
        return nomeServ;
    }

    public void setNomeServ(String nomeServ) {
        this.nomeServ = nomeServ;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
