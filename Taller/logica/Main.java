package logica;

import java.util.Scanner;
import java.io.*;

public class Main {

    // Angel Eduardo Olivares Flores
    // 22.338.590-7 / ICCI

    // Jason Alexander Tapia Castro
    // 22.382.028-K / ICCI

    static int MAX_REGISTROS = 300;
    static int MAX_USUARIOS = 3;

    // lista para usuarios.txt
    static String[] usuariosId = new String[MAX_USUARIOS];
    static String[] usuariosPass = new String[MAX_USUARIOS];
    static int cantUsuarios = 0;

    // lista para registros.txt
    static String[] regUsuario = new String[MAX_REGISTROS];
    static String[] regFecha = new String[MAX_REGISTROS];
    static int[] regHoras = new int[MAX_REGISTROS];
    static String[] regActividad = new String[MAX_REGISTROS];
    static int cantRegistros = 0;

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        leerArchivoRegistros();
        leerArchivoUsuarios();

        int opcionPrincipal = 0;
        int opcionUsuario = 0;
        int opcionAnalisis = 0;

        String usuario;
        String contrasena;
        int posicionUsuario;

        do {
            System.out.println("1) Menu de Usuarios");
            System.out.println("2) Menu de Analisis");
            System.out.println("3) Salir");
            System.out.print("Ingrese una opcion: ");

            try {
                opcionPrincipal = Integer.parseInt(lector.nextLine());
            } catch (Exception e) {
                System.out.println("Error al ingresar la opcion.");
                opcionPrincipal = 0;
            }

            switch (opcionPrincipal) {
                case 1:
                    System.out.print("Usuario: ");
                    usuario = lector.nextLine();

                    System.out.print("Contraseña: ");
                    contrasena = lector.nextLine();

                    posicionUsuario = login(usuario, contrasena);

                    if (posicionUsuario != -1) {
                        System.out.println("Acceso correcto!");

                        do {
                            System.out.println();
                            System.out.println("Bienvenido " + usuario + "!");
                            System.out.println();
                            System.out.println("Que deseas realizar?");
                            System.out.println("1) Registrar actividad");
                            System.out.println("2) Modificar actividad");
                            System.out.println("3) Eliminar actividad");
                            System.out.println("4) Cambiar contraseña");
                            System.out.println("5) Salir");
                            System.out.print("Ingrese una opcion: ");

                            try {
                                opcionUsuario = Integer.parseInt(lector.nextLine());
                            } catch (Exception e) {
                                System.out.println("Error al ingresar la opcion.");
                                opcionUsuario = 0;
                            }

                            switch (opcionUsuario) {
                                case 1:
                                    registrarActividad(usuario, lector);
                                    break;

                                case 2:
                                    System.out.println("Cual actividad deseas modificar?\n");
                                    modificarActividad(usuario, lector);

                                    break;

                                case 3:
                                    System.out.println("Cual actividad deseas eliminar?\n");
                                	// Opcion correcta, se actualiza con los registros añadidos
                                    mostrarRegistrosDeUsuario(usuario);
                                    break;

                                case 4:
                                    cambiarContrasena(usuario, lector);
                                    break;

                                case 5:
                                    System.out.println("Saliendo del menu de usuario...");
                                    break;

                                default:
                                    System.out.println("Opcion invalida.");
                                    break;
                            }

                        } while (opcionUsuario != 5);

                    } else {
                        System.out.println("Usuario o contraseña incorrectos.");
                    }
                    break;

                case 2:
                    do {
                        System.out.println();
                        System.out.println("Bienvenido al menu de analisis!");
                        System.out.println();
                        System.out.println("Que deseas realizar?");
                        System.out.println("1) Actividad mas realizada");
                        System.out.println("2) Actividad mas realizada por cada usuario");
                        System.out.println("3) Usuario con mayor procrastinacion");
                        System.out.println("4) Ver todas las actividades");
                        System.out.println("5) Salir");
                        System.out.print("Ingrese una opcion: ");

                        try {
                            opcionAnalisis = Integer.parseInt(lector.nextLine());
                        } catch (Exception e) {
                            System.out.println("Error al ingresar la opcion.");
                            opcionAnalisis = 0;
                        }

                        switch (opcionAnalisis) {
                            case 1:
                                System.out.println("Actividad mas realizada aun no implementada.");
                                break;

                            case 2:
                                System.out.println("Actividad mas realizada por cada usuario aun no implementada.");
                                break;

                            case 3:
                                System.out.println("Usuario con mayor procrastinacion aun no implementado.");
                                break;

                            case 4:
                            	// Opcion correcta, se actualiza con los registros añadidos
                                mostrarTodosLosRegistros();
                                break;

                            case 5:
                                System.out.println("Saliendo del menu de analisis...");
                                break;

                            default:
                                System.out.println("Opcion invalida.");
                                break;
                        }

                    } while (opcionAnalisis != 5);
                    break;

                case 3:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

            System.out.println();

        } while (opcionPrincipal != 3);

        lector.close();
    }

