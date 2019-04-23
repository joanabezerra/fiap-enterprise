package br.com.fiap.dao.impl;

import java.util.Calendar;
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
		TypedQuery<Pacote> buscarPorTransporte = em.createQuery("from Pacote p where p.transporte = :t", Pacote.class);
		//setar os parametros
		buscarPorTransporte.setParameter("t", transporte);
		//Executar Query
		return buscarPorTransporte.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class)
				.setParameter("i", inicio).setParameter("f", fim).getResultList();
	}

	@Override
	public double somarPrecoPorTransporte(Transporte transporte) {
		return em.createQuery("select sum(p.preco) from Pacote p where p.transporte = :t", Double.class)
				.setParameter("t", transporte).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pacote> buscarPorPrecoMaximo(double preco) {
		return em.createNativeQuery("SELECT * FROM T_PACOTE WHERE PRECO <= :p", Pacote.class)
				.setParameter("p", preco).getResultList();
	}
	
}
