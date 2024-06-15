package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Conexao;
import model.Usuario;

public class UsuarioJpaController extends Thread{
    private Connection conn;

    public UsuarioJpaController() {
        conn = Conexao.getConnection();
    }

    public boolean findUsuario(String login, String senha) {
        try {
            String query = "SELECT u FROM Usuario u WHERE u.login = ? AND u.senha = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return true;
            } else {
                return false; // Usuário não encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}