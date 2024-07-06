package br.unicamp.ic.inf335.trabalho04.trabalho_entregavel_04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProdutoBeanTest {
	
	@Test
	void testGetCodigo() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		assertEquals(produto.getCodigo(), "codigo");
	}

	@Test
	void testSetCodigo() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		produto.setCodigo("codigo2");
		assertEquals(produto.getCodigo(), "codigo2");
	}

	@Test
	void testGetNome() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		assertEquals(produto.getNome(), "nome");
	}

	@Test
	void testSetNome() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		produto.setNome("nome2");
		assertEquals(produto.getNome(), "nome2");
	}

	@Test
	void testGetDescricao() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		assertEquals(produto.getDescricao(), "descricao");
	}

	@Test
	void testSetDescricao() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		produto.setDescricao("descricao2");
		assertEquals(produto.getDescricao(), "descricao2");
	}

	@Test
	void testGetValor() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		assertEquals(produto.getValor(), 10);
	}

	@Test
	void testSetValor() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		produto.setValor(11.);
		assertEquals(produto.getValor(), 11);
	}

	@Test
	void testGetEstado() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		assertEquals(produto.getEstado(), "estado");
	}

	@Test
	void testSetEstado() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		produto.setEstado("estado2");
		assertEquals(produto.getEstado(), "estado2");
	}

	@Test
	void testCompareTo() {
		ProdutoBean produto = new ProdutoBean("codigo", "nome", "descricao", 10.0, "estado");
		ProdutoBean produto2 = new ProdutoBean();
		produto2.setValor(100.0);
		assertEquals(produto.compareTo(produto2), -1);
		assertEquals(produto2.compareTo(produto), 1);
		assertEquals(produto.compareTo(produto), 0);
	}

}
