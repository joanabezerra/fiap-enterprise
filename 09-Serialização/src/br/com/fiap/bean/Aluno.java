package br.com.fiap.bean;

import java.io.Serializable;

public class Aluno implements Serializable{	

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 2576015849280942637L;

	private String nome;
	
	private int rm;
	
	private boolean formato;

	public Aluno() {
		super();
	}

	public Aluno(String nome, int rm, boolean formato) {
		super();
		this.nome = nome;
		this.rm = rm;
		this.formato = formato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public boolean isFormato() {
		return formato;
	}

	public void setFormato(boolean formato) {
		this.formato = formato;
	}
	
}
