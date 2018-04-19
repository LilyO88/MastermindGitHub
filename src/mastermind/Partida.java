package mastermind;

import utilidades.Color;

//import utilidades.Color;

public class Partida {

	private Dificultad dificultad;
	private Jugador jugador1, jugador2;
	
	//Constructor
	public Partida(Dificultad dificultad, Jugador jugador1, Jugador jugador2) {
		this.dificultad = dificultad;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	//Según el nivel de dificultad definir los atributos de la clase
	public void jugar() {
		Tablero tablero1, tablero2;
		Jugada jugada1, jugada2;
		Combinacion combinacion1, combinacion2;
//		Usuario jugador1 = new Usuario(dificultad);
//		Maquina jugadorMaquina1 = new Maquina(dificultad), jugador2 = new Maquina(dificultad);
		boolean salir = false;
//		Casilla pinchoRojo = new Casilla(Color.FONDO_ROJOCLARO), pinchoBlanco = new Casilla(Color.FONDO_BLANCO), 
//		pinchoVacio = new Casilla(Color.FONDO_NEGRO);
		int i, colocados1 = 0, colocados2 = 0, noColocados1 = 0, noColocados2 = 0;
		
		switch (dificultad) {
		case FACILADIVINAR:
			jugador1 = new Usuario(dificultad);
			jugador2 = new Maquina(dificultad);
			/*
			 * 1. La máquina crea una combinación secreta
			 * 2. Sistema pregunta siguiente jugada
			 * 	2.1. No acierta y queda aciertos, vuelve a preguntar 2. 
			 * 	2.2. Acierta la combinación y esta dentro del número de intentos
			 * 	2.3. No acierta y no quedan aciertos, partida acaba
			 */
			
			System.out.println("¡Ha elegido el modo fácil!\n\nDebe adivinar la combinación secreta");
			
		//1. La máquina crea una combinación secreta			
			tablero2 = new Tablero(((Maquina)jugador2).crearCombinacion());
			System.out.println("El Jugador 2 (Máquina) ha creado la combinación secreta, intente adivinarla");
		//2. Sistema pregunta siguiente jugada
			for(i = 0 ; i < dificultad.getIntentos() || salir ; i++) {
				System.out.println("Intento " + (i+1) + ":\n");
				//El usuario crea la combinación
				combinacion1 = ((Usuario)jugador1).crearCombinacion();
				//Creamos la jugada con la combinación propuesta
				jugada1 = new Jugada(combinacion1);
				//Calculamos el resultado de dicha combinación
				jugada1.calcularResultado(tablero2.getCombinacionSecreta());
				tablero2.anadirJugada(jugada1);
		//	2.1. No acierta y queda aciertos, vuelve a preguntar								
				//Dibujar la combinación de la jugada y los pinchos
				//Contamos los pinchos rojos para saber si el usuario ha ganado
				colocados1 = jugada1.getResultado().contarColocados();
		//	2.2. Acierta la combinación y esta dentro del número de intentos				
				if(colocados1 == combinacion1.getCombinacion().length && i < dificultad.getIntentos()) {
					//Dibujar la combinación secreta
					System.out.println(Color.VERDE + "¡Ha ganado Jugador 1 (Usuario)! ¡Ha acertado la combinación secreta!" + Color.RESET);
					salir = true;
				} else if (colocados1 != combinacion1.getCombinacion().length && i == (dificultad.getIntentos() - 1)) {
		//	2.3. No acierta y no quedan aciertos, partida acaba					
					//Dibujar la combinación secreta
					System.out.println(Color.ROJO + "¡¡¡Ooooh, Jugador 1 (Usuario) ha perdido!!! Ha agotado el número de intentos" + Color.RESET);
					salir = true;
				}				
			} //final del for del modo fácil adivinar

		case FACILCOMPROBAR:
			jugador1 = new Usuario(dificultad);
			jugador2 = new Maquina(dificultad);
			/*
			 * 1. El usuario crea una combinación
			 * 2. Sistema pregunta jugada
			 * 	2.1. No acierta y queda aciertos, vuelve a preguntar 2. 
			 * 	2.2. No acierta y no quedan aciertos, partida acaba
			 * 	2.3. Acierta la combinación y esta dentro del número de intentos
			 */
			
			System.out.println("¡Ha elegido el modo fácil!\n\nDebe crear una combinación secreta que la máquina intentará adivinar");
			
		//1. El usuario crea una combinación			
			tablero1 = new Tablero(((Usuario)jugador1).crearCombinacion());
			System.out.println("El Jugador 1 (Usuario) ha creado la combinación secreta, la máquina intentará adivinarla");
		//2. Sistema pregunta siguiente jugada
			for(i = 0 ; i < dificultad.getIntentos() || salir ; i++) {
				System.out.println("Intento " + (i+1) + ":\n");
				//La máquina crea la combinación
				combinacion2 = ((Maquina)jugador2).crearCombinacion();
				jugada2 = new Jugada(combinacion2);
				//La combinación crea un resultado, que es realizado por el usuario y comprobado por el sistema, de la combinación comparada con la secreta
				jugada2.setResutado(((Usuario)jugador1).colocarPinchos(combinacion2, tablero1.getCombinacionSecreta()));
				//Creamos la jugada con la combinación y el resultado de la combinación propuesta
				tablero1.anadirJugada(jugada2);
		//	2.1. No acierta y queda aciertos, vuelve a preguntar								
				//Dibujar la combinación de la jugada y los pinchos
				//Contamos los pinchos rojos para saber si el usuario ha ganado
				colocados2 = jugada2.getResultado().contarColocados();
		//	2.2. Acierta la combinación y esta dentro del número de intentos				
				if(colocados2 == combinacion2.getCombinacion().length && i < dificultad.getIntentos()) {
					//Dibujar la combinación secreta
					System.out.println(Color.VERDE + "¡Ha ganado Jugador 2 (Máquina)! ¡Ha acertado la combinación secreta!" + Color.RESET);
					salir = true;
				} else if (colocados2 != combinacion2.getCombinacion().length && i == (dificultad.getIntentos() - 1)) {
		//	2.3. No acierta y no quedan aciertos, partida acaba					
					//Dibujar la combinación secreta
					System.out.println(Color.ROJO + "¡¡¡Ooooh, Jugador 2 (Máquina) ha perdido!!! Ha agotado el número de intentos" + Color.RESET);
					salir = true;
				}				
			} //final del for del modo fácil comprobar
			break;
		case MEDIO:
			jugador1 = new Usuario(dificultad);
			jugador2 = new Maquina(dificultad);
			/*
			 * 1. El usuario y la máquina crean su combinación secreta cada uno
			 * 2. Usuario y máquina crean combinación para la jugada
			 * 3. Se cuentan los colores colocados en su sitio y los no colocados en su lugar
			 * 	3.1. Uno de los dos acierta la combinación secreta del otro, la partida acaba
			 * 	3.2. No acierta ninguno y no quedan intentos, se comprueban los pinchos rojos y blancos para comprobar el ganador0
			 * 		3.2.1. Jugador 1 tiene más pinchos rojos que Jugador 2, Jugador 1 gana la partida
			 * 		3.2.2. Jugador 2 tiene más pinchos rojos que Jugador 1, Jugador 2 gana la partida
			 * 		3.2.3. Si empatan a pinchos rojos, Jugador 1 tiene más pinchos blancos que Jugador 2, Jugador 1 gana la partida
			 * 		3.2.4. Si empatan a pinchos rojos, Jugador 2 tiene más pinchos blancos que Jugador 1, Jugador 2 gana la partida
			 * 		3.2.5. Si empatan a pinchos rojosy blancos, empatan la partida
			 * 	3.3. No acierta ninguno y quedan intentos, vuelve a preguntar 2.
			 */
			
		//1. El usuario y la máquina crean su combinación secreta cada uno
			tablero1 = new Tablero(((Usuario)jugador1).crearCombinacion());
			System.out.println("Jugador 1 ha creado su combinación secreta");
			tablero2 = new Tablero(((Maquina)jugador2).crearCombinacion());			
			System.out.println("Jugador 2 ha creado su combinación secreta");
			for(i = 0 ; i < dificultad.getIntentos() || salir ; i++) {
				System.out.println("Intento " + (i+1) + ":\n");
		//2. Usuario y máquina crean combinación para la jugada
				combinacion1 = ((Usuario)jugador1).crearCombinacion();
//				resultado1 = combinacion1.calcularResultado(tablero2.getCombinacionSecreta());				
				jugada1 = new Jugada(combinacion1);
				jugada1.calcularResultado(tablero2.getCombinacionSecreta());
				tablero2.anadirJugada(jugada1);
				
				combinacion2 = ((Maquina)jugador2).crearCombinacion();
				//Dibujar la combinación 2
				jugada2 = new Jugada(combinacion2);
				jugada2.setResutado(((Usuario)jugador1).colocarPinchos(combinacion2, tablero1.getCombinacionSecreta()));				
				tablero1.anadirJugada(jugada2);
		//3. Se cuentan los colores colocados en su sitio y los no colocados en su lugar
				colocados1 = jugada1.getResultado().contarColocados();
				colocados2 = jugada2.getResultado().contarColocados();
				noColocados1 = jugada1.getResultado().contarNoColocados();
				noColocados2 = jugada2.getResultado().contarNoColocados();
		//	3.1. Uno de los dos acierta la combinación secreta del otro, la partida acaba	
				if((colocados1 == dificultad.getCasillas() || colocados1 == dificultad.getCasillas()) && i < dificultad.getIntentos()) {
					if(colocados1 == dificultad.getCasillas()) {
						//Dibujar tablero2 y combinación secreta
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 1 (Usuario)! ¡Ha acertado la combinación secreta!" + Color.RESET);
						salir = true;
					} else {
						//Dibujar tablero1 y combinación secreta
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 2 (Máquina)! ¡Ha acertado la combinación secreta!" + Color.RESET);
						salir = true;
					}
		//	3.2. No acierta ninguno y no quedan intentos, se comprueban los pinchos rojos y blancos para comprobar el ganador0
				} else if ((colocados1 != dificultad.getCasillas() || colocados1 == dificultad.getCasillas()) && i == (dificultad.getIntentos() - 1)) {
		//		3.2.1. Jugador 1 tiene más pinchos rojos que Jugador 2, Jugador 1 gana la partida
					if (colocados1 > colocados2) { //Gana J1
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 1 (Usuario)! ¡Tiene " + colocados1 + " ficha/s de su color "
								+ "colocadas en su sitio y Jugador 2 (Máquina) tiene " + "!" + colocados2 + Color.RESET);
						salir = true;
		//		3.2.2. Jugador 2 tiene más pinchos rojos que Jugador 1, Jugador 2 gana la partida
					} else if (colocados1 < colocados2) { //Gana J2
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 2 (Máquina)! ¡Tiene " + colocados1 + " ficha/s de su color "
								+ "colocadas en su sitio y Jugador 1 (Usuario) tiene " + colocados2 + "!" + Color.RESET);
						salir = true;	
		//		3.2.3. Si empatan a pinchos rojos, Jugador 1 tiene más pinchos blancos que Jugador 2, Jugador 1 gana la partida
					} else if (colocados1 == colocados2 && noColocados1 > noColocados2) { //Gana J1
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 1 (Usuario)! ¡Ambos tienen "+ colocados1 + "ficha/s de su color "
								+ "colocadas en su sitio y Jugador 1 ha adivinado " + noColocados1 + " colores que no están en su sitio y Jugador 2"
										+ " (Máquina) tiene " + noColocados2 + " colores no colocados en su sitio"+ Color.RESET);
						salir = true;	
		//		3.2.4. Si empatan a pinchos rojos, Jugador 2 tiene más pinchos blancos que Jugador 1, Jugador 2 gana la partida
					} else if(colocados1 == colocados2 && noColocados1 < noColocados2) { //Gana J2
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 2 (Máquina)! ¡Ambos tienen "+ colocados1 + "ficha/s de su color "
								+ "colocadas en su sitio y, además, Jugador 2 ha adivinado " + noColocados1 + " colores que no están en su sitio y Jugador 1"
										+ "(Usuario) tiene " + noColocados2 + " colores no colocados en su sitio!"+ Color.RESET);
						salir = true;	
		//		3.2.5. Si empatan a pinchos rojosy blancos, empatan la partida
					} else if (colocados1 == colocados2 && noColocados1 == noColocados2) { //Empatan
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Han empatado! Ambos han adivinado los mismos colores y han colocados los mismos" + Color.RESET);
						salir = true;	
					} 				
		//	3.3. No acierta ninguno y quedan intentos, vuelve a preguntar 2.
				} else {
					//Dibujar tablero1 y tablero2
				}
			} //final del dor de intentos del modo medio
			break;
		case DIFICIL:
			jugador1 = new Maquina(dificultad);
			jugador2 = new Maquina(dificultad);
			/*
			 * 1. Las máquinas crean su combinación secreta cada una
			 * 2. Las máquinas crean combinación para la jugada
			 * 3. Se cuentan los colores colocados en su sitio y los no colocados en su lugar
			 * 	3.1. Uno de los dos acierta la combinación secreta del otro, la partida acaba
			 * 	3.2. No acierta ninguno y no quedan intentos, se comprueban los pinchos rojos y blancos para comprobar el ganador0
			 * 		3.2.1. Jugador 1 tiene más pinchos rojos que Jugador 2, Jugador 1 gana la partida
			 * 		3.2.2. Jugador 2 tiene más pinchos rojos que Jugador 1, Jugador 2 gana la partida
			 * 		3.2.3. Si empatan a pinchos rojos, Jugador 1 tiene más pinchos blancos que Jugador 2, Jugador 1 gana la partida
			 * 		3.2.4. Si empatan a pinchos rojos, Jugador 2 tiene más pinchos blancos que Jugador 1, Jugador 2 gana la partida
			 * 		3.2.5. Si empatan a pinchos rojosy blancos, empatan la partida
			 * 	3.3. No acierta ninguno y quedan intentos, vuelve a preguntar 2.
			 */
			
		//1. Las máquinas crean su combinación secreta cada una
			tablero1 = new Tablero(((Maquina)jugador1).crearCombinacion());
			tablero2 = new Tablero(((Maquina)jugador2).crearCombinacion());
			for(i = 0 ; i < dificultad.getIntentos() || salir ; i++) {
				System.out.println("Intento " + (i+1) + ":\n");
		//2. Las máquinas crean combinación para la jugada
				combinacion1 = ((Maquina)jugador1).crearCombinacion();
				jugada1 = new Jugada(combinacion1);
				jugada1.calcularResultado(tablero2.getCombinacionSecreta());
				tablero2.anadirJugada(jugada1);
				
				combinacion2 = ((Maquina)jugador2).crearCombinacion();
				jugada2 = new Jugada(combinacion2);
				jugada2.calcularResultado(tablero1.getCombinacionSecreta());
				tablero1.anadirJugada(jugada2);
		//3. Se cuentan los colores colocados en su sitio y los no colocados en su lugar
				colocados1 = jugada1.getResultado().contarColocados();
				colocados2 = jugada2.getResultado().contarColocados();
				noColocados1 = jugada1.getResultado().contarNoColocados();
				noColocados2 = jugada2.getResultado().contarNoColocados();
		//	3.1. Uno de los dos acierta la combinación secreta del otro, la partida acaba
				if((colocados1 == dificultad.getCasillas() || colocados1 == dificultad.getCasillas()) && i < dificultad.getIntentos()) {
					if(colocados1 == dificultad.getCasillas()) {
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 1! ¡Ha acertado la combinación secreta!" + Color.RESET);
						salir = true;
					} else {
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 2! ¡Ha acertado la combinación secreta!" + Color.RESET);
						salir = true;
					}
		//	3.2. No acierta ninguno y no quedan intentos, se comprueban los pinchos rojos y blancos para comprobar el ganador0
				} else if ((colocados1 != dificultad.getCasillas() || colocados1 == dificultad.getCasillas()) && i == (dificultad.getIntentos() - 1)) {
		//		3.2.1. Jugador 1 tiene más pinchos rojos que Jugador 2, Jugador 1 gana la partida
					if (colocados1 > colocados2) { //Gana J1
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 1! ¡Tiene " + colocados1 + " ficha/s de su color "
								+ "colocadas en su sitio y Jugador 2 tiene " + "!" + colocados2 + Color.RESET);
						salir = true;
		//		3.2.2. Jugador 2 tiene más pinchos rojos que Jugador 1, Jugador 2 gana la partida
					} else if (colocados1 < colocados2) { //Gana J2
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 2! ¡Tiene " + colocados1 + " ficha/s de su color "
								+ "colocadas en su sitio y Jugador 1 tiene " + colocados2 + "!" + Color.RESET);
						salir = true;	
		//		3.2.3. Si empatan a pinchos rojos, Jugador 1 tiene más pinchos blancos que Jugador 2, Jugador 1 gana la partida
					} else if (colocados1 == colocados2 && noColocados1 > noColocados2) { //Gana J1
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 1! ¡Ambos tienen "+ colocados1 + "ficha/s de su color "
								+ "colocadas en su sitio y Jugador 1 ha adivinado " + noColocados1 + " colores que no están en su sitio y Jugador 2"
										+ " tiene " + noColocados2 + " colores no colocados en su sitio"+ Color.RESET);
						salir = true;	
		//		3.2.4. Si empatan a pinchos rojos, Jugador 2 tiene más pinchos blancos que Jugador 1, Jugador 2 gana la partida
					} else if(colocados1 == colocados2 && noColocados1 < noColocados2) { //Gana J2
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Ha ganado Jugador 2! ¡Ambos tienen "+ colocados1 + "ficha/s de su color "
								+ "colocadas en su sitio y, además, Jugador 2 ha adivinado " + noColocados1 + " colores que no están en su sitio y Jugador 1"
										+ " tiene " + noColocados2 + " colores no colocados en su sitio!"+ Color.RESET);
						salir = true;	
		//		3.2.5. Si empatan a pinchos rojosy blancos, empatan la partida
					} else if (colocados1 == colocados2 && noColocados1 == noColocados2) { //Empatan
						//Dibujar tablero1 y tablero2
						System.out.println(Color.VERDE + "¡Han empatado! Ambos han adivinado los mismos colores y han colocados los mismos" + Color.RESET);
						salir = true;	
					} 				
		//	3.3. No acierta ninguno y quedan intentos, vuelve a preguntar 2.
				} else {
				//Dibujar tablero1 y tablero2
				}
			} //final del for de intentos del modo difícil
			break;
		}
	} //final de jugar
	
	//FALTA DIBUJAR LAS JUGADAS Y COMPROBAR EN crearCombinacion de usuario
}