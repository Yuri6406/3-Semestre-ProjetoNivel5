package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.Conexao;
import model.Produto;

public class ProdutoJpaController extends Thread{
	
	private Connection conn;

	public ProdutoJpaController() {
		conn = Conexao.getConnection();
	}
	
	ArrayList<Produto> listaProduto = new ArrayList<Produto>();
	Statement stmt;
	
	public ArrayList<Produto> getListaProduto() {


		try {
			stmt = conn.createStatement();
			ResultSet resut = stmt.executeQuery("select * from produto");

			while (resut.next()) {
				Produto prod = new Produto(
						resut.getInt("idProduto"),
						resut.getString("nome"),
						resut.getInt("quantidade"),
						resut.getFloat("precoVenda")
						);

				listaProduto.add(prod);
				System.out.println(prod);

			}

			resut.close();
			stmt.close();
			conn.close();
			
			return listaProduto;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}


	public void atualizarQuantidade(int idProduto, int quantidade) {
		try {
            String query = "UPDATE loja.produto SET quantidade = ? WHERE idProduto = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,quantidade);
            stmt.setInt(2,idProduto);
            stmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
