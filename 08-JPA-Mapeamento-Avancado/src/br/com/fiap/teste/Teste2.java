package br.com.fiap.teste;

import static org.junit.Assert.fail;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.bean.Consulta;
import br.com.fiap.bean.Medico;
import br.com.fiap.bean.Paciente;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.impl.ConsultaDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Teste2 {
	
	private static ConsultaDAO dao;
	
	@BeforeAll
	private static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new ConsultaDAOImpl(em);
	}

	@Test
	void test() {
		Medico medico = new Medico(123, "Joana", "Clinica", 100000, 420);
		Paciente paciente = new Paciente("Joana");
		Consulta consulta = new Consulta(medico, paciente, Calendar.getInstance(), "Nada");
		
		try {
			dao.cadastrar(consulta);
			dao.commit();
		} catch (Exception e) {
			fail("Errou");
			e.printStackTrace();
		}
		
	}

}
