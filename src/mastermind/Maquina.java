package mastermind;

import java.util.LinkedHashMap;
import java.util.Random;

import utilidades.Color;

public class Maquina extends Jugador {
	
//	private HashMap <Jugada, Boolean> intentos; //Mejor TreeMap para comprobar luego la mejor jugada //De Tablero o de máquina????
	
	Maquina(Dificultad dificultad) {
		this.dificultad = dificultad; //heredado del padre Jugador
		//SI modo dificil hacer un hashMap
//		if (dificultad == Dificultad.DIFICIL) {
//			intentos = new HashMap<>();
//		}
	}

	@Override
	public Combinacion crearCombinacion() {
		Combinacion combinacion = new Combinacion(dificultad);
		Casilla casilla = new Casilla(Color.FONDO_NEGRO);
		Random rnd = new Random();
		boolean repetido;
		int i, j, aleatorioColor;
		
		/*
		 * 1. Sacar color para la posicion x aleatorio, si la partida es nivel difícil hay 10 colores, en el resto de modos se jugarán con 8
		 * 2. Definir si se puede repetir color en el tipo de partida
		 * 3. No se pueden repetir colores. Comprobar si el color está repetido
		 * 	3.1. Si está repetido volver a pedir color
		 * 	3.2. Si no está repetido añadir a la combinacion
		 * 4. Se pueden repetir colores. Comprobar si el color está repetido. Añadir a la combinacion
		 */

		for(i = 0 ; i < dificultad.getCasillas() ; i++) {
			do {
				repetido = false;
		//1. Sacar color para la posicion x aleatorio, si la partida es nivel difícil hay 10 colores, en el resto de modos se jugarán con 8
				aleatorioColor = rnd.nextInt(dificultad.getColores());
				casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioColor);
		//2. Definir si se puede repetir color en el tipo de partida
		/*------------------------NO PUEDEN REPETIRSE LOS COLORES------------------------*/
				if (!dificultad.getRepetir()) {
					if(i==0) {
						combinacion.anadirCasilla(casilla);					
					} else {
		//3. No se pueden repetir colores. Comprobar si el color está repetido	
						for (j = 0 ; j < i && !repetido ; j++) { //falla cuando se repite
		//	3.1. Si está repetido volver a pedir color			
							if (casilla.equals(combinacion.getCasilla(j))) {
								repetido = true;
							} else if (!casilla.equals(combinacion.getCasilla(j)) && (j == (i - 1))) {
		//	3.2. Si no está repetido añadir a la combinacion
								combinacion.anadirCasilla(casilla);
							}
						}
					}
				} else {
		/*------------------------PUEDEN REPETIRSE LOS COLORES------------------------*/
		//4. Se pueden repetir colores. Comprobar si el color está repetido. Añadir a la combinacion
					combinacion.anadirCasilla(casilla);								
				}				
			} while(repetido);
		} //final del for
		
