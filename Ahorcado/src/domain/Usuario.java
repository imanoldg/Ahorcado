package domain;

public class Usuario {
	public int cod;
	public String nombre;
	public String contraseña;
	public int puntuacion;
	
	//Constructor con argumentos
	public Usuario(int cod, String nombre, String contraseña, int puntuacion) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.puntuacion = puntuacion;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	@Override
	public String toString() {
		return "Usuario: " + nombre  + "; Puntuacion: " + puntuacion;
	}
	
	
}
