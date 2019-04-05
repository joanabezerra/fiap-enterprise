package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<Cliente> listar() {
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}
	
	@Override
	public List<Cliente> buscarClientePorNome(Cliente nome) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome = :n", Cliente.class);
		query.setParameter("n", "%" + nome + "%");
		return query.getResultList();
	}

}
