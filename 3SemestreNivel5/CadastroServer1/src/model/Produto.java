package model;

import java.io.Serializable;
import java.util.Iterator;

public class Produto implements Serializable {
	private static final long serialVersionUID = 123456789L;

	private int idProduto;
	private String nome;
	private int quantidade;
	private float precoVenda;

	public Produto(int idProduto, String nome, int quantidade, float precoVenda) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	@Override
	public String toString() {

		System.out.println(" id  " + "  nome" + " " + "quantidade   " + "    "+"   precoVenda \n     ");

		return " " + idProduto + "  " + nome + " " + quantidade + "  " + precoVenda;
	}
}
