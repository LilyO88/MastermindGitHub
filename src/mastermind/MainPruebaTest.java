package mastermind;

import utilidades.Color;

public class MainPruebaTest {

	public static void main(String[] args) {
		
		Dificultad dificultadFacil = Dificultad.FACILADIVINAR;
//		Dificultad dificultadMedio = Dificultad.MEDIO;
//		Dificultad dificultadDificil = Dificultad.DIFICIL;
		
		
//		Combinacion combinacionMedio = new Combinacion(dificultadMedio);
//		Combinacion combinacionDificil = new Combinacion(dificultadDificil);
//		
//		Combinacion combinacionSecretaMedio = new Combinacion(dificultadMedio);
//		Combinacion combinacionSecretaDificil = new Combinacion(dificultadDificil);
//		
//		
//		Combinacion combinacionGanaMedio = new Combinacion(dificultadMedio);
//		Combinacion combinacionGanaDificil = new Combinacion(dificultadDificil);
//		
//		Combinacion combinacionCorta = new Combinacion(dificultadFacil);
//		Combinacion combinacionLarga = new Combinacion(dificultadFacil);
//		Combinacion combinacionSecretaCorta = new Combinacion(dificultadFacil);
//		Combinacion combinacionSecretaLarga = new Combinacion(dificultadFacil);
//		
//		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
//		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
//		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
//		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
//		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
//		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
//		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
//		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
//		for (int i = 0; i < combinacionGanaMedio.getCombinacion().length; i++) {
//			combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
//		}
//		
//		System.out.println(combinacionMedio.dibujar() + "\n" + combinacionSecretaMedio.dibujar() + "\n" + combinacionGanaMedio.dibujar() + "\n" 
//		+ combinacionMedio.calcularResultado(combinacionSecretaMedio).dibujar());
//		

		Combinacion combinacionFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil = new Combinacion(dificultadFacil);
		
		
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		for (int i = 0; i < combinacionGanaFacil.getCombinacion().length; i++) {
			combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		combinacionFacil.calcularResultado(combinacionSecretaFacil).dibujar();

	}

}
