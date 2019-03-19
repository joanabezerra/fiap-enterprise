package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "T_CARRINHO_COMPRAS")
@SequenceGenerator(name = "SQ_CARRINHO_COMPRAS", sequenceName = "SQ_T_CARRINHO_COMPRAS", allocationSize = 1)
public class CarrinhoCompras {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "carrinho")
	@Column(name = "CD_CARRINHO_COMPRAS")
	private int codigo;
	
	@OneToMany(mappedBy="carrinho")
	private List<ItemCarrinho> item;
	
	@OneToOne
	@JoinColumn(name = "CD_CLIENTE", nullable = false)
	private Cliente cliente;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DT_CARRINHO")
	private Calendar data;
	
	@Column(name = "VL_TOTAL", nullable = false)
	private double valorTotal;
	
}
