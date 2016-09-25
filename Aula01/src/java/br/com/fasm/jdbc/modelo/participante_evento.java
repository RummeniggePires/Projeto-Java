package br.com.fasm.jdbc.modelo;

import java.util.Calendar;

public class participante_evento {

    private int participante_evento_id;
    private String nome;
    private Calendar data_nascimento;
    private String telefone;
    private String email;
    private String instituicao;

    public int getParticipante_evento_id() {
        return participante_evento_id;
    }

    public void setParticipante_evento_id(int participante_evento_id) {
        this.participante_evento_id = participante_evento_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    
}
