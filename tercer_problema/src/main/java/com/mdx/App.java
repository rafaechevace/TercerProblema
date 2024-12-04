package com.mdx;

import java.util.InputMismatchException;

public class App implements Constantes, Opciones {
    
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
		Persona persona;
		boolean sana;
		boolean sintomas;
		boolean contacto;
		boolean pasado;
		boolean cartilla;
        System.out.println("La persona está sana? S/n");
        sana=lectura_opcion();
		System.out.println("La persona presenta sintomas de alguna enfermedad? S/n");
        sintomas=lectura_opcion();
		System.out.println("La persona ha tenido contacto con una persona infectada hace menos de 3 semanas? S/n");
        contacto=lectura_opcion();
		System.out.println("La persona ha superado el covid? S/n");
        pasado=lectura_opcion();
		System.out.println("La persona tiene la cartilla en regla? S/n");
        cartilla=lectura_opcion();
		/*(boolean sano, boolean sintomas, boolean contacto, boolean pasado_covid, boolean cartilla)*/
		persona=new Persona(sana,sintomas,contacto,pasado,cartilla);
		return persona;
    }

    public static Espacio crear_espacio(){
        Espacio espacio;
		double temperatura;
		double humedad;
		boolean nieva;
		boolean llueve;
		boolean nublado;
		int aforo_max;
		boolean ciudad_confinada;
		
		System.out.println("Indique la temperatura de la ciudad: ");
		temperatura=lectura_número();

		System.out.println("Indique la humedad relativa de la ciudad: ");
		humedad=lectura_número();

		System.out.println("Está nevando en esa ciudad?");
		nieva=lectura_opcion();

		System.out.println("Está lloviendo en esa ciudad?");
		llueve=lectura_opcion();

		System.out.println("Está nublada esa ciudad?");
		nublado=lectura_opcion();

		System.out.println("Indique el aforo del espacio: ");
		aforo_max=lectura_número();

		System.out.println("Está esta ciudad confinada?");
		ciudad_confinada=lectura_opcion();

		espacio=new Espacio(temperatura, humedad, nieva, llueve, nublado, aforo_max, ciudad_confinada);
		return espacio;
    }

    public static String recomendacion(Persona persona, Espacio espacio, int aforo_actual){
		String actividad;
        return "";
    }

	public static void main(String[] args) {
		Espacio espacio;
		Persona persona;
		int aforo_actual_espacio;
		
		System.out.println("Registrando el espacio recreativo, introduzca por favor la información solicitada:");
		espacio= crear_espacio();
	
		System.out.println("¿Qué capacidad tiene actualmente el local?");
		aforo_actual_espacio= lectura_número();

		System.out.println("Datos del espacio registrado\n\nRegistrando la persona, introduzca por favor la información solicitada:");
		persona= crear_persona();

		System.out.println(recomendacion(persona, espacio, aforo_actual_espacio)+"\nFinalizando programa.");
	}
}
