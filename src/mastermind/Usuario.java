package mastermind;

import utilidades.Color;
import utilidades.Teclado;
import utilidades.Teclado.Rango;

public class Usuario extends Jugador {
	
	Usuario(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public Combinacion crearCombinacion() { //Es igual que realizar jugada, ¿¿¿Llamar a realizarJugada de Usuario???
		Combinacion combinacion = new Combinacion(dificultad);
		Casilla casilla = null;
		boolean repetido;
		int i, j, opcionColor;
		
		/*
		 * 1. Pedir color al usuario de la posicion 
		 * 2. Definir si se puede repetir color o no según el tipo de partida
		 * 3. No se pueden repetir colores. Se comprueba que el color no esté ya en la combinación
		 * 	3.1. Si el color está, se le vuelve a pedir al usuario
		 * 	3.2. Si el color no está, se introduce la casilla en la combinación
		 * 4. Se pueden repetir colores
		 */
		
		System.out.println("Estos son los colores que puede usar para crear la combinación:\n"
		+ Color.FONDO_AMARILLOCLARO + " 1 " + Color.RESET + "  " + Color.FONDO_VERDECLARO + " 2 "
					+ Color.RESET + "  " + Color.FONDO_VERDE + " 3 " + Color.RESET + "  " + Color.FONDO_CELESTECLARO
					+ " 4 " + Color.RESET + "  " + Color.FONDO_AZULCLARO + " 5 " + Color.RESET + "  "
					+ Color.FONDO_ROJOCLARO + " 6 " + Color.RESET + "  " + Color.FONDO_MORADOCLARO + " 7 " + Color.RESET
					+ "  " + Color.FONDO_MORADO + " 8 " + Color.RESET + "\n");
		
		for(i = 0 ; i < dificultad.getCasillas() ; i++) {	
			do {
				repetido = false;		
		//1. Pedir color al usuario de la posicion 
				opcionColor = Teclado.leerInt("Posición " + (i + 1) + ":");
//				System.out.println(opcionColor);
				switch (opcionColor) {
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
		//2. Definir si se pueden repetir colores o no según el tipo de partida
		//3. No se pueden repetir colores. Se comprueba si el color está
		/*------------------------NO PUEDEN REPETIRSE LOS COLORES------------------------*/
				if(!dificultad.getRepetir()) {
					if(i==0) {
						combinacion.anadirCasilla(casilla);					
					} else {
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
		//4. Se pueden repetir colores. Se añade la casilla a la combinación
		/*------------------------PUEDEN REPETIRSE LOS COLORES------------------------*/
					combinacion.anadirCasilla(casilla);
				}			
			} while (repetido);
		} //final del for
		
		return combinacion;
	} //final crearCombinacion
	
	public Combinacion colocarPinchos(Combinacion combinacion, Combinacion combinacionSecreta) { //¿¿¿¿Lo hace el usuario????
		Combinacion resultado = new Combinacion(dificultad);
		boolean repetir;
		int i, colocados = 0, noColocados = 0;
		
		System.out.println("Introduce tu respuesta");
		do {
			repetir = false;
			colocados = Teclado.leerRango(0, dificultad.getCasillas(), Rango.AMBOSINCLUIDOS, "Introduzca el número de fichas "
					+ "que coinciden color y posición");
		//Introduce en resultado el número de fichas del mismo color y en la misma posición
			for (i = 0; i < colocados; i++) {
				resultado.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
			}
			noColocados = Teclado.leerRango(0, (dificultad.getCasillas() - colocados), Rango.AMBOSINCLUIDOS, "Introduce el número "
					+ "de fichas que coicida solo el color");
		//Introduce en resultado el número de fichas del mismo color
			for (i = colocados; i < (colocados + noColocados) ; i++) {
				resultado.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
			}
		//Introduce en resultado el número de fichas que no coinciden
			for (i = (colocados + noColocados); i < dificultad.getCasillas(); i++) {
				resultado.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
			}
			//Se comprueba que el resultado que hemos propuesto es el mismo que si se calcula automáticamente
			if (!resultado.equals((combinacion.calcularResultado(combinacionSecreta)))) {
				System.out.println("Tu respuesta no es correcta, introdúcela de nuevo");
				repetir = true;
			} 
		} while (repetir);
		return resultado;
	} //final de colocarPinchos

}
