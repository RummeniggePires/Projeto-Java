package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Livro {

    private int livroId;
    private String titulo;
    private String autor;
    private String area;
    private int numeroExemplares;

    public Livro() {}

    public Livro(int livroId, String titulo, String autor, String area, int numeroExemplares) {
        this.livroId = livroId;
        this.titulo = titulo;
        this.autor = autor;
        this.area = area;
        this.numeroExemplares = numeroExemplares;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public int salve() {
        // efetua a conexão com o banco de dados
        ConectaBanco conecta = new ConectaBanco();

        // cria sql de inserção de livro
        String sql = "insert into livro (titulo, autor, area, numero_exemplares) "
            + "values (?, ?, ?, ?)";

        // caso de edição
        if (this.livroId != 0) {
            sql = "update livro set titulo = ?, autor = ?, area = ?, ";
            sql+= "numero_exemplares = ? where livro_id = " + this.livroId;
        }

        // objeto utilizado para substituição de interrogações na string sql
        PreparedStatement pst = null;

        // recupera a conexão com o banco de dados
        Connection reg = conecta.conecte();

        try {
            pst = reg.prepareStatement(sql);

            pst.setString(1, this.titulo);
            pst.setString(2, this.autor);
            pst.setString(3, this.area);
            pst.setInt(4, this.numeroExemplares);

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
        String sql = "delete from livro where livro_id = ?";

        PreparedStatement pst = null;

        // recupera a variável com a conexão ativa do banco de dados
        Connection reg = conecta.conecte();

        try {
            pst = reg.prepareStatement(sql);
            pst.setInt(1, this.livroId);
            return pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao remover o livro.");
        }

        return 0;
    }

    public ResultSet listeLivros() {

        String sql = "select livro_id, titulo from livro "
                + "order by titulo";

        ConectaBanco conecta = new ConectaBanco();
        conecta.conecte();
        conecta.executeSQL(sql);
        ResultSet rs = conecta.rs;

        return rs;
    }
}