package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.bean.Carro;
import br.com.fiap.bean.Cliente;
import br.com.fiap.bean.Locacao;
import br.com.fiap.dao.LocacaoDAO;
import br.com.fiap.dao.impl.LocacaoDAOImpl;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Testes {
	
	private static LocacaoDAO dao;
	
	@BeforeAll
	private static void iniciarTeste() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new LocacaoDAOImpl(em);
	}

	@Test
	void cadastrarTudoTest() {
		Carro carro = new Carro();
		carro.setPlaca("123ASDF");
		carro.setModelo("Gol");
		
		Cliente cliente = new Cliente();
		cliente.setNome("Joana Moraes");
		cliente.setCnh(354344);
		
		Locacao loc = new Locacao();
		loc.setData(new GregorianCalendar(28, Calendar.JULY,2000));
		loc.setCliente(cliente);
		loc.setCarro(carro);
		loc.setDias(20);
		
		try {
			dao.cadastrar(loc);
			dao.commit();
		} catch (CommitException e) {
			fail("Erro");
			e.printStackTrace();
		}
	}

}
