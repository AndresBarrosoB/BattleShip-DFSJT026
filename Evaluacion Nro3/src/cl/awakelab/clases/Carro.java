package cl.awakelab.clases;

/**
 * En esta super-clase se contendrán los atributos y constructores que después
 * se heredarán a nuestras sub-clases: Kromi, Caguano y Trupalla. Además de los
 * método toString, set y get.
 */

public abstract class Carro {

    // Atributos.
    private int cantidadOcupantes;
    private String fechaIngreso;
    private int coordenadaColumna;
    private int coordenadaFila;

    /**
     * Descripcion de Atributos.
     * 
     * @param cantidadOcupantes: Este atributo es llenado de manera aleatoria desde
     *                           la clase Tablero con valores desde 15 hasta 45, 3
     *                           hasta 5 y 1 hasta 5, dependiendo de la sub-clase.
     * @param fechaIngreso:      Este atributo es llenado de manera aleatoria desde
     *                           la clase Tablero con valores especificados en
     *                           nuestra clase Libreria.
     * @param coordenadaColumna: Este atributo determina la Columna en donde se
     *                           creara nuestra Kromi, Caguano o Trupalla
     *                           respectivamente. El valor varia desde el 1 al 15 en
     *                           concordancia con los limites de nuestra matriz.
     * @param coordenadaFila:    Este atributo determina la Fila en donde se creara
     *                           nuestra Kromi, Caguano o Trupalla respectivamente.
     *                           El valor varia desde el 1 al 15 en concordancia con
     *                           los limites de nuestra matriz.
     */

    // Constructor.
    public Carro(int cantidadOcupantes, String fechaIngreso, int coordenadaColumna, int coordenadaFila) {
	this.cantidadOcupantes = cantidadOcupantes;
	this.fechaIngreso = fechaIngreso;
	this.coordenadaColumna = coordenadaColumna;
	this.coordenadaFila = coordenadaFila;
    }

    // Metodo toString.
    @Override
    public String toString() {
	return ", Cantidad de ocupantes: " + cantidadOcupantes + ", Fecha de ingreso: " + fechaIngreso + ", Columna: "
		+ (coordenadaColumna + 1) + ", Fila: " + (coordenadaFila + 1) + ".";
    }

    // Metodos Set & Get.
    public int getCantidadOcupantes() {
	return cantidadOcupantes;
    }

    public void setCantidadOcupantes(int cantidadOcupantes) {
	this.cantidadOcupantes = cantidadOcupantes;
    }

    public String getFechaIngreso() {
	return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
	this.fechaIngreso = fechaIngreso;
    }

    public int getCoordenadaColumna() {
	return coordenadaColumna;
    }

    public void setCoordenadaColumna(int coordenadaColumna) {
	this.coordenadaColumna = coordenadaColumna;
    }

    public int getCoordenadaFila() {
	return coordenadaFila;
    }

    public void setCoordenadaFila(int coordenadaFila) {
	this.coordenadaFila = coordenadaFila;
    }

}
