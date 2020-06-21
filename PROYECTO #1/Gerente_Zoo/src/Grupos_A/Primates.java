package Grupos_A;

import animal.*;

public class Primates extends Animal implements Al_Con {
	//CONSTRUCTOR VACIO
	public Primates() {
	}
	//CONSTRUCTOR POR PARAMETROS
	public Primates(String n,String es,float pes,float alt,int ed) {
		super(n,es,pes,alt,ed);
		this.grupo="Primates";
	}
	//COMPORTAMIENTO GENERAL DEL HABITAD DEL GRUPO ANIMAL
	@Override
	public void Comportamiento() {
		System.out.println("Son muy imperactivos, generalmente no"
				+ " dan problemas, a menos que un visitante haga algo"
				+ " que no esté permitido.");
	}
	//ALIMENTACION Y CONDICIONES DEL GRUPO ANIMAL
	@Override
	public void Alimentacion() {
		System.out.println("Se les da frutas y everduras para su comida.");
	}
	@Override
	public void Condiciones() {
		System.out.println("Realmente son amistosos con los cuidadores del"
				+ " Zoologico, Solo algunos Gorilas tiende a comportarse agresivos"
				+ " a veces, en ese caso se recomienda salir del habitad y llamar"
				+ " a alguien mas. No se le permite a los visitantes tocarlos"
				+ " a menos que esté acompañado de un cuidador.");
	}
	//METODO O COMPORTAMIENTO UNICO DE GRUPO
	public void Compartir() {
		System.out.println("Especies de primates como los monos"
				+ " Podran estar frente a los visitantes y comportir con "
				+ " ellos, siempre y cuando esté un cuidador pendiente"
				+ " de todo.");
	}
}
