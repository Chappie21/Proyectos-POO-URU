package Grupos_A;

import animal.*;

public class Felinos extends Animal implements Al_Con{
	//CONSTRUCTOR VACIO
	public Felinos() {
	}
	//CONSTRUCTOR POR PARAMETROS
	public Felinos(String n,String es,float pes,float alt,int ed) {
		super(n,es,pes,alt,ed);
		this.grupo="Felinos";
	}
	//COMPORTAMIENTO GENERAL DEL HABITAD DEL GRUPO ANIMAL
	@Override
	public void Comportamiento() {
		System.out.println("Poseen un comportamiento calmado dentro"
				+ " del habitad artifical, algunos son juguetones.");
	}
	//ALIMENTACION Y CONDICIONES DEL GRUPO ANIMAL
	@Override
	public void Alimentacion() {
		System.out.println("Son carnivoros, para saciar su hambre"
				+ " hay que darles carne de res.");
	}
	@Override
	public void Condiciones() {
		System.out.println(" Al entrar al habitad para alimentarlos"
				+ " hay que tener mucho de no alertarlos, si no"
				+ " pueden intentar atacar. A los visitantes del"
				+ " ZOO hay que advertiles de no pasar la linea amarilla.");
	}
	//METODO O COMPORTAMIENTO UNICO DE GRUPO
	public void actos() {
		System.out.println("Los que están mejor domesticas"
				+ " Pueden mostartse cerca de los visitantes del"
				+ " Zoologico con un pequeño acto, tambien puede"
				+ " Estar frente de los visitantes, siempre y cuando"
				+ " no presente ningun comportamiento agresivo o peligroso");
	}
}
