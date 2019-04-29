package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PacienteDAO;

public class Paciente extends GenericDAOImpl<Paciente, Integer> implements PacienteDAO{

	public Paciente(EntityManager em) {
		super(em);
	}

}
