package lppo.exercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InsereRegistro2 {
    
    public static void main(String[] args) {
    
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            String url = "jdbc:derby://localhost:1527/lppo-2017-1";
            Connection conexao = DriverManager.getConnection(url,"usuario","senha");
            System.out.println("Conexão aberta com sucesso!");
            
            Random rnd= new Random();
            String sql = "INSERT INTO produto(nome, sobrenome,idade) VALUES('Exercicio "
                    + rnd.nextInt(50) + "',"
                    + rnd.nextInt(200) + ")" ;
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(sql);
            System.out.println("Registro inserido!");
            
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver indisponivel!");
            Logger.getLogger(InsereRegistro2.class.getName()).log(Level.SEVERE, null, ex);    
        } catch (SQLException ex) {
            System.err.println("Problema ao acessar o banco!");
            Logger.getLogger(InsereRegistro2.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
}
