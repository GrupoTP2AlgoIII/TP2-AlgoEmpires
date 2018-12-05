package modelo.unidad;


import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.unidad.aldeano.Aldeano;

public class PosicionableTest {

	@Test (expected = CrearUnidadException.class)
	public void test01AldeanoNoPuedeCrearUnaUnidad() {
		
		Posicionable aldeano = new Aldeano ();
		aldeano.crearUnidad('A');
	}
	

	@Test (expected = ConstruccionEdificioException.class)
	public void test02CuartelNoPuedeConstruir() {
		Jugador jugador = new Jugador (new Mapa(), "anto", "juan");	
		Posicionable cuartel = new Cuartel (1, 1, 2, 2, jugador);
		cuartel.construir('C');
	}
	
	@Test (expected = ConstruccionEdificioException.class)
	public void test03AldeanoNoPuedeConstruir() {
		
		Jugador jugador = new Jugador (new Mapa(), "anto", "juan");
		Posicionable cuartel = new Cuartel (1, 1, 2, 2, jugador);
		cuartel.construirPropio('C', jugador);
	}

}
