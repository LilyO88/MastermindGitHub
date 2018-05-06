package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test de Junit para probar el método de colocarPinchos de la clase Usuario") 
class TestCalcularResultado {

	Dificultad dificultadFacil = Dificultad.FACILADIVINAR;
	Dificultad dificultadMedio = Dificultad.MEDIO;
	Dificultad dificultadDificil = Dificultad.DIFICIL;
	
	Combinacion combinacionFacil = new Combinacion(dificultadFacil);
	Combinacion combinacionMedio = new Combinacion(dificultadMedio);
	Combinacion combinacionDificil = new Combinacion(dificultadDificil);
	Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
	Combinacion combinacionSecretaMedio = new Combinacion(dificultadMedio);
	Combinacion combinacionSecretaDificil = new Combinacion(dificultadDificil);
	
	@Test 
	void combinacionCorrectaTest(){ 
			
	}

	@Test 
	void combinacionTamanioMalTest(){ 
			
	}
	
	@Test 
	void tamanioCombinacionNoCorrespondeDificultad(){ 
			
	}

	@Test 
	void combinacionNula(){ 
			
	}

	@Test 
	void elementoDeCombinacionNoEsCasilla(){ 
			
	}

	@Test 
	void colorEquivocadoDificultadFacilMedio(){ 
			
	}

	@Test 
	void coloresRepetidosFacilMedio(){ 
			
	}

	@Test 
	void noEsCombinacion(){ 
			
	}
}
