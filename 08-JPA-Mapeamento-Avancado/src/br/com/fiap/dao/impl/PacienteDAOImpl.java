package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.bean.Consulta;
import br.com.fiap.bean.Paciente;
import br.com.fiap.dao.PacienteDAO;

public class PacienteDAOImpl extends GenericDAOImpl<Paciente, Integer> implements PacienteDAO{

	public PacienteDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public void cadastrar(Consulta consulta) {}

}
