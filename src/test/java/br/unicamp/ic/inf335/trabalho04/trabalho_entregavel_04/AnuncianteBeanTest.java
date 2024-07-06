package br.unicamp.ic.inf335.trabalho04.trabalho_entregavel_04;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnuncianteBeanTest {

    private AnuncianteBean anunciante;
    private AnuncioBean anuncio1;
    private AnuncioBean anuncio2;
    private ArrayList<AnuncioBean> anuncios;

    @BeforeEach
    void setUp() throws URISyntaxException, MalformedURLException {
        ProdutoBean produto1 = new ProdutoBean();
        produto1.setValor(100.0);
        ArrayList<URL> fotosUrl1 = new ArrayList<>();
        fotosUrl1.add(new URI("http://www.foo.com/1.jpg").toURL());
        anuncio1 = new AnuncioBean(produto1, fotosUrl1, 0.1);

        ProdutoBean produto2 = new ProdutoBean();
        produto2.setValor(200.0);
        ArrayList<URL> fotosUrl2 = new ArrayList<>();
        fotosUrl2.add(new URI("http://www.foo.com/2.jpg").toURL());
        anuncio2 = new AnuncioBean(produto2, fotosUrl2, 0.2);

        anuncios = new ArrayList<AnuncioBean>();
        anuncios.add(anuncio1);
        anuncios.add(anuncio2);

        anunciante = new AnuncianteBean("nome", "123", anuncios);
    }

    @Test
    void testGetNome() {
        assertEquals("nome", anunciante.getNome());
    }

    @Test
    void testSetNome() {
        anunciante.setNome("nome2");
        assertEquals("nome2", anunciante.getNome());
    }

    @Test
    void testGetCPF() {
        assertEquals( "123", anunciante.getCPF());
    }

    @Test
    void testSetCPF() {
        anunciante.setCPF("987");
        assertEquals("987", anunciante.getCPF());
    }

    @Test
    void testGetAnuncios() {
        assertEquals(anuncios, anunciante.getAnuncios());
    }

    @Test
    void testSetAnuncios() {
        ArrayList<AnuncioBean> novosAnuncios = new ArrayList<>();
        novosAnuncios.add(anuncio1);
        anunciante.setAnuncios(novosAnuncios);
        assertEquals(novosAnuncios, anunciante.getAnuncios());
    }

    @Test
    void testAddAnuncio() throws URISyntaxException, MalformedURLException  {
        ProdutoBean produto3 = new ProdutoBean();
        produto3.setValor(300.0);
        ArrayList<URL> fotosUrl3 = new ArrayList<URL>();
        fotosUrl3.add(new URI("http://www.foo.com/3.jpg").toURL());
        AnuncioBean anuncio3 = new AnuncioBean(produto3, fotosUrl3, 0.3);

        anunciante.addAnuncio(anuncio3);
        assertTrue(anunciante.getAnuncios().contains(anuncio3));
    }

    @Test
    void testRemoveAnuncio() {
        anunciante.removeAnuncio(0);
        assertEquals(1, anunciante.getAnuncios().size());
        assertEquals(anuncio2, anunciante.getAnuncios().get(0));
    }

    @Test
    void testValorMedioAnuncios() {
        Double valorMedioEsperado = (anuncio1.getValor() + anuncio2.getValor()) / 2;
        assertEquals(valorMedioEsperado, anunciante.valorMedioAnuncios());
    }
}