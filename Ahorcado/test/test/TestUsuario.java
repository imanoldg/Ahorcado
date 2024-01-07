package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import domain.Usuario;

public class TestUsuario {
	
	@Test
	public void testGetNombre() {
		Usuario u = new Usuario(1,"Imanol", "test", 20 );
	
		assertEquals("Imanol", u.getNombre());
		
	}
	
	@Test
	public void testSetNombre() {
		Usuario u = new Usuario(1,"Imanol", "test", 20 );
		
		u.setNombre("Carlos");
		
		assertEquals("Carlos", u.getNombre());
	}
	
	@Test
	public void testGetCod() {
		Usuario u = new Usuario(1,"Imanol", "test", 20 );
		
		assertEquals(1, u.getCod());
	}
	
	@Test
	public void testSetCod() {
		Usuario u = new Usuario(1,"Imanol", "test", 20 );
		
		u.setCod(2);
		
		assertEquals(2, u.getCod());
	}
	
	@Test
	public void testGetContraseña() {
		Usuario u = new Usuario(1,"Imanol", "test", 20 );
		
		assertEquals("test", u.getContraseña());
	}
	
	@Test
	public void testSetContraseña() {
		Usuario u = new Usuario(1,"Imanol", "test", 20 );
		
		u.setContraseña("prueba");
		
		assertEquals("prueba", u.getContraseña());
	}
	
	@Test
	public void testGetPuntuacion() {
		Usuario u = new Usuario(1,"Imanol", "test", 20);
	
		assertEquals(20, u.getPuntuacion());
	}
	
	@Test
	public void testSetPuntuacion() {
		Usuario u = new Usuario(1,"Imanol", "test", 20);
		
		u.setPuntuacion(100);
		
		assertEquals(100, u.getPuntuacion());
	}
	
	@Test
	public void testToString() {
		Usuario u = new Usuario(1,"Imanol", "test", 20 );
		
		assertEquals("Usuario: Imanol; Puntuacion: 20", u.toString());
	}

}
