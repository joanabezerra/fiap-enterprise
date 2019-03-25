package br.com.fiap.entify;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "usuario", sequenceName = "SQ_USUARIO", allocationSize = 1)
@Table(name = "T_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_usuario")
	private int codigo;
	
	@Column(name = "nm_usuario", nullable = false, length = 50)
	private String nome;

}
