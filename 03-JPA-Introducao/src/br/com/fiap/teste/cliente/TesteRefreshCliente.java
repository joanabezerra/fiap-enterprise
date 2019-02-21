package br.com.fiap.teste.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Cliente;

public class TesteRefreshCliente {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		Cliente c = em.find(Cliente.class, 7);
		
		System.out.println(c.getNome());
		c.setNome("Caio");
		
		System.out.println(c.getNome());
		
		em.refresh(c);
		System.out.println(c.getNome());
		
		em.close();
		fabrica.close();
		
	}
	
}
