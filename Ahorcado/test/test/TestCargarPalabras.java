package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Palabra;
import domain.Palabra.Dificultad;
import io.CargarPalabras;

public class TestCargarPalabras {

	@Test
	public void testCargarPalabras() {
        List<Palabra> listaPalabras = CargarPalabras.cargarPalabras("resources/data/palabras.csv");

        assertNotNull(listaPalabras);
        assertFalse(listaPalabras.isEmpty());

        // Verificar que las primeras palabras tengan la dificultad esperada
        for (int i = 0; i < 63; i++) {
            if (i > 62) {
                assertEquals(Dificultad.FACIL, listaPalabras.get(i).getDificultad());
            } else {
                assertEquals(Dificultad.DIFICIL, listaPalabras.get(i).getDificultad());
            }
        }
	}

}
