package br.com.fiap.teste.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class TesteBuscaCliente {
	
	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Cliente c = em.find(Cliente.class, 7);
		
		System.out.println(c.getNome());
		
		//em.getTransaction().begin();
		//em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}

}
