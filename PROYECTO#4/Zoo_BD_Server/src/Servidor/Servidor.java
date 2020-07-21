package Servidor;

import java.net.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import UI.DB;
public class Servidor extends Thread{
	//CONEXION A LA BASE DE DATOS
	DB db = DB.getBase();
	//ELEMENTOS DEL ERVIDOR
	private Socket so;
	private ServerSocket sso;
	private DataInputStream data;
	private DataOutputStream dar;
	
	@Override
	public void run() {
		try {
			sso = new ServerSocket(5558);/*SERVER CON ESCUCHA AL PUERTO 55558*/
			while(true) {
				try {
					so = sso.accept();/*ACEPTA LAS PETICIONES QUE LLEGAN AL SOCKET*/
					data = new DataInputStream(so.getInputStream());
					String comand[] = data.readUTF().split(" ");/*DIVIDE LA CADENA ENVIADA POR EL CLIENTE
																*EN PARTS IGUALES POR CADA " "*/
					dar = new DataOutputStream(so.getOutputStream());
					dar.writeUTF(Consulta(comand));/*ENVIA EL RESULTADO DE LA CONSULTA AL CLINTE*/
					data.close();/*CIERRA EL FLUJO DE ENTRADA*/
					dar.close();/*CIERRA EL FLUJO DE SALIDA*/
				}catch(IOException e) {
					System.out.println("ERROR AL ESCRIBIR SERVIDOR: "+e.getMessage());
				}
			}
		}catch(IOException l) {
			System.out.println("ERROR AL INICIAR SERVIDOR: "+l.getMessage());
		}finally {
			try {
				sso.close();
				so.close();
			}catch(IOException e) {
				
			}
		}
	}
	private String Consulta(String comand[]) {
		try {
			//EL SERVIDOR ENVIA LOS COMANDOS EXISTENTES AYUDANDO AL USUARIO
			if(comand[0].equalsIgnoreCase("Ayudame")) {
				return "\nSERVIDOR: Bienvnido al Sistema de Alpamira!\n"
						+ "Comandos:\n"
						+ "->/Mostrar All (Todos los animales)\n"
						+ "->/Mostrar Grupo (Motsrar el Grupo indicado)\n"
						+ "->Buscar (Id del animal a buscar)\n"
						+ "->BuscarN (Nombre del animal a buscar)\n"
						+ "->/Clear (Borrar Texto)\n\n"
						+ "NOTA: no es necesario escribir la primera\n"
						+ "letra en mayuscula\n"
						+ "QUE TENGA UN FELIZ DIA DE TRABAJO!\n";
			}
			//MOSTRAR ANIMAL DE GRUP ESPECIFICADO POR EL USUARIO
			if(comand[0].equalsIgnoreCase("/Mostrar")) {
				if(comand[1].equalsIgnoreCase("All")) {
					return db.Mostrar("SELECT*FROM Animales ORDER BY Id_animal ASC");
				}
				else {
					/*PRIMERO SE CORRIGE EL TEXTO INGRESADO POR EL USUARIO (FORMA NO1)
					 * SE TRANSFORMA TODA LA CADENA DE CARACTES A MINUSCULCULAS Y LUEGO SE
					 * CONVIRTE LA PRIMERA LETRA EN MAYUSCULA, TOMA EL PRIMER CARACTER DE LA CADENA
					 * A TRAVES DE UN "substring();" Y LUEGO CON EL METODO "ToUpperCase();" COLCA
					 * ESE CARACTER EN MAYUSCULAS, POR ULTIMO SE CONCATENA CON EL RESTO DE LA CADENA
					 * YENDO DESDE LA POSICION 1 DE LA CADENA HASTA LA ULTIMA POSICION "length();"*/
					comand[1]=comand[1].toLowerCase();
					comand[1]=comand[1].substring(0,1).toUpperCase()+comand[1].substring(1,comand[1].length());
					if(db.Mostrar("SELECT*FROM Animales WHERE grupo='"+comand[1]+"' ORDER BY Id_animal ASC")!="") {
						return db.Mostrar("SELECT*FROM Animales WHERE grupo='"+comand[1]+"' ORDER BY Id_animal ASC");
					}
					else {
						return "SERVIDOR: GRUPO NO EXISTENTE EN EL ZOO\n";
					}
				}
			}
			//EL SERVIDOR TE RESPONDE CON UN PACMAN
			if(comand[0].equalsIgnoreCase(":)")) {
				return "SERVIDOR: :v\n";
			}
			//BUSCAR ANIMAL DE ID=? ESPECIFICADO POR EL USUARIO
			if(comand[0].equalsIgnoreCase("/Buscar")) {
				if(db.Mostrar("SELECT*FROM Animales WHERE Id_animal="+comand[1])!="") {
					return db.Mostrar("SELECT*FROM Animales WHERE Id_animal="+comand[1]);
				}
				else {
					return "SERVIDOR: SIN INFORMACION\n";
				}
			}
			//BUSCAR ANIMAL DE NOMBRE=? ESPECIFICADO POR EL USUARIO
			if(comand[0].equalsIgnoreCase("/BuscarN")) {
				if(db.BuscarN(comand[1])!=null) {
					return db.BuscarN(comand[1]);
				}
				else {
					return "SERVIDOR: SIN INFORMACION\n";
				}
			}
			/*EN EL CASO DE NO CUMPLIR NINGUNA CONDICION
			 * EL COMANDO ES ERRONEO Y SE RETORNA UN ERROR*/
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "SERVER: ERROR\n";/*MENSAJE DE ERROR SI EL COMANDO ES INCORRECTO*/
	}
}
