package UI;

import javax.swing.*;

import java.sql.*;
import animal.Animal;
public class DB {
	//ELEMTO JOPTIONPANE, USADO PARA DAR MENSAJES
	public JOptionPane mensaje = new JOptionPane();
	//INSTANCIA CON OBJETOS DEL DRIVER 
	public static DB db = new DB();/*LLAMA AL CONSTRUCTOR, GENERANDO AL CONEXION
									* ESTE OBJETO PUEDE SER UTILIZADO EN DISTINTAS
									* CLASES, SIENDO SIEMPRE EL MISMO OBEJTO YA CREADO
									* SIN GENERAR MULTIPLES CONEXIONES DE FORMA INECESARIA
									* (PRATON DE SINGLTON)*/
	private Connection con;
	private Statement st;
	private PreparedStatement prd;
	private ResultSet rs;
	//CONSTRUCTOR VACIO
	private DB() {	
		try {
			/*ESTABLECE CONEXION CON LA BASE DE DATOS INDICADA EN EL 
			 * PUERTO INDICADO*/
			this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/Zoo_Gerente","postgres","chappie2k18");
			this.mensaje.showMessageDialog(null,"CONEXION ESTABLECIDA");/*MENSAJE DE CONEXION EXITOSA*/
		}catch(Exception e) {
			this.mensaje.showMessageDialog(null,"Error "+e.getMessage());/*MENSAJE DE ERROR DE CONEXION*/
		}
	}
	//RETORNAR CONEXION CON LA BASE DE DATOS
	public static DB getBase() {
		return db;/*RETORNA EL OBJETO YA INSTANCIADO SIGUIENDO EL PATRON SINGLETON*/
	}
	//MOSTRAR ANIMALES
	public String Mostrar(String sentencia) {
		String texto="";/*VARIABLE TIPO STRING DE AMBITO LOCAL*/
		try {
			this.st = this.con.createStatement();
			this.rs = this.st.executeQuery(sentencia);/*EJECUTA LA SENTENCIA SQL INDICADA POR EL STRING "sentencia"*/ 
			/*TOMA TODOS LOS DATOS DE LA CONSULTA SQL Y LO ALAMACENA EN LA VARIABLE "texto"*/
			while(rs.next()) {
				texto+="-->ID: "+rs.getString("Id_animal")+" Nombre: "+rs.getString("nombre")+", Especie :"+rs.getString("especie")
				+", Peso: "+rs.getString("peso")+", Altura: "+rs.getString("altura")
				+", Edad: "+rs.getString("edad")+", Grupo: "+rs.getString("grupo")+"\n";
			}
		}catch(SQLException e) {
			//EN EL CASO DE ALGUN ERROR MUESTRA EL MENSAJE*/
			this.mensaje.showMessageDialog(null,"Error "+e.getMessage());
		}finally {
			try {
				//CIERRE DE OBJETOS*/
				this.st.close();/*CIERRA LA CONSULTA SQL*/
				this.rs.close();/*CIERRA EL RESULTADO RESOTORNADO DE LA CONSULTA*/
			}catch(Exception e) {
			}
		}
		return texto;
	}
	//RETORNAR ID AUTOASIGNABLE
	public int Id_auto() {
		int id=1;/*EN CASO DE NO TENER ANIMALES, ASIGNA EL PRIMER ID COMO 1*/
		try {
			/*REALIZA UNA CONSULTA SQL RETORNANDO EL MAYOR ID DE LA DB
			 * Y ALMACENDANDO EL OBJETO RESULSET EN "rs*/
			this.st = this.con.createStatement();
			this.rs = this.st.executeQuery("SELECT MAX(Id_Animal) FROM Animales");
			while(rs.next()) {
				id=rs.getInt(1)+1;/*TOMA EL MAYOR ID Y EL SUMA UNO*/
			}
		}catch(Exception e) {
			//MENSAJE EN CASO DE ERROR
			this.mensaje.showMessageDialog(null,"Error "+e.getMessage());
		}finally {
			try {
				//CIERRE DE OBJETOS
				this.st.close();
				this.rs.close();
			}catch(Exception l) {
			}
		}
		return id;/*RETORNA EL ID RESPECTIVO PARA EL NUEVO ANIMAL*/
	}
	//AÑADIR ANIMALES
	public void Agregar(Animal o) {
		try {
			this.prd = this.con.prepareStatement("insert into animales (Id_animal,nombre,especie,peso,altura,edad,grupo) values (?,?,?,?,?,?,?)");
			//AÑADIR A CADA COLUMNA
			/*AÑADE LOS DATOS CORRESPONDIENTES EN LA SENTENCIA SQL VALUES(?,?,?...)*/
			this.prd.setInt(1,Id_auto());
			this.prd.setString(2, o.getNombre());
			this.prd.setString(3, o.getEspecie());
			this.prd.setFloat(4, o.getPeso());
			this.prd.setFloat(5, o.getAltura());
			this.prd.setInt(6, o.getEdad());
			this.prd.setString(7, o.getGrupo());
			this.prd.executeUpdate();/*EJECUTA LA SENTENCIA*/
			this.mensaje.showMessageDialog(null,"AÑADIDO EXITOSAMENTE");/*MENSAJE DE AÑADIDO CORRECTO*/
		}catch(Exception e) {
			//MENSJAE EN CASO DE ERROR
			this.mensaje.showMessageDialog(null,"ERROR AL AÑADIR");
		}finally {
			try {
				//CIERRE DE OBJETOS
				this.prd.close();
			}catch(Exception n) {
				
			}
		}
	}
	//BUSQUEDA POR ID
	public String[] Bus_id(String Id) {
		String u[]= new String[7];/*ARRAY TIPO ESTRING DE AMBITO LOCAL
								   *ALMACENA TODOS LOS DATOS DEN ANIMAL DE ID=?*/
		try {	
			this.prd = this.con.prepareStatement("select * from animales where id_animal = ?");
			//TRANSFORMA EL Id de String a Integer
			this.prd.setInt(1, Integer.parseInt(Id));/*AÑADE EL ID RESPECTIVO EN LA SENTENCIA SQL id_animal=?*/
			this.rs = this.prd.executeQuery();/*EJECUTA LA SENTENCIA*/
			if(rs.next()) {
				//GUARDA LOS DATOS DE TODAS LAS COLUMNAS EN EL ARRAY u
				u[0]=rs.getString(1);
				u[1]=rs.getString(2);
				u[2]=rs.getString(3);
				u[3]=rs.getString(4);
				u[4]=rs.getString(5);
				u[5]=rs.getString(6);
				u[6]=rs.getString(7);
			}
			else {
				u=null;/*EN EL CASO DE NO ENCONTRAR EL ID DEL ANIMAL RETORNA NULL*/
			}
		}catch(SQLException e) {
			this.mensaje.showMessageDialog(null,"ERROR "+e.getMessage());
		}finally {
			try {
				//CIERRE DE OBJETOS
				this.st.close();
				this.rs.close();
			}catch(Exception k) {
				
			}
		}
		return u;/*RETORNA LOS DATOS DEL ANIAML DE ID=?
		 		  * ESTE PUEDE SER NULL EN EL CASO DE NO
		 		  * HABER SIDO ENCONTRADO*/
	}
	//EDITAR ANIMAL DE LA DB
	public void Editar(String u[]) {
		try {
			//EDITA LOS DATOS DE LAS RESPECTIVAS COLUMNAS DE LA SENTENCIA SQL DEL ANIMAL id_animla=?;
			this.prd = con.prepareStatement("UPDATE Animales SET nombre=?,especie=?,peso=?,altura=?,edad=?,grupo=? WHERE Id_animal= "+u[0]);
			//AÑADE LOS RESPECTIVOS DATOS A LA SENTENCIA SQL
			this.prd.setString(1, u[1]);
			this.prd.setString(2, u[2]);
			this.prd.setFloat(3, Float.parseFloat(u[3]));
			this.prd.setFloat(4, Float.parseFloat(u[4]));
			this.prd.setInt(5, Integer.parseInt(u[5]));
			this.prd.setString(6, u[6]);
			this.prd.executeUpdate();/*EJECUTA LA SENTENCIA REALIZANDO LOS CAMBIOS*/
			this.mensaje.showMessageDialog(null,"ANIMAL EDITADO");
		}catch(SQLException l) {
			//MENSAJE EN CASO DE ERROR
			this.mensaje.showMessageDialog(null,"ERROR "+l.getMessage());
		}finally {
			try {
				//CIERRE DE OBJETOS
				this.prd.close();
			}catch(Exception f) {
			}
		}
	}
	//BORRAR ANIMAL DE LA DB
	public void Borrar(String id) {
		try {
			//ELIMINA EL ANIMAL DE id_animal=? INGRESADO POR EL USUARIO
			this.prd = this.con.prepareStatement("DELETE FROM Animales WHERE Id_animal="+id);
			this.prd.executeUpdate();/*EJECUTA LA SENTENCIA ELIMINANDO EL ANIMAL*/
			this.mensaje.showMessageDialog(null,"BORRADO CON EXITO");
		}catch(SQLException l) {
			//MENSAJE EN CASO DE ERROR
			this.mensaje.showMessageDialog(null,"ERROR AL BORRAR");
		}finally {
			try {
				//CIERRE DE OBJETOS
				this.prd.close();
			}catch(Exception e) {
				
			}
		}
	}
}
