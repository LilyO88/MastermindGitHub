package mastermind;

import utilidades.Color;

public class Jugada implements JugadaDibujable {
	
	Combinacion combinacion, resultado;
	
	Jugada(Combinacion combinacion) {
		this.combinacion = combinacion;
		setResultado(resultado);
	}
	
	public Combinacion getResultado() {
		return resultado;
	}
	
	public Combinacion getCombinacion() {
		return combinacion;
	}
	
	public void setResultado(Combinacion combinacion) {
		this.resultado = combinacion;
	}

	public Combinacion calcularResultado(Combinacion combinacionSecreta) {		
		resultado = combinacion.calcularResultado(combinacionSecreta);
		
		return resultado;
	}
	
	public String dibujarPrimeraFilaJugada(Dificultad dificultad) {
		final String ESPACIO = " ";
		final int COMB_RESULT = 3, FINALRESULT = 2, OCUPARESULTADO = (3 * dificultad.getCasillas());
		int i, espacioVariable = COMB_RESULT + OCUPARESULTADO + FINALRESULT;
		String espaciosVacios = "";
		
		/*
		 * 1. Construir una cadena que va situada después del inicio y que colocará la jugada que se compone de una combinación y un resultado, en la primera fila
		 * 2. Calculamos el espacio variable que se corresponde a colocar tres espacios entre la combinación y el resultado, la combinación del resultado y dos espacios vacíos al final 
		 * 3. Colocamos la combinación 
		 * 4. Colocamos el espacio variable
		 */
		
		for (i = 0 ; i < espacioVariable ; i++) {
			espaciosVacios = espaciosVacios + ESPACIO;
		}
		
		return combinacion.dibujar() + Color.FONDO_ROJO + espaciosVacios + Color.RESET;
	} //final dibujarPrimeraFilaJugada

	public String dibujarSegundaFilaJugada(Dificultad dificultad) {
		final String DOSESPACIOS = "  ", TRESESPACIOS = "   ";
		
		/*
		 * 1. Construir una cadena que va situada después del inicio, y que incluye la jugada
		 * 2. Colocamos la combinación, tres espacios de separación con el resultado, el resultado y dos casillas vacías al final
		 */
			
		return combinacion.dibujar() + Color.FONDO_ROJO + TRESESPACIOS + Color.RESET + resultado.dibujarResultado() 
			+ Color.FONDO_ROJO + DOSESPACIOS + Color.RESET;
	} //final dibujarSegundaFilaJugada falta desarrollar

	public void dibujarJugada(Dificultad dificultad, int intento) {
		final String ESPACIO = " ";
		final int OCUPAINICIO = 6, OCUPACOMBINACION = (6 * dificultad.getCasillas()), COMB_RESULT = 3, 
				OCUPARESULTADO = (3 * dificultad.getCasillas()), FINALRESULT = 2;
		int i, espacioVariable = OCUPAINICIO + OCUPACOMBINACION + COMB_RESULT + OCUPARESULTADO + FINALRESULT;
		String espaciosVacios = "", espacioResultado = "";
		
		for (i = 0 ; i < espacioVariable ; i++) {
			espaciosVacios = espaciosVacios + ESPACIO;
		}
		for (i = 0 ; i < (OCUPARESULTADO + COMB_RESULT + FINALRESULT) ; i++) {
			espacioResultado = espacioResultado + ESPACIO;
		}
		
		System.out.println(Color.FONDO_ROJO + espaciosVacios + Color.RESET 
				+ "\n" + dibujarPrimeraFilaInicio(dificultad, intento) + combinacion.dibujar() 
						+ Color.FONDO_ROJO + espacioResultado + Color.RESET
				+ "\n" + dibujarSegundaFilaInicio(dificultad) + combinacion.dibujar() 
					+ Color.FONDO_ROJO + espacioResultado + Color.RESET
				+ "\n" + Color.FONDO_ROJO + espaciosVacios + Color.RESET);
	}
	
	private String dibujarPrimeraFilaInicio(Dificultad dificultad, int intento) {		
		final String ESPACIO = " ", DOSESPACIOS = "  ";
		String cadena = "";
		
		/*
		 * 1. Construir la cadena que va situada antes de la combinación, según la dificultad la cadena variará, todo en la primera fila
		 * 	1.1. La dificultad es fácil. Se muestran en pantalla dos espacios (si el intento es menor que 10), y un espacio (si es igual o mayor que diez el intento),
		 * 	 el número de intento junto con un punto al final del mismo, y otros dos espacios detrás
		 * 	1.2. La dificultad es media o difícil. Se muestra en pantalla un único espacio
		 */
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR || dificultad == Dificultad.MEDIO) {
			if (intento < 10) 
				cadena = Color.FONDO_ROJO + DOSESPACIOS + intento + "." + DOSESPACIOS + Color.RESET ;
			else 
				cadena = Color.FONDO_ROJO + DOSESPACIOS + intento + "." + ESPACIO + Color.RESET;
		} else {
			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET;
		}	
		return cadena;
	} //final dibujarPrimeraFilaInicio

	private String dibujarSegundaFilaInicio(Dificultad dificultad) {		
		final String ESPACIO = " ", SEISESPACIOS = "      ";
		String cadena = "";
		
		/*
		 * 1. Se construye una cadena de espacios que va antes de la combinación, dependerá su número de la dificultad de la partida, en la segunda fila
		 * 2. En el caso de ser dificultad fácil, es un total de seis espacios
		 * 3. En el caso de ser dificultad media o difícil, únicamente será un espacio
		 */
		
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR || dificultad == Dificultad.MEDIO)
			cadena = Color.FONDO_ROJO + SEISESPACIOS + Color.RESET ;
		else
			cadena = Color.FONDO_ROJO + ESPACIO + Color.RESET;

		return cadena;
	} //final dibujarSegundaFilaInicio
}
