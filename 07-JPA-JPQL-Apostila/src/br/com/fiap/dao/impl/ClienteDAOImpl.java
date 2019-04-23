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
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where lower(c.nome) = lower(:n) order by c.nome", 
						Cliente.class);
		query.setMaxResults(3);
		query.setParameter("n", "%" + nome + "%");
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {	
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :p", Cliente.class)
				.setParameter("p", estado).getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReservas(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d", Cliente.class)
				.setParameter("d", dias).getResultList();
	}

	@Override
	public List<Cliente> buscarPorNomeECidade(String nome, String cidade) {
		return em.createNamedQuery("Cliente.porNomeECidade", Cliente.class)
				.setParameter("n", "%" + nome + "%").setParameter("e", "%" + cidade + "%").getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createNamedQuery("Cliente.porEstados", Cliente.class)
							.setParameter("e", estados).getResultList();
	}

	@Override
	public long contarPorEstado(String estado) {
		return em.createQuery("select count(c) from Cliente where c.endereco.cidade.uf = :e", Long.class)
			.setParameter("e", estado).getSingleResult();
	}


}
