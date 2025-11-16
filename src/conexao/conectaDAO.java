package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
    public String url = "jdbc:mysql://localhost:3306/bancoleiloes";
    public String user = "root";
    public String password = "taticodobem@357";
    
    private Connection conn; //conexão armazenada aqui
            
    public Connection Conectar(){
        try{
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Conexão com o banco funcionando");
            return conn;
        }catch(SQLException ex){
            System.out.println("Erro ao conectar com o banco");
            return null;
        }
    }
    
    public void desconectar(){
        try{
            if(conn != null && !conn.isClosed()){
            conn.close();
            }
        }catch(SQLException ex){
            System.out.println("Erro ao desconectar");
        }
    }
    
}
