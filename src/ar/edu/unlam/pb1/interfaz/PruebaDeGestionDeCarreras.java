package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;
import ar.edu.unlam.pb1.dominio.Coche;
import ar.edu.unlam.pb1.dominio.GestionDecarreras;
import ar.edu.unlam.pb1.dominio.MenuPrincipal;
import ar.edu.unlam.pb1.dominio.Piloto;

public class PruebaDeGestionDeCarreras {

	private static final int CANTIDAD_DE_COCHES = 5;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String numeroDeGestion = "";
		GestionDecarreras actual = new GestionDecarreras();

		/*
		 * se debe ingresar por teclado un numero de gestión, formado solamente por
		 * números y validar el número de gestión (por ejemplo 20240222). En caso de
		 * haber ingresado mal la clave, se deberá volver a pedirla hasta que se ingrese
		 * un numero de gestión valido.
		 */

		boolean gestion = false;

		do {
			numeroDeGestion = ingresarNumeroDeGestion();
			gestion = actual.validarNumeroDeGestion(numeroDeGestion);

		} while (!gestion);

		MenuPrincipal opcionMenuPrincipal = null;
		int numeroIngresado = 0;
		boolean pilotosIngresados = false;

		// La cantidad de coches debe definirla para la prueba *generando la constante
		// CANTIDAD_DE_COCHES
		Coche[] posiciones = new Coche[CANTIDAD_DE_COCHES];

		do {
			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEntero();
			opcionMenuPrincipal = obtenerOpcionDelMenuPrincipal(numeroIngresado);

			switch (opcionMenuPrincipal) {

			case INSCRIBIR_CORREDORES:
				/*
				 * debe inscribir a los pilotos usando el metodo inscribirPilotos, ordenar los
				 * coches en las posiciones usando el metodo
				 * *ordenarPosicionesPorNumerodeIdentificador, según el número de
				 * identificación, y mostrar los autos en las posiciones de *la pista para
				 * generar la carrera usando el metodo mostrarPosiciones. La cantidad de coches
				 * debe definirla para la prueba *generando la constante CANTIDAD_DE_COCHES. Una
				 * vez que han inscripto todos los corredores para la carrera, debe cerrarse *la
				 * inscripción. En caso de querer ingresar mas corredores se debe mostrar un
				 * mensaje de error.
				 */
				if (pilotosIngresados) {
					mostrarPorPantalla("No hay mas cupo");
				} else {
					inscribirPilotos(posiciones);
					actual.ordenarPosicionesPorNumerodeIdentificador(posiciones);
					mostrarPosiciones(posiciones);
					pilotosIngresados = true;
				}
				break;
			case GENERAR_CARRERAS:

				mostrarPorPantalla("\nGanador de la carrera y entrega del premio a:\n");
				/*
				 * generar las carreras con el metodo generarCarreras, y mostrar por pantalla
				 * (con el metodo mostrarPorPantalla) al *ganador para recibir el premio. Usar
				 * el metodo otorgarPremioAlCocheGanador.
				 */

				actual.generarCarreras(posiciones);

				mostrarPorPantalla(actual.otorgarPremioAlCocheGanador(posiciones));
				break;

			case DETERMINAR_ESTADISTICAS:
				mostrarPorPantalla("\n\tAnalisis de parametros finales de cada coche despues de la carrera\n");

				/*
				 * mostra por pantalla los valores finales de cada coche después de la carrera y
				 * todos los datos del coche con más *kilometres recorridos. Ademas debe mostrar
				 * por pantalla el auto que tuvo la cantidad máxima de kilómetros recorridos
				 * *durante la carrera y debe vaciar la lista de posiciones de los coches y
				 * permitir volver a inscribir a los próximos *corredores.
				 */

				mostrarPorPantalla("\nCoche con mas kilometros recorridos:\n");

				break;
			case SALIR:
				break;
			// Complete la opcion de la excepcion correspondiente
			}
			// Completar la condicion para que funcione correctamente
		} while (false);

		// Libere todos los recursos usados para finalizar el programa
	}

	private static void mostrarPorPantalla(String mensaje) {

		System.out.println(mensaje);
	}

	private static String ingresarNumeroDeGestion() {

		// Complete el metodo para ingresar un numero de gestion y lo devuelva al metodo
		// llamador.
		mostrarPorPantalla("Ingrese numero de gestion");
		return sc.next();
	}

	private static void mostrarMenuPrincipal() {

		// Complete las opciones correspondientes al menu principal

		System.out.println("\n\tSeleccione alguna de las siguientes opciones\n");

		String menu = "\t1-" + "" + ". Asigna los corredores a los autos de carrera" + "\n\t2-" + ""
				+ ". Genera las carreras segun dias y categorias determinadas" + "\n\t3-" + ""
				+ ". Estima las estadisticas de la semana" + "\n\t4-" + "" + ". Finaliza el programa";

		mostrarPorPantalla(menu + "\n\n\tIngrese la opcion deseada");
	}

	private static int ingresarNumeroEntero() {
		// Complete el metodo para ingresar un numero de tipo entero y lo devuelva al
		// metodo llamador.
		return sc.nextInt();
	}

	private static MenuPrincipal obtenerOpcionDelMenuPrincipal(int numeroIngresado) {
		return MenuPrincipal.values()[numeroIngresado - 1];
	}

	private static String ingresarDescripcion() {
		// Complete el metodo para ingresar un texto y lo devuelva al metodo llamador.

		return sc.next();
	}

	private static double ingresarNumeroDecimal() {
		// Complete el metodo para ingresar un numero de tipo decimal y lo devuelva al
		// metodo llamador.
		return sc.nextDouble();
	}

	private static Coche[] inscribirPilotos(Coche[] posiciones) {

		/*
		 * solicita el nombre y apellido de cada piloto y la cantidad de combustible
		 * para el coche de carreras y determina un lugar en la lista de posiciones.
		 * Debe realizar las validaciones correspondientes
		 */
		mostrarPorPantalla("\t\tIngrese los datos del piloto\n'");

		for (int i = 0; i < posiciones.length; i++) {

			mostrarPorPantalla("Ingrese nombre:");
			String nombre = ingresarDescripcion();
			mostrarPorPantalla("Ingrese apellido:");
			String apellido = ingresarDescripcion();
			mostrarPorPantalla("Ingrese combustible:");
			double combustible = ingresarNumeroDecimal();

			Piloto piloto = new Piloto(nombre, apellido);

			Coche coche = new Coche(combustible, piloto);

			posiciones[i] = coche;

		}

		return posiciones;
	}

	private static void mostrarPosiciones(Coche[] posiciones) {

		/*
		 * muestra todos los datos de los coche de carrera y la ubicación en las
		 * posiciones indicadas. Debe realizar las validaciones correspondientes.
		 */

		for (int i = 0; i < posiciones.length; i++) {

			if (posiciones[i] != null) {
				mostrarPorPantalla(posiciones.toString());
			}
		}
	}

	private static void parametrosFinalesDeCadaCocheDespuesDeLaCarrera(Coche[] posiciones) {

		// deberá mostrar todos los datos correspondientes a cada coche de carreras
		// después de la carrera.
		// Debe realizar las validaciones correspondientes.
	}
}
