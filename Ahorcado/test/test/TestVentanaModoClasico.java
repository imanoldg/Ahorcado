package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import gui.VentanaModoClasico;

public class TestVentanaModoClasico {

	@Test
	public void testSeleccionarPalabra() {
		String palabraSeleccionada = VentanaModoClasico.SeleccionarPalabra();

        assertNotNull(palabraSeleccionada);
        assertFalse(palabraSeleccionada.isEmpty());
        assertTrue(palabraSeleccionada.equals(palabraSeleccionada.toUpperCase()));
	}
	
	public void testOcultarPalabra() {
		String palabraOriginal = "EJEMPLO";
		StringBuilder palabraOculta = VentanaModoClasico.ocultarPalabra(palabraOriginal);
		
		assertEquals(palabraOriginal.length(),palabraOculta.length());
		assertTrue(palabraOculta.toString().matches("-"));
		
	}
		
}
