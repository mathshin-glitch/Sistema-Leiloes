package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import conexao.conectaDAO;
import objetos.ProdutosDTO;

public class ProdutosDAO {

    private conectaDAO conexao;
    private Connection conn;

    public ProdutosDAO() {
        this.conexao = new conectaDAO(); // cria um novo objeto de conexão
        this.conn = conexao.Conectar(); // armazena o metodo de conexão no Driver de conexão (Conn)
    }
    
    //Declaca os Objetos
    PreparedStatement prep; // faz consultas sql
    ResultSet resultset; // retorna dados do banco
    
    //Método para casdastrar produtos no banco
    public int cadastrarProduto(ProdutosDTO produto) {
        try {
            int resultado;
            String sql = "INSERT INTO produtos (nome,valor,status) VALUES (?,?,?)";
            prep = this.conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            resultado = prep.executeUpdate();
            return resultado;
        } catch (SQLException ex) {
            System.out.println("Erro no INSERT produtos: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

}
