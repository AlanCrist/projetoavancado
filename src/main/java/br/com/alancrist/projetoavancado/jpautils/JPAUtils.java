package br.com.alancrist.projetoavancado.jpautils;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class JPAUtils {
	
	private static EntityManagerFactory factory = null;
	
	static {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("projetoavancado");
		}
		
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
