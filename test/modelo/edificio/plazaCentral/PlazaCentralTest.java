package modelo.edificio.plazaCentral;


import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.arquero.Arquero;

public class PlazaCentralTest {

	@Test (expected = PlazaCentralNoPuedeAtacarError.class)
	public void test01PlazaCentralNoPuedeAtacarAUnPosicionable () {
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = new Jugador (mapa, "juan", "anto");
    	PlazaCentral plaza = new PlazaCentral (1, 1, 2, 2, primerJugador);
    	Posicionable arquero = new Arquero (2, 3, segundoJugador);
    	
    	plaza.atacar(arquero);
	}
	
	@Test (expected = PlazaCentralNoPuedeAtacarError.class)
	public void test02PlazaCentralNoPuedeAtacarAUnaUnidad () {
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = new Jugador (mapa, "juan", "anto");
    	PlazaCentral plaza = new PlazaCentral (1, 1, 2, 2, primerJugador);
    	Unidad arquero = new Arquero (2, 3, segundoJugador);
    	
    	plaza.atacar(arquero, new Posicion (2,3));		
	}
	
	@Test (expected = PlazaCentralNoPuedeAtacarError.class)
	public void test03PlazaCentralNoPuedeAtacarAUnEdificio () {
    	Mapa mapa = new Mapa ();
    	Jugador primerJugador = new Jugador (mapa, "anto", "juan");
    	Jugador segundoJugador = new Jugador (mapa, "juan", "anto");
    	PlazaCentral plaza = new PlazaCentral (1, 1, 2, 2, primerJugador);
    	Cuartel cuartel = new Cuartel (2, 3, 3, 4, segundoJugador);
    	
    	plaza.atacar(cuartel, new Posicion (2,3));		
	}

}
