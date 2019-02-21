package br.com.fiap.teste.cliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Sexo;

public class TesteCadastrarCliente {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Cliente c = new Cliente("Joana", 123456, 
			new GregorianCalendar(2000, Calendar.JULY, 28), Sexo.FEMININO, false, null);
		
		em.persist(c);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
	}
	
}
