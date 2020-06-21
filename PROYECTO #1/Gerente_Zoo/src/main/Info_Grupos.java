package main;

import java.util.Scanner;
import Grupos_A.*;

public class Info_Grupos {
	
	public Info_Grupos() {
		Scanner leer = new Scanner(System.in);
		int j;/*VARIABLE AUXILIAR PARA SELECCION DE OPCION*/
		//MENU DE COMPORTAMIENTOS POR GRUPO
		do {
			System.out.println("1.-Grupo Aves");
			System.out.println("2.-Grupo Peces");
			System.out.println("3.-Grupo Reptiles");
			System.out.println("4.-Grupo Primates");
			System.out.println("5.-Grupo Felinos");
			System.out.println("6.-Volver a menu principal");
			System.out.print("Opcion: ");
			j=leer.nextInt();/*OPCION INGRESADA POR EL USUARIO*/
			/*OPCIONES POSIBLES, DEPENDIENDO DE 
			 * LA OPCION ESCOGIDA POR EL USUARIO SALDRÁ
			 *UNA INFORMACION ESPECIFICA*/
			switch(j) {	
				case 1: GAves(); break;
				case 2: GPeces(); break;
				case 3: GReptiles(); break;
				case 4: GPrimates(); break;
				case 5: GFelinos(); break;
			}
		}while(j!=6);/*SI J=6 SE TERMINA EL CICLO Y SE REGRESA AL MENÚ ORIGINAL*/
	}
	//COMPOTAMIENTOS SOBRE AVES
	public void GAves() {
		Aves l = new Aves();
		System.out.println("COMPORTAMIENTO DE AVES: ");
		l.Comportamiento();
		l.Volar();
		l.Alimentacion();
		l.Condiciones();
	}
	//COMPORTAMIENTO SOBRE PECES
	public void GPeces() {
		Peces l = new Peces();
		System.out.println("COMPORTAMIENTO DE PECES: ");
		l.Comportamiento();
		l.Alimentacion();
		l.Condiciones();
	}
	//COMPORTAMIENTO SOBRE REPTILES
	public void GReptiles() {
		Reptiles l = new Reptiles();
		System.out.println("COMPORTAMIENTO DE REPTILES: ");
		l.Comportamiento();
		l.Exhibicion();
		l.Alimentacion();
		l.Condiciones();
	}
	//COMPORTAMEINTO SOBRE PRIMATES
	public void GPrimates() {
		Primates l = new Primates();
		System.out.println("COMPORTAMIENTO DE PRIMATES: ");
		l.Comportamiento();
		l.Compartir();
		l.Alimentacion();
		l.Condiciones();
	}
	//COMPORTAMIENTO SOBRE FELINOS
	public void GFelinos() {
		Felinos l = new Felinos();
		System.out.println("COMPORTAMIENTO DE FELINOS: ");
		l.Comportamiento();
		l.actos();
		l.Alimentacion();
		l.Condiciones();
	}
}
