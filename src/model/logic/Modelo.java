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
import view.View;

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

	private View vista= new View();
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

	public String darElemento(int i)
	{
		return  (String) datos.darElemento(i);
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
			
			CSVParser parser1 = new CSVParserBuilder().withSeparator(';').build();
			CSVParser parser2 = new CSVParserBuilder().withSeparator(';').build();

			FileReader fr1 = new FileReader(casting);
			FileReader fr2 = new FileReader(details);

			CSVReader reader1 = new CSVReaderBuilder(fr1).withCSVParser(parser1).build();

			CSVReader reader2 = new CSVReaderBuilder(fr2).withCSVParser(parser2).build();

			String[] fila1 = null;
			String[] fila2 = null;

			while((fila1 = reader1.readNext()) != null && (fila2 = reader2.readNext()) != null) 
			{
				Object[] sirve = new String[12];  
				sirve[0]= fila1[0]; 
				sirve[1]= fila2[10];
				sirve[2]= fila1[1];
				sirve[3]= fila1[3];
				sirve[4]= fila1[5];
				sirve[5]= fila1[7];
				sirve[6]= fila1[9];
				sirve[7]= fila1[12];
				sirve[8]= fila2[2];
				sirve[9]= fila2[16];
				sirve[10]= fila2[17];
				sirve[11]= fila2[18];

				datos.agregar(Arrays.toString(sirve));
			}

			reader1.close();
			reader2.close();

		} 
		catch (Exception e) {
			throw new Exception(e.getMessage() +"pifeo");
		}

	}

	
	
	public void buenasDirector(String director)
	{
		float total = 0;
		char counter = 0;
		for (int i = 0; i < datos.darTamano(); i++) 
		{	
			String[] temp = darElemento(i).split(",");
			if(temp[7].trim().equals(director) && Float.parseFloat((temp[10])) >= 6)
			{
				counter ++;
				total += Float.parseFloat((temp[10]));
				vista.printMessage(darElemento(i));
			}
		}

		vista.printMessage("El promedio es " + total/counter);
	}
}
