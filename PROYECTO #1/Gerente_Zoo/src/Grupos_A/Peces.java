package Grupos_A;

import animal.*;

public class Peces extends Animal implements Al_Con {
	//CONSTRUCTOR VACIO
	public Peces() {
	}
	//CONSTRUCTOR POR PARAMETROS
	public Peces(String n,String es,float pes,float alt,int ed) {
		super(n,es,pes,alt,ed);
		this.grupo="Peces";
	}
	//COMPORTAMIENTO GENERAL DEL HABITAD DEL GRUPO ANIMAL
	@Override
	public void Comportamiento() {
		System.out.println("Siempre en el estanque, ningun incoveniente.");
	}
	//ALIMENTACION Y CONDICIONES DEL GRUPO ANIMAL
	@Override
	public void Alimentacion() {
		System.out.println("Generalmente alimentos para peces.");
	}
	@Override
	public void Condiciones() {
		System.out.println("tener cuidado con algunas especies al ingresar"
				+ " a supervisar el tanque.");
	}
}
