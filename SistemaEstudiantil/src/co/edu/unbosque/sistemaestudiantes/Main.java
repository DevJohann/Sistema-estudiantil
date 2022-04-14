/*	Bienvenido a lo que la capa 8 no ve! 
 *  Todo el c�digo est� documentado
 * 	�ltima versi�n: 2.2
 * 	Realizado por: Johann Toncon
 * 	
 * 	Notas:
 * 
 * 	nextInt del Scanner presenta errores, solucionado con un nextLine debajo (V�ase la l�nea 74)
 * 	L�nea 251 en desarrollo, modificar notas del estudiante (Est�n quedando switch, dentro de switch, dentro de switch, ... y eso no es bueno)
 * 	El objetivo de la clase UI (Que est� vac�a en esta versi�n) es precisamente evitar que este Main quede tan largo, intento hacer que los men�s se puedan volver m�todos de UI
 * 	El inconveniente de poner los men�s en UI es que choca cuando queremos trabajar con los objetos Estudiantes y el ArrayList y todo eso
 * 	
 * 	Los do-while con un switch dentro los uso para gestionar los men�s
 */



package co.edu.unbosque.sistemaestudiantes;
import java.util.*; //S� que es mala pr�ctica importar todo con *, pero igual este es un software peque�o, as� que no afecta mucho

