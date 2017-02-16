package lppo.exercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Criatabela {
    
    public static void main(String[] args) {
    
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            String url = "jdbc:derby://localhost:1527/lppo-2017-1";
            Connection conexao = DriverManager.getConnection(url,"usuario","senha");
            System.out.println("Conexão aberta com sucesso!");
            
            String sql = "CREATE TABLE exercicio (nome VARCHAR (50), sobrenome VARCHAR (50) , idade INTEGER, atualizado TIMESTAMP)";
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(sql);
            System.out.println("Tabela Criada!");
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver indisponivel!");
            Logger.getLogger(Criatabela.class.getName()).log(Level.SEVERE, null, ex);    
        } catch (SQLException ex) {
            System.err.println("Problema ao acessar o banco!");
            Logger.getLogger(Criatabela.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
