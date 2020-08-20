package model.logic;

public class Actor 
{
	/*
	 * Nombre del actor.
	 */
	private String nombre;
	
	/*
	 * Genero del actor.
	 */
	private int genero; 
	
	/*
	 * Metodo constructor 
	 */
	public Actor(String nombre, int genero)
	{
		this.nombre = nombre;
		this.genero = genero;
	}
	
	/*
	 * Retorna el nombre del actor
	 * @Return nombre del actor.
	 */
	public String darNombre()
	{
		return nombre;
	}
	
	/*
	 * Retorna el genero del actor
	 * @Return genero del actor.
	 */
	public int darGenero()
	{
		return genero;
	}

}
