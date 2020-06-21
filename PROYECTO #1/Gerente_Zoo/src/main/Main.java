/*NOMBRE: ANDRÉS CHAPARRO CI:27552207
 * MATERIA: PROGRAAMCION ORIENTADA A OBJETOS 2020B
 * 21/6/2020
 * PUEDEN SER AGREGADOS LOS SIGUIENTES ANIMALES:
 * LOROS, AGUILAS, GUACAMAYOS, PERICOS
 * PECES GLOBOS, PECES PAYASOS, PECES BETA, PECES SALMON
 * MONOS, ORANGUTANES, GORILAS, CHIPAMCESES
 * LAGARTOS Y SERPIENTES(serpientes sin tomar encuenta sus muchas especies)
 * LEON, TOGRE LEOPARDO Y TIGRILLO
 * ESTOS SON LOS ANIMALES ACEPTADOS POR EL ZOOLOGICO*/

package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

import animal.Animal;
import Grupos_A.*;

public class Main {
	static ArrayList<Animal> lista = new ArrayList<>();/*LISTA TIPO ANIMAL*/
	public static void main(String args[]) {
		Default();/*AÑADIR ANIMALES POR DEFAULT*/
		Scanner leer = new Scanner(System.in).useLocale(Locale.US);/*OBJETO TIPO SCANNER*/
		int o; /*VARIABEL AUXILIAR, EL NUMERO QUE TOME ESTA VARIABLE SERÁ LA OPCION A EJECUTAR*/
		do {
			//MENU
			System.out.println("1.-Mostar Animales");
			System.out.println("2.-Mostar info Sobre Comportamiento");
			System.out.println("3.-Agregar Animal");
			System.out.println("4.-Salir del Sistema");
			System.out.print("Opcion: ");
			o=leer.nextInt();/*OPCION INGRESADA POR EL USUARIO*/
			//POSIBLES OPCIONES
			switch(o) {
			//MOSTRAR LISTA DE ANIMALES
				case 1:
					Mostrar();
				break;
			//INFO SOBRE COMPORTAMEINTO DE GRUPOS DE ANIMALES
				case 2:
					Info_Grupos info = new Info_Grupos();/*AL LLAMAR AL CONSTRUCTOR VACIO 
														SALE UN MENU SECUNDARIO INTERACTUABLE*/
				break;
			//AGREGAR ANIMAL
				case 3:
					System.out.print("Nombre: ");
					leer.nextLine();/*LIMPIAR BUFFER*/
					String nom=leer.nextLine();/*NOMBRE INGRESADO POR USUARIO*/
					System.out.print("Especie: ");
					String esp=leer.nextLine();;/*ESPECIE INGRESADA POR EL USUARIO*/
					System.out.print("Peso: ");
					float pes=leer.nextFloat();;/*PESO INGRESADA POR EL USUARIO*/
					System.out.print("Altura: ");
					float alt=leer.nextFloat();;/*ALTURA INGRESADA POR EL USUARIO*/
					System.out.print("Edad: ");
					int ed=leer.nextInt();/*EDAD INGRESADA POR EL USUARIO*/
					ins_esp(nom,esp,pes,alt,ed);
				break;
			}
		}while(o!=4);/*SI O=4 TERMINA EL CICLO Y A SU VEZ EL PROGRAMA*/
	}
	//METODOS A USAR
	//ANIMALES YA INCLUIDOS EN EL ZOO
	public static void Default() {
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
	public static void Agregar(Animal a) {
		lista.add(a);
	}
	//MUESTROR TODOS LOS ANIMALES DE LA LISTA
	public static void Mostrar() {
		for(int i=0;i<lista.size();i++) {
			System.out.println(lista.get(i));/*ANIMAL POSICION "i" DEL ARRAYLIST*/
		}
	}
	/*CREAR INSTANCIA DE CLASE SEGUN LA ESPECIE INGRESADA POR EL USUARIO
	 * Y ALMACENAR EN LISTA*/
	public static void ins_esp(String a,String b,float c,float d,int e) {
		//a=NOMBRE, b=ESPECIE, c=PESO, d=ALTURA, e=EDEAD
		if(b.equalsIgnoreCase("Loro")||b.equalsIgnoreCase("Aguila")||b.equalsIgnoreCase("Guacamayo")||b.equalsIgnoreCase("Perico")) {
			Aves Ag = new Aves(a,b,c,d,e);
			Agregar(Ag);
		}
		else
			if(b.equalsIgnoreCase("Globo")||b.equalsIgnoreCase("Payaso")||b.equalsIgnoreCase("Beta")||b.equalsIgnoreCase("Salmon")) {
				Peces Ag = new Peces(a,b,c,d,e);
				Agregar(Ag);
			}
			else
				if(b.equalsIgnoreCase("Mono")||b.equalsIgnoreCase("Orangutan")||b.equalsIgnoreCase("Gorila")||b.equalsIgnoreCase("Chimpance")) {
					Primates Ag = new Primates(a,b,c,d,e);
					Agregar(Ag);
				}
				else
					if(b.equalsIgnoreCase("Lagarto")||b.equalsIgnoreCase("Serpiente")) {
						Reptiles Ag = new Reptiles(a,b,c,d,e);
						Agregar(Ag);
					}
					else
						if(b.equalsIgnoreCase("Leon")||b.equalsIgnoreCase("Trige")||b.equalsIgnoreCase("leopardo")||b.equalsIgnoreCase("Tigrillo")) {
							Felinos Ag = new Felinos(a,b,c,d,e);
							Agregar(Ag);
						}
						else {
							System.out.println("Especie no disponible para el Zoologico");
						}
	}
}