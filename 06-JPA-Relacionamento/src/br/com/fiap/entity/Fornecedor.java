package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SQ_FORNECEDOR", sequenceName = "SQ_T_FORNECEDOR", allocationSize = 1)
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Fornacedor")
	@Column(name = "CD_FORNECEDOR")
	private int codigo;
	
	@ManyToMany
	private Produto produto;
	
	@Column(name = "NM_NOME")
	private String nome;
	
	@Column(name = "NM_CNPJ")
	private String cnpj;
	
}
