package modelo.unidad;

import static org.junit.Assert.*;


import org.junit.Test;

import modelo.juego.Juego;
import modelo.jugador.PosicionDesocupadaError;
import modelo.jugador.PosicionOcupadaError;
import modelo.mapa.Mapa;
import modelo.unidad.arquero.Arquero;
import modelo.edificio.TamanioIncorrectoError;

public class MovimientosUnidadTest {

	@Test
	public void test01moverUnidadUnaPosicionHaciaLaDerecha() throws MovimientosPorTurnoExcedidosError {
		
		Unidad unidad = new Arquero();
		unidad.posicionarEnFilaColumna (4, 5);
		unidad.desplazarHaciaLaDerecha(1);
		assertEquals (unidad.getPosicion().getFila(), 4);
		assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void test02moverUnidadUnaPosicionHaciaLaIzquierda() throws MovimientosPorTurnoExcedidosError {
		
		Unidad unidad = new Arquero();
		unidad.posicionarEnFilaColumna (4, 5);
		unidad.desplazarHaciaLaIzquierda(1);
		assertEquals (unidad.getPosicion().getFila(), 4);
		assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
	@Test
	public void test03moverUnidadUnaPosicionHaciaArriba() throws MovimientosPorTurnoExcedidosError {
		
		Unidad unidad = new Arquero();
		unidad.posicionarEnFilaColumna (4, 5);
		unidad.desplazarHaciaArriba(1);
		assertEquals (unidad.getPosicion().getFila(), 3);
		assertEquals (unidad.getPosicion().getColumna(), 5);
	 
	}
	
	@Test
	public void test04moverAldeanoUnaPosicionHaciaAbajo() throws MovimientosPorTurnoExcedidosError {
		
	 Unidad unidad = new Arquero();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaAbajo(1);
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 5);
	 
	}
	
	@Test
	public void test05moverAldeanoUnaPosicionHaciaDiagonalSuperiorDerecha() throws MovimientosPorTurnoExcedidosError {
		
	 Unidad unidad = new Arquero();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaLaDiagonalSuperiorDerecha(1);
	 assertEquals (unidad.getPosicion().getFila(), 3);
	 assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void test06moverAldeanoUnaPosicionHaciaDiagonalSuperiorIzquierda() throws MovimientosPorTurnoExcedidosError {
		
	 Unidad unidad = new Arquero();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaLaDiagonalSuperiorIzquierda(1);
	 assertEquals (unidad.getPosicion().getFila(), 3);
	 assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
	@Test
	public void test07moverAldeanoUnaPosicionHaciaDiagonalInferiorDerecha() throws MovimientosPorTurnoExcedidosError {
		
	 Unidad unidad = new Arquero();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaLaDiagonalInferiorDerecha(1);
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void test08moverAldeanoUnaPosicionHaciaDiagonalInferiorIzquierda() throws MovimientosPorTurnoExcedidosError {
		
	 Unidad unidad = new Arquero();
	 unidad.posicionarEnFilaColumna (4, 5);
	 unidad.desplazarHaciaLaDiagonalInferiorIzquierda(1);
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test09moverAldeanoFueraDelLimiteIzquierdoDelMapa () throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Unidad unidad = new Arquero();
		
		mapa.posicionarEnFilaColumna(unidad, 2, 1);
		mapa.desplazarFilaColumnaHaciaLaIzquierda (2, 1, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test10moverAldeanoFueraDelLimiteDerechoDelMapa () throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Unidad unidad = new Arquero();
		
		mapa.posicionarEnFilaColumna (unidad, 2, 50);
		mapa.desplazarFilaColumnaHaciaLaDerecha (2, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test11moverAldeanoFueraDelLimiteSuperiorDelMapa () throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Unidad unidad = new Arquero();
		
		mapa.posicionarEnFilaColumna (unidad, 1, 10);
		mapa.desplazarFilaColumnaHaciaArriba (1, 10, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test12moverAldeanoFueraDelLimiteInferiorDelMapa () throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Unidad unidad = new Arquero();
		
		mapa.posicionarEnFilaColumna (unidad, 50, 10);
		mapa.desplazarFilaColumnaHaciaAbajo (50, 10, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test13moverAldeanoFueraDelMapaConMovimientoDiagonalSuperiorDerecho () throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Unidad unidad = new Arquero();
		
		mapa.posicionarEnFilaColumna (unidad, 1, 50);
		mapa.desplazarFilaColumnaHaciaLaDiagonalSuperiorDerecha (1, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test14moverAldeanoFueraDelMapaConMovimientoDiagonalSuperiorIzquierdo () throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Unidad unidad = new Arquero();
		
		mapa.posicionarEnFilaColumna (unidad, 1, 1);
		mapa.desplazarFilaColumnaHaciaLaDiagonalSuperiorIzquierda (1, 1, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test15moverAldeanoFueraDelMapaConMovimientoDiagonalInferiorDerecho () throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Unidad unidad = new Arquero();
		
		mapa.posicionarEnFilaColumna (unidad, 50, 50);
		mapa.desplazarFilaColumnaHaciaLaDiagonalInferiorDerecha (50, 50, 1);
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test16moverAldeanoFueraDelMapaConMovimientoDiagonalInferiorIzquierdo () throws PosicionFueraDelMapaError, PosicionOcupadaError {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Unidad unidad = new Arquero();
		
		mapa.posicionarEnFilaColumna (unidad, 50, 1);
		mapa.desplazarFilaColumnaHaciaLaDiagonalInferiorIzquierda (50, 1, 1);
	}

	@Test (expected = MovimientosPorTurnoExcedidosError.class)
	public void test17moverAldeanoDosVecesEnUnMismoTurno () throws PosicionFueraDelMapaError, MovimientosPorTurnoExcedidosError, PosicionOcupadaError, PosicionDesocupadaError, TamanioIncorrectoError {
		
		Juego juego = new Juego ();
		Unidad unidad = new Arquero();
		juego.iniciarJuego ();
		juego.agregarUnidadEnFilaColumna (unidad, 10, 10);
		juego.desplazarFilaColumnaHaciaArriba (10, 10, 1);
		juego.desplazarFilaColumnaHaciaArriba (10, 10, 1);
}


}
