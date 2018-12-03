package modelo.unidad;

import static org.junit.Assert.*;


import org.junit.Test;

import modelo.juego.Juego;
import modelo.jugador.PosicionDesocupadaError;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.arquero.Arquero;

public class MovimientosUnidadTest {

	@Test
	public void test01moverUnidadUnaPosicionHaciaLaDerecha()  {
		
		Unidad unidad = new Arquero(4,5);
		unidad.desplazarHasta (new Posicion (4,6));
		assertEquals (unidad.getPosicion().getFila(), 4);
		assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void test02moverUnidadUnaPosicionHaciaLaIzquierda()  {
		
		Unidad unidad = new Arquero(4,5);
		unidad.desplazarHasta (new Posicion (4,4));
		assertEquals (unidad.getPosicion().getFila(), 4);
		assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
	@Test
	public void test03moverUnidadUnaPosicionHaciaArriba() {
		
		Unidad unidad = new Arquero(4,5);
		unidad.desplazarHasta (new Posicion (3,5));
		assertEquals (unidad.getPosicion().getFila(), 3);
		assertEquals (unidad.getPosicion().getColumna(), 5);
	 
	}
	
	@Test
	public void test04moverArqueroUnaPosicionHaciaAbajo() {
		
	 Unidad unidad = new Arquero(4,5);
	 unidad.desplazarHasta (new Posicion (5,5));
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 5);
	 
	}
	
	@Test
	public void test05moverArqueroUnaPosicionHaciaDiagonalSuperiorDerecha()  {
		
	 Unidad unidad = new Arquero(4,5);
	 unidad.desplazarHasta (new Posicion (3,6));
	 assertEquals (unidad.getPosicion().getFila(), 3);
	 assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void test06moverArqueroUnaPosicionHaciaDiagonalSuperiorIzquierda() {
		
	 Unidad unidad = new Arquero(4,5);
	 unidad.desplazarHasta (new Posicion (3,4));
	 assertEquals (unidad.getPosicion().getFila(), 3);
	 assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
	@Test
	public void test07moverArqueroUnaPosicionHaciaDiagonalInferiorDerecha()  {
		
	 Unidad unidad = new Arquero(4,5);
	 unidad.desplazarHasta (new Posicion (5,6));
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 6);
	 
	}
	
	@Test
	public void test08moverArqueroUnaPosicionHaciaDiagonalInferiorIzquierda() {
		
	 Unidad unidad = new Arquero(4,5);
	 unidad.desplazarHasta (new Posicion (5,4));
	 assertEquals (unidad.getPosicion().getFila(), 5);
	 assertEquals (unidad.getPosicion().getColumna(), 4);
	 
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test10moverArqueroFueraDelLimiteDerechoDelMapa (){
		
		Mapa mapa = new Mapa ();
		Arquero arquero = new Arquero(2,50);
		mapa.posicionarEnFilaColumna (arquero, 2, 50);
		mapa.posicionarDesdeEnHasta (new Posicion (2, 50), new Posicion (2,56));
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test11moverAldeanoFueraDelLimiteSuperiorDelMapa ()  {
		
		Mapa mapa = new Mapa ();
		Arquero arquero = new Arquero(1,10);
		
		mapa.posicionarEnFilaColumna (arquero, 1, 10);
		mapa.posicionarDesdeEnHasta (new Posicion (1, 10), new Posicion (55,5));
	}
	
	@Test (expected = MovimientosPorTurnoExcedidosError.class)
	public void test17moverAldeanoDosVecesEnUnMismoTurno ()  {
		
		Juego juego = new Juego ("Pedro", "Maria");
		Arquero arquero = new Arquero(10,10);
		juego.agregarUnidadEnFilaColumna (arquero, 10, 10);
		juego.desplazarUnidadDesdeHasta (10, 10, 11, 10);
		juego.desplazarUnidadDesdeHasta (11, 10, 11, 11);
	}
	
	@Test (expected = PosicionDesocupadaError.class)
	public void test18MoverDesdeUnaPosicionVacia ()  {
		
		Juego juego = new Juego ("Pedro", "Maria");
		juego.desplazarUnidadDesdeHasta (11, 10, 11, 11);
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test19MoverAUnaPosicionOcupada() {
		
		Juego juego = new Juego ("Pedro", "Maria");
		Arquero arquero = new Arquero(10,10);
		Arquero otroArquero = new Arquero(11,10);
		juego.agregarUnidadEnFilaColumna (arquero, 10, 10);
		juego.agregarUnidadEnFilaColumna (otroArquero, 11, 10);
		juego.desplazarUnidadDesdeHasta (10, 10, 11, 10);
				
	}


}
