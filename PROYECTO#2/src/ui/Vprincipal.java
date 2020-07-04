package ui;
import Grupos_A.*;
import animal.Animal;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
public class Vprincipal extends JFrame implements ActionListener {
	
	//INSTANCIA DE SISTEMA_ZOO
	Sistema_ZOO sis = new Sistema_ZOO();
	//ELEMENTOS DEL MENÚ PRINCIPAL
	private JButton b1,b2,b3;/*BOTONES (OPCIONES)*/
	private JButton back;
	private JLabel et;/*ETIQUETA (TITULO)*/
	private JPanel menu = new JPanel();
	
	//CONSTRUCTOR VACIO
	public Vprincipal() {
		super("SISTEMA DE PALMIRA");
		setLayout(null);
		setSize(500,400);/*TAMAÑO DE LA VENTANA*/
		setLocationRelativeTo(null);/*VENTANA SIEMPRE CENTRADA*/
		setResizable(false);/*EL USUARIO NO PUEDE EDITAR LA VENTANA*/
		setVisible(true);/*HACER VISIBLE*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*CERRA PROCESO*/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);/*LIBERAR RECURSOS DEL PROCESO*/
		menu.setLayout(null);
		setContentPane(menu);/*PANEL DEL MENU*/
		PElementos();/*ELEMTOS DEL MENÚ PRINCIPAL*/
	}
	//CREACION DE TODOS LOS ELEMENTOS DEL MENÚ PRINCIPAL
	public void PElementos() {
		this.b1 = new JButton("Mostrar Lista");
		this.b2 = new JButton("Agregar Animal");
		this.b3 = new JButton("Comportamientos");
		//DIMENSIONES Y POSICION DE CADA BOTON
		this.b1.setBounds(165,150,170,30);
		this.b2.setBounds(165,180,170,30);
		this.b3.setBounds(165,210,170,30);
		//ACCIONES
		this.b1.addActionListener(this);
		this.b2.addActionListener(this);
		this.b3.addActionListener(this);
		//HACER VISIBLES
		this.b1.setVisible(true);
		this.b2.setVisible(true);
		this.b3.setVisible(true);
		//AÑADIR AL PANEL
		menu.add(b1);menu.add(b2);menu.add(b3);
		//ETIQUETA
		this.et = new JLabel("ZOOLOGICO DE PALMIRA");
		this.et.setBounds(165,100,190,50);
		this.et.setVisible(true);
		menu.add(et);
		this.et.repaint();
		BotonS();/*BOTON DE VOLVER AL MENÚ PRICIPAL*/
	}
	//BOTON QUE PERMITE VOLVER AL MENÚ PRINCIPAL
	public void BotonS() {
		back = new JButton("VOLVER");
		back.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		//EVENTO DEL BOTON B1
		if(e.getSource()==b1) {
			setSize(600,400);/*SE ESTABLECE OTRO TAMAÑO DEL JFRAME*/
			VMostrar l = new VMostrar(sis.lista());
			back.setBounds(20,330,100,30);/*SE ESTABLECE OTRAS DIMENSIONES PARA EL BOTON BACK*/
			back.setVisible(true);
			l.add(back);/*SE AÑADE AL PANEL VMOSTRAR*/
			setContentPane(l);/*SE COLOCA EL NUEVO PANEL EN EL JFRAME*/
		}
		//EVENTO DEL BOTON B2
		if(e.getSource()==b2) {
			setSize(500,250);/*SE ESTABLECE OTRO TAMAÑO DEL JFRAME*/
			Vagregar l = new Vagregar(sis.lista());
			back.setBounds(20,180,100,30);/*SE ESTABLECE OTRAS DIMENSIONES PARA EL BOTON BACK*/
			back.setVisible(true);
			l.add(back);/*SE AÑADE AL PANEL VAGREGAR*/
			setContentPane(l);/*SE COLOCA EL NUEVO PANEL EN EL JFRAME*/
		}
		//EVENTO DEL BOTON B3
		if(e.getSource()==b3) {
			setSize(500,400);
			Vcomportamiento l = new Vcomportamiento();
			back.setBounds(10,288,100,30);/*SE ESTABLECE OTRAS DIMENSIONES PARA EL BOTON BACK*/
			back.setVisible(true);
			l.add(back);/*SE AÑADE AL PANEL VAGREGAR*/
			setContentPane(l);
		}
		//EVENTO DEL BOTON BACK
		if(e.getSource()== back) {
			setSize(500,400);/*SE REESTABLECE AL TAMAÑO ORIGINAL TAMAÑO DEL JFRAME*/
			setContentPane(menu);/*SE COLOCA EL PANEL PRINCIPAL MENÚ*/
			back.setVisible(false);/*SE HACE INVIBLE EL BOTÓN BACK*/
		}
	}
}
