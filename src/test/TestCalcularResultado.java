package test;

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
	
	//combinacion == combinacionSecreta
	@Test
	@DisplayName("combinacion = combinacionSecreta, dificultad = fácil")
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
	@DisplayName("combinacion = combinacionSecreta, dificultad = medio")
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
	@DisplayName("combinacion = combinacionSecreta, dificultad = difícil")
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
	
	//combinacion != combinacionSecreta
	@Test 
	@DisplayName("combinacion != combinacionSecreta, dificultad = fácil")	
	void combinacionesNoIgualesFacilTest() {
		Combinacion combinacionFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil = new Combinacion(dificultadFacil);
		
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		for (i = 0; i < combinacionGanaFacil.getCombinacion().length; i++) {
			combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		Assert.assertNotEquals(combinacionGanaFacil, combinacionFacil.calcularResultado(combinacionSecretaFacil));
	}
	@Test 
	@DisplayName("combinacion != combinacionSecreta, dificultad = medio")
	void combinacionesNoIgualesMedioTest() {
		Combinacion combinacionMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionSecretaMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionGanaMedio = new Combinacion(dificultadMedio);
		
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		
		for (i = 0; i < combinacionGanaMedio.getCombinacion().length; i++) {
			combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		Assert.assertNotEquals(combinacionGanaMedio, combinacionMedio.calcularResultado(combinacionSecretaMedio));
	}	
	@Test
	@DisplayName("combinacion != combinacionSecreta, dificultad = difícil")
	void combinacionesNoIgualesDificilTest() {
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
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		for (i = 0; i < combinacionGanaDificil.getCombinacion().length; i++) {
			combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		}
		Assert.assertNotEquals(combinacionGanaDificil, combinacionDificil.calcularResultado(combinacionSecretaDificil));
	}
	
	//repetir colores en combinación
	@Test 
	@DisplayName("repetir colores en combinación, dificultad = fácil")
	void repetidosValidosFacilTest(){
		Combinacion combinacionFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil = new Combinacion(dificultadFacil);
		
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
	
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		
		Assert.assertEquals(combinacionGanaFacil, combinacionFacil.calcularResultado(combinacionSecretaFacil));
	}
	@Test 
	@DisplayName("repetir colores en combinación, dificultad = medio")
	void repetidosValidosMedioTest(){
		Combinacion combinacionMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionSecretaMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionGanaMedio = new Combinacion(dificultadMedio);
	
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		
		Assert.assertEquals(combinacionGanaMedio, combinacionMedio.calcularResultado(combinacionSecretaMedio));
	}
	@Test 
	@DisplayName("repetir colores en combinación, dificultad = difícil")
	void repetidosValidosDificilTest(){
		Combinacion combinacionDificil = new Combinacion(dificultadDificil);
		Combinacion combinacionSecretaDificil = new Combinacion(dificultadDificil);
		Combinacion combinacionGanaDificil = new Combinacion(dificultadDificil);
		
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		
		combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaDificil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		
		Assert.assertEquals(combinacionGanaDificil, combinacionDificil.calcularResultado(combinacionSecretaDificil));
	}
	
	//(combinacion.lenght > combinacionSecreta.lenght) || (combinacion.lenght < combinacionSecreta.lenght)	
	@Test 
	@DisplayName("combinacion.lenght < combinacionSecreta.lenght")
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
	@DisplayName("combinacion.lenght > combinacionSecreta.lenght")
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
	
	//combinacion.lenght ò combinacionSecreta.lenght no corresponden con la dificultad
	@Test 
	@DisplayName("combinacion.lenght ò combinacionSecreta.lenght no corresponden con la dificultad = fácil")
	void tamanioCombinacionNoCorrespondeDificultadFacilTest(){ 
		Combinacion combinacionFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil = new Combinacion(dificultadFacil);
		
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
	
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		
		Assert.assertNotEquals(combinacionGanaFacil, combinacionFacil.calcularResultado(combinacionSecretaFacil));
	}	
	@Test 
	@DisplayName("combinacion.lenght ò combinacionSecreta.lenght no corresponden con la dificultad = medio")
	void tamanioCombinacionNoCorrespondeDificultadMedioTest(){ 
		Combinacion combinacionMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionSecretaMedio = new Combinacion(dificultadMedio);
	
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
				
		Assertions.assertThrows(NullPointerException.class, () -> {
			combinacionMedio.calcularResultado(combinacionSecretaMedio);
		});
	}	
	@Test 
	@DisplayName("combinacion.lenght ò combinacionSecreta.lenght no corresponden con la dificultad = difícil")
	void tamanioCombinacionNoCorrespondeDificultadDificilTest(){ 
		Combinacion combinacionDificil = new Combinacion(dificultadDificil);
		Combinacion combinacionSecretaDificil = new Combinacion(dificultadDificil);
		
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaDificil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			combinacionDificil.calcularResultado(combinacionSecretaDificil);
		});
	}
	
	//combinacion == null || combinacionSecreta == null //??????????????
	@Test
	@DisplayName("combinacion == null || combinacionSecreta == null") 
	void combinacionNulaFacilTest(){ 
		Combinacion combinacionFacil = null;
		Combinacion combinacionSecretaFacil = null;
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			combinacionFacil.calcularResultado(combinacionSecretaFacil);
		});
	}	
	@Test
	@DisplayName("combinacion == null || combinacionSecreta == null") 
	void combinacionNulaMedioTest(){ 
		Combinacion combinacionMedio = null;
		Combinacion combinacionSecretaMedio = null;
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			combinacionMedio.calcularResultado(combinacionSecretaMedio);
		});
	}
	@Test
	@DisplayName("combinacion == null || combinacionSecreta == null") 
	void combinacionNulaDificilTest(){ 
		Combinacion combinacionDificil = null;
		Combinacion combinacionSecretaDificil = null;
		
		Assertions.assertThrows(NullPointerException.class, () -> {
			combinacionDificil.calcularResultado(combinacionSecretaDificil);
		});
	}
	//(combinacion[i] == null || !casilla)  || (combinacionSecreta[i] == null || !casilla)
	@Test 
	@DisplayName("combinacion[i] == null || (combinacionSecreta[i] == null")
	void elementoDeCombinacionNoEsCasilla1Test(){ 
		Combinacion combinacionFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil = new Combinacion(dificultadFacil);
		
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionFacil.anadirCasilla(null);
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
	
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		
		Assert.assertEquals(combinacionGanaFacil, combinacionFacil.calcularResultado(combinacionSecretaFacil));
	}	
	
	//introducir un color en cualquiera de las dos combinaciones que no corresponda a la dificultad
	@Test 
	@DisplayName("introducir un color en cualquiera de las dos combinaciones que no corresponda a la dificultad = fácil")
	void colorEquivocadoDificultadFacilTest(){ 
		Combinacion combinacionFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil = new Combinacion(dificultadFacil);
		
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
	
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		
		Assert.assertEquals(combinacionGanaFacil, combinacionFacil.calcularResultado(combinacionSecretaFacil));
	}
	@Test 
	@DisplayName("introducir un color en cualquiera de las dos combinaciones que no corresponda a la dificultad = medio")
	void colorEquivocadoDificultadMediolTest(){
		Combinacion combinacionMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionSecretaMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionGanaMedio = new Combinacion(dificultadMedio);
	
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_GRISOSCURO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));	
		
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		
		Assert.assertEquals(combinacionGanaMedio, combinacionMedio.calcularResultado(combinacionSecretaMedio));
	}
	
	//combinacionSecreta en modo fácil o medio tiene colores repetidos
	@Test 
	@DisplayName("combinacionSecreta en modo fácil tiene colores repetidos")
	void coloresRepetidosFacilTest(){ 
		Combinacion combinacionFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionSecretaFacil = new Combinacion(dificultadFacil);
		Combinacion combinacionGanaFacil = new Combinacion(dificultadFacil);
		
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaFacil.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
	
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaFacil.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		
		Assert.assertEquals(combinacionGanaFacil, combinacionFacil.calcularResultado(combinacionSecretaFacil));
	}	
	@Test 
	@DisplayName("combinacionSecreta en modo medio tiene colores repetidos")
	void coloresRepetidosMedioTest() { 
		Combinacion combinacionMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionSecretaMedio = new Combinacion(dificultadMedio);
		Combinacion combinacionGanaMedio = new Combinacion(dificultadMedio);

		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_VERDE));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));

		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AMARILLOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_MORADOCLARO));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));
		combinacionSecretaMedio.anadirCasilla(new Casilla(Color.FONDO_AZUL));

		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_ROJOCLARO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_BLANCO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_NEGRO));
		combinacionGanaMedio.anadirCasilla(new Casilla(Color.FONDO_NEGRO));

		Assert.assertNotEquals(combinacionGanaMedio, combinacionMedio.calcularResultado(combinacionSecretaMedio));
	}
}
