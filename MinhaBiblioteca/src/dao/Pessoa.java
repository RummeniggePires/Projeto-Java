package dao;

public class Pessoa {
    private int pessoaId;
    private String nome;

    public Pessoa() {}

    public Pessoa(int pessoaId, String nome) {
        this.pessoaId = pessoaId;
        this.nome = nome;
    }

    public int getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