public class Main { //Tambi�n llamada "Application"

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in); //Instaciamos la clase Scanner, para crear el objeto scan y usarlo para leer inputs
		ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>(); //Instanciamos la clase ArrayList, para guardar objetos de la clase Estudiante 
		
		System.out.println("Bienvenido al sistema de gesti�n estudiantes!"); //Bienvenida e informaci�n
		System.out.println("Versi�n 2.2"); //Las versiones Alpha y 1 fueron eliminadas, BACKUP desde la versi�n 2.1
		//System.out.println("Cada estudiante tendr� 6 materias: Programaci�n, Intro. Ingenier�a, Estr. Pensamiento, Mat. B�sicas, Mat. Discretas, Electiva"); //De pronto esto sobra
		System.out.println("Desarrollado por: Johann!"); // :)
		System.out.println();
		
		int res = 0; //Variable que me hace seguimiento a la respuesta del usuario, a la opci�n que elija
		String resNotas; //Variable con la que podr� saber si el usuario ingresa o no notas al estudiante
		
		do { //Repetir hasta que el usuario elija la opci�n 0, se usa do-while porque primero quiero mostrar las opciones y luego analizar su respuesta. "Dispara primero, pregunta desp�es,"
			System.out.println("Que desea hacer hoy: "); //Men� de opciones, men� principal
			System.out.println();
			System.out.println("1. Agregar estudiante");
			System.out.println("2. Aumentar de semestre");
			//System.out.println("3. Calculadora de promedio"); //Eliminado en la versi�n 2.2
			System.out.println("3. Calcular promedio"); 
			System.out.println("4. Opciones estudiante");
			System.out.println("0. Salir");
			res = scan.nextInt(); //Leer la opci�n que escoja el usuario para hacer los respectivos procesos
			
			
			
			switch(res) { //Analizar los posibles valores de res
			
				case 1: //En el caso de que res valga 1, el usuario quiere agregar un nuevo estudiante
					System.out.println("Ingrese el nombre: ");
					String Name = scan.next(); //Recolectar el nombre del estudiante
					
					//Sistema para no repetir nombres
					boolean repetido = false; //Saber si est� o no repetido
					for(Estudiante est : listaEstudiantes) { //For each, en listaEstudiantes, para repasar cada elemento de ese ArrayList
						if(listaEstudiantes.size() == 0) { //Si la lista est� vac�a, no hay necesidad de recorrer la lista, esto se podr�a poner fuera del For Each
							break; //Romper el bucle
						}
						else if(est.getNombre().toLowerCase().equals(Name)) {  //Si el nombre en el que estamos ubicados gracias al bucle coincide con el nombre que va a ingresar el usuario
							System.out.println("Error, ya existe ese estudiante en la lista");
							repetido = true; //El nombre est� repetido
							break;  //Cortar el bucle
						}
					}
					if(repetido) { //En el caso que el nombre no est� repetido
						break; //Terminar el case del switch
					}
					
					//Continua el ingreso de datos b�sicos
					System.out.println("Ingrese la carrera: ");
					String Carrera = scan.next();
					System.out.println("Ingrese el g�nero: ");
					String genero = scan.next();
					System.out.println("Ingrese la edad: ");
					String edad = scan.next();
					System.out.println("Ingrese el semestre: ");
					int semestre = scan.nextInt();
					scan.nextLine(); //Esto para evitar el error de que se salte el Scanner (Un nextInt no se "come" el \n (Cambio de linea), entonces el nextLine lo har�)
					Estudiante estudianteNuevo = new Estudiante(Name, Carrera, genero, edad, semestre); //Creo el objeto estudianteNuevo de la Clase Estudiante, porque lo usar� despu�s para ingresar sus notas
					listaEstudiantes.add(estudianteNuevo); //A�adir el objeto al ArrayList de objetos de la clase Estudiante
					//listaEstudiantes.add(new Estudiante(Name, Carrera, genero, edad, semestre)); //Si no ingresaramos notas, podr�a hacerlo as�
					System.out.println("El estudiante ingresa notas? (Si/No): "); //Puede que todav�a no queramos ingresar sus notas (Tomar�a mucho tiempo crear un nuevo estudiante, y me facilita revisar el c�digo :))
					resNotas = scan.next(); //Conocer la respuesta del usuario
					resNotas = resNotas.toLowerCase(); //resNotas.toLowerCase no modifica el valor propio de la variable; lo pasamos a min�sculas para estar seguros
					
					//System.out.println(resNotas); //Debug
					switch(resNotas) {
						case "si": //Si no pasamos resNotas a min�sculas, si el usuario ingresa "Si" o "SI", no lo detectar�a en este case porque "si" != "Si"
							System.out.println("El sistema de notas le pedir� los promedios de cada materia (En decimal), son 6 materias"); //Informaci�n
							System.out.println("Ingrese el promedio de programaci�n: ");
							//double notaProgramacion = scan.nextDouble(); //Se podr�a hacer as�, pero es un desperdicio de memoria innecesario 
							estudianteNuevo.setNotaProg(scan.nextDouble()); //Lo asignamos de una vez
							System.out.println("Ingrese el promedio de estructuraci�n del pensamiento: ");
							//double notaEstructuracion = scan.nextDouble();
							estudianteNuevo.setNotaEstr(scan.nextDouble());
							System.out.println("Ingrese el promedio de introducci�n a la ingenier�a: ");
							//double notaIntro = scan.nextDouble();
							estudianteNuevo.setNotaIntro(scan.nextDouble());
							System.out.println("Ingrese el promedio de Matem�ticas b�sicas: ");
							//double notaMatBas = scan.nextDouble();
							estudianteNuevo.setNotaMatBa(scan.nextDouble());
							System.out.println("Ingrese el promedio de Matem�ticas discretas: ");
							//double notaMatDis = scan.nextDouble();
							estudianteNuevo.setNotaMatDis(scan.nextDouble());
							System.out.println("Ingrese el promedio de su electiva: ");
							//double notaElec = scan.nextDouble();
							estudianteNuevo.setNotaElec(scan.nextDouble());
							estudianteNuevo.setTieneNotas(true); //Saber si el usuario ingres� notas o no, me sirve para que cuando quiera calcular su promedio y no haya ingresado notas, decirle otro mensaje de excepci�n
							break; //Terminar este case de "si"
						case "no":
							System.out.println("El estudiante no tendr� notas");
							System.out.println("Podr� ingresarlas desp�es"); //Info, en desarrollo, pr�ximamente en la versi�n 2.3
							estudianteNuevo.setTieneNotas(false); //No tiene notas
							break;
						default:
							System.out.println("Error, opci�n inv�lida, ingrese Si o No");
							break;
					}
					
					break; //Terminar el case de 1 (Menu principal)
				case 2: //Opci�n 2 del men� principal
					System.out.println("A quien le desea aumentar el semestre"); //Obtener el nombre a buscar
					String searched = scan.next();
					boolean encontradoAum = false; //Controlar cuando hayamos encontrado o no al nombre a buscar
					for(Estudiante i : listaEstudiantes) { //For each en listaEstudiantes (ArrayList de Estudiantes)
						if(i.getNombre().toLowerCase().contains(searched.toLowerCase())) { //Si el estudiante en el que estamos gracias al bucle coincide con el nombre que busca el usuario (Convertido a min�sculas para estar seguros)
							i.aumentarSemestre(); //aumentar el atributo semestre del objeto en 1
							System.out.println("Ahora " + i.getNombre() + " est� en semestre " + i.getSemestre()); //Mostrar los datos actualizados (Mediante getters)
							encontradoAum = true; //Encontramos al nombre a buscar
							break; //Romper el bucle, NO EL SWITCH, por eso uso el booleano encontradoAum, para luego poder darle break al switch, y poder decir que no encontramos al nombre a buscar
						}
					}
					if(encontradoAum == false) { //No se encontr� al nombre a buscar (Fue inicializado en falso, si entraba en el bucle y se encontraba, se modificar�a a true, pero si se mantuvo en false, es porque no entr� al condicional del for, es decir que no se encontr� el nombre en el ArrayList)
						System.out.println("La persona no tiene registro en la lista");
					}
					break;
				case 3: //Opci�n 3 del men� principal
					//System.out.println("Su promedio es: " + estudiante1.calcularPromedio());	//Intento 1
					//System.out.println("Su promedio es: " + Estudiante.calcularPromedio());	//Intento 2, estos eran calculadoras de promedios, pero no con las notas que ingres� el usuario antes (Si es que lo hizo)
					System.out.println("Ingrese el nombre del estudiante para ver su promedio: ");
					String buscadoProm = scan.next(); //Obtener el nombre a buscar
					boolean completadoPromedio = false; //Saber si logramos o no obtener el promedio (Depende si el usuario ingres� o no las notas antes)
					boolean encontradoPromedio = false; //Saber si encontramos al nombre a buscar
					for(Estudiante est : listaEstudiantes) { //For Each en listaEstudiantes (ArrayList de Estudiantes)
						if(est.getNombre().toLowerCase().contains(buscadoProm)) { //Si el estudiante en el que estamos gracias al bucle, coincide con el nombre a buscar
							encontradoPromedio = true; //Encontramos al nombre a buscar
							if(est.getTieneNotas() == false && encontradoPromedio) { //Encontramos al estudiante, pero no tiene notas
								System.out.println();
								System.out.println("El estudiante no registra notas");
								System.out.println();
								break; //Terminar el bucle, NO EL CASE DEL SWITCH
							}
							else if(est.getTieneNotas() && encontradoPromedio) { //Encontramos al estudiante y tiene notas, entonces podremos calcular su promedio
								System.out.println();
								System.out.println("Su promedio es: " + est.calcularPromedio());
								System.out.println();
								completadoPromedio = true; //Logramos obtener el promedio
								break; //Terminar el bucle, NO EL CASE DEL SWITCH
							}
						}
					}
					if(encontradoPromedio && completadoPromedio) { //Si logramos finalizar la operaci�n sin ninguna novedad
						break; //Terminar el case del switch
					}
					else if(encontradoPromedio == false) { //Si no encontramos al estudiante (Por lo tanto, no habr� entrado a ning�n condicional del bucle)
						System.out.println();
						System.out.println("Error, el estudiante no est� registrado en la base de datos");
						System.out.println();
						break; //Terminar el case del switch
					}
					
					break; //No me acuerdo para qu� es este break :/
				case 4: //Opcion 4 del menu principal
					//estudiante1.getData();
					int resOpc = 0; //Controlar la opci�n que elija el usuario en el men� de abajo
					do {
						System.out.println("1. Consultar datos"); //Mostrar opciones 
						System.out.println("2. Modificar datos");
						System.out.println("3. Eliminar registros");
						System.out.println("0. Volver");
						resOpc = scan.nextInt(); //Obtener la opci�n que elija el usuario
						switch(resOpc) { //Analizar sus posibles valores (Para ver que opci�n eliji�)
							case 1: //Opci�n 1 
								System.out.println("Ingrese el nombre a buscar: ");
								String searchedEstudiante = scan.next(); //Obtener el nombre a buscar
								boolean encontrado = false; //Saber si el usuario existe o no en la listaEstudiantes (ArrayList de Estudiantes)
								
								for(Estudiante est : listaEstudiantes) { //For Each de listaEstudiantes
									if(est.getNombre().toLowerCase().contains(searchedEstudiante.toLowerCase())) { //Si el nombre del objeto de la clase Estudiantes en el que estamos parados gracias al bucle coincide con el nombre a buscar (Todo en min�scula para estar seguros)
										est.getData(); //M�todo que me muestra los valores de los atributos b�sicos del estudiante
										System.out.println(); //Dejar un espacio entre los datos b�sicos y las notas
										est.getNotas(); //M�todo que me muestra el valor de los atributos de notas del estudiante
										System.out.println();
										encontrado = true; //Encontramos al que buscaba el usuario
										break; //Terminar el bucle
										
									}
								}
								if(encontrado) { //Terminar el case sin ninguna novedad
									break;
								}
								else if(encontrado == false) { //Si no encontramos al estudiante en el ArrayList
									System.out.println("La persona no tiene registro");
									break; //Terminar el case
								}
								
							case 2: //Opci�n 2
								System.out.println("Ingresa el nombre del estudiante: ");
								String estBuscado = scan.next();
								boolean encontradoConsulta = false;
								for(Estudiante est : listaEstudiantes) { //V�ase los anteriores For Each para m�s informaci�n, son muy parecidos (Ya me cans� de escribir lo mismo :( )
									if(est.getNombre().toLowerCase().contains(estBuscado.toLowerCase())) {
										encontradoConsulta = true;
										System.out.println("Que desea modificar de " + est.getNombre()); //Saber lo que el usuario quiere modificar espec�ficamente del nombre a buscar
										int item = 0; //Variable igual que los anteriores men�s, para mirar la opci�n que elija el usuario
										do { //"Dispara primero, pregunta despu�s"
											System.out.println("1. Nombre");
											System.out.println("2. Carrera");
											System.out.println("3. Edad");
											System.out.println("4. G�nero"); //Opciones
											System.out.println("5. Semestre");
											System.out.println("6. Notas");
											System.out.println("0. Volver");
											item = scan.nextInt();
											scan.nextLine(); //Evitar el error del Scanner que se salte (V�ase el comentario del scanner debajo de int semestre cuando le pedimos los datos b�sicos al principio)
											
											switch(item) {
												case 1:
													System.out.println("Ingrese el nuevo nombre para " + est.getNombre());
													est.setNombre(scan.nextLine()); //Actualizar datos con setters
													System.out.println("Actualizado correctamente");
													break;
												case 2:
													System.out.println("Ingrese la nueva carrera para " + est.getNombre());
													est.setCarrera(scan.nextLine());
													System.out.println("Actualizado correctamente");
													break;
												case 3:
													System.out.println("Ingrese la nueva edad para " + est.getNombre());
													est.setEdad(scan.nextLine());
													System.out.println("Actualizado correctamente");
													break;
												case 4:
													System.out.println("Ingrese el nuevo g�nero para " + est.getNombre());
													est.setGenero(scan.nextLine());
													System.out.println("Actualizado correctamente");
													break;
												case 5:
													System.out.println("Ingrese el nuevo semestre para " + est.getNombre());
													est.setSemestre(scan.nextInt());
													System.out.println("Actualizado correctamente");
													break;
												case 6:
													System.out.println("::Mod notas"); 
													break;
												default: //El usuario ingres� cualquier otra cosa que no es una de las opciones
													System.out.println("Error, seleccione una opci�n correcta");
													break;
											}
										}while(item != 0); //Repetir mientras la opci�n que elija no sea 0
										
									}
								}
								if(encontradoConsulta == false) { //No se encontr� al estudiante a modificar
									System.out.println("El estudiante no existe en la base de datos");
									break;
								}
							case 3: //Opci�n 3
								System.out.println("Ingrese el nombre del estudiante a eliminar: "); //Obtener el nombre a buscar
								String estEliminar = scan.next(); //Use next() porque nextLine() lo salta
								boolean encontradoElim = false; //Variable que ya conocemos para que es (V�ase los anteriores For Each)
								for(Estudiante est : listaEstudiantes) { //V�ase los anteriores For Each
									if(est.getNombre().toLowerCase().contains(estEliminar)) {
										listaEstudiantes.remove(est); //Eliminar el objeto est de la clase Estudiante de la listaEstudiantes
										System.out.println("Eliminado exitosamente");
										encontradoElim = true;
										break;
									}
								}
								if(encontradoElim) {
									break;
								}
								else if(encontradoElim == false) {
									System.out.println("El estudiante no fue encontrado en la base de datos");
									break;
								}
						}
					}while(resOpc != 0);
					
				
				case 0: //Opci�n de salir del programa
					System.out.println("Los datos no se guardar�n, gracias por usar mi software!");
					System.out.println("Saliendo...");
					break; 
				default:
					System.out.println("Error, opci�n inv�lida");
					System.out.println("Int�ntelo de nuevo");
					System.out.println();
					break;
			}
		}while(res != 0); //Si el usuario elije 0, el programa se termina
		
	}

}
