package mastermind;

import utilidades.Color;

public class Casilla implements Dibujable {
	
	private String color;
	
	Casilla(String color){
		this.color = color;
	}
	
//	public String getColor() {
//		return color;
//	}

	public boolean equals(Object obj) {
		boolean resultado = false;
		
		if (obj instanceof Casilla && color.equals(((Casilla)obj).color))
			resultado = true;		
		return resultado;
	}

	public String dibujar() {
		return (color + "    " + Color.RESET);
	}

	public String dibujarResultado() {
		return (color + "  " + Color.RESET);
	}
	
}
