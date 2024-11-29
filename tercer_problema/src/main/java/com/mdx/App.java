package com.mdx;

import java.util.InputMismatchException;

public class App implements Constantes {
    
    public static int lectura_número() {
		int lectura=0;
		boolean seguir=false;
		do {
		try {
		
			lectura= TECLADO.nextInt();
			seguir=true;
		} catch(InputMismatchException e) {
			
			System.out.println("Error, no ha introducido un número entero, por favor, inténtelo de nuevo");
			TECLADO.next();
		}
		}while (!seguir);
		return lectura;

	}

    public static boolean  lectura_opcion() {
		String lectura;
        boolean resultado=false;
		boolean seguir=false;
		do {
		try {
			lectura= TECLADO.nextLine();
			seguir=true;
            if (lectura.equalsIgnoreCase("s")){
                resultado=true;
                
            }else if (lectura.equalsIgnoreCase("n")){
                resultado=false;

            }else{
                throw new OpcionNoValidaException("Error, seleccion no válida");
            }
		} catch(OpcionNoValidaException e) {			
			System.out.println("Error, seleccion no válida");
			TECLADO.next();
		}
		}while (!seguir);
		return resultado;

	}

    public static Persona crear_persona(){
        Persona p;
        System.out.print("La persona está sana? S/n");
        boolean sana=lectura_opcion();
        return p;
    }

    public static Espacio crear_espacio(){
        Persona p;
        return p;
    }

    public static String recomendcion(){
        return "";
    }
}
