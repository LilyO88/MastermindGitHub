package mastermind;

import utilidades.Color;

public class Jugada implements JugadaDibujable {
	
	Combinacion combinacion, resultado;
	
	Jugada(Combinacion combinacion) {
		this.combinacion = combinacion;
	}
	
	public Combinacion getResultado() {
		return resultado;
	}
	
	public Combinacion getCombinacion() {
		return combinacion;
	}
	
	public void setResutado(Combinacion combinacion) {
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


}
