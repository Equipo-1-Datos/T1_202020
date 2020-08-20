package model.logic;

public class Director
{
	private String nombre;
	
	private int genero;
	
	public Director(String nombre, int genero)
	{
		this.nombre = nombre;
		this.genero = genero;
	}
	
	/*
	 * Retorna el nombre del director
	 * @Return nombre del director.
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/*
	 * Retorna el genero del director
	 * @Return genero del director.
	 */
	public int darGenero()
	{
		return genero;
	}
}
