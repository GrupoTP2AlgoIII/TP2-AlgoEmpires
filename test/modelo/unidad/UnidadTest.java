package modelo.unidad;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

public class UnidadTest {

	@Test
	public void test01RecibirDanioDePosicionableDescuentaVida () {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "anto", "juan");
		Jugador segundoJugador = new Jugador (mapa, "juan", "anto");
		Posicionable posicionable = new Arquero (2,2, primerJugador);
		Unidad espadachin = new Espadachin (2,3, segundoJugador);
		espadachin.recibirDanioDe(posicionable);
		
		assertEquals (espadachin.getVida(), 85);
		
		
	}

}
