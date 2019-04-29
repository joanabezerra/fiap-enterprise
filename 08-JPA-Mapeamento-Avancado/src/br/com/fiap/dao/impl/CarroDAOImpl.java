package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Carro;
import br.com.fiap.bean.Consulta;
import br.com.fiap.dao.CarroDAO;

public class CarroDAOImpl extends GenericDAOImpl<Carro, Integer> implements CarroDAO{

	public CarroDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cadastrar(Consulta consulta) {
		
	}

}
