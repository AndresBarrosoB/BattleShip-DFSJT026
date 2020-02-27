package cl.awakelab.clases;

/**
 * Esta es nuestra clase mas compleja y se encarga de instanciar nuestros arreglos unidimensionales,
 * en los cuales almacenaremos nuestras lista de objetos Carro y Huevo, nuestros arreglos 
 * bidimensionales, en los cuales graficaremos al usuario las posiciones de nuestros objetos Carro y 
 * Huevo. Ademas contiene metodos para 
 * 
 */
import java.util.ArrayList;

public class Tablero {

	Libreria librerias = new Libreria();

	// Atributos.
	private ArrayList<Huevo> huevazos;
	private Carro[] carrots;
	private String[][] cuadricula;
	private String[][] cuadriculaHuevos;

	/**
	 * Descripcion de Atributos.
	 * 
	 * @param huevazos:         Arreglo en el que iremos guardando nuestras
	 *                          instancias de Huevo.
	 * @param carrots:          Arreglo de tipo Carro que guarda las instancias de
	 *                          Carro.
	 * @param cuadricula:       Arreglo bidimencional en el que iremos graficando el
	 *                          progreso de nuestra simulacion. Al desplegarse,
	 *                          mostrara la ubicacion de nuestros objetos Carro y
	 *                          Huevo.
	 * @param cuadriculaHuevos: Arreglo bidimencional en el que iremos graficando el
	 *                          progreso de los Huevos lanzados por el usuario.
	 */

	// Constantes.
	private int TAMANO_CUADRICULA = 15;
	private int MAXIMO_CARROS = 18;
	private int MAX_RANDOM_FILA_KROMI = 13;
	private int MAX_RANDOM_COLUMNA_CAGUANO = 14;

	/**
	 * Descripcion de Constantes.
	 * 
	 * @param TAMANO_CUADRICULA:          Define los limites de los arreglos
	 *                                    "cuadricula" y "cuadriculaHuevos"
	 * @param MAXIMO_CARROS:              Define la cantidad maxima de instancias de
	 *                                    nuestra clase Carro y sus sub-clases.
	 * @param MAX_RANDOM_FILA_KROMI:      Define un limite en la coordenada fila
	 *                                    para la creacion de nuestras Kromis, ya
	 *                                    que al crearse una Kromi, esta se
	 *                                    extendera 2 espacios hacia abajo.
	 * @param MAX_RANDOM_COLUMNA_CAGUANO: Define un limite en la coordenada columna
	 *                                    para la creacion de nuestros Caguanos, ya
	 *                                    que al crearse un Caguano, este se
	 *                                    extendera 1 espacio hacia la derecha.
	 */

	// Constructor.
	public Tablero() {
		this.huevazos = new ArrayList<Huevo>();
		this.carrots = new Carro[MAXIMO_CARROS];
		this.cuadricula = new String[TAMANO_CUADRICULA][TAMANO_CUADRICULA];
		this.cuadriculaHuevos = new String[TAMANO_CUADRICULA][TAMANO_CUADRICULA];
	}

	// Metodos Set & Get.
	public ArrayList<Huevo> getHuevazos() {
		return huevazos;
	}

	public void setHuevazos(ArrayList<Huevo> huevazos) {
		this.huevazos = huevazos;
	}

	public Carro[] getCarrots() {
		return carrots;
	}

	public void setCarrots(Carro[] carrots) {
		this.carrots = carrots;
	}

	public String[][] getCuadricula() {
		return cuadricula;
	}

	public void setCuadricula(String[][] cuadricula) {
		this.cuadricula = cuadricula;
	}

	public String[][] getCuadriculaHuevos() {
		return cuadriculaHuevos;
	}

	public void setCuadriculaHuevos(String[][] cuadriculaHuevos) {
		this.cuadriculaHuevos = cuadriculaHuevos;
	}

