package br.com.fiap.bean;

import javax.persistence.Column;
// import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy=InheritanceType.JOINED)

// @DiscriminatorColumn(name="DS_TIPO")

@Entity
@Table(name="T_PESSOA")
@SequenceGenerator(name="pessoa", sequenceName="SQ_T_PESSOA", allocationSize=1)
public class Pessoa {

	@Id
	@Column(name="CD_PESSOA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pessoa")
	private int codigo;
	
	@Column(name="NM_PESSOA")
	private String nome;
	
	public Pessoa() {
		super();
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
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
	
}
