package Cliente;

import java.net.*;
import java.util.ArrayList;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class Cliente extends JFrame implements ActionListener{
	//ELEMENTOS
	private JPanel panel = new JPanel();
	private Socket clin;
	private DataOutputStream data;
	private DataInputStream  recibir;
	private BufferedReader buff;
	private JOptionPane menj = new JOptionPane();
	//ELEMENTOS DEL CHAT
	private JScrollPane sc1,sc2;
	private JTextField tmen;
	private JTextArea text;
	private JButton enviar,help;
	private JComboBox lista;
	//ARRAYLIST QUE ALMACENA LOS COMANDOS USADOS
	private ArrayList<String> previo = new ArrayList<String>();
	int i=0;/*CONTADOR AUXILIAR*/
	//CONSTRUCTOR VACIO
	public Cliente() {
		setSize(700,500);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*CERRA PROCESO*/
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);/*LIBERAR RECURSOS DEL PROCESO*/
		setVisible(true);
		Elementos();
		panel.setSize(700,500);
		panel.setVisible(true);
		setContentPane(panel);
		this.tmen.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER) {
					if(!tmen.getText().isEmpty()) {
						Accionar();
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_UP) {
					if(i>0) {
						tmen.setText(previo.get(i=i-1));
					}
				}
				if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					if(i<previo.size()) {
						tmen.setText(previo.get(i++));
					}
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
		
			}
		});
	}
	//ELEMETNOS
	private void Elementos() {
		panel.setLayout(null);
		//TEXT AREA
		this.text = new JTextArea();
		this.text.setEditable(false);
		//JTextField
		this.tmen = new JTextField();
		//ScrollPane
		this.sc1 = new JScrollPane(tmen);
		this.sc1.setBounds(90,435,365,30);
		this.sc2 = new JScrollPane(text);
		this.sc2.setBounds(10,10,680,410);
		//BOTONES
		this.enviar = new JButton("Enviar");
		this.help = new JButton("Help");
		//DIMENSIONES DE LOS BOTONES
		this.help.setBounds(10,435,70,28);
		this.enviar.setBounds(465,435,100,28);
		//EVENTOS DE LOS BOTONES
		this.enviar.addActionListener(this);
		this.help.addActionListener(this);
		//LISTA DE COMANDOS
		String lis[]= {"","Ayudame","/Mostrar","/Buscar","/BuscarN","/Clear"};
		this.lista = new JComboBox(lis);
		//DIMENSIONES DE LA LISTA DESPLEGABLE
		this.lista.setBounds(575,435,100,28);
		//EVENTO ITEMSATATECHANGE DE LA LISTA DESPLEGABLE
		this.lista.addItemListener(new ItemListener () {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				//TOMA EL DATO SELECCIONADO DEL JCOMANDBOX
				/*COMO EL METODO "getSelectdItem()" retorna un dao
				 * del tipo object, realizamos un Casting para transformalo
				 * a un dato tipo String*/
				String comando = (String) lista.getSelectedItem();
				tmen.setText(comando);/*SE COLOCA EL DATO SELECCIONADO*/
			}
		});
		//AÑADI AL PANEL
		panel.add(sc1);panel.add(sc2);panel.add(help);
		panel.add(enviar);panel.add(lista);
	}
	private void Accionar() {
		previo.add(tmen.getText());
		i=previo.size();/*AÑADE EL MENSAJE A LA LISTA Y ACTUALIZA EL CONTADOR*/
		if(tmen.getText().equalsIgnoreCase("/Clear")) {
			text.setText(null); 
			tmen.setText(null);
		}else {
			text.append("-----------------------------------------------------------\n");
			text.append("CLIENTE: "+tmen.getText());
			try {
				clin = new Socket("localhost",5558);
				data = new DataOutputStream(clin.getOutputStream());
				recibir = new DataInputStream(clin.getInputStream());
				data.writeUTF(tmen.getText());
				text.append("\n"+recibir.readUTF());
				text.append("-----------------------------------------------------------\n");
				data.close();
				recibir.close();
				clin.close();
			} catch (IOException e1) {
				text.append("ERROR:"+e1.getMessage());
			}
			this.tmen.setText(null);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==enviar) {
			if(!tmen.getText().isEmpty()) {
				Accionar();
			}
		}
		if(e.getSource()==help) {
			menj.showMessageDialog(null,"EN LA ESQUINA INFERIOR DERCHA\n"
					+ "CUENTA CON UNA LISTA DE LOS COMANDOS\n"
					+ "PRESIONE AYUDAME y de ENTER PARA EMPEZAR");
		}
	}
	public static void main(String agrs[]) {
		Cliente l = new Cliente();
	}
}
