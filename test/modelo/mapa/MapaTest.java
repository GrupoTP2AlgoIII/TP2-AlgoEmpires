package modelo.mapa;

import static org.junit.Assert.*;
import org.junit.Test;

import modelo.unidad.DesplazarAPosicionOcupadaError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Posicionable;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

public class MapaTest {

	@Test
	public void test01comprobarTamanioDelMapaTest() {
		
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		
		int cantidadCasilleros = mapa.obtenerTamanioMapa();
		
		assertEquals (2500, cantidadCasilleros);
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test02PosicionarPosicionableEnPosicionOcupadaErrorEnviandoPosicion () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicion posicionSuperpuesta = new Posicion (5, 5);
		Posicionable posicionable = new Arquero();
		mapa.posicionarPosicionableEnPosicion(posicionable, posicionSuperpuesta);
		mapa.posicionarPosicionableEnPosicion(posicionable, posicionSuperpuesta);
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test03PosicionarPosicionableEnPosicionOcupadaErrorEnviandoFilaYColumna ()  {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Espadachin posicionable = new Espadachin(5,5);
		mapa.posicionarEnFilaColumna(posicionable, 5, 5);
		mapa.posicionarEnFilaColumna(posicionable, 5, 5);
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test04DesplazarHaciaLaDerechaEnPosicionOcupadaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		mapa.posicionarEnFilaColumna(new Espadachin (5,5), 5, 5);
		mapa.posicionarEnFilaColumna(new Espadachin (5,6), 5, 6);
		mapa.posicionarDesdeEnHasta(new Posicion (5, 5), new Posicion (5,6));
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test05DesplazarHaciaLaIzquierdaEnPosicionOcupadaError (){
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		mapa.posicionarEnFilaColumna(new Espadachin(5,5), 5, 5);
		mapa.posicionarEnFilaColumna(new Espadachin(5,4), 5, 4);
		mapa.posicionarDesdeEnHasta(new Posicion (5, 5), new Posicion (5,4));
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test06DesplazarHaciaAbajoEnPosicionOcupadaError ()  {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		mapa.posicionarEnFilaColumna(new Arquero(5,5), 5, 5);
		mapa.posicionarEnFilaColumna(new Arquero(4,5), 4, 5);
		mapa.posicionarDesdeEnHasta(new Posicion (5, 5), new Posicion (4,5));

	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test07DesplazarHaciaArribaEnPosicionOcupadaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		mapa.posicionarEnFilaColumna(new Arquero (5,5), 5, 5);
		mapa.posicionarEnFilaColumna(new Espadachin (6,5), 6, 5);
		mapa.posicionarDesdeEnHasta(new Posicion (5, 5), new Posicion (6,5));
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test08DesplazarHaciaDiagonalInferiorDerechaEnPosicionOcupadaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		mapa.posicionarEnFilaColumna(new Arquero (5,5), 5, 5);
		mapa.posicionarEnFilaColumna(new Arquero (4,6), 4, 6);
		mapa.posicionarDesdeEnHasta(new Posicion (5, 5), new Posicion (4,6));
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test09DesplazarHaciaDiagonalInferiorIzquierdaEnPosicionOcupadaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		mapa.posicionarEnFilaColumna(new Arquero (5,5), 5, 5);
		mapa.posicionarEnFilaColumna(new Arquero (4,4), 4, 4);
		mapa.posicionarDesdeEnHasta(new Posicion (5, 5), new Posicion (4,4));
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test10DesplazarHaciaDiagonalSuperiorDerechaEnPosicionOcupadaError ()  {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		mapa.posicionarEnFilaColumna(new Arquero (5,5), 5, 5);
		mapa.posicionarEnFilaColumna(new Arquero (6,6), 6, 6);
		mapa.posicionarDesdeEnHasta(new Posicion (5, 5), new Posicion (6,6));
	}
	
	@Test (expected = DesplazarAPosicionOcupadaError.class)
	public void test11DesplazarDigonalSuperiorIzquierdaEnPosicionOcupadaError ()  {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		mapa.posicionarEnFilaColumna(new Arquero (5,5), 5, 5);
		mapa.posicionarEnFilaColumna(new Arquero (6,4), 6, 4);
		mapa.posicionarDesdeEnHasta(new Posicion (5, 5), new Posicion (6,4));
	}

	@Test (expected = PosicionFueraDelMapaError.class)
	public void test12DesplazarHaciaLaDerechaEnPosicionFueraDelMapaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicionable posicionable = new Arquero(1,50);
		mapa.posicionarEnFilaColumna(posicionable, 1, 50);
		mapa.posicionarDesdeEnHasta(new Posicion (1, 50), new Posicion (1,51));
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test13DesplazarHaciaLaIzquierdaEnPosicionFueraDelMapaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicionable posicionable = new Arquero(1,1);
		mapa.posicionarEnFilaColumna(posicionable, 1, 1);
		mapa.posicionarDesdeEnHasta(new Posicion (1, 1), new Posicion (1,0));
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test14DesplazarHaciaAbajoEnPosicionFueraDelMapaError (){
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicionable posicionable = new Arquero(50,1);
		mapa.posicionarEnFilaColumna(posicionable, 50, 1);
		mapa.posicionarDesdeEnHasta(new Posicion (1, 50), new Posicion (0,50));
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test15DesplazarHaciaArribaEnPosicionFueraDelMapaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicionable posicionable = new Arquero(50,1);
		mapa.posicionarEnFilaColumna(posicionable, 50, 1);
		mapa.posicionarDesdeEnHasta(new Posicion (50, 1), new Posicion (51,1));
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test16DesplazarHaciaLaDerechaEnPosicionFueraDelMapaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicionable posicionable = new Arquero(1,50);
		mapa.posicionarEnFilaColumna(posicionable, 1, 50);
		mapa.posicionarDesdeEnHasta(new Posicion (28, 50), new Posicion (28,51));
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test17DesplazarHaciaLaIzquierdaEnPosicionFueraDelMapaError (){
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicionable posicionable = new Arquero(1,1);
		mapa.posicionarEnFilaColumna(posicionable, 1, 1);
		mapa.posicionarDesdeEnHasta(new Posicion (1, 1), new Posicion (1,0));
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test18DesplazarEnPosicionFueraDelMapaError () {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicionable posicionable = new Arquero(50,50);
		mapa.posicionarEnFilaColumna(posicionable, 50, 50);
		mapa.posicionarDesdeEnHasta(new Posicion (50, 50), new Posicion (51,50));
	}
	
	@Test (expected = PosicionFueraDelMapaError.class)
	public void test19DesplazarHaciaDiagonalInferiorIzquierdaEnPosicionFueraDelMapaError()  {
		
		Mapa mapa = new Mapa ();
		mapa.iniciarMapaVacio();
		Posicionable posicionable = new Arquero(1,1);
		mapa.posicionarEnFilaColumna(posicionable, 1, 1);
		mapa.posicionarDesdeEnHasta(new Posicion (1, 1), new Posicion (0,0));
	}

}
