package Principal;
import conexao.conectaDAO;

public class Main {
    
    public static void main(String[] args) {
        
        conectaDAO c = new conectaDAO();
        c.Conectar();
    }
}
