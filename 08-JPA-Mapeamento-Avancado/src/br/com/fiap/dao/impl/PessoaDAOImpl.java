package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Consulta;
import br.com.fiap.bean.Pessoa;
import br.com.fiap.dao.PessoaDAO;

public class PessoaDAOImpl extends GenericDAOImpl<Pessoa, Integer> implements PessoaDAO{

	public PessoaDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public void cadastrar(Consulta consulta) {}

}
