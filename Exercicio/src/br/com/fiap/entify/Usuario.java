package br.com.fiap.entify;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(mappedBy = "usuarios")
	private List<ItemTeste> itensTestes = new ArrayList<>();
	
	@Column(name = "nm_usuario", nullable = false, length = 50)
	private String nome;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
