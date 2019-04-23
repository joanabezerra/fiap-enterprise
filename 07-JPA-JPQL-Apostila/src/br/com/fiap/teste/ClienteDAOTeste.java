package br.com.fiap.teste;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
		assertNotEquals(0, lista.size());
	}

	@Test
	public void buscarClientePorNome() {
		List<Cliente> lista = dao.buscarClientePorNome("Le");
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().indexOf("Le") > -1);
		}
	}
	
	@Test
	void buscarPorEstado() {
		List<Cliente> lista = dao.buscarPorEstado("SP");
		for (Cliente cliente : lista) {
			assertEquals("SP", cliente.getEndereco().getCidade().getUf());
		}
	}
	
	@Test
	void buscarPorDiasReserva() {
		List<Cliente> lista = dao.buscarPorDiasReservas(10);
		assertNotEquals(0, lista.size());
	}
	
	@Test
	void buscarPorNomeECidade() {
		List<Cliente> lista = dao.buscarPorNomeECidade("Le", "Lon");
		for (Cliente cliente : lista) {
			assertTrue(cliente.getNome().contains("Le") && 
					cliente.getEndereco().getCidade().getNome().contains("Lon"));
		}
	}
	
	@Test
	void buscarPorEstados() {
		List<String> estados = new ArrayList<String>();
		estados.add("PR");
		estados.add("SP");
		
		List<Cliente> lista = dao.buscarPorEstados(estados);
		
		for (Cliente cliente : lista) {
			assertTrue(estados.contains(cliente.getEndereco().getCidade().getUf()));
		}
	}
	
	@Test 
	void contarPorEstado() {
		long qtd = dao.contarPorEstado("SP");
		assertEquals(1, qtd);
	}
	
}
