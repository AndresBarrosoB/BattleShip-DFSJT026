package cl.awakelab.clases;

/**
 * Está sub-clase continente los atributos y constructores requeridos para
 * nuestra clase Kromi, la cual se encarga de instanciar objetos Kromi dentro de
 * una matriz bidimensional. Además tiene sus respectivos método toString, set
 * y get. Algunos de estos atributos de esta sub-clases son rellenados de forma
 * aleatoria desde nuestra clase Tablero con atributos especificados en nuestra
 * clase Librerías.
 */

public class Kromi extends Carro {

	// Atributos.
	private String anoFabricacion;
	private String marca;

	/**
	 * Descripcion de Atributos.
	 * 
	 * @param cantidadOcupantes: Es heredado de Carro.
	 * @param fechaIngreso:      Es heredado de Carro.
	 * @param coordenadaColumna: Es heredado de Carro.
	 * @param coordenadaFila:    Es heredado de Carro.
	 * @param anoFabricacion:    Este atributo es llenado de manera aleatoria desde
	 *                           la clase Tablero con atributos especificados en
	 *                           nuestra clase Librerías.
	 * @param marca:             Este atributo es llenado de manera aleatoria desde
	 *                           la clase Tablero con atributos especificados en
	 *                           nuestra clase Librerías.
	 */

	// Constructor.
	public Kromi(int cantidadOcupantes, String fechaIngreso, int coordenadaColumna, int coordenadaFila,
			String anoFabricacion, String marca) {
		super(cantidadOcupantes, fechaIngreso, coordenadaColumna, coordenadaFila);
		this.anoFabricacion = anoFabricacion;
		this.marca = marca;
	}

	// Metodo toString.
	@Override
	public String toString() {
		return "Tipo: Kromi, Ano fabricacion: " + anoFabricacion + ", Marca: " + marca + super.toString();
	}

	// Metodos Set & Get.
	public String getAnoFabricacion() {
		return anoFabricacion;
	}

	public void setAnoFabricacion(String anoFabricacion) {
		this.anoFabricacion = anoFabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
