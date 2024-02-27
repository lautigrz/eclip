package ar.edu.unlam.pb1.dominio;

public class Coche {

	private int identificador;

//Completar atributos, constructor, getter, setters y métodos necesarios para asegurar el correcto funcionamiento.

	public Coche(double combustible, Piloto piloto) {

		this.identificador = (int) (Math.random() * ((Integer.MAX_VALUE - 1) + 1)) + 1;
	}

	public int getIdentificador() {
		return 0;
	}

	public int getKilometrosRecorridos() {
		return 0;
	}

	public void setKilometrosRecorridos(int kilometros) {
	}

	public void setCantidadDeCombustible(double cantidadDeCombustible) {
	}

	public boolean getMedalla() {
		return false;
	}

	public void setMedalla(boolean medalla) {

	}

}
