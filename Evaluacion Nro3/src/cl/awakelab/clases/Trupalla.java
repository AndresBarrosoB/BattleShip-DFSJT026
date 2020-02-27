package cl.awakelab.clases;

/**
 * Está sub-clase continente los atributos y constructores requeridos para
 * nuestra clase Trupalla, la cual se encarga de instanciar objetos Trupalla
 * dentro de una matriz bidimensional. Además tiene sus respectivos método
 * toString, set y get. Algunos de estos atributos de esta sub-clases son
 * rellenados de forma aleatoria desde nuestra clase Tablero con atributos
 * especificados en nuestra clase Librerías.
 */

public class Trupalla extends Carro {

    // Atributos.
    private int nivelArmadura;
    private String nombreConductor;

    /**
     * Descripcion de Atributos.
     * 
     * @param cantidadOcupantes: Es heredado de Carro.
     * @param fechaIngreso:      Es heredado de Carro.
     * @param coordenadaColumna: Es heredado de Carro.
     * @param coordenadaFila:    Es heredado de Carro.
     * @param nivelArmadura:     Este atributo es llenado de manera aleatoria desde
     *                           la clase Tablero con valores que varian entre 1
     *                           hasta 5 niveles de armadura.
     * @param nombreConductor:   Este atributo es llenado de manera aleatoria desde
     *                           la clase Tablero con atributos especificados en
     *                           nuestra clase Librerías.
     */

    // Constructor.
    public Trupalla(int cantidadOcupantes, String fechaIngreso, int coordenadaColumna, int coordenadaFila,
	    int nivelArmadura, String nombreConductor) {
	super(cantidadOcupantes, fechaIngreso, coordenadaColumna, coordenadaFila);
	this.nivelArmadura = nivelArmadura;
	this.nombreConductor = nombreConductor;
    }

    // Metodo toString.
    @Override
    public String toString() {
	return "Tipo: Trupalla, Nivel de Armadura: " + nivelArmadura + ", " + "Nombre de conductor: " + nombreConductor
		+ super.toString();

    }

    // Metodos Get & Set.
    public int getNivelArmadura() {
	return nivelArmadura;
    }

    public void setNivelArmadura(int nivelArmadura) {
	this.nivelArmadura = nivelArmadura;
    }

    public String getNombreConductor() {
	return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
	this.nombreConductor = nombreConductor;
    }

}
