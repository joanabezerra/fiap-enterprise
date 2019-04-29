package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@DiscriminatorValue("PF")
@Entity
public class PessoaFisica extends Pessoa{
	
	@Column(name="NR_CPF")
	private String cpf;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_ABERTURA")
	private Calendar dataAbertura;
	
	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, String cpf, Calendar dataAbertura) {
		super(nome);
		this.cpf = cpf;
		this.dataAbertura = dataAbertura;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCnpj(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

}
