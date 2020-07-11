package UI;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Vmostrar extends JPanel implements ActionListener{
	//BASE DE DATOS
	DB l = DB.getBase();
	//SENTENCIA SQL
	String query="SELECT * FROM Animales ORDER BY Id_animal ASC";/*SENTENCIA SQL INICIAL*/
	//ELEMTOS DEL PANEL
	private JScrollPane scroll;
	private JTextArea text;/*TEXTAREA USADO PARA MOSTRAR LOS ANIMALES DE LA DB*/
	private JButton editar;/*BOTON QUE EJECUTA LA EDICION DE UN ANIMAL*/
	private JRadioButton r1,r2,r3,r4,r5,r6;/*RADIO BOTONES, EJECUTAN FILTRADO DE ANIMALES POR GRUPOS*/
	private ButtonGroup grupo = new ButtonGroup();/*GRUPO DE RADIOBOTONES*/
	//CONTRUCTOR VACIO
	public Vmostrar() {
		setSize(700,400);/*TAMAÑO DEL PANEL*/
		setLayout(null);/*POSICION COLCOCADA MANUALMENTE*/
		Elementos();/*ELEMENTOS DEL PANEL*/
		setVisible(true);/*PANEL VISIBLE*/
		Colocar();/*TODOS LOS ANIMALES DE LA DB MOSTRADOS AL SOLO ENTRAR A ESTE PANEL*/
	}
	//ELEMTOS DEL PANEl
	private void Elementos() {
		//JTEXTAREA INICIALIZAR
		this.text = new JTextArea();
		this.text.setEditable(false);
		//INICIALIZAR JSCROLLPANE
		this.scroll = new JScrollPane(text);
		//DIMENSIONES DEL SCROLL
		this.scroll.setBounds(10,20,680,300);
		//BOTONES
		this.editar = new JButton("EDITAR");
		//DIMENSIONES DE LOS BOTONES
		this.editar.setBounds(590,330,100,30);
		//EVENTO DE BOTONES
		this.editar.addActionListener(this);
		//RADIO BOTONES
		this.r1 = new JRadioButton("TODO",true);/*OPCION SELECCIONADA AL ENTRAR en el PANEL*/
		this.r2 = new JRadioButton("AVES",false);
		this.r3 = new JRadioButton("PECES",false);
		this.r4 = new JRadioButton("REP",false);
		this.r5 = new JRadioButton("FELI",false);
		this.r6 = new JRadioButton("PRIM",false);
		//DIMENSIONES DE LOS RADIO BOTONES
		this.r1.setBounds(120,330,70,30);
		this.r2.setBounds(190,330,65,30);
		this.r3.setBounds(255,330,70,30);
		this.r4.setBounds(325,330,60,30);
		this.r5.setBounds(380,330,65,30);
		this.r6.setBounds(440,330,70,30);
		//EVENTO DE LOS RADIO BOTONES
		this.r1.addActionListener(this);
		this.r2.addActionListener(this);
		this.r3.addActionListener(this);
		this.r4.addActionListener(this);
		this.r5.addActionListener(this);
		this.r6.addActionListener(this);
		//añadir al grupo
		grupo.add(r1);grupo.add(r2);grupo.add(r3);
		grupo.add(r4);grupo.add(r5);grupo.add(r6);
		//AÑADIR ELEMENTOS AL PANEL
		add(scroll);add(editar);
		add(r1);add(r2);add(r3);
		add(r4);add(r5);add(r6);
	}
	//MOSTRAR LOS ANIMALES
	private void Colocar() {
		this.text.setText(l.Mostrar(query));/*LISTA MOSTRADA AL SOLO ENTRAR*/
	}
	//EVENTOS POSIBLES AL PRESIOANR BOTONES
	@Override
	public void actionPerformed(ActionEvent f) {
		/*AL PRESIONAR EDITAR SE LE PIDE LA ID CONRESPONDIENTE DEL ANIMAL AL USUARIO
		 * SI ETA NO ES ENCONTRADA LA FUNCION "Bus_id" RETORNA NULL, DANDO EL MENSAJE
		 * DE ANIMAL NO ENCONTRADO, SI ES ENCONTRADO S GENERA LA VENTANA "Veditar" CON
		 * TODOS LOS DATOS DEL ANIMAL, Y TOMA LA SENTENCIA SQL DEL STRING QUE POSEA EL
		 * "query" EN ESE MOMENTO, PARA ACTUALIZAR (REIMPRIMRI EN EL TEXTAREA) LA LISTA CON ESA SENTENCIA Y NO GENERAS
		 * CONFUCIONES
		 */
		if(f.getSource()==editar) {
			//SE OPTIENES EL ID DEL ANIMAL INGRESADO POR EL USUARIO Y SE TRANSFORMA A DATO TIPO INT
			String n=l.mensaje.showInputDialog(null,"INGRESE ID");
			if(n!=null) {
				if(l.Bus_id(n)!=null) {
					Veditar edi = new Veditar(l.Bus_id(n),text,query);/*SE EJECUTA LA VENTANA DE EDICION*/
				}
				else {
					l.mensaje.showMessageDialog(null,"ANIMAL NO ENCONTRADO");/*MENSAJE AL NO ENCONTRAR EL ANIMAL CON ID=?*/
				}
			}
		}
		/*OPCIONES DE FILTRADO CON LA FUNCION "MOSTRAR" el cual recibe una sentencia SQL
		*Y LA EJECUTA*/
		/*DEPENDIENDO DE EL RADIOBOTON SELECCIONADO EL STRING QUERY TOMA UNA CADENA
		 * DE CARACTERES DIFERENTES, DE FORMA QUE SI EL USUARIO QUIERE EDITAR UN ANIMAL
		 * TOME LA SENTENCIA QUERY QUE ESTA SELECCIONADA, Y NO HAYA INCONVENIENTES NI
		 * CONFUCIONES CON LA LISTA MOSTRADA*/
		if(f.getSource()==r1) {
			query = "SELECT * FROM Animales ORDER BY Id_animal ASC";
			this.text.setText(l.Mostrar(query));
		}
		if(f.getSource()==r2) {
			query = "SELECT * FROM Animales WHERE grupo='Aves' ORDER BY Id_animal ASC";
			this.text.setText(l.Mostrar(query));
		}
		if(f.getSource()==r3) {
			query="SELECT * FROM Animales WHERE grupo='Peces' ORDER BY Id_animal ASC";
			this.text.setText(l.Mostrar(query));
		}
		if(f.getSource()==r4) {
			query="SELECT * FROM Animales WHERE grupo='Reptiles' ORDER BY Id_animal ASC ";
			this.text.setText(l.Mostrar(query));
		}
		if(f.getSource()==r5) {
			query="SELECT * FROM Animales WHERE grupo='Felinos' ORDER BY Id_animal ASC ";
			this.text.setText(l.Mostrar(query));
		}
		if(f.getSource()==r6) {
			query="SELECT * FROM Animales WHERE grupo='Primates' ORDER BY Id_animal ASC ";
			this.text.setText(l.Mostrar(query));
		}
	}
}