		return combinacion;
	}

	public Combinacion crearIntento(Tablero tablero, int intento) {
		Combinacion intentoCombinacion = new Combinacion(dificultad), combinacionDefinitiva = new Combinacion(dificultad);
		Jugada jugadaIntento = new Jugada(intentoCombinacion);
		Casilla casilla = new Casilla(Color.FONDO_NEGRO);
		LinkedHashMap<Integer, Casilla> coloresEncontrados = new LinkedHashMap<>(), coloresDescartados = new LinkedHashMap<>();
		LinkedHashMap<Integer, Integer> posicionesOcupadas = new LinkedHashMap<>();
		Random rnd = new Random();
		int i = 0, j = 0, numeroPinchos = 0, aleatorioColor = -1, aleatorioPosicion = -1, aleatorioDescartado = -1, contadorColoresEncontrados = 0,
				contadorPosicionesEncontradas = 0, encontrados = 0, descartados = 0, intentosColocar = 0;
		boolean repetida = false;		
		
		//1. Según el modo de juego la máquina crea una estrategia u otra
		//	1.1. Dificultad fácil y media
		if (dificultad == Dificultad.FACILADIVINAR || dificultad == Dificultad.FACILCOMPROBAR
				|| dificultad == Dificultad.MEDIO) {
		//		1.1.1. Si es el primer intento la combinación no se basa en un resultado y es aleatoria
			if (intento == 1) {
				crearCombinacion();
		// 		1.1.2. Creamos una combinación en base al resultado de la combinación anterior
			} else {

			}

		// 	1.2. Dificultad difícil
		} else {		
									/*----------------------------BUSCAR COLORES--------------------------*/
			
		//		1.2.1. Si colores contiene dentro menor cantidad de colores que larga es la combinación, buscamos los coloreS
		// 			1.2.1.1. Primer intento, crear una combinación de solo 1 color
				if(intento == 1) {
					aleatorioColor = rnd.nextInt(dificultad.getColores());
					casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioColor);
		// 				1.2.1.1.1. Rellenar el intento con ese color
					for (i = 0; i < dificultad.getCasillas(); i++) {
						intentoCombinacion.anadirCasilla(casilla);
					}
		// 			1.2.1.2. Si no es el primer intento, comprobar la combinación anterior creada para crear otra según el resultado
				} else {	//fin primer intento
					
					do {
						repetida = false;
						
						for (i = 0; i < tablero.getTablero().size() ; i++) {
		//				1.2.1.2.1. Comprobar el resultado de la jugada anterior
							numeroPinchos = tablero.getTablero().get(i).getResultado().contarColocados();
							if (numeroPinchos != 0) { //Si hay algún pincho, el color está en la combinación secreta y lo guardamos
								for (j = 0; j < numeroPinchos; j++) {
									coloresEncontrados.put(encontrados, tablero.getTablero().get(i).getCombinacion().getCasilla(0)); //introducir color en la lista de coloresEncontrados
									encontrados++;
								}
							} else { //Si no hay ningún pincho, el color no está en la combinación secreta y lo descartamos
								coloresDescartados.put(descartados, tablero.getTablero().get(i).getCombinacion().getCasilla(0)); //introducir color en la lista de coloresDescartados
								descartados++;
							} 
						}
						
						if (coloresEncontrados.size() < dificultad.getCasillas()) { //Busca colores
		// 				1.2.1.2.2. Elegir un color que no haya sido usado, que no esté ni en colores ni en descartados
							do {
								aleatorioColor = rnd.nextInt(dificultad.getColores());
								casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioColor);
							} while (coloresEncontrados.containsValue(casilla) || coloresDescartados.containsValue(casilla));
		// 				1.2.1.2.3. Rellenar el intento con ese color
							for (i = 0; i < dificultad.getCasillas(); i++) {
								intentoCombinacion.anadirCasilla(casilla);
							}
							jugadaIntento.calcularResultado(tablero.getCombinacionSecreta());
							if (tablero.getTablero().contains(jugadaIntento)) {
								repetida = true;
							} 
						} else { //Busca posiciones

							
							/*----------------------------BUSCAR POSICIONES--------------------------*/		

	//		1.2.2. Si colores contiene dentro igual o mayor cantidad de colores que larga es la combinación, buscamos las posiciones
							if (coloresEncontrados.size() >= dificultad.getCasillas()) {
								do {
									repetida = false;
	//			1.2.2.1. Si es el primer intento de colocar, creamos una combinación con una casilla de un color encontrado y el 
	//					resto de un color descartado
									if(intentosColocar == 0) {
										coloresEncontrados.get(contadorColoresEncontrados);
										aleatorioPosicion = rnd.nextInt(dificultad.getCasillas());
	// 				1.2.2.1.1. Asignar un color descartado a casilla, para que con un color que sabemos que esta en la combinación secreta ir 
	//						cambiando la posición hasta encontrar un pincho rojo y asignar la posición a ese color, ya que el color descartado
	//						no nos aparecen pinchos en el resultado
										aleatorioDescartado = rnd.nextInt(coloresDescartados.size());
										casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioDescartado);	
	//				1.2.2.1.2. Con la posición elegida aleatoriamente, probamos el color encontrado en esa posición, y el resto las rellenamos 
	//						de un color descartado
										for (i = 0; i < dificultad.getCasillas(); i++) {
											if (i != aleatorioPosicion) { //Color descartado
												intentoCombinacion.anadirCasilla(casilla);
											} else {
												intentoCombinacion.anadirCasilla(coloresEncontrados.get(contadorColoresEncontrados));
											}
										}
										intentosColocar++;
	//			1.2.2.2. El resto de intentos de colocar, comprobamos la anterior jugada, si hayamos un pincho rojo, asignamos el color   
	//					a la posición y pasamos a buscar la posición del siguiente color
									} else {
	//				1.2.2.2.1. Comprobamos la combinación anterior
										numeroPinchos = tablero.getTablero().getLast().calcularResultado(tablero.getCombinacionSecreta()).contarColocados();
										if(numeroPinchos != 0) {
											for(i = 0 ; i < dificultad.getCasillas() ; i++) {
												if(tablero.getTablero().getLast().getCombinacion().getCasilla(i).equals(coloresEncontrados.get(contadorColoresEncontrados))){
													combinacionDefinitiva.anadirCasillaPosicion(coloresEncontrados.get(contadorColoresEncontrados), i);
													posicionesOcupadas.put(contadorPosicionesEncontradas, i);
													contadorPosicionesEncontradas++;
												}
											}
											contadorColoresEncontrados++;
										} else {
	//				1.2.2.2.2. Comprobamos que posicionesOcupadas ocupe lo mismo que una combinación
	//					1.2.2.2.2.1. Si posicionesOcupadas mide lo mismo que una combinación, hemos encontrado la combinación secreta y la enviamos
											if(posicionesOcupadas.size() == dificultad.getCasillas()) {
												intentoCombinacion = combinacionDefinitiva;
											} else {
	//					1.2.2.2.2.2. Si posicionesOcupadas no mide lo mismo que una combinación, probamos otra posición con el color que corresponda
	// 						1.2.2.2.2.2.1. Elegir una posición que no haya sido usada, que no esté posicionesOcupadas
												do {
													aleatorioPosicion = rnd.nextInt(dificultad.getCasillas());
												} while (posicionesOcupadas.containsValue(aleatorioPosicion));
	// 						1.2.2.2.2.2.2. Asignar un color descartado a casilla, para que con un color que sabemos que esta en la combinación secreta  
	//							ir cambiando la posición hasta encontrar un pincho rojo y asignar la posición a ese color, ya que el color descartado
	//							no nos aparecen pinchos en el resultado
												aleatorioDescartado = rnd.nextInt(coloresDescartados.size());
												casilla = casilla.seleccionarColorCasilla(dificultad, aleatorioDescartado);
										
	//						1.2.2.2.2.2.3. Con la posición elegida aleatoriamente, probamos el color encontrado en esa posición, y el resto las  
	//							rellenamos de un color descartado
												for (i = 0; i < dificultad.getCasillas(); i++) {
													if (i != aleatorioPosicion) { // Color descartado
														intentoCombinacion.anadirCasilla(casilla);
													} else {
														intentoCombinacion.anadirCasilla(coloresEncontrados.get(contadorColoresEncontrados));
													}
												}
	//						1.2.2.2.2.2.4. Si la combinación está dentro del tablero generamos otra
												jugadaIntento.calcularResultado(tablero.getCombinacionSecreta());
												if(tablero.getTablero().contains(jugadaIntento)) {
													repetida = true;
												}									
												intentosColocar++;
											}
										}	
									}				
								} while(repetida);
							}
							
							

						}
					} while (repetida);						
				} //Fin intentos distintos de 1										
			//Fin búsqueda de colores
			
			//FUNCIONA HASTA AQUÍ
		}

		return intentoCombinacion;
	} //final crearIntento()
}
