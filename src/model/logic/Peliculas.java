package model.logic;

import java.io.FileReader;
import java.util.Date;
import java.util.Map;

import com.opencsv.CSVReaderHeaderAware;

public class Peliculas {
	
	/*
	 * Numero de actores que participaron en la pelicula. 
	 */
	private int numeroActores;
	
	/*
	 * Idetificador de la pelicula. 
	 */
	private int id;
	
	/*
	 * Presupuesto de la pelicula. 
	 */
	private int budget;
	
	/*
	 * Genero de la pelicula. 
	 */
	private String genero;
	
	/*
	 * imdb id 
	 */
	private String imdb_id;
	
	/*
	 * Lenguaje original de la pelicula
	 */
	private String lenguajeOriginal;
	
	/*
	 * Titulo original de la pelicula.
	 */
	private String tituloOriginal;
	
	/*
	 * Sinopsis de la pelicula.
	 */
	private String sinopsis;
	
	/*
	 * Popularidad de la pelicula. 
	 */
	private double popularidad;
	
	/*
	 * Companias de produccion de la pelicula. 
	 */
	private String companiasProd;
	
	/*
	 * Paises de produccion de la pelicula
	 */
	private String paisesProd;
	
	/*
	 * Fecha de salida de la pelicula. 
	 */
	private Date fechaSalida;
	
	/*
	 * Ganancias por la pelicula. 
	 */
	private int revenue;
	
	/*
	 * Duracion de la pelicula.
	 */
	private int runtime;
	
	/*
	 * Lenguajes hablados en la pelicula.
	 */
	private String lenguasHabladas;
	
	/*
	 * Estado de la pelicula.
	 */
	private String status;
	
	/*
	 * Slogan de la pelicula. 
	 */
	private String tagline;
	
	/*
	 * Titulo de la pelicula. 
	 */
	private String titulo;
	
	/*
	 * Promedio de valoracion.
	 */
	private double voteAverage;
	
	/*
	 * Numero de votos. 
	 */
	private int voteCount;
	
	/*
	 * Numero de companias involucradas en la produccion. 
	 */
	private int productionCompaniesNumber;
	
	/*
	 * Numero de paises involucrados en la produccion
	 */
	private int productionCountriesNumber;
	
	/*
	 * Numero de lenguajes hablados. 
	 */
	private int spokenLanguagesNumber;
	
	
	
	
	
	Map<String, String> values = new CSVReaderHeaderAware(new FileReader("yourfile.csv")).readMap();

}