	// Metodos complejos.
	/**
	 * Este metodo genera coordenadas aleatorias para instanciar nuestros objetos
	 * tipo Carro. De acuerdo a dichas coordenadas se rellenan los atributos de
	 * nuesstros constructores de las clases tipo Kromi, Caguano y Trupalla. Ademas
	 * registra los objetos en las celdas del arreglo bidimensional cuadricula.
	 */
	public void crearCarros() {

		// Rellena los espacios null de nuestra arreglo bidimensional "cuadricula" con
		// Strings vacios.
		for (int i = 0; i < cuadricula.length; i++) {
			for (int j = 0; j < cuadricula.length; j++) {
				if (cuadricula[i][j] == null) {
					cuadricula[i][j] = "";
				}
			}
		}
		// Rellena los espacios null de nuestra arreglo bidimensional "cuadriculaHuevos"
		// con Strings vacios.
		for (int i = 0; i < cuadriculaHuevos.length; i++) {
			for (int j = 0; j < cuadriculaHuevos.length; j++) {
				if (cuadriculaHuevos[i][j] == null) {
					cuadriculaHuevos[i][j] = "";
				}
			}
		}

		// Kromis
		for (int j2 = 0; j2 < 3; j2++) {
			int coordenadaFila;
			int coordenadaColumna;
			do {
				coordenadaFila = crearNumeroFila(MAX_RANDOM_FILA_KROMI);
				coordenadaColumna = crearNumeroColumna(cuadricula.length);
			} while (cuadricula[coordenadaFila][coordenadaColumna] != ""
					|| cuadricula[coordenadaFila + 1][coordenadaColumna] != ""
					|| cuadricula[coordenadaFila + 2][coordenadaColumna] != "");

			carrots[j2] = new Kromi((int) ((Math.random() * 31) + 15), librerias.rellenarFechaIngreso(),
					coordenadaColumna, coordenadaFila, librerias.rellenarAnoFabricacion(), librerias.rellenarMarca());
			cuadricula[coordenadaFila][coordenadaColumna] = "K";
			cuadricula[coordenadaFila + 1][coordenadaColumna] = "K";
			cuadricula[coordenadaFila + 2][coordenadaColumna] = "K";

		}
		// Caguanos
		for (int j2 = 3; j2 < 8; j2++) {
			int coordenadaFila;
			int coordenadaColumna;
			do {
				coordenadaFila = crearNumeroFila(cuadricula.length);
				coordenadaColumna = crearNumeroColumna(MAX_RANDOM_COLUMNA_CAGUANO);
			} while (cuadricula[coordenadaFila][coordenadaColumna] != ""
					|| cuadricula[coordenadaFila][coordenadaColumna + 1] != "");

			carrots[j2] = new Caguano((int) ((Math.random() * 3) + 2), librerias.rellenarFechaIngreso(),
					coordenadaColumna, coordenadaFila, (int) ((Math.random() * 6) + 15),
					librerias.rellenarColorConfeti());
			cuadricula[coordenadaFila][coordenadaColumna] = "C";
			cuadricula[coordenadaFila][coordenadaColumna + 1] = "C";
		}
		// Trupallas
		for (int j2 = 8; j2 < carrots.length; j2++) {
			int coordenadaFila;
			int coordenadaColumna;
			do {
				coordenadaFila = crearNumeroFila(cuadricula.length);
				coordenadaColumna = crearNumeroColumna(cuadricula.length);
			} while (cuadricula[coordenadaFila][coordenadaColumna] != "");

			carrots[j2] = new Trupalla((int) ((Math.random() * 5) + 1), librerias.rellenarFechaIngreso(),
					coordenadaColumna, coordenadaFila, (int) ((Math.random() * 5) + 1),
					librerias.rellenarNombreConductor(j2));
			cuadricula[coordenadaFila][coordenadaColumna] = "T";
		}

	}

