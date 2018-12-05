package modelo.vacio;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.Edificio;
import modelo.edificio.cuartel.Cuartel;
import modelo.jugador.Jugador;
import modelo.jugador.PosicionDesocupadaError;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.arquero.Arquero;

public class VacioTest {

	@Test
	public void test01EstaEnRangoDePosicionSiempreDevuelveFalse () {
		
		Vacio vacio = new Vacio (1,1);
		assertFalse (vacio.estaEnRangoDePosicion(new Posicion (1,1), 1, 1));

	}
	
	@Test (expected = PosicionDesocupadaError.class)
	public void test02AtacarAUnArqueroLanzaExcepcion () {
		
		Arquero arquero = new Arquero (1, 1);
		Vacio vacio = new Vacio (2,2);
		
		vacio.atacar(arquero, new Posicion (1,1));
	}
	
	@Test (expected = PosicionDesocupadaError.class)
	public void test03AtacarAUnPosicionableLanzaExcepcion () {
		
		Posicionable arquero = new Arquero (1, 1);
		Vacio vacio = new Vacio (2,2);
		
		vacio.atacar(arquero);
	}
	
	@Test (expected = PosicionDesocupadaError.class)
	public void test04AtacarAUnEdificioLanzaExcepcion () {
		
		Jugador jugador = new Jugador (new Mapa(), "juan", "anto");
		Edificio cuartel = new Cuartel (1, 1, 2, 2, jugador);
		Vacio vacio = new Vacio (2,2);
		
		vacio.atacar(cuartel, new Posicion (1,1));
	}

}
