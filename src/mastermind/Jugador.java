package mastermind;

public abstract class Jugador {
	
	Tablero tablero;
	Dificultad dificultad;
	
	Jugador() {
		setTablero(tablero);
	}

	public abstract Combinacion crearCombinacion();
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
}
