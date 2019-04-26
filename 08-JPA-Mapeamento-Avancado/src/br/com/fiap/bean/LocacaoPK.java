package br.com.fiap.bean;

import java.io.Serializable;

public class LocacaoPK implements Serializable{
	
	private int codigo;
	
	private int carro;
	
	private int cliente;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carro;
		result = prime * result + cliente;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocacaoPK other = (LocacaoPK) obj;
		if (carro != other.carro)
			return false;
		if (cliente != other.cliente)
			return false;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
}
