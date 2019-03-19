package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "SQ_ITEM_CARRINHO", sequenceName = "SQ_T_ITEM_CARRINHO", allocationSize = 1)
@Table(name = "T_ITEM_CARRINHO")
public class ItemCarrinho {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemCarrinho")
	@Column(name = "CD_ITEM_CARRINHO")
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "CD_PRODUTO")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "CD_CARRINHO", nullable = false)
	private CarrinhoCompras carrinho;
	
	@Column(name = "NR_ITENS")
	private int quantidade;
	
	@Column(name = "VL_ITEM")
	private double valor;
	
}
