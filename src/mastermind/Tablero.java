package mastermind;

import java.util.ArrayList;

public class Tablero implements TableroDibujable {

	private ArrayList <Jugada> tablero; //LinkedList???
	private Combinacion combinacionSecreta;
	
	public Tablero(Combinacion combinacionSecreta) {
		setCombinacionSecreta(combinacionSecreta);
		//SI modo dificil hacer un hashMap
	}
	
	public ArrayList<Jugada> getTablero() {
		return tablero;
	}
	
	public Combinacion getCombinacionSecreta() {
		return combinacionSecreta;
	}
	
	public void setTablero(ArrayList<Jugada> tablero) {
		this.tablero = tablero;
	}
	
	public void setCombinacionSecreta(Combinacion combinacionSecreta) {
		this.combinacionSecreta = combinacionSecreta;
	}
	
	public ArrayList<Jugada> anadirJugada(Jugada jugada) {
		tablero.add(jugada);
		return tablero;
	}

	@Override
	public void dibujarTablero() {
		
		
	}

	@Override
	public void dibujarTableros(Tablero tablero1, Tablero tablero2) {
	}
	
}
