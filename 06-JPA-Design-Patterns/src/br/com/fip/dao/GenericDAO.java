package br.com.fip.dao;

import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

public interface GenericDAO<T, K> {

	void cadastrar(T entidade);
	
	void alterar(T entidade);
	
	T buscar(K codigo) throws CodigoInvalidoException;
	
	void remover(K codigo) throws CodigoInvalidoException;
	
	void commit() throws CommitException;
	
}