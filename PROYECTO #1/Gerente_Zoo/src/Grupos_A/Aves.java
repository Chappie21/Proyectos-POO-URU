package Grupos_A;

import animal.*;

public class Aves extends Animal implements Al_Con {
	//CONSTRUCTOR VACIO
	public Aves() {
	}
	//CONSTRUCTOR POR PARAMETROS
	public Aves(String n,String es,float pes,float alt,int ed) {
		super(n,es,pes,alt,ed);
		this.grupo="Aves";
	}
	//COMPORTAMIENTO GENERAL DEL HABITAD DEL GRUPO ANIMAL
	@Override
	public void Comportamiento() {
		System.out.println("Son tranquilas dentro su habitad artificial"
				+ " Algunas puden presentarse de forma agresiva si se"
				+ " sienten amenzadas");
	}
	//ALIMENTACION Y CONDICIONES DEL GRUPO ANIMAL
	@Override
	public void Alimentacion() {
		System.out.println("las Aves generalemnet se alimentan frutas y semillas"
				+ " Algunas son Carnivoras tenindo que darles Carne");
	}
	@Override
	public void Condiciones() {
		System.out.println("Las aves realmente son traquilas solo"
				+ " hay que tener cuidado al entara a su habiatd de no"
				+ " Hacer sentir amenazadas a ciertas especies como por"
				+ " ejemplo las Aguilas");
	}
	//METODO O COMPORTAMIENTO UNICO DE GRUPO
	public void Volar() {
		System.out.println("Las aves poseen una habiatd suficiente"
				+ " mente grande para volar, claro, no todas las"
				+ " especies pueden hacerlo. Igual que otros grupos"
				+ " y especies, si este no presenta un comportamiento "
				+ " agresivo o preligro, podrá mostrarse frente a los"
				+ " visitantes");
	}
}
