package br.com.fiap.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="cliente", sequenceName="SQ_CLIENTE", allocationSize=1)
@Table(name="T_CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente")
	@Column(name="CD_CLIENTE", nullable=false)
	private int codigo;
	
	@Column(name="NM_NOME", nullable=false, length=20)
	private String nome;
	
	@Column(name="NR_CNH", nullable=false)
	private long cnh;
	
	public Cliente() {
		super();
	}
	
	public Cliente(String nome, long cnh) {
		super();
		this.nome = nome;
		this.cnh = cnh;
	}

	public Cliente(int codigo, String nome, long cnh) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnh = cnh;
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
	
	public long getCnh() {
		return cnh;
	}
	
	public void setCnh(long cnh) {
		this.cnh = cnh;
	}
	
}
