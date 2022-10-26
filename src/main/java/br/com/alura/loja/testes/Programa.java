package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import br.com.alura.loja.factory.ConFactory;
import br.com.alura.loja.model.Produto;

public class Programa {

	public static void main(String[] args) {
		try (ConFactory conFactory = new ConFactory()) {
			EntityManager em = conFactory.getEm();

			Produto p = new Produto();
			p.setNome("Logitech G27");
			p.setDescricao("Volante Simulador");
			p.setPreco(new BigDecimal(1200));

			em.persist(p);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
