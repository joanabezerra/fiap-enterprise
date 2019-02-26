package br.com.fiap.dao;

import br.com.fiap.bean.Motorista;

public interface MotoristaDAO {

	void cadastrar(Motorista motorista);
	
	void atualizar(Motorista motorista);
	
	Motorista buscar(int codigo);
	
	void deletar(Motorista motorista);
	
	void commit();
	
}