package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Consulta;
import br.com.fiap.bean.Locacao;
import br.com.fiap.dao.LocacaoDAO;

public class LocacaoDAOImpl extends GenericDAOImpl<Locacao, Integer> implements LocacaoDAO{

	public LocacaoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cadastrar(Consulta consulta) {}

}
