package cl.awakelab.clases;

/**
 * @author Andrés Barroso y Diego Pizarro.
 * @version 1.0.0
 * @copyright Todo el codigo escrito en este programa es de dominio publico.
 * El programa comienza mostrando una matriz de 15 por 15, la cual contiene 225 espacios vacios donde posicionaremos 
 * nuestros Carros, y un apartado donde podremos ver como generamos puntaje a medida que la simulacion progresa.
 * Después de posicionar los carros, al usuario se le ofrecerá una primera opcion para intentar impactar estos Carros
 * con Huevos y dependiendo de cuantos aciertos haya, se le irá asignando un puntaje.
 * La segunda opcion nos permitirá mostrar las posiciones de todos nuestros Carros y Huevos dentro de nuestra matriz
 * junto con un sumario de los atributos de cada uno de nuestros Carros.
 * Este menú seguirá desplegandose hasta que el usuario digite la tercera opcion: Salir.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejecutable {

    public static void main(String[] args) {

	Tablero tablero = new Tablero();

	escribir("Bienvenido a tu Simulador de Enfrentamientos.", true);
	tablero.crearCarros();

	boolean salir = true;

	do {

	    escribir("", true);
	    tablero.mostrarMatriz(tablero.getCuadriculaHuevos());
	    escribir("", true);
	    escribir("***** MENU *****", true);
	    escribir("1. Lanzar un huevo.", true);
	    escribir("2. Mostrar la posicion e informacion de tus enemigos.", true);
	    escribir("3. SALIR.", true);
	    escribir("", true);

	    escribir("Elija una opcion: ", false);

	    try {
		int opcion = pideNumero("");
		escribir("", true);

		switch (opcion) {

		case 1:
		    tablero.lanzarHuevo(pideNumero("Ingrese numero de Fila: "),
			    pideNumero("Ingrese numero de Columna: "));
		    break;
		case 2:
		    tablero.mostrarMatriz(tablero.getCuadricula());
		    escribir("", true);
		    tablero.mostrarInfoCarros();
		    break;
		case 3:
		    escribir("SISTEMA FINALIZADO", true);
		    salir = false;
		    break;

		default:
		    escribir("POR FAVOR: ingrese solo numeros 1, 2, 3 !.", true);
		}

	    } catch (InputMismatchException ex) {
		escribir("<ERROR> INGRESAR SOLO NUMEROS ENTEROS.", true);
	    }
	} while (salir);

    }

    //Utilidades.
    private static void escribir(String mensaje, boolean salto) {
	if (salto == true)
	    System.out.println(mensaje);
	else
	    System.out.print(mensaje);
    }
    
    private static int pideNumero(String mensaje) {
	escribir(mensaje, false);
	Scanner entrada = new Scanner(System.in);
	return entrada.nextInt();
    }

}
