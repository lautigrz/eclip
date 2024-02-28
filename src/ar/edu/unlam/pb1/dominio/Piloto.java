package ar.edu.unlam.pb1.dominio;

public class Piloto {

	// Completar atributos, constructor, getter, setters y métodos necesarios para
	// asegurar el correcto funcionamiento
	
	private String nombre;
	private String apellido;
	
	public Piloto(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
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

	@Override
	public String toString() {
		return "Piloto [nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	

}
