package mastermind;

import java.util.Random;

import utilidades.Color;

public class Maquina extends Jugador {
	
//	private HashMap <Jugada, Boolean> intentos; //Mejor TreeMap para comprobar luego la mejor jugada //De Tablero o de máquina????
	
	Maquina(Dificultad dificultad) {
		this.dificultad = dificultad; //heredado del padre Jugador
		//SI modo dificil hacer un hashMap
//		if (dificultad == Dificultad.DIFICIL) {
//			intentos = new HashMap<>();
//		}
	}

	@Override
	public Combinacion crearCombinacion() {
		Combinacion combinacion = new Combinacion(dificultad);
		Casilla casilla = new Casilla(Color.FONDO_NEGRO);
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
				casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioColor);
//				if (dificultad != Dificultad.DIFICIL) {
//					switch (aleatorioColor) {
//					case 0:
//						casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
//						break;
//					case 1:
//						casilla = new Casilla(Color.FONDO_VERDECLARO);
//						break;
//					case 2:
//						casilla = new Casilla(Color.FONDO_VERDE);
//						break;
//					case 3:
//						casilla = new Casilla(Color.FONDO_CELESTECLARO);
//						break;
//					case 4:
//						casilla = new Casilla(Color.FONDO_AZULCLARO);
//						break;
//					case 5:
//						casilla = new Casilla(Color.FONDO_ROJOCLARO);
//						break;
//					case 6:
//						casilla = new Casilla(Color.FONDO_MORADOCLARO);
//						break;
//					case 7:
//						casilla = new Casilla(Color.FONDO_MORADO);
//						break;
//					}
//				} else {
//					switch (aleatorioColor) {
//					case 0:
//						casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
//						break;
//					case 1:
//						casilla = new Casilla(Color.FONDO_AMARILLO);
//						break;
//					case 2:
//						casilla = new Casilla(Color.FONDO_VERDECLARO);
//						break;
//					case 3:
//						casilla = new Casilla(Color.FONDO_VERDE);
//						break;
//					case 4:
//						casilla = new Casilla(Color.FONDO_CELESTECLARO);
//						break;
//					case 5:
//						casilla = new Casilla(Color.FONDO_AZULCLARO);
//						break;
//					case 6:
//						casilla = new Casilla(Color.FONDO_ROJOCLARO);
//						break;
//					case 7:
//						casilla = new Casilla(Color.FONDO_MORADOCLARO);
//						break;
//					case 8:
//						casilla = new Casilla(Color.FONDO_MORADO);
//						break;
//					case 9:
//						casilla = new Casilla(Color.FONDO_GRISOSCURO);
//						break;
//					}					
//				}
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
		Combinacion combinacion = new Combinacion(dificultad), intentoCombinacion = new Combinacion(dificultad);
		Casilla casilla = null, colores[] = new Casilla[dificultad.getCasillas()], descartados[] = new Casilla[dificultad.getCasillas()];
		Random rnd = new Random();
		int i = 0, j = 0, k = 0, aleatorioColor, numeroPinchos = 0, aleatorioPosicion, colocados[] = new int[dificultad.getCasillas()];
		boolean repetido = false, salir = false;
		
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
		//		1.2.1. Comprobar que el array de colores esté lleno, si no lo está seguimos llenándolo de los colores, sino, buscamos las posiciones de las casillas
			while (colores[i] != null || i > 7) {
				i++;
			}		
		//			1.2.1.1. Buscar los colores que componen la combinación			
			if (i <= 7) {
				do {
					//aleatorio para seleccionar un color
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
		//				1.2.1.1.1. Buscar el color en el array descartados para no repetir dos intentos
					for (i = 0; i < descartados.length && !salir; i++) {
		//					1.2.1.1.1.1. Si el color es igual a uno que se encuentre dentro del array de descartados, 
		//								el color ya ha sido usado, hay que pedir otro color
						if (descartados[k] != null && descartados[k].equals(casilla)) {
							repetido = true;
							salir = true;
		//					1.2.1.1.1.2. Si ya no hay más colores que comprobar dentro del array de descartados, el color se puede usar
						} else if (descartados[k] == null) {
							salir = true;
						}
					}
				} while (repetido); //Repite cuando el color está repetido y pide otro
				//Se introduce el color en la combinación a probar
				for (i = 0; i < dificultad.getCasillas(); i++) {
					intentoCombinacion.anadirCasilla(casilla);
				}
				numeroPinchos = intentoCombinacion.contarPinchos(tablero);
				//Si el número de pinchos es distinto de 0, significa que el color si se encuentra en la combinación secreta
				if (numeroPinchos != 0) {
					//Avanzamos hasta que haya un hueco libre en el array de colores
					while (colores[i] != null) {
						i++;
					}
					//Se colocan los colores correspondientes en el array
					for (j = 0; j < numeroPinchos; j++) {
						colores[i] = casilla;
						i++;
					}
					//Si el número de pinchos es IGUAL a 0, significa que el color que hemos probado no está en la combinación secreta
				} else {
					//Avanzamos hasta que haya un hueco libre en el array de descartados
					while (descartados[i] != null) {
						i++;
					}
					//
					descartados[i] = casilla;
				}
		//			1.2.1.2. Teniendo los colores de la combinación, buscar la posición de cada uno
			} else {
				
			}
		}		
		
		return combinacion;
	} //final crearIntento()
}
