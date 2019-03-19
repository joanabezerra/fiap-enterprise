package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_CLIENTE")
@SequenceGenerator(name = "SQ_CLIENTE", sequenceName = "SQ_T_CLIENTE", allocationSize = 1)
public class Cliente {
	
	@Id
	@Column(name = "CD_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="produto")
	private int codigo;
	
	@OneToOne(mappedBy= "cliente")
	private CarrinhoCompras carrinho;
	
	@Column(name = "NM_CLIENTE", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "NR_CPF", length = 11)
	private String cpf;

}
