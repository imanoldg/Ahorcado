package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import DataBase.MetodosBD;
import domain.Usuario;

public class TestMetodosBD {
	
	private MetodosBD metodos;
	private Usuario usuario;
	
	@Before
	public void setUp() {
		metodos = new MetodosBD();
		usuario = new Usuario(52, "imanol", "prueba", 100, 0, 0);
	}
	
	@Test
	public void testExisteCod() {
		assertEquals(false, metodos.existeCod(52));
	}
	
	@Test
	public void testExisteNombre() {
		assertEquals(false, metodos.existeNombre("imanol"));
	}
	
	@Test
	public void testBusquedaUsuario() {
		assertEquals("imanol", metodos.buscarUsuario("imanol"));
	}
	
	@Test
	public void testRegisteredUser() {
		assertEquals("imanol", metodos.registeredUser("imanol", "prueba"));
	}
	
	@Test
	public void testCargarUsuarios() {
		assertEquals("imanol", metodos.obtenerUsuario("imanol").getNombre());
		assertEquals("prueba", metodos.obtenerUsuario("imanol").getContraseña());
		assertEquals(0, metodos.obtenerUsuario("imanol").getPuntuacionClasico());
	}
	
	
}
