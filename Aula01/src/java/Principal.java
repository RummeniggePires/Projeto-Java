import br.com.fasm.jdbc.dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import br.com.fasm.jdbc.modelo.Contato;
import br.com.fasm.jdbc.dao.ContatoDAO;
import java.util.Calendar;

public class Principal {
    
    public static void main(String[] args) throws SQLException{
        //cria um objeto da classe contato (Javabean)
        Contato contato = new Contato();
        /*contato.setNome("Carlos Alberto");
        contato.setEmail("carlos_gsalles@hotmail.com");
        contato.setEndereco("Rua Lincoln Marinho");
        contato.setDataNascimento(Calendar.getInstance());
        contato.setId(Long.parseLong("1"));
        //cria objeto da classe DAO
        ContatoDAO dao = new ContatoDAO();
        
        //invoca o método que adiciona um registro no banco de dados
        dao.altera(contato);
        */
        
        contato.setId(Long.parseLong("1"));
        ContatoDAO dao = new ContatoDAO();
        dao.remove(contato);
        
        System.out.println("Gravado!");
        
    }
    
}
