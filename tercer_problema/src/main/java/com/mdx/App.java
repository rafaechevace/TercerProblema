package com.mdx;

import java.util.InputMismatchException;

public class App implements Constantes, Opciones {
    
    public static int lectura_número() {
		int lectura=0;
		boolean seguir=false;
		do {
		try {
		
			lectura= TECLADO.nextInt();
			TECLADO.nextLine();
			seguir=true;
		} catch(InputMismatchException e) {
			TECLADO.next();
			System.out.println("Error, no ha introducido un número entero, por favor, inténtelo de nuevo");

		}
		}while (!seguir);
		return lectura;

	}

	public static boolean lectura_opcion() {
		String lectura;
		boolean resultado= false;
		boolean seguir= false;
	
		do {
			try {
				lectura = TECLADO.nextLine();
				if (lectura.equalsIgnoreCase("s")) {
					resultado= true;
					seguir= true;
				} else if (lectura.equalsIgnoreCase("n")) {
					seguir= true;
				} else {
					throw new OpcionNoValidaException("Error, selección no válida");
				}
			} catch (OpcionNoValidaException e) {
				System.out.println(e.getMessage() + ", pruebe otra vez.");
			}
		} while (!seguir);
	
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

		System.out.println("Está nevando en esa ciudad? S/n");
		nieva=lectura_opcion();

		System.out.println("Está lloviendo en esa ciudad? S/n");
		llueve=lectura_opcion();

		System.out.println("Está nublada esa ciudad? S/n");
		nublado=lectura_opcion();

		System.out.println("Indique el aforo del espacio: ");
		aforo_max=lectura_número();

		System.out.println("Está esta ciudad confinada? S/n");
		ciudad_confinada=lectura_opcion();

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
				actividad=CAÑAS;
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
		espacio= crear_espacio();
	
		System.out.println("¿Qué capacidad tiene actualmente el local?");
		aforo_actual_espacio= lectura_número();

		System.out.println("Datos del espacio registrado\n\nRegistrando la persona, introduzca por favor la información solicitada:");
		persona= crear_persona();

		System.out.println("Actividad recomendada: \t"+recomendacion(persona, espacio, aforo_actual_espacio)+"\nFinalizando programa.");
	}
}
