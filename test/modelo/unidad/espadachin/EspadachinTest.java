package modelo.unidad.espadachin;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.AtacandoAUnAliadoError;
import modelo.unidad.arquero.Arquero;

public class EspadachinTest {
	
	@Test (expected = AtacandoAUnAliadoError.class)
	public void test01AtacarUnArqueroDelMismoJugadorDebeLanzarExcepcion () {
		
		Mapa mapa = new Mapa ();
		Jugador jugador = new Jugador (mapa, "juan", "amto");
		Espadachin espadachin = new Espadachin (5, 5, jugador);
		Arquero arquero = new Arquero (5, 4, jugador);
		jugador.agregarPosicionableEnFilaColumna(espadachin, 5, 5);
		jugador.agregarPosicionableEnFilaColumna(arquero, 5, 4);
		
		espadachin.atacar(arquero, new Posicion (5, 4));
	}
	
	@Test (expected = AtacandoAUnAliadoError.class)
	public void test02AtacarUnCuartelDelMismoJugadorDebeLanzarExcepcion () {
		
		Mapa mapa = new Mapa ();
		Jugador jugador = new Jugador (mapa, "juan", "amto");
		Espadachin espadachin = new Espadachin (5, 5, jugador);
		Cuartel cuartel = new Cuartel (5, 4, 6, 5, jugador);
		jugador.agregarPosicionableEnFilaColumna(espadachin, 5, 5);
		jugador.agregarPosicionableEnFilaColumna(cuartel, 5, 4);
		
		espadachin.atacar(cuartel, new Posicion (5, 4));
	}
}
