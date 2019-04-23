package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer>{

	List<Cliente> listar();
	
	List<Cliente> buscarPorNomeECidade(String nome, String cidad);
	
	long contarPorEstado(String estado);
	
	List<Cliente> buscarPorEstados(List<String> estados);
	
	List<Cliente> buscarClientePorNome(String string);

	List<Cliente> buscarPorEstado(String estado);
	
	List<Cliente> buscarPorDiasReservas(int dias);
	
}
