package br.com.fiap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "SQ_PRODUTO", sequenceName = "SQ_T_PRODUTO", allocationSize = 1)
@Table(name = "T_PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Produto")
	@Column(name = "CD_PRODUTO")
	private int codigo;
	
	@ManyToMany(mappedBy = "produto")
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy="produto")
	private List<ItemCarrinho> item;
	
	@Column(name = "NM_NOME")
	private String nome;
	
	@Column(name = "VL_VALOR")
	private double valor;
	
}
