package animal;

public abstract class Animal {
	//ATRIBUTOS
	protected String nombre, especie, grupo;
	protected float peso, altura;
	protected int edad;
	//CONTRUCTOR VACIO
	public Animal(){
	}
	//CONSTRUCTOR POR PARAMETROS
	public Animal(String n,String e,float p,float a,int ed) {
		this.nombre=n;
		this.especie=e;
		this.peso=p;
		this.altura=a;
		this.edad=ed;
	}
	//COMPORTAMIENTO COMUN DEL ANIMAL EN EL HABITAD
	public abstract void Comportamiento();/*VARIA SEGUN EL GRUPO DE ANIMAL Y ESPECIE*/
	//SETTERS AND GETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	//METODO toString (DEVUELVE UNA CADENA DE CARACTERES CON INFO DEL ANIMAL)
	public String toString() {
		return "Nombre: "+this.nombre+" Especie: "+this.especie+" Peso: "+this.peso
				+" Altura: "+this.altura+" Edad: "+this.edad+" Grupo: "+this.grupo;
	}
}
