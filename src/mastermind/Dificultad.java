package mastermind;
public enum Dificultad {
	FACILADIVINAR(10, 4, 8, false), FACILCOMPROBAR(10, 4, 8, false), MEDIO(15, 5, 8, false), DIFICIL(-1, 8, 10, true);
	
	private int maximoIntentos, numeroCasillas, numeroColores;
	private boolean repetir;
	
	Dificultad(int maximoIntentos, int numeroCasillas, int numeroColores, boolean repetir) {
		this.maximoIntentos = maximoIntentos;
		this.numeroCasillas = numeroCasillas;
		this.numeroColores = numeroColores;
		this.repetir = repetir;
	}
	
	public int getIntentos() {
		return maximoIntentos;
	}
	
	public int getCasillas() {
		return numeroCasillas;
	}
	
	public int getColores() {
		return numeroColores;
	}
	
	public boolean getRepetir() {
		return repetir;
	}
}
