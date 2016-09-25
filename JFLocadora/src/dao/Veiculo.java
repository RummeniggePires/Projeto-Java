package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Veiculo {

    private int veiculoId;
    private String marca;
    private String modelo;
    private String placa;
    private double valorLocacaoDia;

    public Veiculo() {
    }

    public Veiculo(int veiculoId, String marca, String modelo, String placa, double valorLocacaoDia) {
        this.veiculoId = veiculoId;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.valorLocacaoDia = valorLocacaoDia;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValorLocacaoDia() {
        return valorLocacaoDia;
    }

    public void setValorLocacaoDia(double valorLocacaoDia) {
        this.valorLocacaoDia = valorLocacaoDia;
    }

    public int salve() {
        // efetua a conexão com o banco de dados
        ConectaBanco conecta = new ConectaBanco();

        // cria sql de inserção de veiculo
        String sql = "insert into veiculo (modelo, marca, placa, valor_locacao_dia) "
                + "values (?, ?, ?, ?)";

        // caso de edição
        if (this.veiculoId != 0) {
            sql = "update veiculo set modelo = ?, marca = ?, placa = ?,";
            sql += "valor_locacao_dia = ? where veiculo_id = " + this.veiculoId;
        }

        // objeto utilizado para substituição de interrogações na string sql
        PreparedStatement pst = null;

        // recupera a conexão com o banco de dados
        Connection reg = conecta.conecte();
        
        Connection conn = conecta.conecte();

        try {
            pst = reg.prepareStatement(sql);

            pst.setString(1, this.modelo);
            pst.setString(2, this.marca);
            pst.setString(3, this.placa);
            pst.setDouble(4, this.valorLocacaoDia);

            return pst.executeUpdate();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro.");
        }

        return 0;
    }

    public int delete() {

        // efetua a conexão com o banco de dados
        ConectaBanco conecta = new ConectaBanco();

        // cria a instrução SQL para exclusão de registro
        String sql = "delete from veiculo where veiculo_id = ?";

        PreparedStatement pst = null;

        // recupera a variável com a conexão ativa do banco de dados
        Connection reg = conecta.conecte();

        try {
            pst = reg.prepareStatement(sql);
            pst.setInt(1, this.veiculoId);
            return pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover o veiculo.");
        }

        return 0;
    }

    public ResultSet listeVeiculos() {
        
        ResultSet rs = null;

        String sql = "select veiculo_id, titulo from veiculo "
                + "order by modelo";

        ConectaBanco conecta = new ConectaBanco();
        conecta.conecte();
        conecta.executeSQL(sql);
        rs = conecta.rs;

        return rs;
    }

}
