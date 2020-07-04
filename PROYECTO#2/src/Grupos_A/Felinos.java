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
	public String Comportamiento() {
		return "Comportamiento:\n"
				+ "Poseen un comportamiento calmado dentro"
				+ " del habitad artifical, algunos son juguetones.";
	}
	//ALIMENTACION Y CONDICIONES DEL GRUPO ANIMAL
	@Override
	public String Alimentacion() {
		return "Alimentacion:\n"
				+ "Son carnivoros, para saciar su hambre"
				+ " hay que darles carne de res.";
	}
	@Override
	public String Condiciones() {
		return " Condiciones:\n"
				+ "Al entrar al habitad para alimentarlos"
				+ " hay que tener mucho de no alertarlos, si no"
				+ " pueden intentar atacar.\n"
				+ "A los visitantes del"
				+ " ZOO hay que advertiles de no pasar la linea amarilla.";
	}
	//METODO O COMPORTAMIENTO UNICO DE GRUPO
	public String actos() {
		return "Actos:\n"
				+ "Los que están mejor domesticas"
				+ " Pueden mostartse cerca de los visitantes del"
				+ " Zoologico con un pequeño acto.\n"
				+ "Tambien puede"
				+ " Estar frente de los visitantes, siempre y cuando"
				+ " no sea agresivo";
	}
}
