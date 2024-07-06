package br.unicamp.ic.inf335.trabalho04.trabalho_entregavel_04;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnuncioBeanTest {
	
    private AnuncioBean anuncio;
    private ProdutoBean produto;
    private ArrayList<URL> fotosUrl;
    private Double desconto;
	
    @BeforeEach
    void setUp() throws URISyntaxException, MalformedURLException  {
        produto = new ProdutoBean();
        produto.setValor(100.0);
        fotosUrl = new ArrayList<>();
        fotosUrl.add(new URI("http://www.foo.com/1.jpg").toURL());
        fotosUrl.add(new URI("http://www.foo.com/2.jpg").toURL());
        desconto = 0.2;
        anuncio = new AnuncioBean(produto, fotosUrl, desconto);
    }
	

    @Test
    void testGetProduto() {
        assertEquals(produto, anuncio.getProduto());
    }

    @Test
    void testSetProduto() {
        ProdutoBean novoProduto = new ProdutoBean();
        novoProduto.setValor(200.0);
        anuncio.setProduto(novoProduto);
        assertEquals(novoProduto, anuncio.getProduto());
    }

    @Test
    void testGetFotosUrl() {
        assertEquals(fotosUrl, anuncio.getFotosUrl());
    }

    @Test
    void testSetFotosUrl() throws URISyntaxException, MalformedURLException {
        ArrayList<URL> novasFotos = new ArrayList<>();
        novasFotos.add(new URI("http://www.foo.com/3.jpg").toURL());
        anuncio.setFotosUrl(novasFotos);
        assertEquals(novasFotos, anuncio.getFotosUrl());
    }

    @Test
    void testGetDesconto() {
        assertEquals(desconto, anuncio.getDesconto());
    }

    @Test
    void testSetDesconto() {
        Double novoDesconto = 0.5;
        anuncio.setDesconto(novoDesconto);
        assertEquals(novoDesconto, anuncio.getDesconto());
    }

    @Test
    void testGetValor() {
        Double valorEsperado = produto.getValor() - (produto.getValor() * desconto);
        assertEquals(valorEsperado, anuncio.getValor());
    }
}