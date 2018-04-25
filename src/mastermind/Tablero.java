package mastermind;

import java.util.LinkedList;

import utilidades.Color;

public class Tablero implements TableroDibujable {

	private LinkedList <Jugada> tablero;
	private Combinacion combinacionSecreta;
	private Dificultad dificultad;
	
	public Tablero(Combinacion combinacionSecreta, Dificultad dificultad) {
		this.combinacionSecreta = combinacionSecreta;
		this.dificultad = dificultad;
	}
	
	public LinkedList<Jugada> getTablero() {
		return tablero;
	}
	
	public Combinacion getCombinacionSecreta() {
		return combinacionSecreta;
	}

	public LinkedList<Jugada> anadirJugada(Jugada jugada) {
		tablero.add(jugada);
		
		return tablero;
	}
	
	private String dibujarTablerosPrimeraFila(Tablero tablero2, int intento) {
		String cadena = "";
		Jugada jugada = null, jugada2 = null;

		jugada = tablero.getLast();
		jugada2 = tablero2.getTablero().getLast();
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) 
			cadena = dibujarPrimeraFilaInicio(intento) + jugada.dibujarPrimeraFilaJugada(dificultad);
		else 
			cadena = dibujarPrimeraFilaInicio(intento) + jugada.dibujarPrimeraFilaJugada(dificultad) 
					+ dibujarPrimeraFilaIntermedio(intento) + jugada2.dibujarPrimeraFilaJugada(dificultad);
		
