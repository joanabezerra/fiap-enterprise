package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Pastel;

public class BuscaTeste {

	public static void main(String[] args) {
		//Obter uma f�brica de entity manager
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Pesquisar um pastel de id = 1
		Pastel pastel = em.find(Pastel.class, 1);
		
		//Exibir o sabor do pastel
		System.out.println(pastel.getSabor());
		
		//fechar as paradas
		em.close();
		fabrica.close();
	}
	
}
