package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class CargarPalabras {
	public static List<String> cargarPalabras(String fichero) throws FileNotFoundException {
		
		List<String> listaPalabras = new ArrayList<>();
		
		Scanner scanner = new Scanner(new File(fichero));
		while (scanner.hasNextLine()) {
			listaPalabras.add(scanner.nextLine());
		}
		scanner.close();
			
		return listaPalabras;
	}
	
}
