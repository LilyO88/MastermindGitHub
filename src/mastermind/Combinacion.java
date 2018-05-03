package mastermind;

import utilidades.Color;

public class Combinacion implements Dibujable {
	
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
		Combinacion resultado = new Combinacion(dificultad);
		int i, j, contador = 0; //Contador es estático????????????????????
		
		//Coincide posición y color 
		for(i = 0 ; i < combinacionSecreta.getCombinacion().length ; i++) {
			if(combinacion[i].equals(combinacionSecreta.combinacion[i])) {
				resultado.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
				contador++;
			}
		}		
		//Coincide color
		for(i = 0 ; i < combinacionSecreta.getCombinacion().length ; i++) {
			for(j = 0 ; j < combinacionSecreta.getCombinacion().length ; j++) {
				if (combinacion[i].equals(combinacionSecreta.combinacion[j]) && i != j) {
					resultado.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
					contador++;
				}
			}
		}		
		//No está
		if(contador < combinacionSecreta.getCombinacion().length) {
			for(i = contador ; i < combinacion.length ; i++) {
				resultado.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
				contador++;
			}
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
