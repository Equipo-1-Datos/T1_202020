package model.logic;

import java.io.FileReader;
import java.io.StringReader;

import com.opencsv.CSVReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		datos = new ArregloDinamico(7);
	}

	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public Modelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(Object dato)
	{	
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Integer buscar(Integer dato)
	{
		return (Integer) datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Integer eliminar(Integer dato)
	{
		return (Integer) datos.eliminar(dato);
	}

	public void cargarDatos() throws Exception
	{
		try {

			//			Map<String, String> values = new CSVReaderHeaderAware(new FileReader("SmallMoviesDetailsCleaned.csv")).readMap();

			String casting = "C:\\Users\\cajiv\\eclipse-workspace\\APO2";
			String details = "C:\\Users\\cajiv\\eclipse-workspace\\APO2";

			System.out.println("define rutas de documentos");

			CSVParser parser = new CSVParserBuilder().withSeparator(';').build();

			System.out.println(" crea el parser");

			CSVReader reader1 = new CSVReaderBuilder(new StringReader(casting)).withSkipLines(1).withCSVParser(parser).build();

			System.out.println("Crea primer reader");

			CSVParser parser2 = new CSVParserBuilder().withSeparator(';').build();

			System.out.println(" crea el parser2");

			CSVReader reader2 = new CSVReaderBuilder(new StringReader(details)).withSkipLines(1).withCSVParser(parser).build();

			System.out.println("Crea primer reader2");

			String[] fila1 = null;
			String[] fila2 = null;

			System.out.println("Crear los dos readers");
			while((fila1 = reader1.readNext()) != null && (fila2 = reader2.readNext()) != null) 
			{
				System.out.println("Entra al while");
				Object[] sirve = new String[10];
				sirve[0]= fila1[1];
				sirve[1]= fila1[3];
				sirve[2]= fila1[5];
				sirve[3]= fila1[7];
				sirve[4]= fila1[9];
				sirve[5]= fila1[13];
				sirve[6]= fila2[2];
				sirve[7]= fila2[16];
				sirve[8]= fila2[17];
				sirve[9]= fila2[18];

				System.out.println(sirve);

				datos.agregar(sirve);
			}

			reader1.close();
			reader2.close();


		} 
		catch (Exception e) {
			throw new Exception("pifeo");
		}

	}


}