		return cadena;
	}
	
	private String dibujarTablerosSegundaFila(Tablero tablero2) {
		String cadena = "";
		Jugada jugada = null, jugada2 = null;

		jugada = tablero.getLast();
		jugada2 = tablero2.getTablero().getLast();
		
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) 
			cadena = dibujarSegundaFilaInicio() + jugada.dibujarSegundaFilaJugada(dificultad);
		else 
			cadena = dibujarSegundaFilaInicio() + jugada.dibujarSegundaFilaJugada(dificultad) + dibujarSegundaFilaIntermedio() 
					+ jugada2.dibujarSegundaFilaJugada(dificultad);
		
		return cadena;
	}
	
	private String dibujarPrimeraFilaInicio(int intento) {		
		final String ESPACIO = " ", DOSESPACIOS = "  ";
		String cadena = "";
		
		/*
		 * 1. Construir la cadena que va situada antes de la combinación, según la dificultad la cadena variará, todo en la primera fila
		 * 	1.1. La dificultad es fácil. Se muestran en pantalla dos espacios (si el intento es menor que 10), y un espacio (si es igual o mayor que diez el intento),
		 * 	 el número de intento junto con un punto al final del mismo, y otros dos espacios detrás
		 * 	1.2. La dificultad es media o difícil. Se muestra en pantalla un único espacio
		 */
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
			if (intento < 10) 
				cadena = Color.FONDO_ROJO + DOSESPACIOS + intento + "." + DOSESPACIOS + Color.RESET ;
			else 
				cadena = Color.FONDO_ROJO + DOSESPACIOS + intento + "." + ESPACIO + Color.RESET;
		} else {
			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET;
		}	
		return cadena;
	} //final dibujarPrimeraFilaInicio
	
	private String dibujarPrimeraFilaIntermedio(int intento) {
		final String ESPACIO = " ";
		String intermedio = "";
		
		/*
		 * 1. Construir una cadena que se sitúa entre las dos jugadas
		 * 2. El intento máximo son 999999999, es decir, que la máximo de ocupación sería un espacio, nueve cifras, un punto y un espacio,
		 * 	 que suman 12 caracteres. Para los intentos que tengan menos cifras, por cada cifra menos, esta se sustituirá por un espacio en su lugar
		 */
		
		if (intento < 10) {
			intermedio = ESPACIO + intento + ".         ";
		} else if (intento >= 10 && intento < 100) {
			intermedio = ESPACIO + intento + ".        ";
		} else if (intento >= 100 && intento < 1000) {
			intermedio = ESPACIO + intento + ".       ";
		} else if (intento >= 1000 && intento < 10000) {
			intermedio = ESPACIO + intento + ".      ";
		} else if (intento >= 10000 && intento < 100000) {
			intermedio = ESPACIO + intento + ".     ";
		} else if (intento >= 100000 && intento < 1000000) {
			intermedio = ESPACIO + intento + ".    ";
		} else if (intento >= 1000000 && intento < 10000000) {
			intermedio = ESPACIO + intento + ".   ";
		} else if (intento >= 10000000 && intento < 100000000) {
			intermedio = ESPACIO + intento + ".  ";
		} else if (intento >= 100000000 && intento < 1000000000) {
			intermedio = ESPACIO + intento + ". ";
		}
		return intermedio;
	} //final dibujarPrimeraFilaIntermedio
	
	private String dibujarSegundaFilaInicio() {		
		final String ESPACIO = " ", SEISESPACIOS = "      ";
		String cadena = "";
		
		/*
		 * 1. Se construye una cadena de espacios que va antes de la combinación, dependerá su número de la dificultad de la partida, en la segunda fila
		 * 2. En el caso de ser dificultad fácil, es un total de seis espacios
		 * 3. En el caso de ser dificultad media o difícil, únicamente será un espacio
		 */
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR)
			cadena = Color.FONDO_ROJO + SEISESPACIOS + Color.RESET ;
		else
			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET;

		return cadena;
	} //final dibujarSegundaFilaInicio
	
	private String dibujarSegundaFilaIntermedio() {
		final String DOCEESPACIOS = "            ";
		
		/*
		 * 1. Construir una cadena que se sitúa entre las dos jugadas
		 * 2. El intento máximo son 999999999, es decir, que la máximo de ocupación sería un espacio, nueve cifras, un punto y un espacio,
		 * 	 que suman 12 caracteres. Se colocarán 12 espacios en blanco
		 */

		return Color.FONDO_ROJO + DOCEESPACIOS + Color.RESET;
	} //final dibujarSegundaFilaIntermedio
	
	public void dibujarTableros(Tablero tablero2, int intento) {
		final String ESPACIO = " ";
		String espaciosVacios = "";
		int i, largo = 0;
		
		if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
			largo = dibujarTablerosPrimeraFila(null, intento).length() + dibujarTablerosSegundaFila(null).length();
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}
			
			if(intento == 1) {
				System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET);
			} else {
				System.out.println(dibujarTablerosPrimeraFila(null, intento) + "\n" + dibujarTablerosSegundaFila(null)
									+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
			}
		} else {
			largo = dibujarTablerosPrimeraFila(tablero2, intento).length() + dibujarPrimeraFilaIntermedio(intento).length() 
					+ tablero2.dibujarTablerosPrimeraFila(tablero2, intento).length();
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}
			
			if(intento == 1) {
				System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET);
			} else {
				System.out.println(dibujarTablerosPrimeraFila(null, intento) + dibujarPrimeraFilaIntermedio(intento) 
									+ tablero2.dibujarTablerosPrimeraFila(tablero2, intento) + "\n" + dibujarTablerosSegundaFila(tablero2)
									+ dibujarSegundaFilaIntermedio() + tablero2.dibujarTablerosSegundaFila(tablero2));
			}
		}
			
	}

	public void dibujarCombinacionSecreta(Tablero tablero2) {		
		final String ESPACIO = " ";
		String espaciosVacios = "";
		int i, largo = 0;
		Jugada jugada = new Jugada(combinacionSecreta), jugada2 = new Jugada(tablero2.getCombinacionSecreta());

		/*
		 * 1. Dibujar la combinación secreta del tablero
		 * 2. Dependiendo de la dificultad, mostrar en pantalla la combinación secreta
		 * 	2.1. Fácil, se muestran los espacios del inicio, la combinación secreta y un espacio final, 2 filas
		 * 	2.2. Medio o Difícil, se muestra en pantalla los espacios del inicio, combinación secreta del jugador1, espacios variables,
		 * 		el espacio intermedio, combinación secreta del jugador2, y un pequeño espacio final, 2 filas
		 * 3. Se muestran también una fila entera vacía coloreado como el tablero antes y después de dibujar las jugadas o combinaciones
		 */
		
		if(dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR) {
			largo = dibujarTablerosSegundaFila(null).length();
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}
			
			System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET);
			System.out.println(dibujarSegundaFilaInicio() + jugada.dibujarPrimeraFilaJugada(dificultad) 
								+ "\n" + dibujarSegundaFilaInicio() + jugada.dibujarPrimeraFilaJugada(dificultad)
								+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
		} else {
			largo = dibujarTablerosSegundaFila(null).length() + dibujarSegundaFilaIntermedio().length() 
					+ dibujarTablerosSegundaFila(null).length();
			
			for(i = 0 ; i < largo ; i++) {
				espaciosVacios = espaciosVacios + ESPACIO;
			}
			
			System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET);
			System.out.println(dibujarSegundaFilaInicio() + jugada.dibujarPrimeraFilaJugada(dificultad) + dibujarSegundaFilaIntermedio()
							+ jugada2.dibujarPrimeraFilaJugada(dificultad) + "\n" + dibujarSegundaFilaInicio() 
							+ jugada.dibujarPrimeraFilaJugada(dificultad) + dibujarSegundaFilaIntermedio() 
							+ jugada2.dibujarPrimeraFilaJugada(dificultad) + "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
		}
	} //final dibujarCombinacionSecreta
}
