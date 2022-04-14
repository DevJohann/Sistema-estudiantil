/*	Bienvenido a lo que la capa 8 no ve! 
 *  Todo el código está documentado
 * 	Última versión: 2.2
 * 	Realizado por: Johann Toncon
 * 	
 * 	Notas:
 * 
 * 	nextInt del Scanner presenta errores, solucionado con un nextLine debajo (Véase la línea 74)
 * 	Línea 251 en desarrollo, modificar notas del estudiante (Están quedando switch, dentro de switch, dentro de switch, ... y eso no es bueno)
 * 	El objetivo de la clase UI (Que está vacía en esta versión) es precisamente evitar que este Main quede tan largo, intento hacer que los menús se puedan volver métodos de UI
 * 	El inconveniente de poner los menús en UI es que choca cuando queremos trabajar con los objetos Estudiantes y el ArrayList y todo eso
 * 	
 * 	Los do-while con un switch dentro los uso para gestionar los menús
 */



package co.edu.unbosque.sistemaestudiantes;
import java.util.*; //Sé que es mala práctica importar todo con *, pero igual este es un software pequeño, así que no afecta mucho

public class Main { //También llamada "Application"

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in); //Instaciamos la clase Scanner, para crear el objeto scan y usarlo para leer inputs
		ArrayList<Estudiante> listaEstudiantes = new ArrayList<Estudiante>(); //Instanciamos la clase ArrayList, para guardar objetos de la clase Estudiante 
		
		System.out.println("Bienvenido al sistema de gestión estudiantes!"); //Bienvenida e información
		System.out.println("Versión 2.2"); //Las versiones Alpha y 1 fueron eliminadas, BACKUP desde la versión 2.1
		//System.out.println("Cada estudiante tendrá 6 materias: Programación, Intro. Ingeniería, Estr. Pensamiento, Mat. Básicas, Mat. Discretas, Electiva"); //De pronto esto sobra
		System.out.println("Desarrollado por: Johann!"); // :)
		System.out.println();
		
		int res = 0; //Variable que me hace seguimiento a la respuesta del usuario, a la opción que elija
		String resNotas; //Variable con la que podré saber si el usuario ingresa o no notas al estudiante
		
		do { //Repetir hasta que el usuario elija la opción 0, se usa do-while porque primero quiero mostrar las opciones y luego analizar su respuesta. "Dispara primero, pregunta despúes,"
			System.out.println("Que desea hacer hoy: "); //Menú de opciones, menú principal
			System.out.println();
			System.out.println("1. Agregar estudiante");
			System.out.println("2. Aumentar de semestre");
			//System.out.println("3. Calculadora de promedio"); //Eliminado en la versión 2.2
			System.out.println("3. Calcular promedio"); 
			System.out.println("4. Opciones estudiante");
			System.out.println("0. Salir");
			res = scan.nextInt(); //Leer la opción que escoja el usuario para hacer los respectivos procesos
			
			
			
			switch(res) { //Analizar los posibles valores de res
			
				case 1: //En el caso de que res valga 1, el usuario quiere agregar un nuevo estudiante
					System.out.println("Ingrese el nombre: ");
					String Name = scan.next(); //Recolectar el nombre del estudiante
					
					//Sistema para no repetir nombres
					boolean repetido = false; //Saber si está o no repetido
					for(Estudiante est : listaEstudiantes) { //For each, en listaEstudiantes, para repasar cada elemento de ese ArrayList
						if(listaEstudiantes.size() == 0) { //Si la lista está vacía, no hay necesidad de recorrer la lista, esto se podría poner fuera del For Each
							break; //Romper el bucle
						}
						else if(est.getNombre().toLowerCase().equals(Name)) {  //Si el nombre en el que estamos ubicados gracias al bucle coincide con el nombre que va a ingresar el usuario
							System.out.println("Error, ya existe ese estudiante en la lista");
							repetido = true; //El nombre está repetido
							break;  //Cortar el bucle
						}
					}
					if(repetido) { //En el caso que el nombre no esté repetido
						break; //Terminar el case del switch
					}
					
					//Continua el ingreso de datos básicos
					System.out.println("Ingrese la carrera: ");
					String Carrera = scan.next();
					System.out.println("Ingrese el género: ");
					String genero = scan.next();
					System.out.println("Ingrese la edad: ");
					String edad = scan.next();
					System.out.println("Ingrese el semestre: ");
					int semestre = scan.nextInt();
					scan.nextLine(); //Esto para evitar el error de que se salte el Scanner (Un nextInt no se "come" el \n (Cambio de linea), entonces el nextLine lo hará)
					Estudiante estudianteNuevo = new Estudiante(Name, Carrera, genero, edad, semestre); //Creo el objeto estudianteNuevo de la Clase Estudiante, porque lo usaré después para ingresar sus notas
					listaEstudiantes.add(estudianteNuevo); //Añadir el objeto al ArrayList de objetos de la clase Estudiante
					//listaEstudiantes.add(new Estudiante(Name, Carrera, genero, edad, semestre)); //Si no ingresaramos notas, podría hacerlo así
					System.out.println("El estudiante ingresa notas? (Si/No): "); //Puede que todavía no queramos ingresar sus notas (Tomaría mucho tiempo crear un nuevo estudiante, y me facilita revisar el código :))
					resNotas = scan.next(); //Conocer la respuesta del usuario
					resNotas = resNotas.toLowerCase(); //resNotas.toLowerCase no modifica el valor propio de la variable; lo pasamos a minúsculas para estar seguros
					
					//System.out.println(resNotas); //Debug
					switch(resNotas) {
						case "si": //Si no pasamos resNotas a minúsculas, si el usuario ingresa "Si" o "SI", no lo detectaría en este case porque "si" != "Si"
							System.out.println("El sistema de notas le pedirá los promedios de cada materia (En decimal), son 6 materias"); //Información
							System.out.println("Ingrese el promedio de programación: ");
							//double notaProgramacion = scan.nextDouble(); //Se podría hacer así, pero es un desperdicio de memoria innecesario 
							estudianteNuevo.setNotaProg(scan.nextDouble()); //Lo asignamos de una vez
							System.out.println("Ingrese el promedio de estructuración del pensamiento: ");
							//double notaEstructuracion = scan.nextDouble();
							estudianteNuevo.setNotaEstr(scan.nextDouble());
							System.out.println("Ingrese el promedio de introducción a la ingeniería: ");
							//double notaIntro = scan.nextDouble();
							estudianteNuevo.setNotaIntro(scan.nextDouble());
							System.out.println("Ingrese el promedio de Matemáticas básicas: ");
							//double notaMatBas = scan.nextDouble();
							estudianteNuevo.setNotaMatBa(scan.nextDouble());
							System.out.println("Ingrese el promedio de Matemáticas discretas: ");
							//double notaMatDis = scan.nextDouble();
							estudianteNuevo.setNotaMatDis(scan.nextDouble());
							System.out.println("Ingrese el promedio de su electiva: ");
							//double notaElec = scan.nextDouble();
							estudianteNuevo.setNotaElec(scan.nextDouble());
							estudianteNuevo.setTieneNotas(true); //Saber si el usuario ingresó notas o no, me sirve para que cuando quiera calcular su promedio y no haya ingresado notas, decirle otro mensaje de excepción
							break; //Terminar este case de "si"
						case "no":
							System.out.println("El estudiante no tendrá notas");
							System.out.println("Podrá ingresarlas despúes"); //Info, en desarrollo, próximamente en la versión 2.3
							estudianteNuevo.setTieneNotas(false); //No tiene notas
							break;
						default:
							System.out.println("Error, opción inválida, ingrese Si o No");
							break;
					}
					
					break; //Terminar el case de 1 (Menu principal)
				case 2: //Opción 2 del menú principal
					System.out.println("A quien le desea aumentar el semestre"); //Obtener el nombre a buscar
					String searched = scan.next();
					boolean encontradoAum = false; //Controlar cuando hayamos encontrado o no al nombre a buscar
					for(Estudiante i : listaEstudiantes) { //For each en listaEstudiantes (ArrayList de Estudiantes)
						if(i.getNombre().toLowerCase().contains(searched.toLowerCase())) { //Si el estudiante en el que estamos gracias al bucle coincide con el nombre que busca el usuario (Convertido a minúsculas para estar seguros)
							i.aumentarSemestre(); //aumentar el atributo semestre del objeto en 1
							System.out.println("Ahora " + i.getNombre() + " está en semestre " + i.getSemestre()); //Mostrar los datos actualizados (Mediante getters)
							encontradoAum = true; //Encontramos al nombre a buscar
							break; //Romper el bucle, NO EL SWITCH, por eso uso el booleano encontradoAum, para luego poder darle break al switch, y poder decir que no encontramos al nombre a buscar
						}
					}
					if(encontradoAum == false) { //No se encontró al nombre a buscar (Fue inicializado en falso, si entraba en el bucle y se encontraba, se modificaría a true, pero si se mantuvo en false, es porque no entró al condicional del for, es decir que no se encontró el nombre en el ArrayList)
						System.out.println("La persona no tiene registro en la lista");
					}
					break;
				case 3: //Opción 3 del menú principal
					//System.out.println("Su promedio es: " + estudiante1.calcularPromedio());	//Intento 1
					//System.out.println("Su promedio es: " + Estudiante.calcularPromedio());	//Intento 2, estos eran calculadoras de promedios, pero no con las notas que ingresó el usuario antes (Si es que lo hizo)
					System.out.println("Ingrese el nombre del estudiante para ver su promedio: ");
					String buscadoProm = scan.next(); //Obtener el nombre a buscar
					boolean completadoPromedio = false; //Saber si logramos o no obtener el promedio (Depende si el usuario ingresó o no las notas antes)
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
					if(encontradoPromedio && completadoPromedio) { //Si logramos finalizar la operación sin ninguna novedad
						break; //Terminar el case del switch
					}
					else if(encontradoPromedio == false) { //Si no encontramos al estudiante (Por lo tanto, no habrá entrado a ningún condicional del bucle)
						System.out.println();
						System.out.println("Error, el estudiante no está registrado en la base de datos");
						System.out.println();
						break; //Terminar el case del switch
					}
					
					break; //No me acuerdo para qué es este break :/
				case 4: //Opcion 4 del menu principal
					//estudiante1.getData();
					int resOpc = 0; //Controlar la opción que elija el usuario en el menú de abajo
					do {
						System.out.println("1. Consultar datos"); //Mostrar opciones 
						System.out.println("2. Modificar datos");
						System.out.println("3. Eliminar registros");
						System.out.println("0. Volver");
						resOpc = scan.nextInt(); //Obtener la opción que elija el usuario
						switch(resOpc) { //Analizar sus posibles valores (Para ver que opción elijió)
							case 1: //Opción 1 
								System.out.println("Ingrese el nombre a buscar: ");
								String searchedEstudiante = scan.next(); //Obtener el nombre a buscar
								boolean encontrado = false; //Saber si el usuario existe o no en la listaEstudiantes (ArrayList de Estudiantes)
								
								for(Estudiante est : listaEstudiantes) { //For Each de listaEstudiantes
									if(est.getNombre().toLowerCase().contains(searchedEstudiante.toLowerCase())) { //Si el nombre del objeto de la clase Estudiantes en el que estamos parados gracias al bucle coincide con el nombre a buscar (Todo en minúscula para estar seguros)
										est.getData(); //Método que me muestra los valores de los atributos básicos del estudiante
										System.out.println(); //Dejar un espacio entre los datos básicos y las notas
										est.getNotas(); //Método que me muestra el valor de los atributos de notas del estudiante
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
								
							case 2: //Opción 2
								System.out.println("Ingresa el nombre del estudiante: ");
								String estBuscado = scan.next();
								boolean encontradoConsulta = false;
								for(Estudiante est : listaEstudiantes) { //Véase los anteriores For Each para más información, son muy parecidos (Ya me cansé de escribir lo mismo :( )
									if(est.getNombre().toLowerCase().contains(estBuscado.toLowerCase())) {
										encontradoConsulta = true;
										System.out.println("Que desea modificar de " + est.getNombre()); //Saber lo que el usuario quiere modificar específicamente del nombre a buscar
										int item = 0; //Variable igual que los anteriores menús, para mirar la opción que elija el usuario
										do { //"Dispara primero, pregunta después"
											System.out.println("1. Nombre");
											System.out.println("2. Carrera");
											System.out.println("3. Edad");
											System.out.println("4. Género"); //Opciones
											System.out.println("5. Semestre");
											System.out.println("6. Notas");
											System.out.println("0. Volver");
											item = scan.nextInt();
											scan.nextLine(); //Evitar el error del Scanner que se salte (Véase el comentario del scanner debajo de int semestre cuando le pedimos los datos básicos al principio)
											
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
													System.out.println("Ingrese el nuevo género para " + est.getNombre());
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
												default: //El usuario ingresó cualquier otra cosa que no es una de las opciones
													System.out.println("Error, seleccione una opción correcta");
													break;
											}
										}while(item != 0); //Repetir mientras la opción que elija no sea 0
										
									}
								}
								if(encontradoConsulta == false) { //No se encontró al estudiante a modificar
									System.out.println("El estudiante no existe en la base de datos");
									break;
								}
							case 3: //Opción 3
								System.out.println("Ingrese el nombre del estudiante a eliminar: "); //Obtener el nombre a buscar
								String estEliminar = scan.next(); //Use next() porque nextLine() lo salta
								boolean encontradoElim = false; //Variable que ya conocemos para que es (Véase los anteriores For Each)
								for(Estudiante est : listaEstudiantes) { //Véase los anteriores For Each
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
					
				
				case 0: //Opción de salir del programa
					System.out.println("Los datos no se guardarán, gracias por usar mi software!");
					System.out.println("Saliendo...");
					break; 
				default:
					System.out.println("Error, opción inválida");
					System.out.println("Inténtelo de nuevo");
					System.out.println();
					break;
			}
		}while(res != 0); //Si el usuario elije 0, el programa se termina
		
	}

}
