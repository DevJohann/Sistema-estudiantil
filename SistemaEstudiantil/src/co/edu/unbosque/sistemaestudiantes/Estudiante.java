package co.edu.unbosque.sistemaestudiantes;
import java.util.*;
import java.math.*;


public class Estudiante {
	//Datos básicos
	private String nombre;
	private String carrera;
	private String genero;
	private String edad;
	private int semestre;
	//Notas
	private double notaProg;
	private double notaIntro;
	private double notaEstr;
	private double notaMatBa;
	private double notaMatDis;
	private double notaElec;
	private boolean tieneNotas;
	
	//ArrayList<double> notaProg = new ArrayList<double>(); Parece que no se puede hacer un ArrayList de doubles, por eso opté por trabajar sólo con los promedios de cada materia
	//Próximamente, notas por materia, promedios por materia y promedio general
	
	static Scanner scan = new Scanner(System.in);
	
	Estudiante(String name, String carrera, String genero, String edad, int semestres){
		this.nombre = name;
		this.carrera = carrera;
		this.genero = genero;
		this.edad = edad;
		this.semestre = semestres;
	}
	
	public void aumentarSemestre() {
		semestre = semestre + 1;
		//System.out.println("Ahora tu semestre es: " + semestre);
	}
	
	/* Calculadora de promedio, no toma los valores específicos de cada estudiante, por eso se eliminó
	public static int calcularPromedio() {
		System.out.println("Ingresa tu primera nota: ");
		int nota1 = scan.nextInt();
		System.out.println("Ingresa la segunda nota: ");
		int nota2 = scan.nextInt();
		System.out.println("Ingresa la tercera nota: ");
		int nota3 = scan.nextInt();
		
		int promedio = (nota1 + nota2 + nota3)/3;
		Math.floor(promedio);
		return promedio;
	}
	*/
	
	public double calcularPromedio() {
		double sumatoria = this.notaElec + this.notaEstr + this.notaIntro + this.notaMatBa + this.notaMatDis + this.notaProg;
		return sumatoria/6;
	}
	
	//Getters datos básicos
	public String getNombre() {
		return this.nombre;
	}
	public String getCarrera() {
		return this.carrera;
	}
	public String getGenero() {
		return this.genero;
	}
	public String getEdad() {
		return this.edad;
	}
	public int getSemestre() {
		return this.semestre;
	}
	//Setters datos básicos (Para la modificación)
	
	public void setNombre(String nuevoNombre) {
		this.nombre = nuevoNombre;
	}
	public void setCarrera(String nuevaCarrera) {
		this.carrera = nuevaCarrera;
	}
	public void setEdad(String nuevaEdad) {
		this.edad = nuevaEdad;
	}
	public void setGenero(String nuevoGenero) {
		this.genero = nuevoGenero;
	}
	public void setSemestre(int nuevoSemestre) {
		this.semestre = nuevoSemestre;
	}
	//Setters notas
	
	public void setNotaProg(double nota) {
		this.notaProg = nota;
	}
	public void setNotaEstr(double nota) {
		this.notaEstr = nota;
	}
	public void setNotaIntro(double nota) {
		this.notaIntro = nota;
	}
	public void setNotaMatBa(double nota) {
		this.notaMatBa = nota;
	}
	public void setNotaMatDis(double nota) {
		this.notaMatDis = nota;
	}
	public void setNotaElec(double nota) {
		this.notaElec = nota;
	}
	
	public void setTieneNotas(boolean value) {
		this.tieneNotas = value;
	}
	
	//Getters notas
	
	public void getNotas() {
		System.out.println("Sus notas son: ");
		System.out.println();
		System.out.println("Programación: " + this.notaProg);
		System.out.println("Introducción a la ingeniería: " + this.notaIntro);
		System.out.println("Estructuración del pensamiento: " + this.notaEstr);
		System.out.println("Matemáticas básicas: " + this.notaMatBa);
		System.out.println("Matemáticas discretas: " + this.notaMatDis);
		System.out.println("Electiva: " + this.notaElec);
	}
	public boolean getTieneNotas() {
		return this.tieneNotas;
	}
	

	
	
	//Alpha
	public void getData() {
		System.out.println("Sus datos son: ");
		System.out.println();
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Su edad es: " + this.edad);
		System.out.println("Su género es: " + this.genero);
		System.out.println("Su carrera es: " + this.carrera);
		System.out.println("Su semestre es: " + this.semestre);
		
	}
	
}
