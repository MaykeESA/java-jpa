package br.com.alura.loja.dao;

import java.util.List;

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

	public Produto buscarPorId(Long id) {
		return em.find(Produto.class, id);
	}

	public List<Produto> buscarTodos() {
		return em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}
	
	public List<Produto> buscarNome(String nome) {
		return em.createQuery("SELECT p FROM Produto p WHERE p.nome = :nome", Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
	
	public List<Produto> buscarNomeCategoria(String nome) {
		return em.createQuery("SELECT p FROM Produto p WHERE p.categoria.nome = :nome", Produto.class)
				.setParameter("nome", nome)
				.getResultList();
	}
}
