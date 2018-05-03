package mastermind;

import java.util.LinkedList;
//import java.util.HashMap;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
import java.util.Random;

import utilidades.Color;

public class Maquina extends Jugador {
	
//	private HashMap <Jugada, Boolean> intentos; //Mejor TreeMap para comprobar luego la mejor jugada //De Tablero o de máquina????
	
	Maquina(Dificultad dificultad) {
		this.dificultad = dificultad; //heredado del padre Jugador
		//SI modo dificil hacer un hashMap
		if (dificultad == Dificultad.DIFICIL) {
//			intentos = new HashMap<>();
		}
	}

	@Override
	public Combinacion crearCombinacion() {
		Combinacion combinacion = new Combinacion(dificultad);
		Casilla casilla = null;
		Random rnd = new Random();
		boolean repetido;
		int i, j, aleatorioColor;
		
		/*
		 * 1. Sacar color para la posicion x aleatorio, si la partida es nivel difícil hay 10 colores, en el resto de modos se jugarán con 8
		 * 2. Definir si se puede repetir color en el tipo de partida
		 * 3. No se pueden repetir colores. Comprobar si el color está repetido
		 * 	3.1. Si está repetido volver a pedir color
		 * 	3.2. Si no está repetido añadir a la combinacion
		 * 4. Se pueden repetir colores. Comprobar si el color está repetido. Añadir a la combinacion
		 */

		for(i = 0 ; i < dificultad.getCasillas() ; i++) {
			do {
				repetido = false;
		//1. Sacar color para la posicion x aleatorio, si la partida es nivel difícil hay 10 colores, en el resto de modos se jugarán con 8
				aleatorioColor = rnd.nextInt(dificultad.getColores());
				if (dificultad != Dificultad.DIFICIL) {
					switch (aleatorioColor) {
					case 0:
						casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
						break;
					case 1:
						casilla = new Casilla(Color.FONDO_VERDECLARO);
						break;
					case 2:
						casilla = new Casilla(Color.FONDO_VERDE);
						break;
					case 3:
						casilla = new Casilla(Color.FONDO_CELESTECLARO);
						break;
					case 4:
						casilla = new Casilla(Color.FONDO_AZULCLARO);
						break;
					case 5:
						casilla = new Casilla(Color.FONDO_ROJOCLARO);
						break;
					case 6:
						casilla = new Casilla(Color.FONDO_MORADOCLARO);
						break;
					case 7:
						casilla = new Casilla(Color.FONDO_MORADO);
						break;
					}
				} else {
					switch (aleatorioColor) {
					case 0:
						casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
						break;
					case 1:
						casilla = new Casilla(Color.FONDO_AMARILLO);
						break;
					case 2:
						casilla = new Casilla(Color.FONDO_VERDECLARO);
						break;
					case 3:
						casilla = new Casilla(Color.FONDO_VERDE);
						break;
					case 4:
						casilla = new Casilla(Color.FONDO_CELESTECLARO);
						break;
					case 5:
						casilla = new Casilla(Color.FONDO_AZULCLARO);
						break;
					case 6:
						casilla = new Casilla(Color.FONDO_ROJOCLARO);
						break;
					case 7:
						casilla = new Casilla(Color.FONDO_MORADOCLARO);
						break;
					case 8:
						casilla = new Casilla(Color.FONDO_MORADO);
						break;
					case 9:
						casilla = new Casilla(Color.FONDO_GRISOSCURO);
						break;
					}					
				}
		//2. Definir si se puede repetir color en el tipo de partida
		/*------------------------NO PUEDEN REPETIRSE LOS COLORES------------------------*/
				if (!dificultad.getRepetir()) {
					if(i==0) {
						combinacion.anadirCasilla(casilla);					
					} else {
		//3. No se pueden repetir colores. Comprobar si el color está repetido	
						for (j = 0 ; j < i && !repetido ; j++) { //falla cuando se repite
		//	3.1. Si está repetido volver a pedir color			
							if (casilla.equals(combinacion.getCasilla(j))) {
								repetido = true;
							} else if (!casilla.equals(combinacion.getCasilla(j)) && (j == (i - 1))) {
		//	3.2. Si no está repetido añadir a la combinacion
								combinacion.anadirCasilla(casilla);
							}
						}
					}
				} else {
		/*------------------------PUEDEN REPETIRSE LOS COLORES------------------------*/
		//4. Se pueden repetir colores. Comprobar si el color está repetido. Añadir a la combinacion
					for (i = 0; i < combinacion.getCombinacion().length ; i++) {
						combinacion.anadirCasilla(casilla);					
					}
				}				
			} while(repetido);
		} //final del for
		
		return combinacion;
	}

