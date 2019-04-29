package br.com.fiap.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
@SecondaryTable(name="T_DADOS_MEDICO")
public class Medico {
	
	@Id
	@Column(name="CD_MEDICO", nullable=false)
	private int codigo;
	
	@Column(name="NM_MEDICO", nullable= false, length=20)
	private String nome;
	
	@Column(name="DS_ESPECIALIDADE", nullable = false, length=40)
	private String especialidade;
	
	@Column(name="VL_SALARIO", table="T_DADOS_MEDICO")
	private double salario;
	
	public Medico() {
		super();
	}
	
	@Column(name="NR_CONTA", table="T_DADOS_MEDICO")
	private int conta;
	
	public Medico(int codigo, String nome, String especialidade, double salario, int conta) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.especialidade = especialidade;
		this.salario = salario;
		this.conta = conta;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
}
