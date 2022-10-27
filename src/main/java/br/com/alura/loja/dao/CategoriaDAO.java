package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Categoria;

public class CategoriaDAO {

	private EntityManager em;
	
	public CategoriaDAO(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Categoria c) {
		this.em.persist(c);
	}
	
	public void atualizar(Categoria c) {
		this.em.merge(c);
	}
	
	public void remover(Categoria c) {
		c = this.em.merge(c);
		this.em.remove(c);
	}
	
}
