package model.logic;

import java.io.FileReader;
import java.util.Date;
import java.util.Map;

import com.opencsv.CSVReaderHeaderAware;

public class Peliculas {
	
	private int id;
	private int budget;
	private String genero;
	private String imdb_id;
	private String lengua;
	private String titulo;
	private String overview;
	private double popularidad;
	private String companiaProd;
	private String paisProd;
	private Date fechaSalida;
	private int revenue;
	private int runtime;
	private String lenguasHabladas;
	private String status;
	
	/// no se sabe 
	private String tagline;
	
	
	
	
	
	Map<String, String> values = new CSVReaderHeaderAware(new FileReader("yourfile.csv")).readMap();

}
