package ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import animal.Animal;

public class VMostrar extends JPanel{
	//ELEMENTOS DEL PANEL
	private JButton b1,b2;/*BOTOINES*/
	private JTextArea mos;
	private JScrollPane scroll;
	private JLabel titu;
	private JButton busc,aceptar;
	private JOptionPane men;
	//CONSTRUCTOR VACIO
	public VMostrar(ArrayList<Animal> p) {
		setSize(600,400);/*TAMAÑO DEL PANEL*/
		setLayout(null);
		Elementos();
		Mostrar(p);
		//EVENTO AL PRECIONAR EL BOTON BUSC
		this.busc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				//PIDE AL USUARIO QUE INGRESE EL GRUPO O ESPECIE ANIMAL
				String an=men.showInputDialog(null,"Ingrese Especie, Grupo Animal o Nombre");
				if(Filtrar(an,p)!="") {
					mos.setText(null);/*LIMPIA EL JTEXTAREA*/
					aceptar.setVisible(true);/*VUELVE VISIBLE EL BOTON ACEPTAR*/
					mos.setText(Filtrar(an,p));/*MUESTRA LOS ANIMALES ENCONTRADOS*/
				}
				else {
					men.showMessageDialog(null,"No encontrado");
				}
			}
		});
		//EVENTO AL PRECIONAR EL BOTON ACEPTAR
		this.aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				//VUELVE A MOSTRAR LA LISTA COMPLETA
				Mostrar(p);
				aceptar.setVisible(false);
			}
		});
	}
	private void Elementos() {
		//TEXT AREA
		this.mos = new JTextArea();
		this.mos.setEditable(false);/*EL USUARIO NO PODRÁ EDITAR EL TEXTO*/
		add(mos);
		//SCROLL PANE
		this.scroll = new JScrollPane(mos);
		this.scroll.setBounds(60,100,500,200);
		this.scroll.setVisible(true);
		add(this.scroll);
		//ETIQUETA
		this.titu = new JLabel("ANIMALES DEL ZOOLOGICO: ");
		this.titu.setBounds(50,20,200,70);
		this.titu.setVisible(true);
		add(this.titu);
		//BOTONES
		this.busc = new JButton("FILTRAR");
		this.aceptar = new JButton("ACEPTAR");
		//DIMENSIONES
		this.busc.setBounds(480,330,100,30);
		this.aceptar.setBounds(255,330,100,30);
		//INVISIBLE
		this.aceptar.setVisible(false);
		//AÑADIR AL PANEL
		add(this.busc);add(this.aceptar);
		//MENSAJE PARA EL USUARIO
		men = new JOptionPane();
	}
	//MOTSRAR TODOS LOS ANIMALES DE LA LISTA
	private void Mostrar(ArrayList<Animal> f) {
		String texto="";/*VARIABLE TIPO STRING AUXILIAR*/
		for(int i=0;i<f.size();i++) {
			texto+=f.get(i)+ "\n";/*ALMACENA TODO EN LA VARIABLE TIPO STRING*/
		}
		this.mos.setText(texto);/*MUESTRA EN EL JTEXTAREA LA LISTA*/
	}
	//BUSQUEDA POR NOMBRE
	private String Filtrar(String nom, ArrayList<Animal> l) {
		String n="";
		for(int i=0;i<l.size();i++) {
			if(nom.equalsIgnoreCase(l.get(i).getEspecie())||nom.equalsIgnoreCase(l.get(i).getGrupo())||nom.equalsIgnoreCase(l.get(i).getNombre())) {
				n+=l.get(i)+ "\n";
			}
		}
		return n;/*RETORNA LOS DATOS ENCONTRADOS*/
	}
}