	/**
	 * Este metodo busca de acuerdo a las coordenadas ingresadas por el usuario si
	 * en el arreglo bidimensional "cuadricula" existe alguna letra asociada a los
	 * objetos creados y dependiendo de su tipo, asigna valores al atributo
	 * "puntaje" de los objetos Huevo que se iran creando segun la decision del
	 * usuario.
	 * 
	 * @param coordenadaFila:    Parametro ingresado por el usuario.
	 * @param coordenadaColumna: Parametro ingresado por el usuario.
	 */
	public void lanzarHuevo(int coordenadaFila, int coordenadaColumna) {

		if (coordenadaFila >= 1 && coordenadaFila <= 15 && coordenadaColumna >= 1 && coordenadaColumna < +15) {

			int coordenadaFilaCuadricula = coordenadaFila - 1;
			int coordenadaColumnaCuadricula = coordenadaColumna - 1;
			if (cuadricula[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] == "") {
				cuadricula[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] = "H";
				cuadriculaHuevos[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] = "H";
				huevazos.add(new Huevo(coordenadaColumnaCuadricula, coordenadaFilaCuadricula, 0));
			} else {
				if (cuadricula[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] == "K") {
					cuadricula[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] = "H";
					cuadriculaHuevos[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] = "H";
					huevazos.add(new Huevo(coordenadaColumnaCuadricula, coordenadaFilaCuadricula, 3));
				} else {
					if (cuadricula[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] == "C") {
						cuadricula[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] = "H";
						cuadriculaHuevos[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] = "H";
						huevazos.add(new Huevo(coordenadaColumnaCuadricula, coordenadaFilaCuadricula, 2));

					} else {
						if (cuadricula[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] == "T") {
							cuadricula[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] = "H";
							cuadriculaHuevos[coordenadaFilaCuadricula][coordenadaColumnaCuadricula] = "H";
							huevazos.add(new Huevo(coordenadaColumnaCuadricula, coordenadaFilaCuadricula, 1));
						}
					}
				}
			}
		} else {
			System.out.println("POR FAVOR: ingrese un numero entre 1 y 15 !");
		}
	}

