package br.com.fiap.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_LOCACAO")
@IdClass(LocacaoPK.class)
public class Locacao {
	
	@Id
	@SequenceGenerator(name="locacao", sequenceName="SQ_LOCACAO", allocationSize=1)
	@GeneratedValue(generator="locacao", strategy=GenerationType.SEQUENCE)
	@Column(name="CD_CODIGO")
	private int codigo;
	
	@Id
	@ManyToOne
	@JoinColumn(name="CD_CARRO")
	private Carro carro;
	
	@Id
	@ManyToOne
	@JoinColumn(name="CD_CLIENTE")
	private Cliente cliente;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_DATA")
	private Calendar data;
	
	@Column(name="NR_DIAS")
	private int dias;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public int getDias() {
		return dias;
	}
	
	public void setDias(int dias) {
		this.dias = dias;
	}	

}

