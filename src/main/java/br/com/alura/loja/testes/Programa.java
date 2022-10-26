package br.com.alura.loja.testes;

import java.math.BigDecimal;
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
			
			Categoria categoria = new Categoria("Veículos");
			Produto produto = new Produto("Carro", 
									"Mitsubishi Lancer Evo", 
									new BigDecimal(230000), categoria);
			
			categoriaDao.salvar(categoria);
			produtoDao.salvar(produto);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
