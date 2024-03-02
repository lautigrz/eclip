package ar.edu.unlam.pb1.dominio;

public class Coche {

	private int identificador;
	private int kilometrosRecorridos;
	private boolean medalla = false;
	
//Completar atributos, constructor, getter, setters y métodos necesarios para asegurar el correcto funcionamiento.
	private static int numero = 0;
	private Piloto piloto;
	private double combustible;

	public Coche(double combustible, Piloto piloto) {
		this.identificador = numero++;
		this.combustible = combustible;
		this.piloto = piloto;
		this.identificador = (int) (Math.random() * ((Integer.MAX_VALUE - 1) + 1)) + 1;
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public int getKilometrosRecorridos() {
		return this.kilometrosRecorridos;
	}

	public void setKilometrosRecorridos(int kilometros) {
		this.kilometrosRecorridos += kilometros;
	}

	public void setCantidadDeCombustible(double cantidadDeCombustible) {
		this.combustible -= cantidadDeCombustible;
	}

	public double getCantidadDeCombustible() {
		return combustible;
	}

	public boolean getMedalla() {
		return medalla;
	}

	public void setMedalla(boolean medalla) {
		this.medalla = medalla;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
		return "Coche [identificador=" + identificador + ", kilometrosRecorridos=" + kilometrosRecorridos + ", medalla="
				+ medalla + ", piloto=" + piloto + ", combustible=" + combustible + "]";
	}
	
	

}
