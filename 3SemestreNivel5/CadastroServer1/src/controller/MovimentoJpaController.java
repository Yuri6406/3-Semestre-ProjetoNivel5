package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Conexao;
import model.Movimento;

public class MovimentoJpaController extends Thread{
	private Connection conn;

	public MovimentoJpaController() {
		conn = Conexao.getConnection();
	}
	
	
	public void persist(Movimento movimento) throws SQLException {
		String sqlInsert = "INSERT INTO loja.movimento (idMovimento, quantidade, tipo, valorUnitario, idpessoafisica, idpessoajuridica, idproduto, idusuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert);
	    preparedStatement.setInt(1, movimento.getIdMovimento());
	    preparedStatement.setInt(2, movimento.getQuantidade());
	    preparedStatement.setString(3, movimento.getTipo());
	    preparedStatement.setDouble(4, movimento.getValorUnitario());
	    preparedStatement.setInt(5, movimento.getIdPessoaFisica());
	    preparedStatement.setInt(6, movimento.getIdPessoaJuridica());
	    preparedStatement.setInt(7, movimento.getIdProduto());
	    preparedStatement.setInt(8, movimento.getIdUsuario());
	    preparedStatement.executeUpdate();
	}
}
