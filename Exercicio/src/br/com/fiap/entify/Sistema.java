package br.com.fiap.entify;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_SISTEMA")
@SequenceGenerator(name = "sistema", sequenceName = "SQ_SISTEMA", allocationSize = 1)
public class Sistema {
	
	@Id
	@GeneratedValue(generator = "sistema", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_sistema")
	private int codigo;
	
	@OneToMany(mappedBy="sistema", cascade =  CascadeType.PERSIST)
	private List<CasoTeste> casosTestes = new ArrayList<>();
	
	@Column(name = "nm_sistema", nullable = false, length = 50)
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
