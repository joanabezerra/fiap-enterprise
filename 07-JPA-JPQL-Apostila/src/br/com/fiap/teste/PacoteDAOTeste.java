package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