    // Funcion para leer el archivo de registros
    public static void leerArchivoRegistros() {
        cantRegistros = 0;

        try {
            File registro = new File("Registros.txt");
            Scanner scRegistro = new Scanner(registro);

            while (scRegistro.hasNextLine() && cantRegistros < MAX_REGISTROS) {
                String linea = scRegistro.nextLine();
                String[] partesRG = linea.split(";");

                if (partesRG.length == 4) {
                    regUsuario[cantRegistros] = partesRG[0];
                    regFecha[cantRegistros] = partesRG[1];
                    regHoras[cantRegistros] = Integer.parseInt(partesRG[2]);
                    regActividad[cantRegistros] = partesRG[3];

                    cantRegistros++;
                }
            }

            scRegistro.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo Registros.txt");
        }
    }

    // Funcion para leer el archivo de los usuarios
    public static void leerArchivoUsuarios() {
        cantUsuarios = 0;

        try {
            File archivoU = new File("Usuarios.txt");

            if (archivoU.exists()) {
                Scanner scUser = new Scanner(archivoU);

                while (scUser.hasNextLine() && cantUsuarios < MAX_USUARIOS) {
                    String linea = scUser.nextLine();
                    String[] partesU = linea.split(";");

                    if (partesU.length == 2) {
                        usuariosId[cantUsuarios] = partesU[0];
                        usuariosPass[cantUsuarios] = partesU[1];

                        cantUsuarios++;
                    }
                }

                scUser.close();
            } else {
                System.out.println("No se encontro Usuarios.txt");
            }

        } catch (Exception e) {
            System.out.println("Error al cargar los usuarios.");
        }
    }

    // Funcion para validar login
    public static int login(String usuario, String contrasena) {
        for (int i = 0; i < cantUsuarios; i++) {
            if (usuariosId[i].equals(usuario) && usuariosPass[i].equals(contrasena)) {
                return i;
            }
        }

        return -1;
    }

    // Funcion para mostrar solo los registros de un usuario
    public static int mostrarRegistrosDeUsuario(String usuarioBuscado) {
        int contador = 0;

        System.out.println("0) Regresar");

        for (int i = 0; i < cantRegistros; i++) {
            if (regUsuario[i].equals(usuarioBuscado)) {
                contador++;
                System.out.println(contador + ") " + regUsuario[i] + ";" + regFecha[i] + ";" + regHoras[i] + ";" + regActividad[i]);
            }
        }

        if (contador == 0) {
            System.out.println("Este usuario no tiene actividades registradas.");
        }

        return contador;
    }

    // Funcion para guardar los indices reales de un usuario
    // OPCIONES 2 Y 3 DEL MENU 1
    public static int[] obtenerIndicesDeUsuario(String usuarioBuscado) {
        int[] indices = new int[MAX_REGISTROS];
        int j = 0;

        for (int i = 0; i < cantRegistros; i++) {
            if (regUsuario[i].equals(usuarioBuscado)) {
                indices[j] = i;
                j++;
            }
        }

        return indices;
    }

