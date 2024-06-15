package model;

import java.io.Serializable;

public class PessoaJuridica implements Serializable {
	private static final long serialVersionUID = 123456789L;
	
	private int idPessoaJuridica;
	private String nome;
	private String logradouro;
	private String cidade;
	private String estado;
	private String telefone;
	private String email;
	private String cnpj;

	public PessoaJuridica(int idPessoaJuridica, String nome, String logradouro, String cidade, String estado,
			String telefone, String email, String cnpj) {
		super();
		this.idPessoaJuridica = idPessoaJuridica;
		this.nome = nome;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
		this.cnpj = cnpj;
	}

	public int getIdPessoaJuridica() {
		return idPessoaJuridica;
	}

	public void setIdPessoaJuridica(int idPessoaJuridica) {
		this.idPessoaJuridica = idPessoaJuridica;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		return "PessoaJuridica [idPessoaJuridica=" + idPessoaJuridica + ", nome=" + nome + ", logradouro=" + logradouro
				+ ", cidade=" + cidade + ", estado=" + estado + ", telefone=" + telefone + ", email=" + email
				+ ", cnpj=" + cnpj + "]";
	}

}
