package mastermind;

//import utilidades.Color;

public class Prueba {
//	public static void main(String[] args) {
//		String cadena1 = Color.FONDO_ROJOCLARO + "    \n    " + Color.RESET;
//		String cadena2 = Color.FONDO_VERDECLARO + "    \n    " + Color.RESET;
//		String cadena3 = Color.FONDO_AMARILLOCLARO + "    \n    " + Color.RESET;
//		
//		System.out.print(cadena1 + cadena2 + cadena3);
//	}
	
	//en la clase Jugada
	
	
//	public void dibujarJugada(Dificultad dificultad, int intento, Jugada jugada1, Jugada jugada2) {
//		if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
//			System.out.println(jugada1.dibujarPrimeraFila(dificultad, intento, jugada1, null) 
//					+ "\n" + jugada1.dibujarSegundaFila(dificultad, intento, jugada1, null));
//		} else {
//			System.out.println(jugada1.dibujarPrimeraFila(dificultad, intento, jugada1, jugada2)
//					+ "\n" + jugada1.dibujarSegundaFila(dificultad, intento, jugada1, jugada2));
//		}
//	}
	
//	private String dibujarPrimeraFila(Dificultad dificultad, int intento, Jugada jugada1, Jugada jugada2) {
//		final int ESPACIOCOMBRESULT = 3, ESPACIORESULT = (3 * dificultad.getCasillas()), ESPACIOFINAL = 2;
//		final String ESPACIO = " ", DOSESPACIOS = "  ";
//		String cadena = "", espaciosVariables = "", intermedio = "";	
//		int espaciosLibres;
//
//		espaciosLibres = ESPACIOCOMBRESULT + ESPACIORESULT + ESPACIOFINAL;			
//		for(int i = 0 ; i < espaciosLibres ; i++) {
//			espaciosVariables = espaciosVariables + " ";
//		}
//			
//		if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
//			if (intento < 10) {
//				cadena = Color.FONDO_ROJO + DOSESPACIOS + intento + "." + DOSESPACIOS + Color.RESET //Dos espacios, nº de intento y espacio hasta la combinación
//						+ jugada1.getCombinacion().dibujarCombinacion() + Color.FONDO_ROJO + espaciosVariables + Color.RESET; //Combinación y espacios hasta el final del tablero
//			} else {
//				cadena = Color.FONDO_ROJO + DOSESPACIOS + intento + "." + ESPACIO + Color.RESET
//						+ combinacion.dibujarCombinacion() + Color.FONDO_ROJO + espaciosVariables + Color.RESET;;
//			}
//		} else if (dificultad == Dificultad.MEDIO || dificultad == Dificultad.DIFICIL) {
//			if (intento < 10) {
//				intermedio = ESPACIO + intento + ".         ";
//			} else if (intento >= 10 && intento < 100) {
//				intermedio = ESPACIO + intento + ".        ";
//			} else if (intento >= 100 && intento < 1000) {
//				intermedio = ESPACIO + intento + ".       ";
//			} else if (intento >= 1000 && intento < 10000) {
//				intermedio = ESPACIO + intento + ".      ";
//			} else if (intento >= 10000 && intento < 100000) {
//				intermedio = ESPACIO + intento + ".     ";
//			} else if (intento >= 100000 && intento < 1000000) {
//				intermedio = ESPACIO + intento + ".    ";
//			} else if (intento >= 1000000 && intento < 10000000) {
//				intermedio = ESPACIO + intento + ".   ";
//			} else if (intento >= 10000000 && intento < 100000000) {
//				intermedio = ESPACIO + intento + ".  ";
//			} else if (intento >= 100000000 && intento < 1000000000) {
//				intermedio = ESPACIO + intento + ". ";
//			} 
//			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET + jugada1.getCombinacion().dibujarCombinacion() //Espacio inicial y combinación de jugador1 
//					+ Color.FONDO_ROJO + espaciosVariables + intermedio + Color.RESET //Espacio hasta el medio, intento y espacios hasta la combinación del jugador2
//					+ jugada2.getCombinacion().dibujarCombinacion() //Combinación del jugador2
//					+ Color.FONDO_ROJO + espaciosVariables + Color.RESET; 
//		}
//		return cadena;
//	} //final primera fila
//	
//	private String dibujarSegundaFila(Dificultad dificultad, int intento, Jugada jugada1, Jugada jugada2) {
//		final String ESPACIO = " ", DOSESPACIOS = "  ", TRESESPACIOS = "   ", CUATROESPACIOS = "    ";
//		String cadena = "", intermedio = "              ";
//		
//		if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
//			cadena = Color.FONDO_ROJO + DOSESPACIOS + CUATROESPACIOS + Color.RESET //Dos espacios, nº de intento y espacio hasta la combinación
//					+ combinacion.dibujarCombinacion() + Color.FONDO_ROJO + TRESESPACIOS + Color.RESET  //Combinación, espacios hasta el resultado
//					+ resultado.dibujarResultado() + Color.FONDO_ROJO + DOSESPACIOS + Color.RESET; //Resultado y dos espacios hasta el final del tablero
//		} else if (dificultad == Dificultad.MEDIO || dificultad == Dificultad.DIFICIL) {
//			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET + jugada1.getCombinacion().dibujarCombinacion()
//					+ Color.FONDO_ROJO + TRESESPACIOS + Color.RESET + jugada1.getResultado().dibujarResultado()
//					+ Color.FONDO_ROJO + intermedio + Color.RESET + jugada2.getCombinacion().dibujarCombinacion()
//					+ Color.FONDO_ROJO + TRESESPACIOS + Color.RESET + jugada2.getResultado().dibujarResultado() 
//					+ Color.FONDO_ROJO + DOSESPACIOS + Color.RESET ;
//		}
//		
//		return cadena;
//	}
	
//	public static void main(String[] args) {
//		Dificultad dificultad = Dificultad.DIFICIL;
//		Combinacion combinacion = new Combinacion(Dificultad.MEDIO);
//		combinacion.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion.anadirCasilla(new Casilla(Color.FONDO_AZUL));
//		combinacion.anadirCasilla(new Casilla(Color.FONDO_VERDE));
//		combinacion.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		Combinacion resultado = new Combinacion(Dificultad.MEDIO);
//		resultado.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		Combinacion combinacion2 = new Combinacion(Dificultad.MEDIO);
//		combinacion2.anadirCasilla(new Casilla(Color.FONDO_VERDE));
//		combinacion2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		combinacion2.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion2.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
//		Combinacion resultado2 = new Combinacion(Dificultad.MEDIO);
//		resultado2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado2.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado2.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		Combinacion combinacion3 = new Combinacion(dificultad);
//		combinacion3.anadirCasilla(new Casilla(Color.FONDO_VERDE));
//		combinacion3.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		combinacion3.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion3.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion3.anadirCasilla(new Casilla(Color.FONDO_AZUL));
//		combinacion3.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion3.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion3.anadirCasilla(new Casilla(Color.FONDO_AZUL));
//		Combinacion resultado3 = new Combinacion(dificultad);
//		resultado3.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado3.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado3.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado3.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado3.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado3.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado3.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado3.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		Combinacion combinacion4 = new Combinacion(dificultad);
//		combinacion4.anadirCasilla(new Casilla(Color.FONDO_VERDE));
//		combinacion4.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		combinacion4.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion4.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion4.anadirCasilla(new Casilla(Color.FONDO_AZUL));
//		combinacion4.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion4.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion4.anadirCasilla(new Casilla(Color.FONDO_AZUL));
//		Combinacion resultado4 = new Combinacion(dificultad);
//		resultado4.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado4.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado4.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado4.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado4.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado4.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado4.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado4.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		Combinacion combinacion5 = new Combinacion(Dificultad.FACILADIVINAR);
//		combinacion5.anadirCasilla(new Casilla(Color.FONDO_VERDE));
//		combinacion5.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		combinacion5.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		combinacion5.anadirCasilla(new Casilla(Color.FONDO_AMARILLO));
//		Combinacion resultado5 = new Combinacion(Dificultad.FACILADIVINAR);
//		resultado5.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		resultado5.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado5.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
//		resultado5.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//
//		Jugada jugada = new Jugada(combinacion, resultado);
//		Jugada jugada2 = new Jugada(combinacion2, resultado2);
//		Jugada jugada3 = new Jugada(combinacion3, resultado3);
//		Jugada jugada4 = new Jugada(combinacion4, resultado4);
//		Jugada jugada5 = new Jugada(combinacion5, resultado5);
//			
//		System.out.println(jugada5.dibujarPrimeraFila(Dificultad.FACILADIVINAR, 9, jugada5, null));
//		System.out.println(jugada5.dibujarSegundaFila(Dificultad.FACILADIVINAR, 9, jugada5, null));
//
//		
//		System.out.println(jugada2.dibujarPrimeraFila(Dificultad.MEDIO, 10, jugada2, jugada));
//		System.out.println(jugada2.dibujarSegundaFila(Dificultad.MEDIO, 10, jugada2, jugada));
//		
//		System.out.println("");
//		
//		System.out.println(jugada3.dibujarPrimeraFila(dificultad, 10, jugada3, jugada4));
//		System.out.println(jugada3.dibujarSegundaFila(dificultad, 10, jugada3, jugada4));
//		
//		System.out.println("");
//		
//		System.out.println(jugada3.dibujarPrimeraFila(dificultad, 999999999, jugada3, jugada4));
//		System.out.println(jugada3.dibujarSegundaFila(dificultad, 999999999, jugada3, jugada4));
//
//	}
	
