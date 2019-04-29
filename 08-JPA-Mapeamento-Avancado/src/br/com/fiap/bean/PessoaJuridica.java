package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PessoaJuridica extends Pessoa{
	
	@Column(name="NR_CNPJ")
	private String cnpj;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_NASCIMENTO")
	private Calendar dataNascimento;
	
	public PessoaJuridica() {
		super();
	}
	
	public PessoaJuridica(String nome, String cnpj, Calendar dataNascimento) {
		super(nome);
		this.cnpj = cnpj;
		this.dataNascimento = dataNascimento;
	}

	public String getCpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}
