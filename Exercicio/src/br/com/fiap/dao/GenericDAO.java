package br.com.fiap.dao;

import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T, K> {

	void Cadastrar(T entidade);
	
	void alterar(T entidade);
	
	T buscar(K codigo) throws CodigoInvalidoException;
	
	void remover(K codigo) throws CodigoInvalidoException;
	
	void commit() throws CommitException;

	void cadastrar(T entidade);
	
}