/*NOMBRE: ANDŔES CHAPARRO, CI:27552207
 * PROYECTO#2 PROGRAMACION ORIENTADA A OBJETOS URU
 */
package ui;

import javax.swing.*;
import Grupos_A.*;
import java.awt.event.*;
import java.util.ArrayList;
import animal.Animal;

public class Vagregar extends JPanel implements ActionListener{
	//ELEMENTOS DEL PANEL
	private JButton ag,pre;/*BOTON DE AGREGADO*/
	private JTextField t1,t2,t3,t4,t5;/*CAMPOS DE TEXTO*/
	private JLabel e1,e2,e3,e4,e5,titulo;
	private JOptionPane men;
	//CONTRUCTOR
	public Vagregar(ArrayList<Animal> h) {
		setSize(500,250);/*TAMAÑO DEL PANEL*/
		setLayout(null);
		Elementos();
		this.ag.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//SI ALGUNOS DE LOS CAMPOS ESTA VACIO, NO PERMITIRÁ AL USUARIO AÑADIR
				if(!t1.getText().isEmpty()&&!t2.getText().isEmpty()&&!t3.getText().isEmpty()&&!t4.getText().isEmpty()&&!t5.getText().isEmpty()) {
					//MIENTRAS EL NOMBRE NO COINCIDA CON EL DE OTRO ANIMAL, PERMITIRA AÑADIR
					/*SE COMPRUEBA MEDIANTE LA FUNCION COMPROBAR */
					if(!Comprobar(h,t1.getText())) {
						Animal p = Crear(t1.getText(),t2.getText(),Float.parseFloat(t3.getText()),Float.parseFloat(t4.getText()),Integer.parseInt(t5.getText()));
						//Si el Objeto es diferente de NULL, añade al nuevo Animal
						if(p!=null) {
							h.add(p);
							Borrar();/*SE BORRA EL TEXTO DE LOS JTEXTFIELD*/
							men.showMessageDialog(null,"Añadido Correctamente");/*MENSAJE DE CONFIRMACION AL AÑADIR*/
						}
						else {
							men.showMessageDialog(null,"Animal no permitido");/*MENSAJE DE ERROR AL SER EL OBJETO NULO*/
						}
					}
					else {
						men.showMessageDialog(null,"Nombre Ocupado");/*MENSAJE DE ERROR AL COINCIDIR ALGUN NOMBRE*/
					}
				}
				else {
					men.showMessageDialog(null,"INFORMACION INCOMPLETA");/*MENSAJE DE ERROR POR ALGUN CAMPO DE TEXTO VACIO*/
				}
			}
		});
	}
	//ELEMENTOS DEL PANEL
	private void Elementos() {
		//CREACION DE LOS CAMPOS DE TEXTO
		this.t1 = new JTextField();
		this.t2 = new JTextField();
		this.t3 = new JTextField();
		this.t4 = new JTextField();
		this.t5 = new JTextField();
		//TAMAÑOS DE LOS CAMPOS DE TEXTO
		this.t1.setBounds(80,70,90,30);/*NOMBRE DEL ANIMAL*/
		this.t2.setBounds(245,70,90,30);/*ESPECIE DEL ANIMAL*/
		this.t3.setBounds(80,120,90,30);/*PESO DEL ANIMAL*/
		this.t4.setBounds(245,120,90,30);/*ALTURA DEL ANIMAL*/
		this.t5.setBounds(395,120,90,30);/*EDAD DEL ANIMAL*/
		//GENERAR EVENTOS
		SoloLetras(t1);SoloLetras(t2);
		SoloNumeros(t3);SoloNumeros(t4);SoloNumeros(t5);
		//AÑADIR AL PANEL
		add(this.t1);add(this.t2);
		add(this.t3);add(this.t4);
		add(this.t5);
		//ETIQUETAS
		this.titulo = new JLabel("SISTEMA DE AGREGADO PARA NUEVOS ANIMALES");
		this.e1 = new JLabel("NOMBRE:");
		this.e2 = new JLabel("ESPECIE:");
		this.e3 = new JLabel("PESO:");
		this.e4 = new JLabel("ALTURA:");
		this.e5 = new JLabel("EDAD:");
		//TAMAÑO DE LAS ETIQUETAS
		this.titulo.setBounds(10,10,400,40);
		this.e1.setBounds(10,70,70,30);
		this.e2.setBounds(180,70,70,30);
		this.e3.setBounds(10,120,70,30);
		this.e4.setBounds(180,120,70,30);
		this.e5.setBounds(345,120,70,30);
		//HACER VISIBLE
		this.titulo.setVisible(true);
		this.e1.setVisible(true);
		this.e2.setVisible(true);
		this.e3.setVisible(true);
		this.e4.setVisible(true);
		this.e5.setVisible(true);
		//AÑADIR AL PANEL
		add(this.titulo);add(this.e1);
		add(this.e2);add(this.e3);
		add(this.e4);add(this.e5);
		//BOTONES
		this.pre = new JButton("?");
		this.ag = new JButton("AÑADIR");
		//TAMAÑO DE LOS BOTONES
		this.pre.setBounds(395,70,90,30);
		this.ag.setBounds(385,180,100,30);
		//ACCION DEL BOTON
		this.pre.addActionListener(this);
		//HACER VISIBLE
		this.pre.setVisible(true);
		this.ag.setVisible(true);
		this.ag.setEnabled(true);
		//AÑADIR AL PANEL
		add(this.pre);add(this.ag);
		//MENSAJE PARA EL USUARIO "?"
		men = new JOptionPane();
	}
	private Animal Crear(String n,String esp,float p,float alt,int ed) {
		if(esp.equalsIgnoreCase("Leon")||esp.equalsIgnoreCase("Tigre")||esp.equalsIgnoreCase("Leopardo")||esp.equalsIgnoreCase("Tigrillo")) {
			Felinos g = new Felinos(n,esp,p,alt,ed);;
			return g;
		}
		else
			if(esp.equalsIgnoreCase("Lagarto")||esp.equalsIgnoreCase("Serpiente")) {
				Reptiles g = new Reptiles(n,esp,p,alt,ed);
				return g;
			}
			else
				if(esp.equalsIgnoreCase("Mono")||esp.equalsIgnoreCase("Orangutan")||esp.equalsIgnoreCase("Gorila")||esp.equalsIgnoreCase("Chimpance")) {
					Primates g = new Primates(n,esp,p,alt,ed);
					return g;
				}
				else
					if(esp.equalsIgnoreCase("Globo")||esp.equalsIgnoreCase("Payaso")||esp.equalsIgnoreCase("Beta")||esp.equalsIgnoreCase("Salmon")) {
						Peces g = new Peces(n,esp,p,alt,ed);
						return g;
					}
					else
						if(esp.equalsIgnoreCase("Loro")||esp.equalsIgnoreCase("Aguila")||esp.equalsIgnoreCase("Guacamayo")||esp.equalsIgnoreCase("Perico")) {
							Aves g = new Aves(n,esp,p,alt,ed);
							return g;
						}
						return null;/*SI LA ESPECIE INGRESADA NO COINCIDE RETORNA NULO
									*DE FORMA QUE SE GENERA UN MENSAJE DE ERROR EVITANDO
									*QUE EL USUARIO INGRE UN VALOR NULO EN LA LISTA*/
	}
	//BORRAR TEXTO DE LOS JTEXTFIELD
	private void Borrar() {
		t1.setText(null);t2.setText(null);
		t3.setText(null);t4.setText(null);
		t5.setText(null);
	}
	/*SE LE INGRESA UN OBEJTO TIPO JTEXTFIELD Y GENERA UN EVENTO
	 * QUE DETECTA SI EL USUARIO TECLEA UN CARACTER
	 * EVITANDO QUE USUARIO LO INGRESE*/
	private void SoloNumeros(JTextField t) {
		t.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			/*SI EL USUARIO TELCEA ALGUN CARACTER, NO SERÁ PERMITIDO
			 *Y SALDRÁ UN MENSAJE DE ERROR*/
			@Override
			public void keyTyped(KeyEvent ev) {
				char dato=ev.getKeyChar();
				if(Character.isLetter(dato)) {
					getToolkit().beep();
					ev.consume();
					men.showMessageDialog(null,"INGRESE SOLO DATOS NUMERICOS");
				}
			}
		});
	}
	/*SE LE INGRESA UN OBEJTO TIPO JTEXTFIELD Y GENERA UN EVENTO
	 * QUE DETECTA SI EL USUARIO TECLEA UN DATO NUMERICO
	 * EVITANDO QUE USUARIO LO INGRESE*/
	private void SoloLetras(JTextField t) {
		t.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
			}
			/*SI EL USUARIO TELCEA ALGUN NUMERO, NO SERÁ PERMITIDO
			 *Y SALDRÁ UN MENSAJE DE ERROR*/
			@Override
			public void keyTyped(KeyEvent ev) {
				char dato=ev.getKeyChar();
				if(Character.isDigit(dato)) {
					getToolkit().beep();
					ev.consume();
					men.showMessageDialog(null,"INGRESE SOLO CARACTERES");
				}
			}
		});
	}
	//NOMBRE DISPONIBLE
	public boolean Comprobar(ArrayList<Animal> l,String n) {
		for(int i=0;i<l.size();i++) {
			if(n.equalsIgnoreCase(l.get(i).getNombre())) {
				return true;/*SI EL NOMBRE COINCIDE RETORNA TRUE*/
			}
		}
		return false;/*SI NO COINCIDE NINGUN NOMBRE RETORNA FALSE*/
	}
	//EVENTOS
	public void actionPerformed(ActionEvent o) {
		//MENSAJE DE AYUDA PARA EL USUARIO
		if(o.getSource()==pre) {
			men.showMessageDialog(null,"SOLO SE PUEDEN AÑADIR LOS SIGUIENTES ANIMALES:\n"
					+ "LEON, TIGRE, LEOPARDO, TIGRILLO,\n"
					+ "LAGARTO, SERPIENTE, MONO, ORANGUTAN,\n"
					+ "GORILA, CHIMPANCE, PEZ GLOBO, PEZ PAYASO\n"
					+ "PEZ BETA, PEZ SALMON, LORO, AGUILA\n"
					+ "GUACAMAYO Y PERICO");
					
		}
	}
}