    // Funcion para mostrar todos los registros
    public static void mostrarTodosLosRegistros() {
        if (cantRegistros == 0) {
            System.out.println("No hay registros guardados.");
        } else {
            for (int i = 0; i < cantRegistros; i++) {
                System.out.println((i + 1) + ") " + regUsuario[i] + ";" + regFecha[i] + ";" + regHoras[i] + ";" + regActividad[i]);
            }
        }
    }
    // Funcion menu 1, 1) Registrar actividad.
    public static void registrarActividad(String usuarioActual, Scanner lector) {
        String fecha;
        int horas;
        String actividad;

        if (cantRegistros >= MAX_REGISTROS) {
            System.out.println("No se pueden agregar mas registros.");
            return;
        }

        System.out.print("Ingrese la fecha (dd/mm/yyyy): ");
        fecha = lector.nextLine();

        do {
            System.out.print("Ingrese la cantidad de horas: ");
            try {
                horas = Integer.parseInt(lector.nextLine());

                if (horas <= 0) {
                    System.out.println("Las horas deben ser mayores a 0.");
                }

            } catch (Exception e) {
                System.out.println("Error, ingrese un numero valido.");
                horas = -1;
            }
        } while (horas <= 0);

        System.out.print("Ingrese la actividad: ");
        actividad = lector.nextLine();

        regUsuario[cantRegistros] = usuarioActual;
        regFecha[cantRegistros] = fecha;
        regHoras[cantRegistros] = horas;
        regActividad[cantRegistros] = actividad;

        cantRegistros++;
        guardarCambios(1);
        
        System.out.println("Actividad registrada con exito.");
    }
    // Funcion para guardar (sobreescribir) los arreglos en el archivo de texto
    public static void guardarCambios(int opcion) {
    	//Verificamos que tipo de guardado queremos para ahorar ram
    	if (opcion == 1) {
	        try {
	            // Al no poner true al lado del nombre, le decimos a Java que 
	            // borre el contenido anterior y escriba todo el archivo desde cero.
	            FileWriter archivo = new FileWriter("Registros.txt");
	            PrintWriter escritor = new PrintWriter(archivo);
	            
	            // Recorremos nuestros arreglos hasta donde haya datos reales
	            for (int i = 0; i < cantRegistros; i++) {
	                // Escribimos la linea respetando el formato original con los punto y coma
	                escritor.println(regUsuario[i] + ";" + regFecha[i] + ";" + regHoras[i] + ";" + regActividad[i]);
	            }
	            // Cerramos el escritor para que el archivo no quede en blanco
	            escritor.close();
	            } catch (Exception e) {
	            System.out.println("Error al guardar los datos en Registros.txt");
	        }
    	}
    	
    	else if(opcion == 2) {
    		try {
	        	FileWriter archivoUs = new FileWriter("Usuarios.txt");
	            PrintWriter escritorUs = new PrintWriter(archivoUs);
	
	            //repetimos con los usuarios
	            for (int i = 0; i < cantUsuarios; i++) {
	            	
	            	escritorUs.println(usuariosId[i] + ";" + usuariosPass[i]);
	            }
	            
	            escritorUs.close();
			} catch (Exception e) {
				System.out.println("Error al guardar los datos en Usuarios.txt");
			}
    	}
        
    }
    
