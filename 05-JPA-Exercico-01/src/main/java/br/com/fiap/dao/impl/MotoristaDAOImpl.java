package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Motorista;
import br.com.fiap.dao.exception.CodigoInvalidoException;
import br.com.fiap.dao.exception.CommitException;

public class MotoristaDAOImpl {
	
	private EntityManager em;
		
	public MotoristaDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Motorista motorista) {
		em.persist(motorista);
	}
	
	public void atualizar(Motorista motorista) {
		em.find(Motorista.class, motorista.getCarteira());
		em.merge(motorista);
	}
	
	public Motorista buscar(int codigo) {
		return em.find(Motorista.class, codigo);
	}
	
	public void deletar(int codigo) throws CodigoInvalidoException{
		Motorista motorista = buscar(codigo);
		if(motorista == null) {
			throw new CodigoInvalidoException();
		}
		em.remove(motorista);
	}
	
	public void commit() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}