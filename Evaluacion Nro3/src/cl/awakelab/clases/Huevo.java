package cl.awakelab.clases;

/**
 * Está clase continente los atributos y constructores requeridos para nuestra
 * clase Huevo, la cual se encarga de instanciar objetos Huevo dentro de una
 * matriz bidimensional.
 */

public class Huevo {

    // Atributos.
    private int coordenadaColumna;
    private int coordenadaFila;
    private int puntaje;

    /**
     * Descripcion de Atributos.
     * 
     * @param coordenadaColumna: Este atributo determina la Columna en donde se
     *                           creara nuestro Huevo. El valor varia desde el 1 al
     *                           15 en concordancia con los limites de nuestra
     *                           matriz.
     * @param coordenadaFila:    Este atributo determina la Fila en donde se creara
     *                           nuestro Huevo. El valor varia desde el 1 al 15 en
     *                           concordancia con los limites de nuestra matriz.
     * @param puntaje:           Este atributo es asignado dependiendo de la
     *                           coordenadaColumna y la coordenadaFila. Los valores
     *                           varian entre 3, 2 y 1.
     */

    // Constructor.
    public Huevo(int coordenadaColumna, int coordenadaFila, int puntaje) {
	this.coordenadaColumna = coordenadaColumna;
	this.coordenadaFila = coordenadaFila;
	this.puntaje = puntaje;
    }

    // Metodo toString.
    @Override
    public String toString() {
	return "Huevo [coordenadaColumna=" + coordenadaColumna + ", coordenadaFila=" + coordenadaFila + ", puntaje="
		+ puntaje + "]";
    }

    // Metodos Set & Get.
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

    public int getPuntaje() {
	return puntaje;
    }

    public void setPuntaje(int puntaje) {
	this.puntaje = puntaje;
    }

}
