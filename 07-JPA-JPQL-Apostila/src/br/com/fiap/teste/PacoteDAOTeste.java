package br.com.fiap.teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
public class PacoteDAOTeste {
	
	private static PacoteDAO dao;
	private static TransporteDAO daoTransporte;
	
	@BeforeAll
	public static void iniciar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new PacoteDAOImpl(em);
		daoTransporte = new TransporteDAOImpl(em);
	}
	
	@Test
	public void buscarPorTransporte() {
		Transporte transporte = daoTransporte.pesquisar(1);
		List<Pacote> lista = dao.buscarPorTransporte(transporte);
		for (Pacote pacote : lista) {
			assertEquals(transporte.getId(), pacote.getTransporte().getId());			
		}
	}
	
	@Test
	void buscarPorDatas() {
		Calendar inicio = new GregorianCalendar(2017, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2018, Calendar.JANUARY, 1);
		
		List<Pacote> lista = dao.buscarPorDatas(inicio, fim);
		
		for (Pacote pacote : lista) {
			assertTrue(pacote.getDataSaida().after(inicio) && pacote.getDataSaida().before(fim));
		}
	}
	
	@Test
	void somarPrecoPorTransporte() {
		Transporte transporte = daoTransporte.pesquisar(1);
		double total = dao.somarPrecoPorTransporte(transporte);
		assertEquals(4300, total);
	}
	
	@Test
	void buscarPorPrecoMaximo() {
		List<Pacote> lista = dao.buscarPorPrecoMaximo(1000);
		for (Pacote pacote : lista) {
			assertTrue(pacote.getPreco() <= 1000);
		}
	}

}
