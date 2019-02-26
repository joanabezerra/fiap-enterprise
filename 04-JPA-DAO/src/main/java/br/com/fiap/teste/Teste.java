package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.FarmaciaDAO;
import br.com.fiap.dao.impl.FarmaciaDAOImpl;
import br.com.fiap.entity.Farmacia;
import br.com.fiap.entity.TipoFarmacia;
import br.com.fiap.exception.CodigoInvalidoException;
import br.com.fiap.exception.CommitException;

public class Teste {
	
	public static void main(String[] args) {
		//Instanciar a galera
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		FarmaciaDAO dao = new FarmaciaDAOImpl(em);
		
		//cadastrar uma farmacia
		Farmacia farmacia = new Farmacia("Droga", 
				new GregorianCalendar(2000, Calendar.JULY, 28), TipoFarmacia.DROGARIA, true);
		
		
		try {
			dao.cadastrar(farmacia);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		//Atualiza
		farmacia.setNome("Drogazil");
		
		try {
			dao.atualizar(farmacia);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}		
		
		//Pesquisar
		Farmacia busca = dao.buscar(1);
		System.out.println(busca.getNome());		
		
		//Deletar
		
		try {
			dao.deletar(2);
			dao.commit();
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		
		em.close();
		fabrica.close();
		
		
	}

}
