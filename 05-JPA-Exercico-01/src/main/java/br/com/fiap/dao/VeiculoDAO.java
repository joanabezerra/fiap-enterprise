package br.com.fiap.dao;

import br.com.fiap.bean.Veiculo;

public interface VeiculoDAO {
	
	void cadastrar(Veiculo veiculo);
	
	void atualizar(Veiculo veiculo);
	
	Veiculo buscar(int codigo);
	
	void deletar(Veiculo veiculo);
	
	void commit();

}