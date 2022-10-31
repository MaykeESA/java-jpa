package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConFactory implements AutoCloseable{

	private static final EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory("loja");
	private EntityManager em;
	
	public ConFactory() {
		this.em = FACTORY.createEntityManager();
		this.em.getTransaction().begin();
	}
	
	public EntityManager getEm() {
		return em;
	}

	@Override
	public void close() throws Exception {
		this.em.getTransaction().commit();
		this.em.close();
		System.out.println("\nConexão Fechada!");
	}
}
