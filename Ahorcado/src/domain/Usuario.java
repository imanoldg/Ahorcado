package domain;

public class Usuario {
	public String nombre;
	public String apellido;
	public String contraseña;
	public int puntuacion;
	
	//Constructor con argumentos
	public Usuario(String nombre, String apellido, String contraseña, int puntuacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.puntuacion = puntuacion;
	}
	
	//Constructor vacio
	public Usuario() {
		super();
		this.nombre = "Usuario sin nombre";
		this.apellido = "";
		this.contraseña = "Usuario sin contraseña";
		this.puntuacion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		return "Usuario: " + nombre + apellido + "; Puntuacion: " + puntuacion;
	}
	
	
}
