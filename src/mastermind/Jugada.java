package mastermind;

public class Jugada {
	
	Combinacion combinacion, resultado;
	
	Jugada(Combinacion combinacion) {
		this.combinacion = combinacion;
	}
	
	public Combinacion getResultado() {
		return resultado;
	}
	
	public void setResutado(Combinacion combinacion) {
		this.resultado = combinacion;
	}

	public Combinacion calcularResultado(Combinacion combinacionSecreta) {		
		resultado = combinacion.calcularResultado(combinacionSecreta);
		
		return resultado;
	}
}
