package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mastermind.Casilla;
import mastermind.Combinacion;
import mastermind.Dificultad;
import utilidades.Color;

@DisplayName("Test de Junit para probar el método de colocarPinchos de la clase Usuario") 
class TestCalcularResultado {

	final int TRESDIFICULTADES = 3;
	int i;
	
	Dificultad dificultadFacil = Dificultad.FACILADIVINAR;
	Dificultad dificultadMedio = Dificultad.MEDIO;
	Dificultad dificultadDificil = Dificultad.DIFICIL;
	
	
	
	@Test
	void combinacionesIgualesFacilTest() {
		Combinacion combinacionFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil = new Combinacion(dificultadFacil);
		
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		for (i = 0; i < combinacionGanaFacil.getCombinacion().length; i++) {
			combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		
		Assert.assertEquals(combinacionGanaFacil, combinacionFacil.calcularResultado(combinacionSecretaFacil));
	}
	@Test 
	void combinacionesIgualesMedioTest() {
		Combinacion combinacionMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionSecretaMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionGanaMedio = new Combinacion(dificultadMedio);
	
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		for (i = 0; i < combinacionGanaMedio.getCombinacion().length; i++) {
			combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		Assert.assertEquals(combinacionGanaMedio, combinacionMedio.calcularResultado(combinacionSecretaMedio));
	} 
	@Test 
	void combinacionesIgualesDificilTest() {
		Combinacion combinacionDificil = new Combinacion(dificultadDificil);
		Combinacion combinacionSecretaDificil = new Combinacion(dificultadDificil);
		Combinacion combinacionGanaDificil = new Combinacion(dificultadDificil);
		
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		
		for (i = 0; i < combinacionGanaDificil.getCombinacion().length; i++) {
			combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		
		Assert.assertEquals(combinacionGanaDificil, combinacionDificil.calcularResultado(combinacionSecretaDificil));		
	}	
	@Test 
	void combinacionesNoIgualesFacilTest() {
		Combinacion combinacionFacil2 = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil2 = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil2 = new Combinacion(dificultadFacil);
		
		combinacionFacil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionFacil2.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionFacil2.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaFacil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil2.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaFacil2.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaFacil2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		for (i = 0; i < combinacionGanaFacil2.getCombinacion().length; i++) {
			combinacionGanaFacil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		Assert.assertNotEquals(combinacionGanaFacil2, combinacionFacil2.calcularResultado(combinacionSecretaFacil2));
	}
	@Test 
	void combinacionesNoIgualesMedioTest() {
		Combinacion combinacionMedio2 = new Combinacion(dificultadMedio);
		Combinacion combinacionSecretaMedio2 = new Combinacion(dificultadMedio);
		Combinacion combinacionGanaMedio2 = new Combinacion(dificultadMedio);
		
		combinacionMedio2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionMedio2.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionMedio2.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionMedio2.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		combinacionSecretaMedio2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaMedio2.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaMedio2.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaMedio2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaMedio2.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		
		for (i = 0; i < combinacionGanaMedio2.getCombinacion().length; i++) {
			combinacionGanaMedio2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		Assert.assertNotEquals(combinacionGanaMedio2, combinacionMedio2.calcularResultado(combinacionSecretaMedio2));
	}	
	@Test
	void combinacionesNoIgualesDificilTest() {
		Combinacion combinacionDificil2 = new Combinacion(dificultadDificil);
		Combinacion combinacionSecretaDificil2 = new Combinacion(dificultadDificil);
		Combinacion combinacionGanaDificil2 = new Combinacion(dificultadDificil);
		
		combinacionDificil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionDificil2.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionDificil2.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionDificil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil2.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		combinacionDificil2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionDificil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaDificil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaDificil2.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaDificil2.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaDificil2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil2.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaDificil2.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		combinacionSecretaDificil2.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		for (i = 0; i < combinacionGanaDificil2.getCombinacion().length; i++) {
			combinacionGanaDificil2.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		Assert.assertNotEquals(combinacionGanaDificil2, combinacionDificil2.calcularResultado(combinacionSecretaDificil2));
	}

	@Test 
	void tamanioCombinacionesDistintas1Test(){
		Combinacion combinacionCorta = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaLarga = new Combinacion(dificultadFacil);
		Combinacion combinacionResultadoReal = new Combinacion(dificultadFacil);
		
		combinacionCorta.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionCorta.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionCorta.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		
		combinacionSecretaLarga.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaLarga.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaLarga.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaLarga.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		
		combinacionResultadoReal.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionResultadoReal.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionResultadoReal.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionResultadoReal.anadirCasilla(new Casilla(Color.FONDO_NEGRO));	
		
		Assert.assertEquals(combinacionResultadoReal, combinacionCorta.calcularResultado(combinacionSecretaLarga));
	}
	
	@Test
	void tamanioCombinacionesDistintas2Test(){
		Combinacion combinacionLarga = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaCorta = new Combinacion(dificultadFacil);
		
		combinacionLarga.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionLarga.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionLarga.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionLarga.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		combinacionSecretaCorta.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaCorta.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaCorta.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			combinacionLarga.calcularResultado(combinacionSecretaCorta);
		});
	}
	
	@Test 
	void tamanioCombinacionNoCorrespondeDificultadTest(){ 
		//Crear set para pasarle una combinacion que no sea del largo de la dificultad?????????????
	}

	@Test 
	void combinacionNulaTest(){ 
			
	}

	@Test 
	void elementoDeCombinacionNoEsCasillaTest(){ 
			
	}

	@Test 
	void colorEquivocadoDificultadFacilMedioTest(){ 
			
	}

	@Test 
	void coloresRepetidosFacilMedioTest(){ 
			
	}

	@Test 
	void noEsCombinacionTest(){ 
			
	}
}
