package controller;

import java.util.Scanner;

import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() throws Exception 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = null;
//		String respuesta = null;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("--------- \n Cargar Datos de los CSV: ");
				    modelo.cargarDatos();
				    view.printMessage("Información películas: "+ modelo.darElemento(0));
				    view.printMessage("Información primera película: "+ modelo.darElemento(1));
				    view.printMessage("Información última película: "+ modelo.darElemento(modelo.darTamano()-1));
				    view.printMessage("Total de películas " + (modelo.darTamano()-1) + "\n---------");	
					break;

				case 2:
					view.printMessage("--------- \n Buenas películas de un director: ");
					lector.nextLine();
					dato = lector.nextLine();
//					System.out.println("Este es el dato  "+ dato + " termina");
					modelo.buenasDirector(dato);	
					break;
//
//				case 3:	
//					view.printMessage("--------- \nDar cadena (simple) a buscar: ");
//					dato = lector.nextInt();
//					respuesta = modelo.buscar(dato);
//					if ( respuesta != null)
//					{
//						view.printMessage("Dato encontrado: "+ respuesta);
//					}
//					else
//					{
//						view.printMessage("Dato NO encontrado");
//					}
//					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
//					break;
//
//				case 4:
//					view.printMessage("--------- \nDar cadena (simple) a eliminar: ");
//					dato = lector.nextInt();
//					respuesta = modelo.eliminar(dato);
//					if ( respuesta != null)
//					{
//						view.printMessage("Dato eliminado "+ respuesta);
//					}
//					else
//					{
//						view.printMessage("Dato NO eliminado");							
//					}
//					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
//					break;
//
//				case 5: 
//					view.printMessage("--------- \nContenido del Arreglo: ");
//					view.printModelo(modelo);
//					view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
//					break;	
				
				case 6: 
					view.printMessage("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	
	
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
