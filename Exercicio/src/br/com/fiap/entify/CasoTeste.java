package br.com.fiap.entify;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name = "cd_sistema")
	private Sistema sistema;
	
	@OneToMany(mappedBy = "casoTeste", cascade = CascadeType.PERSIST)
	private List<ItemTeste> itensTetes = new ArrayList<>();
	
	@Column(name = "nm_caso_teste", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "ds_caso_teste", length = 550)
	private String descricao;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
