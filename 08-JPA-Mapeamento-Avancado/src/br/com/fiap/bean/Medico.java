package br.com.fiap.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
@SequenceGenerator(name="medico", sequenceName="SQ_MEDICO", allocationSize=1)
public class Medico {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="medico")
	@Column(name="CD_MEDICO", nullable=false)
	private int codigo;
	
	@Column(name="NM_MEDICO", nullable= false, length=20)
	private String nome;
	
	@Column(name="DS_ESPECIALIDADE", nullable = false, length=40)
	private String especialidade;
	
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
