package ui;

import java.util.ArrayList;
import animal.Animal;
import Grupos_A.*;

public class Sistema_ZOO {
	private ArrayList<Animal> lista = new ArrayList<Animal>();
	//CONSTRUCTOR VACIO
	public Sistema_ZOO() {
		Default();
	}
	private void Default() {
		//AVES
		Aves l = new Aves("Corni","loro",17,0.5f,12);
		Aves l1 = new Aves("Loki","aguila",34,1.3f,9);
		Aves l2 = new Aves("Sandre","guacamayo",21,0.6f,18);
		Aves l3 = new Aves("Samuel","Perico",12.1f,0.2f,2);
		//PECES
		Peces l4 = new Peces("Tommy","globo",13,0.3f,2);
		Peces l5 = new Peces("Angry","payazo",1.1f,0.1f,3);
		//REPTILES
		Reptiles l6 = new Reptiles("Comandante","lagarto",67.5f,1.8f,11);
		Reptiles l7 = new Reptiles("Porta","serpiene",39.5f,2.2f,8);
		Reptiles l8 = new Reptiles("Kenny","serpiente",13.5f,0.6f,11);
		//PRIMATES
		Primates l9 = new Primates("Lonza","mono",45.2f,1.3f,24);
		Primates l10 = new Primates("Taco","orangutan",43.2f,1.2f,21);
		Primates l11 = new Primates("Lider","gorila",75.3f,1.6f,17);
		Primates l12 = new Primates("Gloria","chimpance",41.4f,1.4f,7);
		//FELINOS
		Felinos l13 = new Felinos("Rayo","leopardo",65.3f,1.7f,13);
		Felinos l14 = new Felinos("Risa","tigre",48.1f,1.6f,16);
		Felinos l15 = new Felinos("Funny","tigrillo",41.4f,1.4f,7);
		Agregar(l);Agregar(l1);Agregar(l2);
		Agregar(l3);Agregar(l4);Agregar(l5);
		Agregar(l6);Agregar(l7);Agregar(l8);
		Agregar(l9);Agregar(l10);Agregar(l11);
		Agregar(l12);Agregar(l13);Agregar(l14);
		Agregar(l15);
	}
	//AGREGAR ANIMAL A LISTA TENIENDO QUE SER EL OBJETO SIEMPRE TIPO ANIMAL
	private void Agregar(Animal a) {
		lista.add(a);
	}
	//RETORNAR LA LISTA
	public ArrayList<Animal> lista() {
		return lista;
	}
}
