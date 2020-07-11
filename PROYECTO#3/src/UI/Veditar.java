package UI;

import javax.swing.*;

import Grupos_A.Aves;
import Grupos_A.Felinos;
import Grupos_A.Peces;
import Grupos_A.Primates;
import Grupos_A.Reptiles;

import java.awt.event.*;
import java.sql.*;

public class Veditar extends JFrame implements ActionListener{
	//CONEXION
	DB d = DB.getBase();
	//ELEMTOS DE LA VENTANA MODIFICAR
	private JTextField t1,t2,t3,t4,t5,t6,t7;/*CUADROS DE TEXTO CON LOS DATOS DEN ANIMAL*/
	private JLabel e1,e2,e3,e4,e5,e6,e7;/*ETIQUETAS INDICADORAS*/
	private JButton edit,cancel,borrar;/*BOTONES CON ACCIONS DISTINTAS*/
	private JOptionPane men = new JOptionPane();
	//CONSTRCUTOR VACIO
	public Veditar(String Datos[],JTextArea text,String query) {
		super("EDITAR ANIMAL");/*TITULO DE LA VENTANA*/
		setSize(350,300);/*TAMAÑO DE LA VENTANA*/
		setLayout(null);/*POSICIONES AGREGADAS DE FORMA MANUAL*/
		setResizable(false);/*VENTANA DE TAMAÑO NO EDITABLE POR EL USUARIO*/
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*CERRA PROCESO*/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);/*LIBERAR RECURSOS DEL PROCESO*/
		setLocationRelativeTo(null);
		setVisible(true);
		Elementos(Datos);
		//EVENTO PARA EL BOTON EDITAR
		this.edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*COMPRUEBA SI LOS CAMPOS SI ALGUN CAMPO DE TEXTO ESTA VACIO
				 * DE SER ASÍ DARÁ UN MENSAJE DE ERROR*/
				if(!t2.getText().isEmpty()&&!t3.getText().isEmpty()&&!t4.getText().isEmpty()&&!t5.getText().isEmpty()&&!t6.getText().isEmpty()) {
					Asignar(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText());
					text.setText(d.Mostrar(query));
				}
				else {
					men.showMessageDialog(null,"ERROR CAMPO VACIO");/*MENSAJE DE ERROR*/
				}
				dispose();/*AL SER EDITADO SE CIERRA LA VENTANA*/
			}
		});
		this.borrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				d.Borrar(t1.getText());/*BORRA EL ANIMAL DESEADO TOMANDO SU ID*/
				text.setText(d.Mostrar(query));/*REIMPRIME EN EL JTEXTFIELD CON LA SENTENCIA SQL QUE FUE 
												*SELECIONADA POR EL USUARIO*/
				dispose();/*CIERRA LA VENTANA*/
			}
		});
	}
	//ELEMENTOS A INICIAR
	private void Elementos(String Datos[]) {
		//ETIQUETAS
		this.e1 = new JLabel("ID:");
		this.e2 = new JLabel("NOMBRE:");
		this.e3 = new JLabel("ESPECIE:");
		this.e4 = new JLabel("PESO:");
		this.e5 = new JLabel("ALTURA:");
		this.e6 = new JLabel("EDAD:");
		this.e7 = new JLabel("GRUPO:");
		//DIMENSIONES DE ETIQUETAS
		this.e1.setBounds(10,30,100,30);
		this.e2.setBounds(160,30,100,30);
		this.e3.setBounds(10,70,100,30);
		this.e4.setBounds(180,70,100,30);
		this.e5.setBounds(10,110,100,30);
		this.e6.setBounds(180,110,100,30);
		this.e7.setBounds(10,150,100,30);
		//TEXTFIELDS
		this.t1 = new JTextField(Datos[0]);/*COLCOCA LA ID DEL ANIMAL*/
		this.t2 = new JTextField(Datos[1]);/*COLCOCA EL NOMBRE DEL ANIMAL*/
		this.t3 = new JTextField(Datos[2]);/*COLCOCA LA ESPECIE DEL ANIMAL*/
		this.t4 = new JTextField(Datos[3]);/*COLCOCA EL PESO DEL ANIMAL*/
		this.t5 = new JTextField(Datos[4]);/*COLCOCA LA ALTURA DEL ANIMAL*/
		this.t6 = new JTextField(Datos[5]);/*COLCOCA LA EDAD DEL ANIMAL*/
		this.t7 = new JTextField(Datos[6]);/*COLCOCA EL GRUPO DEL ANIMAL*/
		//DIMENSIONES DE LOS TEXTFIELDS
		this.t1.setBounds(75,30,50,30);
		this.t1.setEnabled(false);/*LA ID NO SEŔA EDITABLE POR EL USUARIO*/
		this.t2.setBounds(240,30,80,30);
		this.t3.setBounds(75,70,70,30);
		this.t4.setBounds(240,70,70,30);
		this.t5.setBounds(75,110,70,30);
		this.t6.setBounds(240,110,70,30);
		this.t7.setBounds(75,150,70,30);
		this.t7.setEnabled(false);/*EL GRUPO ANIMAL NO SEŔA EDITABLE POR EL USUARIO*/
		//EVENTOS DE TECLADO
		SoloLetras(t2);SoloLetras(t3);
		SoloNumeros(t4);SoloNumeros(t5);
		SoloNumeros(t6);
		//CREACION DE BOTONES
		this.edit = new JButton("ACEPTAR");
		this.cancel = new JButton("CANCELAR");
		this.borrar = new JButton("BORRAR");
		//DIMENSIONES DE LOS BOTONES
		this.edit.setBounds(240,230,100,30);
		this.cancel.setBounds(10,230,105,30);
		this.borrar.setBounds(125,230,105,30);
		//EVENTO PARA LOS BOTONES
		this.edit.addActionListener(this);
		this.cancel.addActionListener(this);
		this.borrar.addActionListener(this);
		//AÑADIRA A LA VENTANA
		add(e1);add(t1);
		add(e2);add(t2);
		add(e3);add(t3);
		add(e4);add(t4);
		add(e5);add(t5);
		add(e6);add(t6);
		add(e7);add(t7);
		add(edit);add(cancel);add(borrar);
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		//CERRAR O CANCELAR EDICION DE DATOS
		if(ev.getSource()==cancel) {
			dispose();/*CERRAR VENTANA*/
		}
	}
	//ASIGNAR GRUPO ANIMAL Y RETORNAR OBJETO
	/*DETECTA LA ESPECIE ANIMAL, TOMA LOS DATOS Y ASGINA EL GRUPO ESPECIFICO
	 * DE LA ESPECIE, PARA EVITAR POSIBLES INCONGRUENCIAS, GUARDA LOS DATOS
	 * INGRESADOS POR EL USUARIO(ALTERADOS O NO), LOS ALMACENA EN UN ARRAY
	 * TIPO STRING Y CON LA FUNCION "Editar()" LOS ENVIA, SE EJECUTA LA SENTENCIA
	 * SQL Y SE EFECTUA EL CAMBIO, NOTA: SI LA ESPECIE ANIMAL NO SE ENCUENTRA EN EL
	 * ZOOLOGICO, DARÁ MENSAJE DE ERROR, EVITANDO UNA ACTUALIZACION DE DATOS 
	 */
	private void Asignar(String id,String nom, String esp, String pe, String altu, String ed) {
		if(esp.equalsIgnoreCase("Leon")||esp.equalsIgnoreCase("Tigre")||esp.equalsIgnoreCase("Leopardo")||esp.equalsIgnoreCase("Tigrillo")) {
			String u[]= {id,nom,esp,pe,altu,ed,"Felinos"};
			d.Editar(u);
		}
		else
			if(esp.equalsIgnoreCase("Lagarto")||esp.equalsIgnoreCase("Serpiente")) {
				String u[]= {id,nom,esp,pe,altu,ed,"Reptiles"};
				d.Editar(u);
			}
			else
				if(esp.equalsIgnoreCase("Mono")||esp.equalsIgnoreCase("Orangutan")||esp.equalsIgnoreCase("Gorila")||esp.equalsIgnoreCase("Chimpance")) {
					String u[]= {id,nom,esp,pe,altu,ed,"Primates"};
					d.Editar(u);
				}
				else
					if(esp.equalsIgnoreCase("Globo")||esp.equalsIgnoreCase("Payaso")||esp.equalsIgnoreCase("Beta")||esp.equalsIgnoreCase("Salmon")) {
						String u[]= {id,nom,esp,pe,altu,ed,"Peces"};
						d.Editar(u);
					}
					else
						if(esp.equalsIgnoreCase("Loro")||esp.equalsIgnoreCase("Aguila")||esp.equalsIgnoreCase("Guacamayo")||esp.equalsIgnoreCase("Perico")) {
							String u[]= {id,nom,esp,pe,altu,ed,"Aves"};
							d.Editar(u);
						}
						else {
							men.showMessageDialog(null,"ERROR");
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
						d.mensaje.showMessageDialog(null,"INGRESE SOLO DATOS NUMERICOS");
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
						d.mensaje.showMessageDialog(null,"INGRESE SOLO CARACTERES");
					}
				}
			});
		}
}