	//En la clase combinacion
	
//	public static void main(String[] args) {
//		Combinacion combinacion = new Combinacion(Dificultad.FACILADIVINAR);
//		Casilla array[] = new Casilla[Dificultad.FACILADIVINAR.getCasillas()];
//		array[0] = new Casilla(Color.FONDO_AMARILLO);
//		array[1] = new Casilla(Color.FONDO_AZUL);
//		array[2] = new Casilla(Color.FONDO_VERDE);
//		array[3] = new Casilla(Color.FONDO_ROJOCLARO);
//		Combinacion resultado = new Combinacion(Dificultad.FACILADIVINAR);
//		Casilla array2[] = new Casilla[Dificultad.FACILADIVINAR.getCasillas()];
//		array2[0] = new Casilla(Color.FONDO_ROJOCLARO);
//		array2[1] = new Casilla(Color.FONDO_BLANCO);
//		array2[2] = new Casilla(Color.FONDO_BLANCO);
//		array2[3] = new Casilla(Color.FONDO_ROJOCLARO);
//	
//		combinacion.combinacion = array;
//		resultado.combinacion = array2;		
//	
//		System.out.println(Color.FONDO_ROJO + "                                             " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + "    " + Color.RESET + combinacion.dibujarCombinacion() + Color.FONDO_ROJO + "               " + Color.RESET + Color.FONDO_ROJO + "  " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + " 1. " + Color.RESET + combinacion.dibujarCombinacion() + Color.FONDO_ROJO + "   " + Color.RESET + resultado.dibujarResultado() + Color.FONDO_ROJO + "  " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + "                                             " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + " 10." + Color.RESET + combinacion.dibujarCombinacion() + Color.FONDO_ROJO + "   " + Color.RESET + resultado.dibujarResultado() + Color.FONDO_ROJO + "  " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + "    " + Color.RESET + combinacion.dibujarCombinacion() + Color.FONDO_ROJO + "               " + Color.RESET + Color.FONDO_ROJO + "  " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + "                                             " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + " 1. " + Color.RESET + combinacion.dibujarCombinacion() + Color.FONDO_ROJO + "               " + Color.RESET + Color.FONDO_ROJO + "  " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + "    " + Color.RESET + combinacion.dibujarCombinacion() + Color.FONDO_ROJO + "   " + Color.RESET + resultado.dibujarResultado() + Color.FONDO_ROJO + "  " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + "                                             " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + "    " + Color.RESET + combinacion.dibujarCombinacion() + Color.FONDO_ROJO + "   " + Color.RESET + resultado.dibujarResultado() + Color.FONDO_ROJO + "  " + Color.RESET);
//		System.out.println(Color.FONDO_ROJO + " 10." + Color.RESET + combinacion.dibujarCombinacion() + Color.FONDO_ROJO + "               " + Color.RESET + Color.FONDO_ROJO + "  " + Color.RESET);
//	
//}

}
