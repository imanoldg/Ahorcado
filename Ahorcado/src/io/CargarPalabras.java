package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Palabra;
import domain.Palabra.Dificultad;



public class CargarPalabras {
	public static List<Palabra> cargarPalabras(String fichero) {
		
		List<Palabra> listaPalabras = new ArrayList<Palabra>();
		List<String> lista = new ArrayList<>();
		
		Scanner scanner;
		try {
			scanner = new Scanner(new File(fichero));
			while (scanner.hasNextLine()) {
				lista.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			
			System.out.println("El fichero no se ha abierto");
		}
		
		for (int i = 0; i < lista.size(); i++) {
			if(i > 62) {
				listaPalabras.add(new Palabra(lista.get(i),Dificultad.FACIL));
			}else {
				listaPalabras.add(new Palabra(lista.get(i),Dificultad.DIFICIL));
			}
		}
		
		return listaPalabras;
	}
	
}
