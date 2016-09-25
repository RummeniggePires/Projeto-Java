package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.JFAluno;

public class Aluno extends Pessoa {

    private int alunoId;
    private String curso;
    private int serie;

    public Aluno() {
        super();
    }

    public Aluno(int alunoId, String curso, int serie, int pessoaId, String nome) {
        super(pessoaId, nome);
        this.alunoId = alunoId;
        this.curso = curso;
        this.serie = serie;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public int salve() {
        // efetua a conexão com o banco de dados
        ConectaBanco conecta = new ConectaBanco();

        // controla inserção ou atualização
        boolean insercao = true;

        // cria sql de inserção de pessoa
        String sql = "insert into pessoa (nome) values (?)";

        // caso de edição
        if (super.getPessoaId() != 0) {
            sql = "update pessoa set nome = ? ";
            sql += "where pessoa_id = " + super.getPessoaId();
        }

        // objeto utilizado para substituição de interrogações na string sql
        PreparedStatement pst = null;

        // recupera a conexão com o banco de dados
        Connection reg = conecta.conecte();

        try {
            // prepara o objeto para retornar o id gerado
            pst = reg.prepareStatement(sql, pst.RETURN_GENERATED_KEYS);
            // substitui o parâmetro ? pelo nome obtido no objeto
            pst.setString(1, super.getNome());
            // executa o código SQL
            pst.execute();

            // cria a SQL de inserção de aluno
            sql = "insert into aluno (curso, serie, pessoa_id) ";
            sql += "values (?, ?, ?)";

            if (super.getPessoaId() != 0) {
                sql = "update aluno set curso = ?, serie = ?, ";
                sql += "pessoa_id = ? where pessoa_id = " + super.getPessoaId();
            }

            // recupera em um recordset o id gerado na transação
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                super.setPessoaId(rs.getInt(1));
            }

            pst = reg.prepareStatement(sql);
            pst.setString(1, this.getCurso());
            pst.setInt(2, this.getSerie());
            pst.setInt(3, super.getPessoaId());

            return pst.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
        }

        return 0;
    }

    // remove registro de aluno
    public int delete() {
        // efetua conexão com o banco de dados
        ConectaBanco conecta = new ConectaBanco();
        // cria SQL de remoção de registro de aluno
        String sql = "delete from aluno where pessoa_id = ?";
        PreparedStatement pst = null;
        Connection reg = conecta.conecte();
        try {
            pst = reg.prepareStatement(sql);
            pst.setInt(1, super.getPessoaId());
            pst.execute();

            // cria SQL de remoção de registro de pessoa
            sql = "delete from pessoa where pessoa_id = ?";
            pst = reg.prepareStatement(sql);
            pst.setInt(1, super.getPessoaId());
            return pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
        }
        return 0;
    }

    public ResultSet listeAlunos() {

        String sql = "select a.aluno_id, p.nome, a.curso, a.serie "
                + "from pessoa p "
                + "inner join aluno a on p.pessoa_id = a.pessoa_id "
                + "order by p.nome";

        ConectaBanco conecta = new ConectaBanco();
        conecta.conecte();
        conecta.executeSQL(sql);
        ResultSet rs = conecta.rs;

        return rs;
    }
}
