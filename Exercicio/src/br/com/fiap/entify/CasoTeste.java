package br.com.fiap.entify;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "casoTeste", sequenceName = "SQ_CASO_TESTE", allocationSize = 1)
@Table(name = "T_CASO_TESTE")
public class CasoTeste {
	
	@Id
	@GeneratedValue(generator = "casoTeste", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_caso_teste")
	private int codigo;
	
	@Column(name = "nm_caso_teste", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "ds_caso_teste", length = 550)
	private String descricao;

}
