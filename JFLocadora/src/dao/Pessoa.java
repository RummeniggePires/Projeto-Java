package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Pessoa extends Cliente{

    private int clienteId;
    private String cpf,cnh;
    private int idade;
    
     public Pessoa() {
        super();
    }

    public Pessoa(int clienteId, String cpf, String cnh, int idade) {
        this.clienteId = clienteId;
        this.cpf = cpf;
        this.cnh = cnh;
        this.idade = idade;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

            // cria a SQL de inserção de cliente
            sql = "insert into cliente (idade, cpf,cnh, pessoa_id) ";
            sql += "values (?, ?, ?, ?)";

            if (super.getPessoaId() != 0) {
                sql = "update cliente set idade = ?, cpf = ?, cnh = ? ";
                sql += "pessoa_id = ? where pessoa_id = " + super.getPessoaId();
            }

            // recupera em um recordset o id gerado na transação
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                super.setPessoaId(rs.getInt(1));
            }

            pst = reg.prepareStatement(sql);
            pst.setInt(2, this.getIdade());
            pst.setString(3, this.getCpf());
            pst.setString(4, this.getCnh());
            pst.setInt(5, super.getPessoaId());

            return pst.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
        }

        return 0;
    }
    
    public int delete() {
        // efetua conexão com o banco de dados
        ConectaBanco conecta = new ConectaBanco();
        // cria SQL de remoção de registro de cliente
        String sql = "delete from cliente where pessoa_id = ?";
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
    
    public ResultSet listeCliente() {

        String sql = "select c.cliente_id, p.nome, p.cpf, p.cnh, p.idade "
                + "from pessoa p "
                + "inner join cliente c on c.pessoa_id = p.pessoa_id "
                + "order by p.nome";

        ConectaBanco conecta = new ConectaBanco();
        conecta.conecte();
        conecta.executeSQL(sql);
        ResultSet rs = conecta.rs;

        return rs;
    }
}
