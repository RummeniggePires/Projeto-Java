package br.com.fasm.jdbc.modelo;

public class Atendimento {
    
    int codAtendimento;
    int fk_codCliente;
    int fk_codFunc;
    int fk_codServ;

    public int getCodAtendimento() {
        return codAtendimento;
    }

    public void setCodAtendimento(int codAtendimento) {
        this.codAtendimento = codAtendimento;
    }

    public int getFk_codCliente() {
        return fk_codCliente;
    }

    public void setFk_codCliente(int fk_codCliente) {
        this.fk_codCliente = fk_codCliente;
    }

    public int getFk_codFunc() {
        return fk_codFunc;
    }

    public void setFk_codFunc(int fk_codFunc) {
        this.fk_codFunc = fk_codFunc;
    }

    public int getFk_codServ() {
        return fk_codServ;
    }

    public void setFk_codServ(int fk_codServ) {
        this.fk_codServ = fk_codServ;
    }
    
    

}
