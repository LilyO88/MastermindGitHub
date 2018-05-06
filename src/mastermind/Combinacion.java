package mastermind;

import java.util.LinkedList;

import utilidades.Color;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Combinacion implements Dibujable {
	/**
	 * Almacena un conjunto de determinado tamaño de casillas que juntas forman una combinación
	 */
	private Casilla combinacion[];
	private Dificultad dificultad;
	private int posicion = 0;
	
	Combinacion(Dificultad dificultad) {
		combinacion = new Casilla[dificultad.getCasillas()];
		this.dificultad = dificultad;
	}

	public Casilla[] getCombinacion() {
		return combinacion;
	}
	
	public Casilla getCasilla(int indice) {
		return combinacion[indice];
	}
	
	public boolean equals(Object obj) {
	boolean resultado = false;
	
	if (obj instanceof Combinacion && combinacion.equals(((Combinacion)obj).combinacion) && dificultad==(((Combinacion)obj).dificultad));
			resultado = true;		
	return resultado;
	}
	
	public void anadirCasilla(Casilla casilla) {
		if(posicion < combinacion.length) {
			combinacion[posicion] = casilla;
			posicion++;
		}
	}
	
	public void anadirCasillaPosicion(Casilla casilla, int posicionCasilla) {
		combinacion[posicionCasilla] = casilla;
	}
	
	public Combinacion calcularResultado(Combinacion combinacionSecreta) {
		LinkedList<Casilla> combinacionOculta = new LinkedList<>(),
				combinacionIntento = new LinkedList<>();
		Combinacion resultado = new Combinacion(dificultad);
		int i, j;
		
		//Introducir las combinaciones en los mapas para poder trabajar con ellos
		for(i = 0 ; i < combinacion.length ; i++) {
			combinacionIntento.add(this.getCasilla(i));
		}
		for(i = 0 ; i < combinacionSecreta.getCombinacion().length ; i++) {
			combinacionOculta.add(combinacionSecreta.getCasilla(i));
		}
		
		//Coincide posición y color 
		for(i = 0 ; i < combinacionOculta.size() ; i++) {
			if(combinacionOculta.get(i).equals(combinacionIntento.get(i))) {
				resultado.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
				combinacionOculta.remove(i);
				combinacionIntento.remove(i);
				i--;
			}
		}	
		//Coincide color
		for(i = 0 ; i < combinacionOculta.size() ; i++) {
			for(j = 0 ; j < combinacionIntento.size() ; j++) {
				if(combinacionOculta.get(i).equals(combinacionIntento.get(j))) {
					resultado.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
					combinacionIntento.remove(j);
					j--;
				}
			}
		}	
		//No está
		for(i = 0 ; i < combinacionOculta.size() ; i++) {
			resultado.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		}	
		return resultado; //devolver resultado
	}
	
	public int contarColocados() {
		int colocado = 0, i;
		Casilla pinchoRojo = new Casilla(Color.FONDO_ROJOCLARO);
		
		for(i = 0 ; i < combinacion.length ; i++) {
			if(combinacion[i].equals(pinchoRojo)) {
				colocado++;
			}
		}
		
		return colocado;
	}
	
	public int contarNoColocados() {
		int noColocado = 0, i;
		Casilla pinchoBlanco = new Casilla(Color.FONDO_BLANCO);
		
		for(i = 0 ; i < combinacion.length ; i++) {
			if(combinacion[i].equals(pinchoBlanco)) {
				noColocado++;
			}
		}
		
		return noColocado;
	}
	
	public int contarPinchos(Tablero tablero) {
		int pinchos = 0;
		
		pinchos = calcularResultado(tablero.getCombinacionSecreta()).contarColocados() 
				+ calcularResultado(tablero.getCombinacionSecreta()).contarNoColocados();
		
		return pinchos;
	}
	
	public String dibujar() {		
		String cadena = "";
		
		for(int i = 0 ; i < combinacion.length ; i++) {
			cadena = cadena + (Color.FONDO_ROJO + "  " + Color.RESET) + combinacion[i].dibujar();
		}		
		return cadena;
	}
	
	public String dibujarResultado() {		
		String cadena = "";
		
		for(int i = 0 ; i < combinacion.length ; i++) {
			cadena = cadena + (Color.FONDO_ROJO + " " + Color.RESET) + combinacion[i].dibujarResultado();
		}		
		return cadena;
	}
	
}
