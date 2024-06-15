package model;

import java.io.Serializable;

public class PessoaFisica implements Serializable {
	private static final long serialVersionUID = 123456789L;

	private int idPessoaFisica;
	private String nome;
	private String logradouro;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	private String cpf;

	public PessoaFisica(int idPessoaFisica, String nome, String logradouro, String cidade, String estado,
			String telefone, String email, String cpf) {
		this.idPessoaFisica = idPessoaFisica;
		this.nome = nome;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
	}

	public int getIdPessoaFisica() {
		return idPessoaFisica;
	}

	public void setIdPessoaFisica(int idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "PessoaFisica [idPessoaFisica=" + idPessoaFisica + ", nome=" + nome + ", logradouro=" + logradouro
				+ ", cidade=" + cidade + ", estado=" + estado + ", telefone=" + telefone + ", email=" + email + ", cpf="
				+ cpf + "]";
	}

}
