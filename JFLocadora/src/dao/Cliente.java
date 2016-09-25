package dao;


public class Cliente {

    private int pessoa_id;
    private String nome;
    
    public Cliente() {}

    public Cliente(int pessoa_id, String nome) {
        this.pessoa_id = pessoa_id;
        this.nome = nome;
    }

    public int getPessoaId() {
        return pessoa_id;
    }

    public void setPessoaId(int pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
