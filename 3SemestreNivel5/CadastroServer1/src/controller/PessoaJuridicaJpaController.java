package controller;

import java.sql.Connection;

import connection.Conexao;

public class PessoaJuridicaJpaController {

	private Connection conn;

	public PessoaJuridicaJpaController() {
		conn = Conexao.getConnection();
	}
	
}