 // Menu 1, opcion 4) Cambiar contrasena
    public static void cambiarContrasena(String usuarioActual, Scanner lector) {
        int posicionUsuario = -1;
        String nuevaContrasena;
        String repetirContrasena;

        // Recorro en busca de la posición
        for (int i= 0; i < cantUsuarios; i++) {
            if (usuariosId[i].equals(usuarioActual)) {
                posicionUsuario = i;
                break;
            }
        }

        // Filtro por si no se encuentra en el arreglo
        // Redudante, si ingreso es porque el usuario si existe, printeo solo en construccion de codigo
        if (posicionUsuario == -1) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.print("Ingrese la nueva contraseña: ");
        nuevaContrasena = lector.nextLine();

        System.out.print("Repita la nueva contraseña: ");
        repetirContrasena = lector.nextLine();

        // Filtro por si no coinciden contraseñas
        if (!nuevaContrasena.equals(repetirContrasena)) {
            System.out.println("Las contraseñas no coinciden");
        // Filtro invisible
        } else if (nuevaContrasena.equals("")) {
            System.out.println("La contraseña no puede estar vacia");
        } else {
            usuariosPass[posicionUsuario] = nuevaContrasena;
            guardarCambios(2);
            System.out.println("Contraseña cambiada con exito");
            
        }
    }
    
public static void modificarActividad(String usuarioActual, Scanner lector) {
        
        int cantidadRegistros = mostrarRegistrosDeUsuario(usuarioActual);

        if (cantidadRegistros == 0) {
            return; 
        }
       
        System.out.print("\nIngrese el numero de la actividad: ");
        int opcionElegida;
        try {
            opcionElegida = Integer.parseInt(lector.nextLine());
        } catch (Exception e) {
            System.out.println("Error, ingrese un numero valido.");
            return;
        }

        if (opcionElegida == 0) {
            System.out.println("Regresando...");
            return;
        }

        if (opcionElegida > 0 && opcionElegida <= cantidadRegistros) {
            
            int[] indices = obtenerIndicesDeUsuario(usuarioActual);
            int indiceReal = indices[opcionElegida - 1];

            // Implementamos un ciclo para que pueda volver a la parte anterior
            int tipoMod = -1;
            do {
                System.out.println("\nQue deseas modificar?");
                System.out.println("0) Regresar al menu principal.");
                System.out.println("1) Fecha");
                System.out.println("2) Duracion");
                System.out.println("3) Tipo de actividad");
                System.out.print("Opcion: ");

                try {
                    tipoMod = Integer.parseInt(lector.nextLine());
                } catch (Exception e) {
                    System.out.println("Error, ingrese un numero valido.");
                    tipoMod = -1;
                    continue;
                }

                switch (tipoMod) {
                    case 0:
                        System.out.println("Regresando...");
                        break;
                    
                    case 1:
                        System.out.println("0) Regresar");
                        System.out.print("Ingrese nueva fecha (dd/mm/yyyy): ");
                        String nuevaFecha = lector.nextLine();
                        
                        if (nuevaFecha.equals("0")) {
                            System.out.println("Edicion cancelada.");
                            // Al no forzar tipoMod = 0, el ciclo vuelve a empezar
                        } else {
                            regFecha[indiceReal] = nuevaFecha;
                            guardarCambios(1); 
                            System.out.println("Actividad modificada con exito!");
                            tipoMod = 0; 
                        }
                        break;
                    
                    case 2:
                        System.out.println("0) Regresar");
                        System.out.print("Ingrese nueva duracion (horas): ");
                        try {
                            int nuevasHoras = Integer.parseInt(lector.nextLine());
                            if (nuevasHoras == 0) {
                                System.out.println("Edicion cancelada.");
                            } else if (nuevasHoras > 0) {
                                regHoras[indiceReal] = nuevasHoras;
                                guardarCambios(1);
                                System.out.println("Actividad modificada con exito!");
                                tipoMod = 0; 
                            } else {
                                System.out.println("Las horas deben ser mayores a 0. No se guardaron cambios.");
                            }
                        } catch (Exception e) {
                            System.out.println("Error, ingrese un numero valido. No se guardaron cambios.");
                        }
                        break;
                    
                    case 3:
                        System.out.println("0) Regresar");
                        System.out.print("Ingrese nuevo tipo de actividad: ");
                        
                        String opcionTemp = lector.nextLine();
                        if (opcionTemp.equals("0")) {
                            System.out.println("Edicion cancelada.");
                        } else {
                            regActividad[indiceReal] = opcionTemp;
                            guardarCambios(1);
                            System.out.println("Actividad modificada con exito!");
                            tipoMod = 0; 
                        }
                        break;

                    default:
                        System.out.println("Opcion invalida.");
                        break;
                }
            } while (tipoMod != 0); // El ciclo repite el menu mientras no sea 0

        } else {
            System.out.println("Numero de actividad fuera de rango.");
        }
    }
}