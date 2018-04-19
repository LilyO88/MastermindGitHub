package mastermind;

//import java.util.ArrayList;
//import java.util.LinkedHashMap;
import java.util.Random;

import utilidades.Color;

public class Maquina extends Jugador {
	
	Maquina(Dificultad dificultad) {
		this.dificultad = dificultad; //heredado del padre Jugador
	}

	@Override
	public Combinacion crearCombinacion() {
		Combinacion combinacion = new Combinacion(dificultad);
		Casilla casilla = null;
		Random rnd = new Random();
		boolean repetido;
		int i, aleatorioColor;
		
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
					case 1:
						casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
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
					}
				} else {
					switch (aleatorioColor) {
					case 1:
						casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
						break;
					case 2:
						casilla = new Casilla(Color.FONDO_AMARILLO);
						break;
					case 3:
						casilla = new Casilla(Color.FONDO_VERDECLARO);
						break;
					case 4:
						casilla = new Casilla(Color.FONDO_VERDE);
						break;
					case 5:
						casilla = new Casilla(Color.FONDO_CELESTECLARO);
						break;
					case 6:
						casilla = new Casilla(Color.FONDO_AZULCLARO);
						break;
					case 7:
						casilla = new Casilla(Color.FONDO_ROJOCLARO);
						break;
					case 8:
						casilla = new Casilla(Color.FONDO_MORADOCLARO);
						break;
					case 9:
						casilla = new Casilla(Color.FONDO_MORADO);
						break;
					case 10:
						casilla = new Casilla(Color.FONDO_GRISOSCURO);
						break;
					}					
				}
		//2. Definir si se puede repetir color en el tipo de partida
		/*------------------------NO PUEDEN REPETIRSE LOS COLORES------------------------*/
				if (!dificultad.getRepetir()) {
		//3. No se pueden repetir colores. Comprobar si el color está repetido	
					for (i = 0; i < combinacion.getCombinacion().length ; i++) {
		//	3.1. Si está repetido volver a pedir color			
						if (casilla.equals(combinacion.getCasilla(i))) {
							repetido = true;
						} else {
		//	3.2. Si no está repetido añadir a la combinacion
							combinacion.anadirCasilla(casilla);
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

}
