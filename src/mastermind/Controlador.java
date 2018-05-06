package mastermind;

import static utilidades.Color.*;

import utilidades.Teclado;
import utilidades.Teclado.*;
/**
 * 
 * @author Lidia
 * @version 1.0
 * @since 1.0
 *
 */
public class Controlador {
	/**
	 * Construye un objeto que contiene un menú con el que controlar la partida
	 */
	Controlador() {
		Menu();
	}
	
	/**
	 * Modela una estructura que nos facilita controlar los menús internos
	 * @see mastermind.Partida#jugar()
	 */
	public void Menu() {	
		
		boolean salir = false, volverJugar;
		int menu1 = 0, menu2 = 0, menu3 = 0;
		Jugador jugador1 = null, jugador2 = null;
		Partida partida;
		
		//1. Presentación del juego
		System.out.println("    " + FONDO_ROJOCLARO + "  " + RESET + "   " + FONDO_VERDECLARO
				+ "  " + RESET + "   " + "MasterMind" + "   " + FONDO_AMARILLOCLARO + "  " + RESET
				+ "   " + FONDO_AZULCLARO + "  " + RESET + "\n");
	
		do {
			volverJugar = false;
		//2. Menú inicial, elige jugar, ver normas o salir del juego
			menu1 = Teclado.leerRango(1, 3, Rango.AMBOSINCLUIDOS, "1. Juego nuevo\n2. Normas\n3. Salir");
		//	2.1. Jugar
		//		2.1.2. Menú elección de dificultad
			switch (menu1) {
			case 1: 
				System.out.println("Elija la dificultad");
				menu2 = Teclado.leerRango(1, 3, Rango.AMBOSINCLUIDOS, "1. Fácil\n2. Medio\n3. Difícil");
		//			2.1.2.1. Menú de elección de modo fácil
				switch (menu2) {
				case 1: 
					System.out.println("Elegir modo fácil");
					menu3 = Teclado.leerRango(1, 2, Rango.AMBOSINCLUIDOS, "1. Adivinar combinación\n2. Crear combinación");
					switch (menu3) {
		//				2.1.2.1.1. Fácil, adivinar la combinación
					case 1: 
						partida = new Partida(Dificultad.FACILADIVINAR, jugador1, jugador2);
						partida.jugar();
						break;
		//				2.1.2.1.2. Fácil, crear la combinación
					case 2: 
						partida = new Partida(Dificultad.FACILCOMPROBAR, jugador1, jugador2);
						partida.jugar();
						break;
					} //switch menú3

					break;
				case 2: 	
					partida = new Partida(Dificultad.MEDIO, jugador1, jugador2);
					partida.jugar();
					break;
				case 3: 	
					partida = new Partida(Dificultad.DIFICIL, jugador1, jugador2);
					partida.jugar();
					break;
				} //switch menú2

				volverJugar = Teclado.leerBooleanSN("\n¿Quiere jugar una nueva partida? Sí o No");
				if(!volverJugar) {
					System.out.println("¡Hasta pronto!");
					salir = true;
				}
				break;
		//	2.2. Ver normas		
			case 2: 	
				
				//INTRODUCIR NORMAS

				volverJugar = Teclado.leerBooleanSN("\n¿Quiere jugar una nueva partida? Sí o No");
				if(!volverJugar) {
					System.out.println("¡Hasta pronto!");
					salir = true;
				}
				break;
			
		//	2.3. Salir del juego
			case 3: 
				volverJugar = Teclado.leerBooleanSN("\n¿Quiere jugar una nueva partida? Sí o No");
				if(!volverJugar) {
					System.out.println("¡Hasta pronto!");
					salir = true;
				}
				break;
			} //switch menú1		
		} while (!salir);
			
	} //final menu()
	
	
}
