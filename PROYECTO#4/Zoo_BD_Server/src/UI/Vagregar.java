package UI;

import javax.swing.*;
import java.awt.event.*;
import Grupos_A.*;
public class Vagregar extends JPanel implements ActionListener{
	//CONEXION
	DB l = DB.getBase();
	//ELEMENTOS DEL PANEL
	private JTextField t1,t2,t3,t4,t5;/*CAMPOS DE TEXTO*/
	private JLabel e1,e2,e3,e4,e5,titulo;/*INDICADORES Y TITULO*/
	private JButton ayuda,agregar;/*BOTONES*/
	//CONSTRUCTOR VACIO
	public Vagregar() {
		setSize(500,300);/*TAMAÑO DEL PANEL*/
		setLayout(null);/*POSICIONES EDITABLES DE FORMA MANUAL*/
		setVisible(true);/*PANEL VISIBLE*/
		Elementos();/*ELEMETOS DEL PANEL INICIADOS*/
	}
	//INICIALIZAR ELEMENTOS
	private void Elementos() {
		//JTEXTFIELDS
		this.t1 = new JTextField();
		this.t2 = new JTextField();
		this.t3 = new JTextField();
		this.t4 = new JTextField();
		this.t5 = new JTextField();
		//DIMENSIONES DE LOS JTEXTFIELDS
		this.t1.setBounds(80,50,100,30);
		this.t2.setBounds(265,50,100,30);
		this.t3.setBounds(80,90,100,30);
		this.t4.setBounds(265,90,100,30);
		this.t5.setBounds(80,130,100,30);
		//EVENTO KEYLISTENER
		SoloLetras(t1);SoloLetras(t2);
		SoloNumeros(t3);SoloNumeros(t4);
		SoloNumeros(t5);
		//ETIQUETAS
		this.titulo = new JLabel("REGISTRO DE ANIMALES");
		this.e1 = new JLabel("NOMBRE:");
		this.e2 = new JLabel("ESPECIE:");
		this.e3 = new JLabel("PESO:");
		this.e4 = new JLabel("ALTURA:");
		this.e5 = new JLabel("EDAD:");
		//DIMENSIONS DE LAS ETIQUETAS
		this.titulo.setBounds(10,10,300,30);
		this.e1.setBounds(10,50,100,30);
		this.e2.setBounds(200,50,100,30);
		this.e3.setBounds(10,90,100,30);
		this.e4.setBounds(200,90,100,30);
		this.e5.setBounds(10,130,100,30);
		//BOTONES
		this.ayuda = new JButton("HELP");
		this.agregar = new JButton("AGREGAR");
		//DIMENSIONES DE LOS BOTONES
		this.ayuda.setBounds(200,130,165,30);
		this.agregar.setBounds(388,235,100,30);
		//EVENTO DE LOS BOTONES
		this.agregar.addActionListener(this);
		this.ayuda.addActionListener(this);
		//AÑADIR AL PANEL
		add(titulo);
		add(e1);add(t1);
		add(e2);add(t2);
		add(e3);add(t3);
		add(e4);add(t4);
		add(e5);add(t5);
		add(ayuda);add(agregar);
	}
	public void actionPerformed(ActionEvent p) {
		if(p.getSource()==agregar) {
			/*CONFRIMA SE ALGUNOS DE LOS CAMPOS DE YTEXTO ESTÁN VACIOS DE
		     * DE SER ASÍ DARÁ UN MENSAJ DE ERROR AL USUARIO*/
			if(!t1.getText().isEmpty()&&!t2.getText().isEmpty()&&!t3.getText().isEmpty()&&!t4.getText().isEmpty()&&!t5.getText().isEmpty()) {
				/*TOMA LOS DATOS DE CADA UNOS DE LOS CAMPOS DE TEXTO
				 * Y CREA LAS INSTANCIAS RESPECTIVAS*/
				Tomar(t1.getText(),t2.getText(),Float.parseFloat(t3.getText()),Float.parseFloat(t4.getText()),Integer.parseInt(t5.getText()));
			}
			else {
				l.mensaje.showMessageDialog(null,"ERROR CAMPO VACIO");/*ERROR AL TENER UN CAMPO VACIO*/
			}
		}
		//MENSAJE DE AYUDA PARA EL USUARIO, INDICA LAS ESPECIE POSIBLS A AGREGAR
		if(p.getSource()==ayuda) {
			l.mensaje.showMessageDialog(null,"SOLO SER PERMIENTEN:\n"
					+ "LEON, TIGRE, LEOPARDO, TIGRILLO,\n"
					+ "LAGARTO, SERPIENTE, MONO, ORANGUTAN,\n"
					+ "GORILA, CHIMPANCE, PEZ GLOBO, PEZ PAYASO\n"
					+ "PEZ BETA, PEZ SALMON, LORO, AGUILA\n"
					+ "GUACAMAYO Y PERICO");
		}
	}
	//AGREGAR ANIMAL
	/*CREA LA INSTANICA RESPECTIVAS, Y LO AÑADE A LA BASE DE DATOS
	 * A TRAVES DE LA FUNCION "Agregar", EN EL CASO DE QUE UNA ESPECIE
	 * NO COINCIDA DARÁ MENSAJE DE ERROR, EVITANDO POSIBLES PROBLEMAS
	 * CON LA DB, SI TODO COINCIDE EL TEXTO DE LOS CAMPOS SERÁN BORRADOS
	 */
	public void Tomar(String nombre, String especie, float peso, float altura, int edad ) {
		if(especie.equalsIgnoreCase("Leon")||especie.equalsIgnoreCase("Tigre")||especie.equalsIgnoreCase("Leopardo")||especie.equalsIgnoreCase("Tigrillo")) {
			Felinos k = new Felinos(nombre,especie,peso,altura,edad);
			l.Agregar(k);Borrar();
		}
		else
			if(especie.equalsIgnoreCase("Lagarto")||especie.equalsIgnoreCase("Serpiente")) {
				Reptiles k = new Reptiles(nombre,especie,peso,altura,edad);
				l.Agregar(k);Borrar();
			}
			else
				if(especie.equalsIgnoreCase("Mono")||especie.equalsIgnoreCase("Chimpance")||especie.equalsIgnoreCase("Orangutan")||especie.equalsIgnoreCase("Gorila")) {
					Primates k = new Primates(nombre,especie,peso,altura,edad);
					l.Agregar(k);Borrar();
				}
				else
					if(especie.equalsIgnoreCase("Globo")||especie.equalsIgnoreCase("Payaso")||especie.equalsIgnoreCase("Beta")||especie.equalsIgnoreCase("Salmon")) {
						Peces k = new Peces(nombre,especie,peso,altura,edad);
						l.Agregar(k);Borrar();
					}
					else
						if(especie.equalsIgnoreCase("Loro")||especie.equalsIgnoreCase("Aguila")||especie.equalsIgnoreCase("Guacamayo")||especie.equalsIgnoreCase("Perico")) {
							Aves k = new Aves(nombre,especie,peso,altura,edad);
							l.Agregar(k);Borrar();
						}
						else {
							l.mensaje.showMessageDialog(null,"ANIMAL NO PERMITIDO");
						}
	}
	//EVNTOS KEYLISTENER
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
					l.mensaje.showMessageDialog(null,"INGRESE SOLO DATOS NUMERICOS");
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
					l.mensaje.showMessageDialog(null,"INGRESE SOLO CARACTERES");
				}
			}
		});
	}
	//BORRAR TEXTO DE LOS JTEXTFIELD
	private void Borrar() {
		t1.setText(null);t2.setText(null);t3.setText(null);
		t4.setText(null);t5.setText(null);
	}
}
