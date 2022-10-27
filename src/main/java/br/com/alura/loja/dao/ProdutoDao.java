package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.loja.model.Produto;

public class ProdutoDao {

	private EntityManager em;
	
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void salvar(Produto p) {
		this.em.persist(p);
	}
	
	public void atualizar(Produto p) {
		this.em.merge(p);
	}
	
	public void remover(Produto p) {
		p = this.em.merge(p);
		this.em.remove(p);
	}
}
