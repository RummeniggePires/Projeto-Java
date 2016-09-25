package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Locacao {

    private int locacaoId;
    private String dataLocacao;
    private String dataDevolucao;
    private int clienteId;
    private int veiculoId;

    public Locacao() {
    }

    public Locacao(int locacaoId, String dataLocacao, String dataDevolucao, int clienteId, int veiculoId) {
        this.locacaoId = locacaoId;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.clienteId = clienteId;
        this.veiculoId = veiculoId;
    }

    public int getLocacaoId() {
        return locacaoId;
    }

    public void setLocacaoId(int locacaoId) {
        this.locacaoId = locacaoId;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    // retorna em um ResultSet todos os registros de emprestimo
    public ResultSet listeLocacoes() {
        // cria objeto da classe de conexão com o banco de dados
        ConectaBanco conecta = new ConectaBanco();
        // ativa a conexão com o banco de dados
        Connection reg = conecta.conecte();
        conecta.executeSQL("select l.locacao_id, "
            + "date_format(l.data_locacao, '%d/%m/%Y') as data_locacao,"
            + " date_format(l.data_devolucao, '%d/%m/%Y') as data_devolucao, "
            + "c.cliente_id, p.nome, v.veiculo_id, v.marca "
            + "from locacao l "
            + "inner join cliente c on c.cliente_id = c.cliente_id "
            + "inner join pessoa p on p.pessoa_id = c.pessoa_id "
            + "inner join veiculo v on v.veiculo_id = l.veiculo_id");
        return conecta.rs;
    }
    
    
    public int salve() {
        // cria um objeto da classe ConectaBanco
        ConectaBanco conecta = new ConectaBanco();
        // cria um objeto da classe PreparedStatement
        PreparedStatement pst = null;
        // recupera conexão com o banco de dados
        Connection reg = conecta.conecte();
        // cria um SQL para inserção
        String sql = "insert into locacao (data_locacao, "
                + "data_devolucao, cliente_id, veiculo_id) values (?,?,?,?)";
        // caso o usuario tenha selecionado um registro do JTable
        if (this.locacaoId != -1) {
            // cria SQL de atualização de registro
            sql = "update locacao set data_locacao = ?, "
                    + "data_devolucao = ?, cliente_id = ?, veiculo_id = ? "
                    + "where locacao_id = " + this.locacaoId;
        }
        try {
            pst = reg.prepareStatement(sql);
            pst.setString(1, this.dataLocacao);
            pst.setString(2, this.dataDevolucao);
            pst.setInt(3, this.clienteId);
            pst.setInt(4, this.veiculoId);
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
        String sql = "delete from locacao where locacao_id = ?";
        try {
            pst = reg.prepareStatement(sql);
            pst.setInt(1, this.locacaoId);
            return pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
        }
        // caso os fluxos alternativos falhem retorna zero
        return 0;
    }

}
