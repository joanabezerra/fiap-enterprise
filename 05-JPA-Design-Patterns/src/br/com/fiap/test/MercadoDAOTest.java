package br.com.fiap.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.MercadoDAO;
import br.com.fiap.dao.impl.MercadoDAOImpl;
import br.com.fiap.entity.CategoriaMercado;
import br.com.fiap.entity.Mercado;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

class MercadoDAOTest {
	
	private static MercadoDAO dao;
	private Mercado mercado;
	
	@BeforeEach
	public void antesDeCadaTeste() {
		//Arrange - Instanciar as classes
		mercado = new Mercado("Andorinha", 
				"Santana", CategoriaMercado.HIPER, 
				new GregorianCalendar(1999,Calendar.AUGUST,1));
			
			//Act - chamar o método
			try {
				dao.cadastrar(mercado);
				dao.commit();
			} catch (CommitException e) {
				e.printStackTrace();
				fail("Falha no commit");
			}
	}
	
	@BeforeAll //executa antes de todos os testes
	public static void init() {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("teste");
		EntityManager em = fabrica.createEntityManager();
		dao = new MercadoDAOImpl(em);
	}

	@Test
	@DisplayName("Teste de busca do DAO genérico")
	void buscaTest() {	
		try {
			Mercado busca = dao.buscar(mercado.getCodigo());

			//Arrange - validação do resultado
			assertNotNull(busca);
			assertEquals("Andorinha", busca.getNome());
			
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
			fail("Falha na pesquisa");
		}
		
	}
	
	@Test
	void cadastrarTest() {
		//Assert - validar o resultado
		//O banco gerou um código para o mercado..
		assertNotEquals(0, mercado.getCodigo());
		
	}
	
	@Test
	void alterar() {
		//alterar
		mercado.setNome("Adenilton Shop");
		//buscar e validar se alterou
		
		try {
			dao.cadastrar(mercado);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha no commit");
		}
		
		try {
			Mercado busca = dao.buscar(mercado.getCodigo());

			//Arrange - validação do resultado
			assertNotNull(busca);
			assertEquals("Adenilton Shop", busca.getNome());
			
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
			fail("Falha na pesquisa");
		}
		
	}
	
	@Test
	void delete() throws CodigoInvalidoException {				
		try {
			dao.remover(mercado.getCodigo());
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			fail("Falha na remoção!");
		}
		
		try {
			Mercado busca = dao.buscar(mercado.getCodigo());
			fail("Falha");
		} catch(CodigoInvalidoException e) {
			//Sucessi
		}
		
		assertThrows(CodigoInvalidoException.class, 
				() -> dao.buscar(mercado.getCodigo()));
		
	}

}
