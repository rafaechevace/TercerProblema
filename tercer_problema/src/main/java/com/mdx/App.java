package com.mdx;

import java.util.InputMismatchException;

public class App implements Constantes, Opciones {
    
       public static int lectura_numero(Scanner scanner) {
        int lectura = 0;
        boolean inputValido = false;

        while (!inputValido) {
            try {
                System.out.print("Introduzca un número entero: ");
                lectura = Integer.parseInt(scanner.nextLine().trim());
                inputValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error, no ha introducido un número entero. Por favor, inténtelo de nuevo.");
            }
        }

        return lectura;
    }

    public static boolean lectura_opcion(Scanner scanner) {
        String lectura;

        while (true) {
            try {
                System.out.print("Introduzca 's' (sí) o 'n' (no): ");
                lectura = scanner.nextLine().trim();

                if (lectura.equalsIgnoreCase("s")) {
                    return true;
                } else if (lectura.equalsIgnoreCase("n")) {
                    return false;
                } else {
                    throw new OpcionNoValidaException("Error, selección no válida.");
                }
            } catch (OpcionNoValidaException e) {
                System.out.println(e.getMessage() + " Pruebe otra vez.");
            }
        }
    }
	
    public static Persona crear_persona(Scanner entrada){
		Persona persona;
		boolean sana;
		boolean sintomas;
		boolean contacto;
		boolean pasado;
		boolean cartilla;
        System.out.println("La persona está sana? S/n");
        sana=lectura_opcion(entrada);
		System.out.println("La persona presenta sintomas de alguna enfermedad? S/n");
        sintomas=lectura_opcion(entrada);
		System.out.println("La persona ha tenido contacto con una persona infectada hace menos de 3 semanas? S/n");
        contacto=lectura_opcion(entrada);
		System.out.println("La persona ha superado el covid? S/n");
        pasado=lectura_opcion(entrada);
		System.out.println("La persona tiene la cartilla en regla? S/n");
        cartilla=lectura_opcion(entrada);
		/*(boolean sano, boolean sintomas, boolean contacto, boolean pasado_covid, boolean cartilla)*/
		persona=new Persona(sana,sintomas,contacto,pasado,cartilla);
		return persona;
    }

    public static Espacio crear_espacio(Scanner entrada){
        Espacio espacio;
		double temperatura;
		double humedad;
		boolean nieva;
		boolean llueve;
		boolean nublado;
		int aforo_max;
		boolean ciudad_confinada;
		
		System.out.println("Indique la temperatura de la ciudad: ");
		temperatura=lectura_numero(entrada);

		System.out.println("Indique la humedad relativa de la ciudad: ");
		humedad=lectura_numero(entrada);

		System.out.println("Está nevando en esa ciudad? S/n");
		nieva=lectura_opcion(entrada);

		System.out.println("Está lloviendo en esa ciudad? S/n");
		llueve=lectura_opcion(entrada);

		System.out.println("Está nublada esa ciudad? S/n");
		nublado=lectura_opcion(entrada);

		System.out.println("Indique el aforo del espacio: ");
		aforo_max=lectura_numero(entrada);

		System.out.println("Está esta ciudad confinada? S/n");
		ciudad_confinada=lectura_opcion(entrada);

		espacio=new Espacio(temperatura, humedad, nieva, llueve, nublado, aforo_max, ciudad_confinada);
		return espacio;
    }
	
    public static String recomendacion(Persona persona, Espacio espacio, int aforo_actual){
		String actividad=NADA;
		if (persona.get_sano()&&!persona.get_sintomas()&&!persona.get_contacto()&&persona.get_pasado_covid()&&persona.get_cartilla()){	
			if(espacio.get_temperatura()<BAJOC&&espacio.get_humedad()<POCAH){
					if (espacio.get_nieva()||espacio.get_llueve()){
						actividad=CASA;
					}else if(aforo_actual+1<=espacio.get_aforo_max_actividad()){
						actividad=ESQUIAR;
					}
			} else if ((espacio.get_temperatura()>=BAJOC&&espacio.get_temperatura()<=QUINCE)&&!espacio.get_llueve()&&(aforo_actual+1<=espacio.get_aforo_max_actividad())){
				actividad=SENDERISMO;
			} else if ((espacio.get_temperatura()>=QUINCE&&espacio.get_temperatura()<=TEMPLADO)&&!espacio.get_llueve()&&!espacio.get_nublado()&&espacio.get_humedad()<=MUCHAH&&!espacio.get_confinada()){
				actividad=TURISMO;
			} else if ((espacio.get_temperatura()>=TEMPLADO&&espacio.get_temperatura()<=MUCHOCALOR)&&!espacio.get_llueve()&&(aforo_actual+1<=espacio.get_aforo_max_actividad())){
				actividad=CANAS;
			}else if(espacio.get_temperatura()>=CALOR&&!espacio.get_llueve()){
				actividad=PISCINA;
				if (aforo_actual+1>=espacio.get_aforo_max_actividad()){
					actividad=PLAYA;
				}
			}
		}
        return actividad;
    }

	public static void main(String[] args) {
		Espacio espacio;
		Persona persona;
		int aforo_actual_espacio;
		
		System.out.println("Registrando el espacio recreativo, introduzca por favor la información solicitada:");
		espacio= crear_espacio(TECLADO);//Sé que no es buena práctica, pero es la única forma de que JUnit no se raye entrando en bucle a la hora de testear que hemos encontrado
	
		System.out.println("¿Qué capacidad tiene actualmente el local?");
		aforo_actual_espacio= lectura_numero(TECLADO);

		System.out.println("Datos del espacio registrado\n\nRegistrando la persona, introduzca por favor la información solicitada:");
		persona= crear_persona(TECLADO);

		System.out.println("Actividad recomendada: \t"+recomendacion(persona, espacio, aforo_actual_espacio)+"\nFinalizando programa.");
	}
}
