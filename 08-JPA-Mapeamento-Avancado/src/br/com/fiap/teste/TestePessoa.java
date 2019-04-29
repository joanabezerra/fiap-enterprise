package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.bean.Pessoa;
import br.com.fiap.bean.PessoaFisica;
import br.com.fiap.bean.PessoaJuridica;
import br.com.fiap.dao.PessoaDAO;
import br.com.fiap.dao.impl.PessoaDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class TestePessoa {

	private static PessoaDAO dao;
	
	@BeforeAll
	private static void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PessoaDAOImpl(em);
	}
	
	@Test
	void herancaTest() {
		Pessoa p1 = new Pessoa("Joana");
		PessoaFisica p2 = new PessoaFisica("Joana PF", "477.134.418-32", Calendar.getInstance());
		PessoaJuridica p3 = new PessoaJuridica("Joana PF", "477.134.418-32", Calendar.getInstance());
		
		dao.cadastrar(p1);
		dao.cadastrar(p2);
		dao.cadastrar(p3);
		try {
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			fail("Errouuu!");
		}
		
	}

}
