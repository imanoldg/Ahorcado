package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import DataBase.MetodosBD;

public class TestMetodosBD {
	
	private MetodosBD metodos;
	
	@Before
	public void setUp() {
		metodos = new MetodosBD();
	}
	
	@SuppressWarnings("static-access")
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
