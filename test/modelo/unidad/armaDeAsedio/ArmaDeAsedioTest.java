package modelo.unidad.armaDeAsedio;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.AtacandoAUnAliadoError;
import modelo.unidad.arquero.Arquero;

public class ArmaDeAsedioTest {

	@Test
	public void test01AtacarAUnArqueroNoLeRestaVida () {
		
		Mapa mapa = new Mapa();
		Jugador primerJugador = new Jugador (mapa, "anto", "juan");
		
		ArmaDeAsedio arma = new ArmaDeAsedio (5,5, primerJugador);
		arma.montar();
		arma.avanzarTurno();
		
		Jugador segundoJugador = primerJugador.jugadorSiguiente();
		Arquero arquero = new Arquero (5, 4, segundoJugador);
		
		arma.atacar(arquero, new Posicion (5, 4));
		
		assertEquals (arquero.getVida(), 75);
		
	}
	
	@Test (expected = AtacandoAUnAliadoError.class)
	public void test02AtacarAUnCuartelQuePerteneceAlMismoJugadorLanzaExcepcion () {
		
		Mapa mapa = new Mapa();
		Jugador primerJugador = new Jugador (mapa, "anto", "juan");
		
		ArmaDeAsedio arma = new ArmaDeAsedio (5,5, primerJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 5, 5);
		Cuartel cuartel = new Cuartel (5, 4, 6, 5, primerJugador);
		primerJugador.agregarPosicionableEnFilaColumna(cuartel, 5, 4);
		
		arma.montar();
		arma.avanzarTurno();
		arma.atacar(cuartel, new Posicion (5, 4));
	
		
	}
	
	@Test (expected = AtacandoAUnAliadoError.class)
	public void test03AtacarAUnArqueroQuePerteneceAlMismoJugadorLanzaExcepcion () {
		
		Mapa mapa = new Mapa();
		Jugador primerJugador = new Jugador (mapa, "anto", "juan");
		
		ArmaDeAsedio arma = new ArmaDeAsedio (5,5, primerJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 5, 5);
		Arquero arquero = new Arquero (5, 4, primerJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arquero, 5, 4);
		
		arma.montar();
		arma.avanzarTurno();
		arma.atacar(arquero, new Posicion (5, 4));
	
		
	}
	
	@Test (expected = ArmaDeAsedioMontandoseException.class)
	public void test04AtacarConArmaDeAsedioMontandoseDebeLanzarExcepcion () {
		
		Mapa mapa = new Mapa();
		Jugador primerJugador = new Jugador (mapa, "anto", "juan");
		Jugador segundoJugador = new Jugador (mapa, "juan", "anto");		
		ArmaDeAsedio arma = new ArmaDeAsedio (5,5, primerJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 5, 5);

		Arquero arquero = new Arquero (5, 4, segundoJugador);
		segundoJugador.agregarPosicionableEnFilaColumna(arquero, 5, 4);
		
		arma.montar();
		
		arma.atacar(arquero, new Posicion (5, 4));
	
		
	}
	
	@Test (expected = ArmaDeAsedioDesmontadaException.class)
	public void test05AtacarConArmaDeAsedioDesmontadaDebeLanzarExcepcion () {
		
		Mapa mapa = new Mapa();
		Jugador primerJugador = new Jugador (mapa, "anto", "juan");
		Jugador segundoJugador = new Jugador (mapa, "juan", "anto");		
		ArmaDeAsedio arma = new ArmaDeAsedio (5,5, primerJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 5, 5);

		Arquero arquero = new Arquero (5, 4, segundoJugador);
		segundoJugador.agregarPosicionableEnFilaColumna(arquero, 5, 4);
		
		
		arma.atacar(arquero, new Posicion (5, 4));
		
	}
	
	@Test (expected = ArmaDeAsedioDesmontandoseException.class)
	public void test06AtacarConArmaDeAsedioDesmontandoseDebeLanzarExcepcion () {
		
		Mapa mapa = new Mapa();
		Jugador primerJugador = new Jugador (mapa, "anto", "juan");
		Jugador segundoJugador = new Jugador (mapa, "juan", "anto");		
		ArmaDeAsedio arma = new ArmaDeAsedio (5,5, primerJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 5, 5);

		Arquero arquero = new Arquero (5, 4, segundoJugador);
		segundoJugador.agregarPosicionableEnFilaColumna(arquero, 5, 4);
		arma.montar();
		arma.avanzarTurno();
		arma.desarmar();
		
		arma.atacar(arquero, new Posicion (5, 4));
		
	}

}
