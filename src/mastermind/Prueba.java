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
	
	//En la clase tablero
	
//	public void dibujarTableros(Tablero tablero2, int intento) {
//	final int UNESPACIO = 1, DOSESPACIOS = 2, TRESESPACIOS = 3, SEISESPACIOS = 6, DOCEESPACIOS = 12, 
//			OCUPACOMB = (6 * dificultad.getCasillas()), OCUPARESULT = (3 * dificultad.getCasillas());
//	final String ESPACIO = " ";
//	String espaciosVacios = "";
//	int i, largo = 0;
//	
//	if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
//		largo = SEISESPACIOS + OCUPACOMB + TRESESPACIOS + OCUPARESULT + DOSESPACIOS;
//		
//		for(i = 0 ; i < largo ; i++) {
//			espaciosVacios = espaciosVacios + ESPACIO;
//		}
//		
//		if(intento == 1) {
//			System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET + "\n"
//								+ dibujarTablerosPrimeraFila(null, intento) + "\n" + dibujarTablerosSegundaFila(null)
//								+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
//		} else {
//			System.out.println(dibujarTablerosPrimeraFila(null, intento) + "\n" + dibujarTablerosSegundaFila(null)
//								+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
//		}
//	} else {
//		largo = UNESPACIO + (2 * (6 * OCUPACOMB)) + (2 * TRESESPACIOS) + (2 * (3 * OCUPARESULT)) + (2 * DOSESPACIOS) + DOCEESPACIOS;
//		
//		for(i = 0 ; i < largo ; i++) {
//			espaciosVacios = espaciosVacios + ESPACIO;
//		}
//		
//		if(intento == 1) {
//			System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET);
//		} else {
//			System.out.println(dibujarTablerosPrimeraFila(null, intento) + dibujarPrimeraFilaIntermedio(intento) 
//								+ tablero2.dibujarTablerosPrimeraFila(tablero2, intento) + "\n" + dibujarTablerosSegundaFila(tablero2)
//								+ dibujarSegundaFilaIntermedio() + tablero2.dibujarTablerosSegundaFila(tablero2));
//		}
//	}
//		
//}
	
//	public void dibujarCombinacionSecreta2(Tablero tablero2) {		
//	final String ESPACIO = " ";
//	String espaciosVacios = "";
//	int i, largo = 0;
//	Jugada jugada = new Jugada(combinacionSecreta), jugada2 = new Jugada(tablero2.getCombinacionSecreta());
//
//	/*
//	 * 1. Dibujar la combinación secreta del tablero
//	 * 2. Dependiendo de la dificultad, mostrar en pantalla la combinación secreta
//	 * 	2.1. Fácil, se muestran los espacios del inicio, la combinación secreta y un espacio final, 2 filas
//	 * 	2.2. Medio o Difícil, se muestra en pantalla los espacios del inicio, combinación secreta del jugador1, espacios variables,
//	 * 		el espacio intermedio, combinación secreta del jugador2, y un pequeño espacio final, 2 filas
//	 * 3. Se muestran también una fila entera vacía coloreado como el tablero antes y después de dibujar las jugadas o combinaciones
//	 */
//	
//	if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
//		largo = dibujarTablerosSegundaFila(null).length();
//		
//		for(i = 0 ; i < largo ; i++) {
//			espaciosVacios = espaciosVacios + ESPACIO;
//		}
//		
//		System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET);
//		System.out.println(dibujarSegundaFilaInicio() + jugada.dibujarPrimeraFilaJugada(dificultad) 
//							+ "\n" + dibujarSegundaFilaInicio() + jugada.dibujarPrimeraFilaJugada(dificultad)
//							+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
//	} else {
//		largo = dibujarTablerosSegundaFila(null).length() + dibujarSegundaFilaIntermedio().length() 
//				+ dibujarTablerosSegundaFila(null).length();
//		
//		for(i = 0 ; i < largo ; i++) {
//			espaciosVacios = espaciosVacios + ESPACIO;
//		}
//		
//		System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET);
//		System.out.println(dibujarSegundaFilaInicio() + jugada.dibujarPrimeraFilaJugada(dificultad) + dibujarSegundaFilaIntermedio()
//						+ jugada2.dibujarPrimeraFilaJugada(dificultad) + "\n" + dibujarSegundaFilaInicio() 
//						+ jugada.dibujarPrimeraFilaJugada(dificultad) + dibujarSegundaFilaIntermedio() 
//						+ jugada2.dibujarPrimeraFilaJugada(dificultad) + "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
//	}
//} //final dibujarCombinacionSecreta
	
//	private String dibujarTablerosPrimeraFila(Tablero tablero2, int intento) {
//	String cadena = "";
//	Jugada jugada = null, jugada2 = null;
//
//	jugada = tablero.getLast();
//	
//	if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) 
//		cadena = dibujarPrimeraFilaInicio(intento) + jugada.dibujarPrimeraFilaJugada(dificultad);
//	else {
//		jugada2 = tablero2.getTablero().getLast();
//		cadena = dibujarPrimeraFilaInicio(intento) + jugada.dibujarPrimeraFilaJugada(dificultad) 
//				+ dibujarPrimeraFilaIntermedio(intento) + jugada2.dibujarPrimeraFilaJugada(dificultad);
//	}
//	return cadena;
//}
//
//private String dibujarTablerosSegundaFila(Tablero tablero2) {
//	String cadena = "";
//	Jugada jugada = null, jugada2 = null;
//
//	jugada = tablero.getLast();
//	
//	
//	if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) 
//		cadena = dibujarSegundaFilaInicio() + jugada.dibujarSegundaFilaJugada(dificultad);
//	else {
//		jugada2 = tablero2.getTablero().getLast();
//		cadena = dibujarSegundaFilaInicio() + jugada.dibujarSegundaFilaJugada(dificultad) + dibujarSegundaFilaIntermedio() 
//				+ jugada2.dibujarSegundaFilaJugada(dificultad);
//	}
//	return cadena;
//}

	//Máquina
	
