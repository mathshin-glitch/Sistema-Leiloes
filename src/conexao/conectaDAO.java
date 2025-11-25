package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {

    private final String url = "jdbc:mysql://localhost:3306/bancoleiloes";
    private final String user = "root";
    private final String password = "taticodobem@357";

    private Connection conn; //conexão armazenada aqui

    public Connection Conectar() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conexão com o banco funcionando");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco");
            return null;
        }
        return conn;
    }

    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão encerrada");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar" + ex.getMessage());
        }
    }
    
    public Connection getConnection(){
        return conn;
    }

}
