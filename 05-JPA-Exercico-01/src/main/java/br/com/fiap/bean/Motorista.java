package br.com.fiap.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name= "T_MOTORISTA")
public class Motorista {

	@Id
	@Column(name= "NR_CARTEIRA", nullable=false)
	private int carteira;
	
	@Column(name="NM_MOTORISTA", nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name= "DT_NASCIMENTO")
	private Date dataNascimento;
	
	@Lob
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="DS_GENERO")
	private Genero genero;
	
	public Motorista(int carteira, String nome, Date dataNascimento, Genero genero) {
		super();
		this.carteira = carteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero;
	}

	public Motorista(int carteira, String nome, Date dataNascimento, byte[] foto, Genero genero) {
		super();
		this.carteira = carteira;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.genero = genero;
	}

	public Motorista() {
		super();
	}

	public int getCarteira() {
		return carteira;
	}

	public void setCarteira(int carteira) {
		this.carteira = carteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
