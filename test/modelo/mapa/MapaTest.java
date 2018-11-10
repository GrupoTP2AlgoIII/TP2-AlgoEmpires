package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapaTest {

	@Test
	public void comprobarTamanioDelMapaTest() {
		
		Mapa mapa = new Mapa();
		mapa.iniciarMapa();
		
		int cantidadCasilleros = mapa.obtenerTamanioMapa();
		
		assertEquals (2500, cantidadCasilleros);
	}

}
