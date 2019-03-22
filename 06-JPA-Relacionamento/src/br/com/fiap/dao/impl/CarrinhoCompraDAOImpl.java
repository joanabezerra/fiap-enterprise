package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CarrinhoComprasDAO;
import br.com.fiap.entity.CarrinhoCompras;

public class CarrinhoCompraDAOImpl extends GenericDAOImpl<CarrinhoCompras, Integer> 
															implements CarrinhoComprasDAO {
	
	public CarrinhoCompraDAOImpl(EntityManager em) {
		super(em);
	}

}
