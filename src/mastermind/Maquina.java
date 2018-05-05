package mastermind;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Random;

import utilidades.Color;

public class Maquina extends Jugador {
	
	private LinkedHashMap<Integer, Casilla> coloresEncontrados = new LinkedHashMap<>(), coloresDescartados = new LinkedHashMap<>(),
			listaPosicionColorDescartado = new LinkedHashMap<>();
	private LinkedList<Casilla> listaColoresDefinitivos = new LinkedList<>();
//	private LinkedList<Integer> listaPosicionesDefinitivos = new LinkedList<>();
	private int encontrados = 0, descartados = 0, contadorColoresEncontrados = 0, intentosColocar = 0, contarColoresListaColoresDefinitivos = 0;
	
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
		Combinacion intentoCombinacion = new Combinacion(dificultad);
		Jugada jugadaIntento = new Jugada(intentoCombinacion);
		Casilla casilla = new Casilla(Color.FONDO_NEGRO), casillaDescartado = new Casilla(Color.FONDO_NEGRO);		
		Random rnd = new Random();
		int i = 0, j = 0, numeroPinchos = 0, aleatorioColor = -1, aleatorioPosicion = -1, aleatorioDescartado = 0;
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
		//				1.2.1.2.1. Comprobar el resultado de la jugada anterior
						numeroPinchos = tablero.getTablero().getLast().getResultado().contarColocados();
						if (numeroPinchos != 0) { //Si hay algún pincho, el color está en la combinación secreta y lo guardamos
							for (j = 0; j < numeroPinchos; j++) {
								coloresEncontrados.put(encontrados, tablero.getTablero().getLast().getCombinacion().getCasilla(0)); //introducir color en la lista de coloresEncontrados
								encontrados++;
							}
						} else { //Si no hay ningún pincho, el color no está en la combinación secreta y lo descartamos
							coloresDescartados.put(descartados, tablero.getTablero().getLast().getCombinacion().getCasilla(0)); //introducir color en la lista de coloresDescartados
							descartados++;
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
		// 			1.2.2.1. Si es la primera vez que intentamos colocar una casilla, creamos la combinación teniendo solo en cuenta un color que esté
								if(intentosColocar == 0) {
									casilla = coloresEncontrados.get(contadorColoresEncontrados);
									casillaDescartado = coloresDescartados.get(aleatorioDescartado);
									aleatorioPosicion = rnd.nextInt(dificultad.getCasillas());									
									for (i = 0 ; i < dificultad.getCasillas() ; i++) {
										if(i != aleatorioPosicion) {
											intentoCombinacion.anadirCasilla(casillaDescartado);
										} else {
											intentoCombinacion.anadirCasilla(casilla);
										}
									}
//									//Para poder buscar luego dentro de ella aunque aún no se haya encontrado ningún color
//									for (i = 0 ; i < dificultad.getCasillas() ; i++) {
//										listaColoresDefinitivos.add(new Casilla(Color.FONDO_NEGRO));
//									}
									
									intentosColocar++;
		// 			1.2.2.2. Si no es la primera vez que intentamos colocar una casilla, creamos la combinación teniendo en cuenta el resultado de la jugada anterior
								} else {
		//				1.2.2.2.1. Comprobar la combinación anterior para crear la siguiente
									numeroPinchos = tablero.getTablero().getLast().getResultado().contarColocados();
									if (numeroPinchos != 0) { //Si hay un pincho rojo, hemos encontrado la posición del color
										for(i = 0 ; i < dificultad.getCasillas() ; i++) { //Buscamos la posición que corresponde al color
											if(tablero.getTablero().getLast().getCombinacion().getCasilla(i)
													.equals(casilla.seleccionarColorCasilla(dificultad, contadorColoresEncontrados))) {
												//Introducimos en la lista el color y la posición que ocupa
												casilla = casilla.seleccionarColorCasilla(dificultad, contadorColoresEncontrados); //?????????????????????
												listaColoresDefinitivos.add(i, casilla);
											}
										}
										aleatorioDescartado = rnd.nextInt(coloresDescartados.size()); //Cambiamos el color de prueba por estética
										contadorColoresEncontrados++; //Cambiamos al siguiente color para buscar su posición
									} else { //Si no hay un pincho rojo 
										for(i = 0 ; i < dificultad.getCasillas() ; i++) { //Buscamos la posición que corresponde al color
											if(tablero.getTablero().getLast().getCombinacion().getCasilla(i)
													.equals(casilla.seleccionarColorCasilla(dificultad, contadorColoresEncontrados))) {
												//Introducimos el color y la posición en la lista para saber que no se encuentra en esta posición
												listaPosicionColorDescartado.put(i, casilla.seleccionarColorCasilla(dificultad, contadorColoresEncontrados));
											}
										}
									}
									
//									for(i = 0 ; i < listaColoresDefinitivos.size() ; i++) {
//										if(!listaColoresDefinitivos.get(i).equals(new Casilla(Color.NEGRO)))
//											contarColoresListaColoresDefinitivos++;
//									}
									
									
									if (listaColoresDefinitivos.size() < dificultad.getCasillas() || listaColoresDefinitivos.isEmpty()) {
			//				1.2.2.2.2. Crear combinación seleccionando una posición para uno de los colores encontrados, y rellenar el resto de posiciones 
			//						con un color descartado
										casilla = coloresEncontrados.get(contadorColoresEncontrados);
										casillaDescartado = coloresDescartados.get(aleatorioDescartado);
										if (!listaColoresDefinitivos.isEmpty()) {
											do {
												aleatorioPosicion = rnd.nextInt(dificultad.getCasillas());
											} while ((listaPosicionColorDescartado.get(aleatorioPosicion).equals(casilla))); //Si ese color ya ha ocupado esa posición
										} else {
											do {
												aleatorioPosicion = rnd.nextInt(dificultad.getCasillas());
											} while (!listaColoresDefinitivos.get(aleatorioPosicion).equals(null) //Si la posición está ocupada por otro color
													|| (listaPosicionColorDescartado.get(aleatorioPosicion)
															.equals(casilla))); //Si ese color ya ha ocupado esa posición
										}
										for (i = 0; i < dificultad.getCasillas(); i++) {
											if (i != aleatorioPosicion) {
												intentoCombinacion.anadirCasilla(casillaDescartado);
											} else {
												intentoCombinacion.anadirCasilla(casilla);
											}
										} 
									} else {
										for(i = 0 ; i < listaColoresDefinitivos.size() ; i++) {
											intentoCombinacion.anadirCasillaPosicion(listaColoresDefinitivos.get(i), i);
										}
									}
									intentosColocar++;
								} //fin no primer intento de buscar posición								
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
