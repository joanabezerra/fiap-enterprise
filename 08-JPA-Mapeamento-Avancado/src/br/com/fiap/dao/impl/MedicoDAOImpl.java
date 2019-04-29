package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Consulta;
import br.com.fiap.bean.Medico;
import br.com.fiap.dao.MedicoDAO;

public class MedicoDAOImpl extends GenericDAOImpl<Medico, Integer> implements MedicoDAO{

	public MedicoDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public void cadastrar(Consulta consulta) {}

}
