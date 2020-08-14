package model.data_structures;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private String elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = new String[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( String dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			String [ ] copia = elementos;
			elementos = new String[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public String darElemento(int i) {

		if(i < tamanoAct)
			return elementos[i];

		else
			return null;
	}

	public String buscar(String dato) 
	{
		String rta = null;
		boolean terminar = false;

		for (int j = 0; j < elementos.length && !terminar; j++) 
		{

			if(elementos[j].compareTo(dato) == 0)
			{
				rta = elementos[j];
				terminar = true;
			}

		}
		return rta;
	}

	public String eliminar(String dato) {

		ArrayList<String> lista = new ArrayList<>();
		
		String rta = null;

		for ( int i = 0; i < tamanoAct; i++)
		{
			if (elementos[i].compareTo(dato) != 0)
			{
				lista.add(elementos[i]);
			}
			
			else
				rta = elementos[i];
		} 

		String[] copia = new String[elementos.length];
			
		for (int i = 0; i < lista.size(); i++) {

			copia[i] = lista.get(i);
		}


		return rta;
	}

}
