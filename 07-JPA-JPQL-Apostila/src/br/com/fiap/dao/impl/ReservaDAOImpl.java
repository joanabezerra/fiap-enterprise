package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ReservaDAO;
import br.com.fiap.entity.Reserva;

public class ReservaDAOImpl extends GenericDAOImpl<Reserva,Integer> implements ReservaDAO {

	public ReservaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Reserva> listar() {
		//Criar a query
		TypedQuery<Reserva> query = em.createQuery("from Reserva", Reserva.class);
		//Executar a Query
		return query.getResultList();
	}
	
	@Override
	public List<Reserva> buscarPorData(Calendar data) {
		//criar a typequery
		TypedQuery<Reserva> query = em.createQuery("from Reserva r where r.dataReserva = :d", Reserva.class);
		
		//setar o parametro
		query.setParameter("d", data);
				
		//executar a typequery
		return query.getResultList();
	}

}
