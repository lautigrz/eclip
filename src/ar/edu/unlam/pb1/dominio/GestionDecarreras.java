package ar.edu.unlam.pb1.dominio;

import java.util.Random;

public class GestionDecarreras {

	private final int NUMERO_GESTION = 5;

	public boolean validarNumeroDeGestion(String numeroDeGestion) {

		/*
		 * Deberá validad el número de gestión recibido como parametro, cuya longitud se
		 * encuentra definida y determinar si la clave está compuesta de solo números y
		 * tiene el tamaño indicado. Aplique las validaciones correspondientes. Puede
		 * utilizar el metodo Character.isDigit().
		 * 
		 */

		boolean clave = false;

		for (int i = 0; i < numeroDeGestion.length(); i++) {
			if (numeroDeGestion.length() == NUMERO_GESTION && Character.isDigit(numeroDeGestion.charAt(i))) {
				clave = true;
			}

			else {
				clave = false;
				break;
			}
		}

		return clave;
	}

	public Coche[] ordenarPosicionesPorNumerodeIdentificador(Coche[] posiciones) {

		/*
		 * Debera ordenar el array de coches ingresados por el numero de identificador
		 * de cada coche y devolver el array ordenado con los autos en posicion para
		 * iniciar la carrera Aplique las validaciones correspondientes.
		 */

		for (int i = 0; i < posiciones.length; i++) {
			for (int j = 0; j < posiciones.length - 1; j++) {

				if (posiciones[j] != null && posiciones[j + 1] != null
						&& posiciones[j].getIdentificador() > posiciones[j + 1].getIdentificador()) {

					Coche aux = posiciones[j];
					posiciones[j] = posiciones[j + 1];
					posiciones[j + 1] = aux;
				}

			}
		}

		return posiciones;
	}

	public Coche[] generarCarreras(Coche[] posiciones) {

		/*
		 * Complete las consignas solicitadas (7) para que el metodo funcione de manera
		 * correcta
		 * 
		 */
		int distanciaDeLaPista = 100; // Distancia total de la pista de carreras
		boolean meta = false;
		Random rand = new Random();
		int kilometrosRecorridos = 0;
		double combustibleConsumido = 0;
		boolean ganador = false;

		// 1-Modifique la condicion para que los coches puedan iniciar la carrera

		while (!meta) {

			for (int i = 0; i < posiciones.length; i++) {

				// Mover el coche actual

				// 2-Complete la expresion con un metodo de la clase Random para que cada auto
				// avance en la carrera
				kilometrosRecorridos = rand.nextInt(12);

				posiciones[i].setKilometrosRecorridos(kilometrosRecorridos);

				// 4-Complete la expresion con un metodo de la clase Random para determinar el
				// combustible que consume durante la carrera

				combustibleConsumido = rand.nextDouble() * 3.2;

				posiciones[i].setCantidadDeCombustible(combustibleConsumido);

				// Mostrar la posición actual del coche

				// 5-Complete la condicion para determinar si hubo un ganador

				if (!meta) {
					System.out.print("Coche " + posiciones[i].getIdentificador() + ": ");
					for (int j = 0; j < distanciaDeLaPista; j++) {
						if (j == posiciones[i].getKilometrosRecorridos()) {
							// Dibujamos la posicion actual del coche
							System.out.print(">");
						} else {
							// Dibujamos la posicion actual de la pista
							System.out.print("-");
						}
					}

					// Verificar si el coche recorrio toda la distancia de la pista y ha llego a la
					// meta

					// 6-Complete la condicion para determinar si algun coche recorrio toda la
					// distancia de la pista
					if (posiciones[i].getKilometrosRecorridos() >= distanciaDeLaPista) {
						posiciones[i].setMedalla(true);
						meta = true;
						ganador = true;
					}
					System.out.println();
				}
			}
			System.out.println();
		}
		// 7-El metodo debe devolver el array de coches para conocer las posiciones
		// finales de los coches durante la carrera.
		return posiciones;
	}

	public String otorgarPremioAlCocheGanador(Coche[] posiciones) {

		/*
		 * este método busca al ganador de la carrera para otorgar el premio y devuelve
		 * todos los datos del coche y del piloto a fin de mostrar en pantalla la
		 * descripción del mismo acompañado del texto “Ganador de la carrera y entrega
		 * del premio a”.
		 */

		boolean seEncontroGanador = false;
		int contador = 0;
		String mensajeGanador = " ";

		while (!seEncontroGanador && contador < posiciones.length) {
			if (posiciones[contador] != null && posiciones[contador].getMedalla()) {

				mensajeGanador = "Ganador de la carrera y entrega del premio a " + posiciones[contador].toString();
				seEncontroGanador = true;
			}
			contador++;
		}
		return mensajeGanador;
	}

	public String obtenerlaCantidadMaximaDeKilometrosRecorridos(Coche[] posiciones) {

		/*
		 * Este método permite obtener el identificador, la cantidad de kilómetros
		 * recorridos totales del coche de carreras que mas kilómetros recorrió en la
		 * pista para llegar a la meta y el apellido del piloto
		 */
		Coche aux = posiciones[0];
		for (int i = 0; i < posiciones.length; i++) {

			if (posiciones[i] != null && posiciones[i].getKilometrosRecorridos() > aux.getKilometrosRecorridos()) {

				aux = posiciones[i];
			}
		}

		String cocheConMasKm = "Identificacion del coche:" + aux.getIdentificador() + "\n"
				+ "Cantidad de kilometros recorridos:" + aux.getKilometrosRecorridos() + "\n" + "Apellido:"
				+ aux.getPiloto().getApellido();

		return cocheConMasKm;
	}

	public Coche[] vaciarListaDePosiciones(Coche[] posiciones) {

		/*
		 * devuelve vacía la lista de posiciones para poder ingresar nuevamente los
		 * pilotos y coches y generar una nueva carrera.
		 */

		for (int i = 0; i < posiciones.length; i++) {
			if (posiciones[i] != null) {
				posiciones[i] = null;
			}
		}
		return posiciones;
	}
}
