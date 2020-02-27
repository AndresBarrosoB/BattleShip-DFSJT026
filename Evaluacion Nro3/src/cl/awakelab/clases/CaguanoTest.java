package cl.awakelab.clases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaguanoTest {
    
    private Caguano caguano;
    
    int ocupantes;
    String ingreso;
    int fila;
    int columna;
    int alcance;
    String color;

    @BeforeEach
    void setUp() throws Exception {
	Libreria libreria = new Libreria();
	ocupantes = 3;
	ingreso = libreria.rellenarFechaIngreso();
	fila = 1;
	columna = 4;
	alcance = 10;
	color = libreria.rellenarColorConfeti();
	caguano = new Caguano(ocupantes, ingreso, columna, fila, alcance, color);
    }
    //Prueba Get & Set de cantidadOcupantes.
    @Test
    void comprobarGetOcupantes() {
	assertEquals(ocupantes, caguano.getCantidadOcupantes());
    }
    @Test
    void comprobarSetOcupantes() {
	int nuevoOcupantes = 5;
	caguano.setCantidadOcupantes(nuevoOcupantes);
	assertEquals(nuevoOcupantes, caguano.getCantidadOcupantes());
    }
    //Prueba Get & Set de fechaIngreso.
    @Test
    void comprobarGetIngreso() {
	assertEquals(ingreso, caguano.getFechaIngreso());
    }
    @Test
    void comprobarSetIngreso() {
	String nuevoIngreso = "20 de Enero";
	caguano.setFechaIngreso(nuevoIngreso);
	assertEquals(nuevoIngreso, caguano.getFechaIngreso());
    }
    //Prueba Get & Set de coordenadaFila.
    @Test
    void comprobarGetFila() {
	assertEquals(fila, caguano.getCoordenadaFila());
    }
    @Test
    void comprobarSetFila() {
	int nuevaFila = 2;
	caguano.setCoordenadaFila(nuevaFila);
	assertEquals(nuevaFila, caguano.getCoordenadaFila());
    }
    //Prueba Get & Set de coordenadaColumna.
    @Test
    void comprobarGetColumna() {
	assertEquals(columna, caguano.getCoordenadaColumna());
    }


}
