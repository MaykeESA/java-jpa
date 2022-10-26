package br.com.alura.loja.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConFactory implements AutoCloseable{

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
	EntityManager em;
	
	public ConFactory() {
		this.em = this.factory.createEntityManager();
		this.em.getTransaction().begin();
	}
	
	public EntityManager getEm() {
		return em;
	}

	@Override
	public void close() throws Exception {
		this.em.getTransaction().commit();
		this.em.close();
		System.out.println("Conexão Fechada!");
	}
}
