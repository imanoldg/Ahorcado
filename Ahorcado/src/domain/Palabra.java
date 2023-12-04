package domain;

public class Palabra {

	public enum Dificultad{
		FACIL,
		DIFICIL
	}
	
	public String palabra;
	public Dificultad dificultad;
	
	
	public Palabra(String palabra, Dificultad dificultad) {
		super();
		this.palabra = palabra;
		this.dificultad = dificultad;
	}


	public String getPalabra() {
		return palabra;
	}


	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}


	public Dificultad getDificultad() {
		return dificultad;
	}


	public void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}


	@Override
	public String toString() {
		return "Palabra: " + palabra + ", dificultad:" + dificultad;
	}


	public int length() {
		// TODO Auto-generated method stub
		return palabra.length();
	}


	public String toUpperCase() {
		// TODO Auto-generated method stub
		return palabra.toUpperCase();
	}
	
	
}
