package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Emprestimo {
    private int emprestimoId;
    private String dataEmprestimo;
    private String dataDevolucao;
    private int alunoId;
    private int livroId;

    public Emprestimo(){}

    public Emprestimo(int emprestimoId, String dataEmprestimo, String dataDevolucao, int alunoId, int livroId) {
        this.emprestimoId = emprestimoId;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.alunoId = alunoId;
        this.livroId = livroId;
    }

    public int getEmprestimoId() {
        return emprestimoId;
    }

    public void setEmprestimoId(int emprestimoId) {
        this.emprestimoId = emprestimoId;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    // retorna em um ResultSet todos os registros de emprestimo
    public ResultSet listeEmprestimos() {
        // cria objeto da classe de conexão com o banco de dados
        ConectaBanco conecta = new ConectaBanco();
        // ativa a conexão com o banco de dados
        Connection reg = conecta.conecte();
        conecta.executeSQL("select e.emprestimo_id, "
            + "date_format(e.data_emprestimo, '%d/%m/%Y') as data_emprestimo,"
            + " date_format(e.data_devolucao, '%d/%m/%Y') as data_devolucao, "
            + "a.aluno_id, p.nome, l.livro_id, l.titulo "
            + "from emprestimo e "
            + "inner join aluno a on a.aluno_id = e.aluno_id "
            + "inner join pessoa p on p.pessoa_id = a.pessoa_id "
            + "inner join livro l on l.livro_id = e.livro_id");
        return conecta.rs;
    }

    // grava um registro de empréstimo no banco de dados
    public int salve() {
        // cria um objeto da classe ConectaBanco
        ConectaBanco conecta = new ConectaBanco();
        // cria um objeto da classe PreparedStatement
        PreparedStatement pst = null;
        // recupera conexão com o banco de dados
        Connection reg = conecta.conecte();
        // cria um SQL para inserção
        String sql = "insert into emprestimo (data_emprestimo, "
                + "data_devolucao, aluno_id, livro_id) values (?,?,?,?)";
        // caso o usuario tenha selecionado um registro do JTable
        if (this.emprestimoId != -1) {
            // cria SQL de atualização de registro
            sql = "update emprestimo set data_emprestimo = ?, "
                + "data_devolucao = ?, aluno_id = ?, livro_id = ? "
                + "where emprestimo_id = " + this.emprestimoId;
        }
        try {
            pst = reg.prepareStatement(sql);
            pst.setString(1, this.dataEmprestimo);
            pst.setString(2, this.dataDevolucao);
            pst.setInt(3, this.alunoId);
            pst.setInt(4, this.livroId);
            return pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
        }
        // caso os fluxos alternativos falhem retorna zero
        return 0;
    }

    public int delete() {
        // cria um objeto da classe ConectaBanco
        ConectaBanco conecta = new ConectaBanco();
        // cria um objeto da classe PreparedStatement
        PreparedStatement pst = null;
        // recupera conexão com o banco de dados
        Connection reg = conecta.conecte();
        // cria um SQL para inserção
        String sql = "delete from emprestimo where emprestimo_id = ?";
        try {
            pst = reg.prepareStatement(sql);
            pst.setInt(1, this.emprestimoId);
            return pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
        }
        // caso os fluxos alternativos falhem retorna zero
        return 0;
    }
}






