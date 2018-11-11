package modelo.unidad;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.mapa.Mapa;

public class MovimientosUnidadTest {

	@Test
	public void moverUnidadUnaPosicionHaciaLaDerecha() {
		
		Unidad unidad = new Unidad();
		unidad.posicionarEnFilaColumna (4, 5);
		unidad.desplazarHaciaLaDerecha(1);
		assertEquals (unidad.getPosicion().getFila(), 4);
		assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void moverUnidadUnaPosicionHaciaLaIzquierda() {
		
		Unidad unidad = new Unidad();
		unidad.posicionarEnFilaColumna (4, 5);
		unidad.desplazarHaciaLaIzquierda(1);
		assertEquals (unidad.getPosicion().getFila(), 4);
		assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
	@Test
	public void moverUnidadUnaPosicionHaciaArriba() {
		
		Unidad unidad = new Unidad();
		unidad.posicionarEnFilaColumna (4, 5);
		unidad.desplazarHaciaArriba(1);
		assertEquals (unidad.getPosicion().getFila(), 3);
		assertEquals (unidad.getPosicion().getColumna(), 5);
	 
	}
	
	@Test
	public void moverAldeanoUnaPosicionHaciaAbajo() {
		
	 Unidad unidad = new Unidad();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaAbajo(1);
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 5);
	 
	}
	
	@Test
	public void moverAldeanoUnaPosicionHaciaDiagonalSuperiorDerecha() {
		
	 Unidad unidad = new Unidad();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaLaDiagonalSuperiorDerecha(1);
	 assertEquals (unidad.getPosicion().getFila(), 3);
	 assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void moverAldeanoUnaPosicionHaciaDiagonalSuperiorIzquierda() {
		
	 Unidad unidad = new Unidad();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaLaDiagonalSuperiorIzquierda(1);
	 assertEquals (unidad.getPosicion().getFila(), 3);
	 assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
	@Test
	public void moverAldeanoUnaPosicionHaciaDiagonalInferiorDerecha() {
		
	 Unidad unidad = new Unidad();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaLaDiagonalInferiorDerecha(1);
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void moverAldeanoUnaPosicionHaciaDiagonalInferiorIzquierda() {
		
	 Unidad unidad = new Unidad();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaLaDiagonalInferiorIzquierda(1);
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
/*
	@Test (expected = PosicionFueraDelMapaError.class)
	public void moverAldeanoFueraDelLimiteIzquierdoDelMapa () throws PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		Unidad unidad = new Unidad ();
		
		mapa.posicionarEnFilaColumna(unidad, 2, 1);
		mapa.desplazarFilaColumnaHaciaLaIzquierda (2, 1, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void moverAldeanoFueraDelLimiteDerechoDelMapa () throws PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		Unidad unidad = new Unidad ();
		
		mapa.posicionarEnFilaColumna (unidad, 2, 50);
		mapa.desplazarFilaColumnaHaciaLaDerecha (2, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void moverAldeanoFueraDelLimiteSuperiorDelMapa () throws PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		Unidad unidad = new Unidad ();
		
		mapa.posicionarEnFilaColumna (unidad, 1, 10);
		mapa.desplazarFilaColumnaHaciaArriba (1, 10, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void moverAldeanoFueraDelLimiteInferiorDelMapa () throws PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		Unidad unidad = new Unidad ();
		
		mapa.posicionarEnFilaColumna (unidad, 50, 10);
		mapa.desplazarFilaColumnaHaciaAbajo (50, 10, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void moverAldeanoFueraDelMapaConMovimientoDiagonalSuperiorDerecho () throws PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		Unidad unidad = new Unidad ();
		
		mapa.posicionarEnFilaColumna (unidad, 1, 50);
		mapa.desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha (1, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void moverAldeanoFueraDelMapaConMovimientoDiagonalSuperiorIzquierdo () throws PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		Unidad unidad = new Unidad ();
		
		mapa.posicionarEnFilaColumna (unidad, 1, 1);
		mapa.desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda (1, 1, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void moverAldeanoFueraDelMapaConMovimientoDiagonalInferiorDerecho () throws PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		Unidad unidad = new Unidad ();
		
		mapa.posicionarEnFilaColumna (unidad, 50, 50);
		mapa.desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha (50, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void moverAldeanoFueraDelMapaConMovimientoDiagonalInferiorIzquierdo () throws PosicionFueraDelMapaError {
		
		Mapa mapa = new Mapa ();
		Unidad unidad = new Unidad ();
		
		mapa.posicionarEnFilaColumna (unidad, 50, 1);
		mapa.desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda (50, 1, 1);
	}
	
	@Test (expected = MovimientosPorTurnoExcedidosError.class)
	public void moverAldeanoDosVecesEnUnMismoTurno () {
		
		Juego juego = new Juego ();
		juego.iniciarTurno();
		Unidad unidad = new Unidad ();
		unidad.posicionarEnFilaColumna (10, 10);
		unidad.desplazarHaciaArriba (1);
		unidad.desplazarHaciaArriba (1);
	}
*/

}
