package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Veiculo;
import br.com.fiap.dao.exception.CodigoInvalidoException;
import br.com.fiap.dao.exception.CommitException;

public class VeiculoDAOImpl {
	
	private EntityManager em;
	
	public VeiculoDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void cadastrar(Veiculo veiculo) {
		em.persist(veiculo);
		
	}
	
	public void atualizar(Veiculo veiculo) {
		em.find(Veiculo.class, veiculo.getCodigo());
		em.merge(veiculo);
	}
	
	public Veiculo buscar(int codigo) {
		return em.find(Veiculo.class, codigo);
	}
	
	public void deletar(int codigo) throws CodigoInvalidoException{
		Veiculo veiculo = buscar(codigo);
		if(veiculo == null) {
			throw new CodigoInvalidoException();
		}
		em.remove(veiculo);
	}
	
	void commit() throws CommitException {
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