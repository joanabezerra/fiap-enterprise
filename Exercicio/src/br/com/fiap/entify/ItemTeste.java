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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_ITEM_TESTE")
@SequenceGenerator(name = "item_teste", sequenceName = "SQ_ITEM_TESTE", allocationSize = 1)
public class ItemTeste {
	
	@Id
	@GeneratedValue(generator = "item_teste", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name = "nm_item_teste", nullable = false, length = 50)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "cd_caso_teste")
	private CasoTeste casoTeste;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "T_ITEM_TESTE_USUARIO", joinColumns = @JoinColumn(name = "cd_caso_teste"), inverseJoinColumns = @JoinColumn(name = "cd_usuario"))
	private List<Usuario> usuarios = new ArrayList<>();

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
