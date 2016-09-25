package dao;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Veiculo {

    public ResultSet listeVeiculos() {
        ResultSet rs = null;

        String sql = "select * from veiculo order by modelo";

        try {

            ConectaBanco conecta = new ConectaBanco();
            conecta.conecte();
            conecta.execulteSQL(sql);
            rs = conecta.rs;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar veiculos.");
        }
        return rs;

    }

    public ResultSet listeVeciulo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ResultSet listeVeiculo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