	/**
	 * Este metodo mostrara por pantalla los diferentes tipos de matrices creadas en
	 * esta clase. Ademas, le incorpora formato y si fuese el caso, muestra el
	 * puntaje y el tipo de Carro derribado.
	 * 
	 * @param matriz: Esta parametro puede corresponder a nuestra matriz
	 *                "cuadricula" o "cuadriculaHuevos".
	 */
	public void mostrarMatriz(String[][] matriz) {
		// Primera seccion de la cuadricula.
		System.out.print("      ");
		for (int i = 1; i < TAMANO_CUADRICULA + 1; i++) {
			System.out.printf("%-3d", i);
		}
		System.out.println();
		// Cuadricula.
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (j == 0)
					System.out.printf("%2d %1s %2s", i + 1, "|", matriz[i][j]);
				else if (j == matriz[i].length - 1)
					System.out.printf("%3s %1s %-3d", matriz[i][j], "|", i + 1);
				else
					System.out.printf("%3s", matriz[i][j]);
			}
			System.out.println();
		}
		// Ultima seccion de la cuadricula.
		System.out.print("      ");
		for (int i = 1; i < TAMANO_CUADRICULA + 1; i++) {
			System.out.printf("%-3d", i);
		}
		System.out.println();
		System.out.println();

		// Informacion solo utilizable en juego

		if (matriz == cuadriculaHuevos) {
			System.out.println("Haz derribado " + kromisDerribadas() + " Kromi(s)");
			System.out.println("Haz derribado " + caguanosDerribados() + " Caguano(s)");
			System.out.println("Haz derribado " + trupallasDerribadas() + " Trupalla(s)");
			System.out.println();
			System.out.println("Tu puntaje por aciertos es: " + calcularPuntajes());
			System.out.println("Bonus(es) logrado(s): " + calcularBonus());
			int puntajeTotal = calcularPuntajes() + calcularBonus();
			System.out.println("Tu puntaje total es de: " + puntajeTotal);
			System.out.println();
			if (kromisDerribadas() + caguanosDerribados() + trupallasDerribadas() == 18) {
				System.out.println("¡¡HAZ GANADO!!");
			}
		}
	}

	/**
	 * Este metodo despliega todos los toString de nuestros objetos Carro
	 * almacenados en nuestro arreglo "carrots[i]".
	 */
	public void mostrarInfoCarros() {
		for (int i = 0; i < carrots.length; i++) {
			System.out.println(carrots[i].toString());
		}
	}

	/**
	 * Este metodo suma todos los atributos puntaje de los objetos Huevo que han
	 * sido creados.
	 * 
	 * @return: Valor entero que corresponde a la suma de los puntajes.
	 */
	private int calcularPuntajes() {
		int score = 0;

		for (Huevo huevo : huevazos) {
			score += huevo.getPuntaje();
		}
		return score;
	}

	/**
	 * Este metodo retorna el bonus obtenido por derribar la totalidad de un objeto
	 * Kromi o Caguano.
	 * 
	 * @return Valor entero que corresponde al total de los bonus obtenidos.
	 */
	private int calcularBonus() {
		int bonus = 0;
		int bonusKromis = 10;
		int bonusCaguanos = 7;
		for (int j2 = 0; j2 < 3; j2++) {
			if (cuadricula[carrots[j2].getCoordenadaFila()][carrots[j2].getCoordenadaColumna()] == "H"
					&& cuadricula[carrots[j2].getCoordenadaFila() + 1][carrots[j2].getCoordenadaColumna()] == "H"
					&& cuadricula[carrots[j2].getCoordenadaFila() + 2][carrots[j2].getCoordenadaColumna()] == "H") {
				bonus = bonus + bonusKromis;
			}
		}
		for (int j2 = 3; j2 < 8; j2++) {
			if (cuadricula[carrots[j2].getCoordenadaFila()][carrots[j2].getCoordenadaColumna()] == "H"
					&& cuadricula[carrots[j2].getCoordenadaFila()][carrots[j2].getCoordenadaColumna() + 1] == "H") {
				bonus = bonus + bonusCaguanos;
			}
		}
		return bonus;
	}

	/**
	 * Este metodo hace un conteo de la cantidad de objetos de tipo Kromi que han
	 * sido derribados (La totalidad de sus celdas han sido cambiadas a una letra
	 * H).
	 * 
	 * @return Valor entero que expresa la cantidad de Kromis derribadas.
	 */
	private int kromisDerribadas() {
		int contador = 0;
		for (int j2 = 0; j2 < 3; j2++) {
			if (cuadricula[carrots[j2].getCoordenadaFila()][carrots[j2].getCoordenadaColumna()] == "H"
					&& cuadricula[carrots[j2].getCoordenadaFila() + 1][carrots[j2].getCoordenadaColumna()] == "H"
					&& cuadricula[carrots[j2].getCoordenadaFila() + 2][carrots[j2].getCoordenadaColumna()] == "H") {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Este metodo hace un conteo de la cantidad de objetos de tipo Caguano que han
	 * sido derribados (La totalidad de sus celdas han sido cambiadas a una letra
	 * H).
	 * 
	 * @return Valor entero que expresa la cantidad de Caguano derribados.
	 */
	private int caguanosDerribados() {
		int contador = 0;
		for (int j2 = 3; j2 < 8; j2++) {
			if (cuadricula[carrots[j2].getCoordenadaFila()][carrots[j2].getCoordenadaColumna()] == "H"
					&& cuadricula[carrots[j2].getCoordenadaFila()][carrots[j2].getCoordenadaColumna() + 1] == "H") {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Este metodo hace un conteo de la cantidad de objetos de tipo Trupalla que han
	 * sido derribados (La totalidad de sus celdas han sido cambiadas a una letra
	 * H).
	 * 
	 * @return Valor entero que expresa la cantidad de Trupallas derribadas.
	 */
	private int trupallasDerribadas() {
		int contador = 0;
		for (int j2 = 8; j2 < carrots.length; j2++) {
			if (cuadricula[carrots[j2].getCoordenadaFila()][carrots[j2].getCoordenadaColumna()] == "H") {
				contador++;
			}
		}
		return contador;
	}

	/**
	 * Este metodo genera un valor entero aleatorio para luego asignarlo a la
	 * coordenada Columna del atributo del objeto Carro.
	 * 
	 * @param maximoRandom: numero maximo en el cual ejecutar el MathRandom
	 * @return numero columna entre 0 y rango maximo.
	 */
	private int crearNumeroColumna(int maximoRandom) {
		int numeroColumna;
		numeroColumna = (int) (Math.random() * maximoRandom);
		return numeroColumna;
	}

	/**
	 * Este metodo genera un valor entero aleatorio para luego asignarlo a la
	 * coordenada Fila del atributo del objeto Carro.
	 * 
	 * @param maximoRandom: numero maximo en el cual ejecutar el MathRandom
	 * @return numero columna entre 0 y rango maximo.
	 */
	private int crearNumeroFila(int maximoRandom) {
		int numeroFila;
		numeroFila = (int) (Math.random() * maximoRandom);
		return numeroFila;
	}

}
