package br.com.fiap.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PACINETE")
@SequenceGenerator(name="paciente", sequenceName="SQ_PACIENTE", allocationSize=1)
public class Paciente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paciente")
	@Column(name="CD_PACIENTE")
	private int codigo;
	
	@Column(name="NM_PACIENTE", nullable=false, length=20)
	private String nome;
	
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
	
}
