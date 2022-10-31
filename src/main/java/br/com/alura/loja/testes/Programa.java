package br.com.alura.loja.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.model.Categoria;
import br.com.alura.loja.model.Produto;
import br.com.alura.loja.util.ConFactory;

public class Programa {

	public static void main(String[] args) {
		try (ConFactory conFactory = new ConFactory()) {
			EntityManager em = conFactory.getEm();
			
			CategoriaDAO categoriaDao = new CategoriaDAO(em);
			ProdutoDao produtoDao = new ProdutoDao(em);
			 
			List<Produto> listaP = produtoDao.buscarNomeCategoria("Moto");
			
			System.out.println("X-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=X");
			listaP.forEach(p -> System.out.println(p.getId() + " | " + p.getDescricao() + " | R$ " + p.getPreco()));
			System.out.println("X-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=X");			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
