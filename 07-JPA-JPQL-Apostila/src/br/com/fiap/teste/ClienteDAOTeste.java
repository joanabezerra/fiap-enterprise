package br.com.fiap.teste;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.entity.Cliente;

public class ClienteDAOTeste {
	
	private static ClienteDAO dao;
	
	@BeforeAll
	public static void iniciar() {
		dao = new ClienteDAOImpl(EntityManagerFactorySingleton.getInstance().createEntityManager());
	}
	
	@Test
	public void listar() {
		List<Cliente> lista = dao.listar();
		assertEquals(5, lista.size());
	}

	@Test
	public void buscarClientePorNome(Cliente cliente) {
		
		cliente.setNome("Julio");
		
		List<Cliente> lista = dao.buscarClientePorNome(cliente);
		
		fail("Julio");
	}
	
}
