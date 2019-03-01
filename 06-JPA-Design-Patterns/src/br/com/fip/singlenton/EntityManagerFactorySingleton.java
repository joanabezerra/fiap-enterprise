package br.com.fip.singlenton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	// 1- atributo estatico que sera unico
	private static EntityManagerFactory emf;
	
	//2- Construtor vazio e privado
	private EntityManagerFactorySingleton() {}
	
	//3- metodo estatico que retorn a unica instancia
	public static EntityManagerFactory getInstance() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}
		return emf;
	}

}