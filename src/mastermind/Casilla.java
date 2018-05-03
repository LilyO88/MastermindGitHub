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

	public Casilla seleccionarColorCasilla(Dificultad dificultad, int aleatorioColor) {
		Casilla casilla = null;
		
		if(dificultad != Dificultad.DIFICIL) {
			switch (aleatorioColor) {
			case 0:
				casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
				break;
			case 1:
				casilla = new Casilla(Color.FONDO_VERDECLARO);
				break;
			case 2:
				casilla = new Casilla(Color.FONDO_VERDE);
				break;
			case 3:
				casilla = new Casilla(Color.FONDO_CELESTECLARO);
				break;
			case 4:
				casilla = new Casilla(Color.FONDO_AZULCLARO);
				break;
			case 5:
				casilla = new Casilla(Color.FONDO_ROJOCLARO);
				break;
			case 6:
				casilla = new Casilla(Color.FONDO_MORADOCLARO);
				break;
			case 7:
				casilla = new Casilla(Color.FONDO_MORADO);
				break;
			}
		} else {
			switch (aleatorioColor) {
			case 0:
				casilla = new Casilla(Color.FONDO_AMARILLOCLARO);
				break;
			case 1:
				casilla = new Casilla(Color.FONDO_AMARILLO);
				break;
			case 2:
				casilla = new Casilla(Color.FONDO_VERDECLARO);
				break;
			case 3:
				casilla = new Casilla(Color.FONDO_VERDE);
				break;
			case 4:
				casilla = new Casilla(Color.FONDO_CELESTECLARO);
				break;
			case 5:
				casilla = new Casilla(Color.FONDO_AZULCLARO);
				break;
			case 6:
				casilla = new Casilla(Color.FONDO_ROJOCLARO);
				break;
			case 7:
				casilla = new Casilla(Color.FONDO_MORADOCLARO);
				break;
			case 8:
				casilla = new Casilla(Color.FONDO_MORADO);
				break;
			case 9:
				casilla = new Casilla(Color.FONDO_GRISOSCURO);
				break;
			}	
		}
		return casilla;
	}
	
	public String dibujar() {
		return (color + "    " + Color.RESET);
	}

	public String dibujarResultado() {
		return (color + "  " + Color.RESET);
	}
	
}