	public Combinacion crearIntento(Tablero tablero, int intento) {
		Combinacion combinacion = new Combinacion(dificultad), colores = new Combinacion(dificultad), intentoCombinacion = new Combinacion(dificultad),
				definitiva = new Combinacion(dificultad);
		Jugada resultadoAnterior = new Jugada(tablero.getTablero().getLast().getResultado());
		Casilla casilla = null;
		Random rnd = new Random();
		int i, aleatorioColor, numeroPinchos = 0, descartados[] = new int[dificultad.getCasillas()];
		
		//1. Según el modo de juego la máquina crea una estrategia u otra
		//	1.1. Dificultad fácil y media
		if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR || dificultad == Dificultad.MEDIO) {
		//		1.1.1. Si es el primer intento la combinación no se basa en un resultado y es aleatoria	
			if(intento == 1) {
				crearCombinacion();
		//		1.1.2. Creamos una combinación en base al resultado de la combinación anterior
			} else {
		//			1.1.2.1. Comprobamos el resultado de la jugada anterior
				
			}
		

		//	1.2. Dificultad difícil
		} else {
		//		1.2.1. Si es el primer intento la combinación no se basa en un resultado y es un color aleatorio 
		//			repetido en todas las casillas	
			if(intento == 1) {
				aleatorioColor = rnd.nextInt(dificultad.getColores());				
				switch (aleatorioColor) {
				case 0:
					casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
					break;
				case 1:
					casilla = new Casilla(Color.FONDO_AMARILLO);
					break;
				case 2:
					casilla = new Casilla(Color.FONDO_VERDECLARO);
					break;
				case 3:
					casilla = new Casilla(Color.FONDO_VERDE);
					break;
				case 4:
					casilla = new Casilla(Color.FONDO_CELESTECLARO);
					break;
				case 5:
					casilla = new Casilla(Color.FONDO_AZULCLARO);
					break;
				case 6:
					casilla = new Casilla(Color.FONDO_ROJOCLARO);
					break;
				case 7:
					casilla = new Casilla(Color.FONDO_MORADOCLARO);
					break;
				case 8:
					casilla = new Casilla(Color.FONDO_MORADO);
					break;
				case 9:
					casilla = new Casilla(Color.FONDO_GRISOSCURO);
					break;
				}	
				for(i = 0 ; i < dificultad.getCasillas() ; i++) {
					intentoCombinacion.anadirCasilla(casilla);
				}
		//		1.2.2. Contamos el número de pinchos que resultan de crear esta combinación
				numeroPinchos = intentoCombinacion.calcularResultado(tablero.getCombinacionSecreta()).contarColocados()
								+ intentoCombinacion.calcularResultado(tablero.getCombinacionSecreta()).contarNoColocados();
		//			1.2.2.1. Si el número de pinchos es superior a 0, el color aleatorio que hemos probado está en la combinación secreta
		//					y lo colocamos dentro de un array que usaremos para reunir todos los colores que están en la secreta
				
		//			1.2.2.2. Si el número de pinchos ES IGUAL 0, el color aleatorio que hemos probado NO está en la combinación secreta
		//					y lo colocamos dentro de un array de colores descartados
				combinacion = intentoCombinacion;
				
		//		1.2.2. Creamos una combinación en base al resultado de la combinación anterior
			} else {
		//			1.1.2.1. Comprobamos que el array de colores tenga algún espacio vacío
		//				1.1.2.1.1. Si tiene algún espacio por rellenar, buscamos un nuevo color
		//					1.1.2.1.1.1. Elegir color para seguir rellenando el array de colores de la combinación, repitiendo siempre que
		//								el color ya este repetido
				
		//				1.1.2.1.2. Si no tiene ningún espacio para rellenar, colocamos los colores en sus correspondientes posiciones
				
			}
		}
		
		return combinacion;
	} //final crearIntento()
}
