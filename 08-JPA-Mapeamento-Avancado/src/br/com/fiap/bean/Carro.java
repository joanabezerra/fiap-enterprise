package br.com.fiap.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="carro", sequenceName="SQ_CARRO", allocationSize=1)
@Table(name="T_CARRO")
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="carro")
	@Column(name="CD_CODIGO", nullable=false)
	private int codigo;
	
	@Column(name="DS_PLACA", length=7, nullable=false)
	private String placa;
	
	@Column(name="DS_MODELO", nullable=false)
	private String modelo;
	
	public Carro() {
		super();
	}
	
	public Carro(String placa, String modelo) {
		super();
		this.placa = placa;
		this.modelo = modelo;
	}

	public Carro(int codigo, String placa, String modelo) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.modelo = modelo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
