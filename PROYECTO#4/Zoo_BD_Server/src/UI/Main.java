package UI;

import Servidor.Servidor;

public class Main {
	public static void main(String args[]) {
		Vprincipal l = new Vprincipal();
		Servidor ser = new Servidor();/*INSTANCIA CON LA CLASE SERVIDOR*/
		ser.start();/*INICIA EL HILO, COMENZANDO EL PROCESO DEL SERVIDOR
					 *HASTA QUE LA VENTANA SEA CERRADA*/
	}
}
