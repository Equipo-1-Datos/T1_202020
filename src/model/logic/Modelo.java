package model.logic;

import java.io.FileReader;
import java.io.StringReader;
import java.util.Arrays;

import com.opencsv.CSVReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 * @param <T>
 *
 */
public class Modelo<T> {
	/**
	 * Atributos del modelo del mundo
	 */
	private ArregloDinamico datos;

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
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return (String) datos.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return (String) datos.eliminar(dato);
	}

	public void cargarDatos() throws Exception
	{
		try {
			String casting = "docs/MoviesCastingRaw-small.csv";
			String details = "docs/SmallMoviesDetailsCleaned.csv";

			System.out.println("define rutas de documentos");

			CSVParser parser1 = new CSVParserBuilder().withSeparator(';').build();
			CSVParser parser2 = new CSVParserBuilder().withSeparator(';').build();
			System.out.println(" crea los parcers");
			
			FileReader fr1 = new FileReader(casting);
			FileReader fr2 = new FileReader(details);
			
			System.out.println("Crea los fr");
			
			CSVReader reader1 = new CSVReaderBuilder(fr1).withCSVParser(parser1).build();

			System.out.println("Crea primer reader");

			CSVReader reader2 = new CSVReaderBuilder(fr2).withCSVParser(parser2).build();

			System.out.println("Crea primer reader2");

			String[] fila1 = null;
			String[] fila2 = null;

			System.out.println("Crear los dos readers");
			while((fila1 = reader1.readNext()) != null && (fila2 = reader2.readNext()) != null) 
			{
//				System.out.println("Entra al while");
				Object[] sirve = new String[12];  // si no dejan usar array tipo objeto, convertir este array que sale a string.
				sirve[0]= fila1[0]; 
				sirve[1]= fila2[0];
				sirve[2]= fila1[1];
				sirve[3]= fila1[3];
				sirve[4]= fila1[5];
				sirve[5]= fila1[7];
				sirve[6]= fila1[9];
				sirve[7]= fila1[12];
				sirve[8]= fila2[2];
				sirve[9]= fila2[16];
				sirve[10]= fila2[17];
				sirve[11]= fila2[18]; // agregar release date !

//				System.out.println(Arrays.toString(sirve));

				datos.agregar(Arrays.toString(sirve));
			}

			reader1.close();
			reader2.close();

		} 
		catch (Exception e) {
			throw new Exception(e.getMessage() +"pifeo");
		}

	}
	
	public void buenasDirector()
	{
		
	}
	
	
//	public void imprimir()
//	{
//		for (int i = 0; i < datos.darTamano()/4; i++) {
//			System.out.println(Arrays.deepToString((Object[]) datos.darElemento(i)));
//			System.out.println(darTamano());
//		}
//	}
	
	


}
