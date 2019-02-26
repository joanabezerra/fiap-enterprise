package br.com.fiap.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_VEICULO")
@SequenceGenerator(name="vaiculo", sequenceName="SQ_T_VEICULO", allocationSize = 1)
public class Veiculo {
	
	@Id
	@Column(name= "CD_VEICULO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo")
	private int codigo;
	
	@Column(name= "DS_PLACA", nullable=false, length = 7)
	private int placa;
	
	@Column(name= "DS_COR", nullable=false)
	private String cor;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "NR_ANO", nullable= false)
	private Date anoLancamento;
	
	public Veiculo(int placa, String cor, Date anoLancamento) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.anoLancamento = anoLancamento;
	}

	public Veiculo(int codigo, int placa, String cor, Date anoLancamento) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.cor = cor;
		this.anoLancamento = anoLancamento;
	}

	public Veiculo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Date getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}	

}
