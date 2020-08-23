package main;
import controller.Controller;
import model.logic.Modelo;

public class Main {
	
	
	
	
	public static void main(String[] args) throws Exception 
	{
//		Controller controler = new Controller();
//		controler.run();

		Modelo model = new Modelo();
//		model.cargarDatos();
//		
//		Object[] hola = new Object[]{ 1,2,3,4,5,6,7,8,9,10 };
//		Object[] holi = new Object[]{ 1,2,3,4,5,6,7,8,9,10 };
//		model.agregar(hola);
//		model.agregar(holi);
//		System.out.println(model.darTamano());
		
		model.cargarDatos();
		model.imprimir();
		System.out.println(model.darTamano());
	}
}
