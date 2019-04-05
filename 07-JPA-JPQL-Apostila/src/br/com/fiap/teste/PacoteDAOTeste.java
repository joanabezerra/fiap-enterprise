package br.com.fiap.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOTeste {
	
	private static PacoteDAO dao;
	
	@BeforeAll
	public static void iniciar() {
		dao = new PacoteDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@Test
	public void buscarPorTransporte() {
		Transporte transporte = new Transporte();
		transporte.setId(1);
		List<Pacote> pacotes = dao.buscarPorTransporte(transporte);
		assertEquals(3, pacotes.size());
	}

}
