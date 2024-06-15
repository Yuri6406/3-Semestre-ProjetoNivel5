package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

private static Connection conn;

    
    public static Connection getConnection(){

        try {
            String url = "jdbc:mysql://127.0.0.1:3306/loja?useTimezone=true&serverTimezone=UTC";
            String user = "root";
            String password = "root6406";
            
            // Conexão
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

    
	}
}
