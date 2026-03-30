package logica;

import java.util.Scanner;
import java.io.*;


public class Main{
	
	    static int MAX_REGISTROS = 300;
	    static int MAX_USUARIOS = 3;

	    static String[] usuariosId = new String[MAX_USUARIOS];
	    static String[] usuariosPass = new String[MAX_USUARIOS];
	    static int cantUsuarios = 0;

	    static String[] regUsuario = new String[MAX_REGISTROS];
	    static String[] regFecha = new String[MAX_REGISTROS];
	    static int[] regHoras = new int[MAX_REGISTROS];
	    static String[] regActividad = new String[MAX_REGISTROS];
	    static int cantRegistros = 0;
	
	
    public static void main(String[] args) throws FileNotFoundException {
        Scanner lector = new Scanner(System.in);
        
        //creamos el lector del archivo de registros
        File registro = new File("Registros.txt");
        
        Scanner scRegistro =  new Scanner(registro);
        
        int opcionPrincipal = 0;
        int opcionUsuario = 0;
        String usuario;
        String contrasena;
        boolean accesoCorrecto = false;
        
        
        
        do {
            System.out.println("1) Menu de Usuarios");
            System.out.println("2) Menu de Analisis");
            System.out.println("3) Salir");
            System.out.print("Ingrese una opcion: ");
            
            
            try {
            	opcionPrincipal = Integer.parseInt(lector.nextLine());
			} catch (Exception e) {
				System.out.println("Error");
			}
           

            switch (opcionPrincipal) {
                case 1:
                    System.out.print("Usuario: ");
                    usuario = lector.nextLine();

                    System.out.print("Contraseña: ");
                    contrasena = lector.nextLine();

                    accesoCorrecto = false;

                    if (usuario.equals("Martin") && contrasena.equals("papurri")) {
                        accesoCorrecto = true;
                    } else if (usuario.equals("Catalina") && contrasena.equals("furryfacto")) {
                        accesoCorrecto = true;
                    } else if (usuario.equals("Estefania") && contrasena.equals("cutiemarks")) {
                        accesoCorrecto = true;
                    }

                    if (accesoCorrecto) {
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
                            opcionUsuario = Integer.parseInt(lector.nextLine());

                            switch (opcionUsuario) {
                                case 1:
                                    System.out.println("Opcion registrar actividad seleccionada.");
                                    break;
                                case 2:
                                    System.out.println("Opcion modificar actividad seleccionada.");
                                    break;
                                case 3:
                                    System.out.println("Opcion eliminar actividad seleccionada.");
                                    break;
                                case 4:
                                    System.out.println("Opcion cambiar contraseña seleccionada.");
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
                    System.out.println("Menu de analisis aun no implementado.");
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
}