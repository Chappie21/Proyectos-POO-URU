package Grupos_A;

import animal.*;

public class Reptiles extends Animal implements Al_Con {
	//CONSTRUCTOR VACIO
	public Reptiles() {
	}
	//CONSTRUCTOR POR PARAMETROS
	public Reptiles(String n,String es,float pes,float alt,int ed) {
		super(n,es,pes,alt,ed);
		this.grupo="Reptiles";
	}
	//COMPORTAMIENTO GENERAL DEL HABITAD DEL GRUPO ANIMAL
	@Override
	public String Comportamiento() {
		return "Comportamiento:\n"
				+ "Agresivos en todo momento, salvo"
				+ " algunas especies de serpientes.";
	}
	//ALIMENTACION Y CONDICIONES DEL GRUPO ANIMAL
	@Override
	public String Alimentacion() {
		return "Alimentacion:\n"
				+ "Los lagartos y serpientes son carnivoros, pero"
				+ " algunas especies de serpientes no.";
	}
	@Override
	public String Condiciones() {
		return "Condiciones:\n"
				+ "Está proivido entrar al habitad de los"
				+ " reptiles sin seguridad, y sin otras medidas"
				+ " especiales";
	}
	//METODO O COMPORTAMIENTO UNICO DE GRUPO
	public String Exhibicion() {
		return "Exhibicion:\n"
				+ "Algunos reptiles con comportameinto calmado"
				+ " y que no demuestre acciones peligrosas\n"
				+ "Podran ser mostrados frente a los visitantes"
				+ " Con precaucion de un cuidador";
	}
}
