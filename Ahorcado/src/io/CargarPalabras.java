package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import domain.Palabra;
import domain.Palabra.Dificultad;

 

public class CargarPalabras {
	
	private static Logger log = LoggerReg.ejecutarLogger();
	
	//Metodo para cargar las palabras del fichero
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
			
			System.out.println("El fichero de palabras no se ha abierto");
		}
		
		for (int i = 0; i < lista.size(); i++) {
			if(i > 62) {
				listaPalabras.add(new Palabra(lista.get(i).toUpperCase(),Dificultad.FACIL));
			}else {
				listaPalabras.add(new Palabra(lista.get(i).toUpperCase(),Dificultad.DIFICIL));
			}
		}
		
		log.info("Palabras cargadas correctamente");
		return listaPalabras;
	}
	
}
