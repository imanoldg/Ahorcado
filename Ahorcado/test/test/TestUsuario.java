package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import domain.Usuario;

public class TestUsuario {
	
	private Usuario u;
	
	@Before
	public void setUp() {
		u = new Usuario(1, "Imanol", "test", 20 , 40, 50);
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Imanol", u.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		u.setNombre("Carlos");
		
		assertEquals("Carlos", u.getNombre());
	}
	
	@Test
	public void testGetCod() {
		assertEquals(1, u.getCod());
	}
	
	@Test
	public void testSetCod() {
		u.setCod(2);
		
		assertEquals(2, u.getCod());
	}
	
	@Test
	public void testGetContraseña() {
		assertEquals("test", u.getContraseña());
	}
	
	@Test
	public void testSetContraseña() {
		u.setContraseña("prueba");
		
		assertEquals("prueba", u.getContraseña());
	}
	
	@Test
	public void testGetPuntuacionClasico() {
		assertEquals(20, u.getPuntuacionClasico());
	}
	
	@Test
	public void testSetPuntuacionClasico() {
		u.setPuntuacionClasico(100);
		
		assertEquals(100, u.getPuntuacionClasico());
	}
	
	@Test
	public void testGetPuntuacionContrarreloj() {
		assertEquals(40, u.getPuntuacionContrarreloj());
	}
	
	@Test
	public void testSetPuntuacionContrarreloj() {
		u.setPuntuacionContrarreloj(100);
		
		assertEquals(100, u.getPuntuacionContrarreloj());
	}
	
	@Test
	public void testGetPuntuacionSubita() {
		assertEquals(50, u.getPuntuacionSubita());
	}
	
	@Test
	public void testSetPuntuacionSubita() {
		u.setPuntuacionSubita(400);
		assertEquals(400, u.getPuntuacionSubita());
	}
}
