package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		//Criar query
		TypedQuery<Pacote> buscarPorTransporte = em.createQuery("from Pacote where Transporte = :t", Pacote.class);
		//setar os parametros
		buscarPorTransporte.setParameter("t", transporte);
		//Executar Query
		return buscarPorTransporte.getResultList();
	}
	
}
