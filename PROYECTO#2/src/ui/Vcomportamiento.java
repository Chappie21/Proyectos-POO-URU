package ui;

import javax.swing.*;
import Grupos_A.*;
import java.awt.event.*;
import animal.Animal;

public class Vcomportamiento extends JPanel implements ActionListener {
	//INSTANCIAS
	Felinos f = new Felinos();
	Primates pr = new Primates();
	Aves Av = new Aves();
	Peces ps = new Peces();
	Reptiles rep = new Reptiles();
	//ELEMENTOS DEL PANEL
	private JTextArea info;
	private JScrollPane scroll;
	private JButton b1,b2,b3,b4,b5;
	private JLabel et;
	//CONSTRUCTOR VACIO
	public Vcomportamiento() {
		setSize(500,400);
		setLayout(null);
		Elementos();
	}
	//CREACION DE LOS ELEMENTOS DEL PANEL
	private void Elementos() {
		//CREACION DE LOS BOTONES
		b1 = new JButton("FELINOS");
		b2 = new JButton("PRIMATES");
		b3 = new JButton("AVES");
		b4 = new JButton("PECES");
		b5 = new JButton("REPTILES");
		//DIMENSIONES DE LOS BOTONES
		b1.setBounds(10,95,100,30);
		b2.setBounds(10,125,100,30);
		b3.setBounds(10,155,100,30);
		b4.setBounds(10,185,100,30);
		b5.setBounds(10,215,100,30);
		//EVENTOS
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		//AÑADIR AL PANEL
		add(b1);add(b2);add(b3);
		add(b4);add(b5);
		//CREACION DEL JTEXTAREA
		info = new JTextArea();
		info.setEditable(false);/*NO EDITABLE POR EL USUARIO*/
		//CRECION DEL SCROLLPANE
		scroll = new JScrollPane(info);
		//DIMENSIONS DEL SCROLLPANE
		scroll.setBounds(130,20,360,300);
		//AÑADIR AL PANEL
		add(scroll);
	}
	public void actionPerformed(ActionEvent l) {
		info.setText(null);/*CADA VEZ QUE SE EJECUTE UN EVENTO S LIMPIA EL JTEXTAREA*/
		if(l.getSource()==this.b1) {
			info.setText(f.Comportamiento()+"\n\n"+f.Alimentacion()+"\n\n"+f.Condiciones()+"\n\n"+f.actos());
		}
		if(l.getSource()==this.b2) {
			info.setText(pr.Comportamiento()+"\n\n"+pr.Alimentacion()+"\n\n"+pr.Condiciones()+"\n\n"+pr.Compartir());
		}
		if(l.getSource()==this.b3) {
			info.setText(Av.Comportamiento()+"\n\n"+Av.Alimentacion()+"\n\n"+Av.Condiciones()+"\n\n"+Av.Volar());
		}
		if(l.getSource()==b4) {
			info.setText(ps.Comportamiento()+"\n\n"+ps.Alimentacion()+"\n\n"+ps.Condiciones());
		}
		if(l.getSource()==b5) {
			info.setText(rep.Comportamiento()+"\n\n"+rep.Alimentacion()+"\n\n"+rep.Condiciones()+"\n\n"+rep.Exhibicion());
		}
	}
}
