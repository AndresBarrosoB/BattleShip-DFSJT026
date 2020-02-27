package cl.awakelab.clases;

/**
 * Está sub-clase continente los atributos y constructores requeridos para
 * nuestra clase Caguano, la cual se encarga de instanciar objetos Caguano
 * dentro de una matriz bidimensional. Además tiene sus respectivos método
 * toString, set y get. Algunos de estos atributos de esta sub-clases son
 * rellenados de forma aleatoria desde nuestra clase Tablero con atributos
 * especificados en nuestra clase Librerías.
 */

public class Caguano extends Carro {

    // Atributos.
    private int alcanceTiro;
    private String colorConfeti;

    /**
     * Descripcion de Atributos.
     * 
     * @param cantidadOcupantes: Es heredado de Carro.
     * @param fechaIngreso:      Es heredado de Carro.
     * @param coordenadaColumna: Es heredado de Carro.
     * @param coordenadaFila:    Es heredado de Carro.
     * @param alcanceTiro:       Este atributo es llenado de manera aleatoria desde
     *                           la clase Tablero con valores que varian entre 15
     *                           hasta 20 metros.
     * @param colorConfeti:      Este atributo es llenado de manera aleatoria desde
     *                           la clase Tablero con atributos especificados en
     *                           nuestra clase Librerías.
     */

    // Constructor.
    public Caguano(int cantidadOcupantes, String fechaIngreso, int coordenadaColumna, int coordenadaFila,
	    int alcanceTiro, String colorConfeti) {
	super(cantidadOcupantes, fechaIngreso, coordenadaColumna, coordenadaFila);
	this.alcanceTiro = alcanceTiro;
	this.colorConfeti = colorConfeti;
    }

    // Metodo toString.
    @Override
    public String toString() {
	return "Tipo: Caguano, Alcance de tiro: " + alcanceTiro + ", Color confeti: " + colorConfeti + super.toString();
    }

    // Metodos Set & Get.
    public int getAlcanceTiro() {
	return alcanceTiro;
    }

    public void setAlcanceTiro(int alcanceTiro) {
	this.alcanceTiro = alcanceTiro;
    }

    public String getColorConfeti() {
	return colorConfeti;
    }

    public void setColorConfeti(String colorConfeti) {
	this.colorConfeti = colorConfeti;
    }

}
