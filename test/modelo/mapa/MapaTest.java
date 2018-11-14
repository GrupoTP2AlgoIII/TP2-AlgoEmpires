package modelo.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.jugador.PosicionOcupadaError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Posicionable;

public class MapaTest {

	@Test
	public void test01comprobarTamanioDelMapaTest() {
		
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		
		int cantidadCasilleros = mapa.obtenerTamanioMapa();
		
		assertEquals (2500, cantidadCasilleros);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test02PosicionarPosicionableEnPosicionOcupadaErrorEnviandoPosicion () throws PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		Posicion posicionSuperpuesta = new Posicion (5, 5);
		mapa.posicionarPosicionableEnPosicion(new Posicionable (), posicionSuperpuesta);
		mapa.posicionarPosicionableEnPosicion(new Posicionable (), posicionSuperpuesta);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test03PosicionarPosicionableEnPosicionOcupadaErrorEnviandoFilaYColumna () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test04DesplazarHaciaLaDerechaEnPosicionOcupadaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 6);
		mapa.desplazarFilaColumnaHaciaLaDerecha(5, 5, 1);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test05DesplazarHaciaLaIzquierdaEnPosicionOcupadaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 4);
		mapa.desplazarFilaColumnaHaciaLaIzquierda(5, 5, 1);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test06DesplazarHaciaArribaEnPosicionOcupadaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 4, 5);
		mapa.desplazarFilaColumnaHaciaArriba(5, 5, 1);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test07DesplazarHaciaAbajoEnPosicionOcupadaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 6, 5);
		mapa.desplazarFilaColumnaHaciaAbajo(5, 5, 1);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test08DesplazarHaciaDiagonalSuperiorDerechaEnPosicionOcupadaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 4, 6);
		mapa.desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha(5, 5, 1);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test09DesplazarHaciaDiagonalSuperiorIzquierdaEnPosicionOcupadaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 4, 4);
		mapa.desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda(5, 5, 1);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test10DesplazarHaciaDiagonalInferiorDerechaEnPosicionOcupadaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 6, 6);
		mapa.desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha(5, 5, 1);
	}
	
	@Test (expected = PosicionOcupadaError.class)
	public void test11DesplazarHaciaDiagonalInferiorIzquierdaEnPosicionOcupadaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 5, 5);
		mapa.posicionarEnFilaColumna(new Posicionable (), 6, 4);
		mapa.desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda(5, 5, 1);
	}

	@Test (expected = PosicionFueraDelMapaError.class)
	public void test12DesplazarHaciaLaDerechaEnPosicionFueraDelMapaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 1, 50);
		mapa.desplazarFilaColumnaHaciaLaDerecha(1, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test13DesplazarHaciaLaIzquierdaEnPosicionFueraDelMapaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 1, 1);
		mapa.desplazarFilaColumnaHaciaLaIzquierda(1, 1, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test14DesplazarHaciaArribaEnPosicionFueraDelMapaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 1, 1);
		mapa.desplazarFilaColumnaHaciaArriba(1, 1, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test15DesplazarHaciaAbajoEnPosicionFueraDelMapaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 50, 1);
		mapa.desplazarFilaColumnaHaciaAbajo(50, 1, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test16DesplazarHaciaDiagonalSuperiorDerechaEnPosicionFueraDelMapaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 1, 50);
		mapa.desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha(1, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test17DesplazarHaciaDiagonalSuperiorIzquierdaEnPosicionFueraDelMapaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 1, 1);
		mapa.desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda(1, 1, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test18DesplazarHaciaDiagonalInferiorDerechaEnPosicionFueraDelMapaError () throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 50, 50);
		mapa.desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha(50, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test19DesplazarHaciaDiagonalInferiorIzquierdaEnPosicionFueraDelMapaError() throws PosicionOcupadaError, PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		mapa.posicionarEnFilaColumna(new Posicionable (), 1, 1);
		mapa.desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda(1, 1, 1);
	}
}
