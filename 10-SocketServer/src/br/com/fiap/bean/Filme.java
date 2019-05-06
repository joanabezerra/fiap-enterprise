package br.com.fiap.bean;

import java.io.Serializable;

public class Filme implements Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 5095903696817442257L;

	private String nome;
	
	private int duracao;
	
	private Genero genero;
	
	public Filme(String nome, int duracao, Genero genero) {
		super();
		this.nome = nome;
		this.duracao = duracao;
		this.genero = genero;
	}

	public Filme() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
