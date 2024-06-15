package model;

import java.io.Serializable;

public class Movimento implements Serializable {
	private static final long serialVersionUID = 123456789L;

	private int idMovimento;
	private int quantidade;
	private char tipo;
	private float valorUnitario;
	private int idPessoaFisica;
	private int idPessoaJuridica;
	private int idProduto;
	private int idUsuario;

	public Movimento() {
	}

	public Movimento(int idMovimento) {
		this.idMovimento = idMovimento;
	}

	public Movimento(int idMovimento, int quantidade, char tipo, float valorUnitario) {
		super();
		this.idMovimento = idMovimento;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.valorUnitario = valorUnitario;
	}

	public Movimento(int idMovimento, int quantidade, char tipo, float valorUnitario, int idPessoaFisica,
			int idPessoaJuridica, int idProduto, int idUsuario) {
		super();
		this.idMovimento = idMovimento;
		this.quantidade = quantidade;
		this.tipo = tipo;
		this.valorUnitario = valorUnitario;
		this.idPessoaFisica = idPessoaFisica;
		this.idPessoaJuridica = idPessoaJuridica;
		this.idProduto = idProduto;
		this.idUsuario = idUsuario;
	}

	public int getIdMovimento() {
		return idMovimento;
	}

	public void setIdMovimento(int idMovimento) {
		this.idMovimento = idMovimento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int getIdPessoaFisica() {
		return idPessoaFisica;
	}

	public void setIdPessoaFisica(int idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	public int getIdPessoaJuridica() {
		return idPessoaJuridica;
	}

	public void setIdPessoaJuridica(int idPessoaJuridica) {
		this.idPessoaJuridica = idPessoaJuridica;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Movimento [idMovimento=" + idMovimento + ", quantidade=" + quantidade + ", tipo=" + tipo
				+ ", valorUnitario=" + valorUnitario + ", idPessoaFisica=" + idPessoaFisica + ", idPessoaJuridica="
				+ idPessoaJuridica + ", idProduto=" + idProduto + ", idUsuario=" + idUsuario + "]";
	}

}
