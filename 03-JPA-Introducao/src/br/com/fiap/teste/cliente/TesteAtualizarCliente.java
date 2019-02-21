package br.com.fiap.teste.cliente;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Sexo;

public class TesteAtualizarCliente {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Cliente c = new Cliente(7, "Julia", 654321, 
				new GregorianCalendar(2003, Calendar.MARCH, 12), Sexo.FEMININO, true, null);
		
		em.merge(c);				
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		
	}
	
}
