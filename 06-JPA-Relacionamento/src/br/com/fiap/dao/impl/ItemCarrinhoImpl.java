package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ItemCarrinhoDAO;
import br.com.fiap.entity.ItemCarrinho;

public class ItemCarrinhoImpl extends GenericDAOImpl<ItemCarrinho, Integer> implements ItemCarrinhoDAO{

	public ItemCarrinhoImpl(EntityManager em) {
		super(em);
	}

}
