package UI;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Vprincipal extends JFrame implements ActionListener{
	//ELEMENTOS DE LA VENTANA
	JPanel principal = new JPanel();
	private JLabel et;
	private JButton b1,b2,b3,back;
	//CONEXION CON BASE DE DATOS
	DB l = DB.getBase();
	//CONSTRUCTOR VACIO
	public Vprincipal() {
		super("SISTEMA DE PALMIRA");/*TITULO DE LA VENTANA*/
		setLayout(null);
		setSize(450,200);/*TAMAÑO DE LA VENTANA*/
		setResizable(false);/*VENTANA NO EDITABLE POR EL USUARIO*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*CERRA PROCESO*/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);/*LIBERAR RECURSOS DEL PROCESO*/
		setLocationRelativeTo(null);/*POSICION CENTRAL EN LA PANTALLA*/
		Elementos();/*ELEMENTOS DE LA VENTANA CREADOS JUNTO CON UN PANEL*/
		setContentPane(principal);/*SE AÑADE EL PANEL CON TODOS LOS ELEMENTOS A LA VENTANA*/
		setVisible(true);/*VENTANA VISIBLE*/
	}
	//ELEMENTOS
	private void Elementos() {
		principal.setLayout(null);/*DAR LA ṔOSICION DE LOS ELEMENTOS DE FORMA "MANUAL"*/
		//ETIQUETA
		et = new JLabel("ZOOLOGICO DE PALMIRA");
		//DIMENSIONES DE LA ETIQUETA
		et.setBounds(140,5,200,60);
		//BOTONES
		b1 = new JButton("MOSTRAR");
		b2 = new JButton("AGREGAR");
		b3 = new JButton("COMPORT");
		back = new JButton("VOLVER");
		//DIMENSIONES DE LOS BOTONES
		b1.setBounds(10,60,140,100);
		b2.setBounds(155,60,140,100);
		b3.setBounds(300,60,140,100);
		//EVENTOS DE LOS BOTONES
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		back.addActionListener(this);
		//HACER INVISIBLE
		back.setVisible(false);
		//AÑADIR ELEMENTOS AL PANEL
		principal.add(et);principal.add(b1);
		principal.add(b2);principal.add(b3);
		//GENERAR EVENTOS PARA OTROS BOTONES
	}
	//PERMITE CAMBIAR DE VISTA, TAMAÑO Y CENTRAR LA VENTANA 
	private void Cambiar(int i,int j,JPanel l) {
		setBounds(400,300,i,j);
		setContentPane(l);
	}
	//COLOCAR EL BOTON BACK EN PANELES DISTINTOS "p" EN UNA POSICION "i" "j"
	private void Colocar_B(int i,int j,JPanel p) {
		back.setBounds(i,j,100,30);
		back.setVisible(true);
		p.add(back);/*AÑADIR AL PANEL "p"*/
	}
	//EVENTOS
	public void actionPerformed(ActionEvent e) {
		//CAMBIAR DE PANEL 
		if(e.getSource()==b1) {
			Vmostrar mostrar = new Vmostrar();/*INSTANCIA CON LA CLASE Vmostrar (se crea el panel mostrar)*/
			Colocar_B(10,330,mostrar);
			Cambiar(700,400,mostrar);
		}
		if(e.getSource()==b2) {
			Vagregar agregar = new Vagregar();/*INSTANCIA CON LA CLASE Vagregar (se crea el panel agregar)*/
			Colocar_B(10,235,agregar);
			Cambiar(500,300,agregar);
		}
		if(e.getSource()==b3) {
			Vcomportamiento comportamiento = new Vcomportamiento();/*INSTANCIA CON LA CLASE Vcomportamiento (se crea el panel comportamiento)*/
			Colocar_B(10,330,comportamiento);
			Cambiar(500,400,comportamiento);
		}
		//BOTON VOLVER
		if(e.getSource()==back) {
			back.setVisible(false);
			Cambiar(450,200,principal);/*CADA VEZ QUE EL USUARIO PRESIONE EL BOTON VOLVER 
										*SE COLOCARÁ NUEVAMENTE EL PANEL PRINCIPAL(menú principal)*/
		}
	}
}
