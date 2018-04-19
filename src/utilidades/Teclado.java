package utilidades;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

	public static void main(String[] args) {
		
//		System.out.print(leerCaracter());
//		teclado.close();
//		
//		System.out.print(leerCadena());
//		teclado.close();
//		
//		System.out.println(leerBoolean("elige", "a", "b"));
//		teclado.close();
//		
//		System.out.println(leerBooleanSN("si o no"));
//		teclado.close();
//		
//		System.out.println(leerByte());
//		teclado.close();
//		
//		System.out.println(leerShort());
//		teclado.close();
//		
//		System.out.println(leerInt());
//		teclado.close();
//		
//		System.out.println(leerLong());
//		teclado.close();
//		
//		System.out.println(leerFloat());
//		teclado.close();
//		
//		System.out.println(leerDouble());
//		teclado.close();
//	
//		byte a=2, b=10, c; 
//		c = leerRango(a, b, Rango.AMBOSINCLUIDOS);
//		System.out.println(c);
//		 
//		c = leerRango(a, b, Rango.AMBOSEXCLUIDOS);
//		System.out.println(c);
//
//		c = leerRango(a, b, Rango.MININCMAXEXC);
//		System.out.println(c);
//		
//		c = leerRango(a, b, Rango.MINEXCMAXINC);
//		System.out.println(c);
		
	}
	
	public static Scanner teclado = new Scanner(System.in);
	
	//Cerrar teclado
	public static void cerrarTeclado() {
		teclado.close();
	}
	
	//Lectura de un caracter
	public static char leerCaracter() {
			
			char caracter;
			String cadenaCaracter;
			
			do {
				cadenaCaracter = teclado.next();
				if (cadenaCaracter.length()>1) {
					System.out.println("El largo de la cadena debe contener 1 solo caracter\n");
				}
			} while (cadenaCaracter.length()>1);
			
			caracter = cadenaCaracter.charAt(0);
	//		teclado.nextLine();
			return caracter;
	} //cierre caracter
	public static char leerCaracter(String mensaje1) {
			
			char caracter;
			String cadenaCaracter;
			
			System.out.println(mensaje1);
			
			do {
				cadenaCaracter = teclado.next();
				if (cadenaCaracter.length()>1) {
					System.out.println("El largo de la cadena debe contener 1 solo caracter\n");
				}
			} while (cadenaCaracter.length()>1);
			
			caracter = cadenaCaracter.charAt(0);
	//		teclado.nextLine();
			return caracter;
	} //cierre caracter
	
	//Leer una cadena
	public static String leerCadena(String mensaje1) {
		
		String cadena;
		
		System.out.println(mensaje1);
		
		do {
			cadena = teclado.nextLine();
			if (cadena.length()==0) {
				System.out.println("Cadena vacía\n" + mensaje1);
			}
		} while (cadena.length()==0);
		return cadena;
	} //cierre cadena
	public static String leerCadena() {
		
		String cadena;
		
		do {
			cadena = teclado.nextLine();
			if (cadena.length()==0) {
				System.out.println("Cadena vacía. Introduzca un valor");
			}
		} while (cadena.length()==0);
		return cadena;
	} //cierre cadena
	
	//Lectura de un boolean
	public static boolean leerBoolean(String mensaje1, String mensaje2, String mensaje3) {
		
		boolean booleano;
		int respuesta = 0;
		
		do {	
		
			System.out.println(mensaje1);
			System.out.println("   1.-" + mensaje2);
			System.out.println("   2.-" + mensaje3);
			try {
				respuesta = teclado.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nIntroduzca su elección 1 ó 2:");
			} finally {
				teclado.nextLine();			
			}
			if (respuesta == 1) {
				booleano = true;
			} 
			else {
				booleano = false;
			} 
			
		} while (respuesta!=1 && respuesta!=2);
	
		return booleano;	
	} //cierre boolean

	//Lectura de si o no
	public static boolean leerBooleanSN(String mensaje1) {
		
		boolean booleano;
		char respuesta;
		
		
		do {
			System.out.println(mensaje1);
			respuesta = teclado.next().toLowerCase().charAt(0);
			if (respuesta=='s') {
				booleano = true;
			}
			else {
				booleano = false;
			}
		} while (respuesta!='s' && respuesta!='n');

		return booleano;
	}
	
	//Lectura byte
	public static byte leerByte() {
		
		byte numero=0;
		boolean error=false;

		do {
			error =  false;
			System.out.println("Introduzca un número:");
	
			try {
				numero = teclado.nextByte();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine(); //En petición de números siempre se limpia el buffer
			}
		} while (error);
		
		return numero;
	}
	public static byte leerByte(String mensaje1) {
		
		byte numero=0;
		boolean error=false;

		do {
			error =  false;
			System.out.println(mensaje1);
	
			try {
				numero = teclado.nextByte();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine(); //En petición de números siempre se limpia el buffer
			}
		} while (error);
		
		return numero;
	}
	
	//Lectura short
	public static short leerShort() {
		
		short numero=0;
		boolean error=false;

		do {
			error =  false;
			System.out.println("Introduzca un número:");
	
			try {
				numero = teclado.nextShort();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);

		return numero;
	}
	public static short leerShort(String mensaje1) {
		
		short numero=0;
		boolean error=false;

		do {
			error =  false;
			System.out.println(mensaje1);
	
			try {
				numero = teclado.nextShort();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);

		return numero;
	}
	
	//Lectura int	
	public static int leerInt() {
		
		int numero=0;
		boolean error=false;


		do {
			error =  false;	
			
			try {
				numero = teclado.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);
		
		return numero;
	}
	public static int leerInt(String mensaje1) {
		
		int numero=0;
		boolean error=false;


		do {
			error =  false;		
			System.out.println(mensaje1);
			
			try {
				numero = teclado.nextInt();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error);
		
		return numero;
	}
	
	//Lectura long
	public static long leerLong() {
		
		long numero=0;
		boolean error=false;
		

		do {
			error =  false;
			System.out.println("Introduzca un número:");
	
			try {
				numero = teclado.nextLong();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);

		return numero;
	}
	public static long leerLong(String mensaje1) {
		
		long numero=0;
		boolean error=false;
		

		do {
			error =  false;
			System.out.println(mensaje1);
	
			try {
				numero = teclado.nextLong();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Número no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);

		return numero;
	}
	
	//Lectura float	
	public static float leerFloat() {
		
		float numero=0;
		boolean error=false;
		
		do {
			error =  false;
	
			try {
				numero = teclado.nextFloat();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Caracter no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);

		return numero;
	}
	public static float leerFloat(String mensaje1) {
		
		float numero=0;
		boolean error=false;
		
		do {
			error =  false;
			System.out.println(mensaje1);
	
			try {
				numero = teclado.nextFloat();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Caracter no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);

		return numero;
	}
		
	//Lectura double
	public static double leerDouble() {
		
		double numero=0;
		boolean error=false;

		do {
			error =  false;
			System.out.println("Introduzca un número:");
	
			try {
				numero = teclado.nextDouble();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Caracter no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);
		
		return numero;
	}
	public static double leerDouble(String mensaje1) {
		
		double numero=0;
		boolean error=false;

		do {
			error =  false;
			System.out.println(mensaje1);
	
			try {
				numero = teclado.nextDouble();
				error = false;
			} catch (InputMismatchException e) {
				System.out.println("Error. Caracter no válido");
				error = true;
			} finally {
				teclado.nextLine();
			}
		} while (error==true);
		
		return numero;
	}

	//Enumeración comparaciones numéricas	
	public static enum Comparar {
		MAYORIGUAL, MENORIGUAL, MAYOR, MENOR;
	}
	
	//Leer comparación con sobrecarga	
	public static byte leerComparaNum(byte numero, Comparar comp) {
		
		boolean error=false;
		byte numeroUsuario;
		
		do {
			
			numeroUsuario = leerByte();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero + "\n");
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero + "\n");
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}	
	public static short leerComparaNum(short numero, Comparar comp) {
		
		boolean error=false;
		short numeroUsuario;
		
		do {
			
			numeroUsuario = leerShort();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero + "\n");
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero + "\n");
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static int leerComparaNum(int numero, Comparar comp) {
		
		boolean error=false;
		int numeroUsuario;
		
		do {
			
			numeroUsuario = leerInt("");
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero + "\n");
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero + "\n");
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static long leerComparaNum(long numero, Comparar comp) {
		
		boolean error=false;
		long numeroUsuario;
		
		do {
			
			numeroUsuario = leerLong();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero + "\n");
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero + "\n");
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static float leerComparaNum(float numero, Comparar comp) {
		
		boolean error=false;
		float numeroUsuario;
		
		do {
			
			numeroUsuario = leerFloat();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero + "\n");
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero + "\n");
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static double leerComparaNum(double numero, Comparar comp) {
		
		boolean error=false;
		double numeroUsuario;
		
		do {
			
			numeroUsuario = leerDouble();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero + "\n");
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero + "\n");
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero + "\n");
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static byte leerComparaNum(byte numero, Comparar comp, String mensaje1) {
		
		boolean error=false;
		byte numeroUsuario;
		
		System.out.println(mensaje1);
		
		do {
			
			numeroUsuario = leerByte();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero);
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero);
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static short leerComparaNum(short numero, Comparar comp, String mensaje1) {
		
		boolean error=false;
		short numeroUsuario;
		
		System.out.println(mensaje1);
		
		do {
			
			numeroUsuario = leerShort();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero);
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero);
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static int leerComparaNum(int numero, Comparar comp, String mensaje1) {
		
		boolean error=false;
		int numeroUsuario;
		
		System.out.println(mensaje1);
		
		do {
			
			numeroUsuario = leerInt();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero);
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero);
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static long leerComparaNum(long numero, Comparar comp, String mensaje1) {
		
		boolean error=false;
		long numeroUsuario;
		
		System.out.println(mensaje1);
		
		do {
			
			numeroUsuario = leerLong();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero);
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero);
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static float leerComparaNum(float numero, Comparar comp, String mensaje1) {
		
		boolean error=false;
		float numeroUsuario;
		
		System.out.println(mensaje1);
		
		do {
			
			numeroUsuario = leerFloat();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero);
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero);
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}
	public static double leerComparaNum(double numero, Comparar comp, String mensaje1) {
		
		boolean error=false;
		double numeroUsuario;
		
		System.out.println(mensaje1);
		
		do {
			
			numeroUsuario = leerDouble();
			
			switch (comp) {
			
			case MAYORIGUAL:
				if (numeroUsuario<numero) {
					System.out.println("Error. Introduce un número mayor o igual que " + numero);
					error = true; //si inicializara error en true, no haria falta repetir la linea aquí
				}	
				else {
					error = false;
				}
				break;
			
			case MENORIGUAL:
				if (numeroUsuario>numero) {
					System.out.println("Error. Introduce un número menor o igual que " + numero);
					error = true;
				}	
				else {
					error = false;
				}
			break;
			
			case MAYOR:
				if (numeroUsuario<=numero) {
					System.out.println("Error. Introduce un número mayor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			
			case MENOR:
				if (numeroUsuario>=numero) {
					System.out.println("Error. Introduce un número menor que " + numero);
					error = true; 
				}	
				else {
					error = false;
				}
			break;
			}
			
		} while (error);
		return numeroUsuario;
	}

	//Enumeración rangos
	public static enum Rango {
		AMBOSINCLUIDOS, AMBOSEXCLUIDOS, MININCMAXEXC, MINEXCMAXINC;
	}

	//Leer rango con sobrecarga	
	public static byte leerRango(byte minimo, byte maximo, Rango rang) {
			
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		byte numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerByte();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static short leerRango(short minimo, short maximo, Rango rang) {
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		short numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerShort();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static int leerRango(int minimo, int maximo, Rango rang) {
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		int numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerInt();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static long leerRango(long minimo, long maximo, Rango rang) {
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		long numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerLong();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static float leerRango(float minimo, float maximo, Rango rang) {
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		float numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerFloat();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static double leerRango(double minimo, double maximo, Rango rang) {
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		double numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerDouble();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static byte leerRango(byte minimo, byte maximo, Rango rang, String mensaje1) {
		
		System.out.println(mensaje1);
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		byte numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerByte();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static short leerRango(short minimo, short maximo, Rango rang, String mensaje1) {
		
		System.out.println(mensaje1);
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		short numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerShort();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static int leerRango(int minimo, int maximo, Rango rang, String mensaje1) {
		
		System.out.println(mensaje1);
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		int numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerInt();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static long leerRango(long minimo, long maximo, Rango rang, String mensaje1) {
		
		System.out.println(mensaje1);
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		long numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerLong();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static float leerRango(float minimo, float maximo, Rango rang, String mensaje1) {
		
		System.out.println(mensaje1);
		
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		float numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerFloat();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}
	public static double leerRango(double minimo, double maximo, Rango rang, String mensaje1) {
		
		System.out.println(mensaje1);
	
		if (minimo>maximo) {
			throw new IllegalArgumentException("Error. Máximo no puede ser menor que mínimo");
		}
			
		double numeroUsuario;
		boolean error=false;
		
		do {
			error = false;
			numeroUsuario = leerDouble();
			
			switch (rang) {
			
			case AMBOSINCLUIDOS:
				if (numeroUsuario < minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " incluidos");
					error = true;
				} 
				break;
			case AMBOSEXCLUIDOS:
				if (numeroUsuario <= minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " y " + maximo + " no incluidos");
					error = true;
				} 
				break;
			case MININCMAXEXC:
				if (numeroUsuario < minimo || numeroUsuario >= maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " incluido y " + maximo + " no incluido");
					error = true;
				} 
				break;
			case MINEXCMAXINC:
				if (numeroUsuario <= minimo || numeroUsuario > maximo) {
					System.out.println("Error. El número debe estar entre " + minimo + " no incluido y " + maximo + " incluido\n");
					error =  true;
				} 
				else {
				}
				break;
			}
		} while (error);
		return numeroUsuario;
	}

}
	