package controller;

import java.sql.Connection;

import connection.Conexao;

public class PessoafisicaJpaController {

	private Connection conn;

	public PessoafisicaJpaController() {
		conn = Conexao.getConnection();
	}
	
}
