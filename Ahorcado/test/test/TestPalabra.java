package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Palabra;
import domain.Palabra.Dificultad;

public class TestPalabra {

	@Test
	public void testGetPalabra() {
		Palabra p = new Palabra("teclado", Dificultad.FACIL);
		
		assertEquals("teclado", p.getClass());
	}

	@Test
	public void testSetPalabra() {
		Palabra p = new Palabra("teclado", Dificultad.FACIL);
		
		p.setPalabra("raton");
		
		assertEquals("raton", p.getPalabra());
	}
	
	@Test
	public void testGetDificultad() {
		Palabra p = new Palabra("teclado", Dificultad.FACIL);
		
		assertEquals(Dificultad.FACIL, p.getDificultad());
	}
	
	@Test
	public void testSetDificultad() {
		Palabra p = new Palabra("teclado", Dificultad.FACIL);
		
		p.setDificultad(Dificultad.DIFICIL);
		
		assertEquals(Dificultad.DIFICIL, p.getDificultad());
	}
}