//	//		1.2.1. Comprobar que el array de colores esté lleno, si no lo está seguimos llenándolo de los colores, sino, buscamos las posiciones de las casillas
//	while (colores[i] != null && i > 7) {
//		i++;
//	}		
////			1.2.1.1. Buscar los colores que componen la combinación			
//	if (i <= 7) {
//		do {
//			//aleatorio para seleccionar un color
//			aleatorioColor = rnd.nextInt(dificultad.getColores());
//			casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioColor);
////				1.2.1.1.1. Buscar el color en el array descartados para no repetir dos intentos
//			for (i = 0; i < descartados.length && !salir; i++) {
////					1.2.1.1.1.1. Si el color es igual a uno que se encuentre dentro del array de descartados o colores, 
////								el color ya ha sido usado, hay que pedir otro color
//				if (descartados[k] != null && descartados[k].equals(casilla) || colores[k] != null && colores[k].equals(casilla)) {
//					repetido = true;
//					salir = true;
////					1.2.1.1.1.2. Si ya no hay más colores que comprobar dentro del array de descartados, el color se puede usar
//				} else if (descartados[k] == null || colores[k] == null) {
//					salir = true;
//				}
//			}
//		} while (repetido); //Repite cuando el color está repetido y pide otro
//		//Se introduce el color en la combinación a probar
//		for (i = 0; i < dificultad.getCasillas(); i++) {
//			intentoCombinacion.anadirCasilla(casilla);
//		}
////				1.2.1.1.2. Contamos el número de pinchos resultantes de la combinación propuesta
//		numeroPinchos = intentoCombinacion.contarPinchos(tablero);
////					1.2.1.1.2.1. Si el número de pinchos es distinto de 0, significa que el color si se encuentra en la combinación secreta
//		if (numeroPinchos != 0) {
//			//Avanzamos hasta que haya un hueco libre en el array de colores
//			i = 0;
//			while (colores[i] != null) {
//				i++;
//			}
//			//Se colocan los colores correspondientes en el array
//			for (j = 0; j < numeroPinchos; j++) {
//				colores[i] = casilla;
//				i++;
//			}
////					1.2.1.1.2.2. Si el número de pinchos es IGUAL a 0, significa que el color que hemos probado no está en la combinación secreta
//		} else {
//			//Avanzamos hasta que haya un hueco libre en el array de descartados
//			i = 0;
//			while (descartados[i] != null) {
//				i++;
//			}
//			//Introducimos el color que no está en la combinación secreta en el array de descartados
//			descartados[i] = casilla;
//		}
////			1.2.1.2. Teniendo los colores de la combinación, buscar la posición de cada uno
//	} else {
//		int contadorColores = 0, contadorPosiciones = 0, posicionesOcupadas[] = new int[dificultad.getCasillas()], 
//				aleatorioPosicion;
//		boolean posicionRepetida = false;
//		Casilla colorDescartado;
//		
//		/*
//		 * 1. Elige un color
//		 * 2. Elige una posición
//		 * 3. Envía y comprueba la intentoCombinación
//		 * 	3.1. Si el pincho no es rojo
//		 * 		3.1.1. Cambia la posición
//		 * 	3.2. Si el pincho es rojo
//		 * 		3.2.1. Introduce la posición en el array de posicionesOcupadas
//		 * 		3.2.2. Añade el color en la posición correcta en la combinación
//		 * 		3.2.3. Aumenta el contador de colores
//		 */
//		
//		//Se rellena de -1 para poder hacer comprobaciones de contenido después
//		if (contadorPosiciones == 0) {
//			for (i = 0; i < posicionesOcupadas.length; i++) {
//				posicionesOcupadas[i] = -1;
//			} 
//		}
////	2. Elige una posición al azar
//		do {
//			posicionRepetida = false; //reinicio las variables
//			salir = false;
//			aleatorioPosicion = rnd.nextInt(7);
//			for(i = 0 ; i < posicionesOcupadas.length && !salir; i++) {
//				//La posición a probar está en el array de posicionesOcupadas
//				if(posicionesOcupadas[i] == aleatorioPosicion) {
//					posicionRepetida = true;
//					salir = true;
//				//Ya no hay más posiciones en el array de posicionesOcupadas para comprobar
//				} else if(posicionesOcupadas[i] == -1) {
//					salir = true;
//				}
//			}
//		} while (posicionRepetida);
//		
//		colorDescartado = descartados[0];
//		for(i = 0 ; i < dificultad.getCasillas() ; i++) {
//			if(i == aleatorioPosicion) {
//				intentoCombinacion.anadirCasilla(colores[contadorColores]);
//			} else {
//				intentoCombinacion.anadirCasilla(colorDescartado);
//			}
//		}
//		
//		numeroPinchos = intentoCombinacion.contarColocados();
//		if(numeroPinchos != 0) {
//			salir = false;
//			combinacion.anadirCasillaPosicion(colores[contadorColores], aleatorioPosicion);
//			while(posicionesOcupadas[j] != -1 && j < dificultad.getCasillas()) {
//				j++;
//			}
//			posicionesOcupadas[j] = aleatorioPosicion;
//			contadorColores++;
//			contadorPosiciones++;
//		}
//		
//		//Si ya hemos metido el último color, mandamos la combinación con los colores colocados "combinacion"
//		if(j == (dificultad.getCasillas() - 1)) {
//			intentoCombinacion = combinacion;
//		}
//		
//	} //final else de elegir posición
}
