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
	public List<Cliente> buscarClientePorNome(String nome) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome = :n", Cliente.class);
		query.setMaxResults(3);
		query.setParameter("n", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {	
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :p", Cliente.class).setParameter("p", estado).getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReservas(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d", Cliente.class).setParameter("d", dias).getResultList();
	}


}
