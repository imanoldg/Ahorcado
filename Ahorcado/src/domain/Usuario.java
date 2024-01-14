package domain;

public class Usuario {
	public int cod;
	public String nombre;
	public String contraseña;
	public int puntuacionClasico;
	public int puntuacionContrarreloj;
	public int puntuacionSubita;

	//Constructor con argumentos
	
	public Usuario(int cod, String nombre, String contraseña, int puntuacionClasico, int puntuacionContrarreloj,
			int puntuacionSubita) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.puntuacionClasico = puntuacionClasico;
		this.puntuacionContrarreloj = puntuacionContrarreloj;
		this.puntuacionSubita = puntuacionSubita;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getPuntuacionClasico() {
		return puntuacionClasico;
	}

	public void setPuntuacionClasico(int puntuacionClasico) {
		this.puntuacionClasico = puntuacionClasico;
	}

	public int getPuntuacionContrarreloj() {
		return puntuacionContrarreloj;
	}

	public void setPuntuacionContrarreloj(int puntuacionContrarreloj) {
		this.puntuacionContrarreloj = puntuacionContrarreloj;
	}

	public int getPuntuacionSubita() {
		return puntuacionSubita;
	}

	public void setPuntuacionSubita(int puntuacionSubita) {
		this.puntuacionSubita = puntuacionSubita;
	}

	@Override
	public String toString() {
		return String.format("Usuario: %s, Puntuacion Modo Clasico: %d ; Puntuacion Modo Contrarreloj: %d ; Puntuacion Modo Muerte Subita: %d", 
				nombre, puntuacionClasico, puntuacionContrarreloj, puntuacionSubita);
	}
	
	
}
