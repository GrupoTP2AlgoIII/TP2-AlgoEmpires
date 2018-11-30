package modelo.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.arquero.Arquero;

public class JuegoTest {

	@Test // Como son inicializados sin estar ocupados devuelven 20 de oro
	public void test01IniciarJuegoInicializaAldeanosJugador1()  {
		
		Juego juego = new Juego();
		juego.iniciarJuego();

		for (int i = 6; i <= 8; i++) {
			Posicion posicion = new Posicion (8, i);
			assertEquals(20, juego.obtenerPosicionableEn(posicion).avanzarTurno());
		}
		
	}
	
	@Test
	public void test02IniciarJuegoInicializaAldeanosJugador2()  {
		
		Juego juego = new Juego();
		juego.iniciarJuego();
		
		for (int j = 43; j <= 45; j++) {
			Posicion posicion = new Posicion (43, j);
			assertEquals(20, juego.obtenerPosicionableEn(posicion).avanzarTurno());
		}
	}
	
	@Test
	public void test03IniciarJuegoInicializaCastilloJugador1() {
		
		Juego juego = new Juego();
		juego.iniciarJuego();
			
		Posicion posicionCastillo = new Posicion (4,4);
		Posicionable castillo = juego.obtenerPosicionableEn(posicionCastillo);
		
		Unidad armaAsedio = castillo.crearUnidad('A');
		
		assertEquals(150, armaAsedio.getVida());		

	}
	
	@Test
	public void test04IniciarJuegoInicializaCastilloJugador2() {
		
		Juego juego = new Juego();
		juego.iniciarJuego();

		Posicion posicionCastillo = new Posicion (44,44);
		Posicionable castillo = juego.obtenerPosicionableEn(posicionCastillo);
		
		Unidad armaAsedio = castillo.crearUnidad('A');
		
		assertEquals(150, armaAsedio.getVida());
	}
	
	@Test
	public void test05IniciarJuegoInicializaPlazaCentralJugador1() {
		
		Juego juego = new Juego();
		juego.iniciarJuego();

		Posicion posicionPlaza = new Posicion (2,8);
		Posicionable plazaCentral = juego.obtenerPosicionableEn(posicionPlaza);
		
		Unidad aldeano = plazaCentral.crearUnidad('A');
		
		assertEquals(50, aldeano.getVida());
		
	}
	
	@Test
	public void test06IniciarJuegoInicializaPlazaCentralJugador2() {
		
		Juego juego = new Juego();
		juego.iniciarJuego();

		Posicion posicionPlaza = new Posicion (2,8);
		Posicionable plazaCentral = juego.obtenerPosicionableEn(posicionPlaza);
		
		Unidad aldeano = plazaCentral.crearUnidad('A');
		
		assertEquals(50, aldeano.getVida());
		
	}
	
	@Test //Verifica que no hay que pasar de turno para crear aldeano
	public void test07IniciarJuegoInicializaPlazaCentralConstruidaJugador1()  {
		
		Juego juego = new Juego();
		juego.iniciarJuego();
		
		Arquero arquero = new Arquero(5,5);
		Cuartel cuartel = new Cuartel(3,3,4,4);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		arquero.atacar(cuartel, new Posicion (4,4)); // le resta vida
				
		Posicion posicionPlaza = new Posicion (2,9);
		Aldeano aldeano = (Aldeano)juego.obtenerPosicionableEn(posicionPlaza).crearUnidad('A'); // se puede crear aldeano
		
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
		
		assertEquals(250, cuartel.getVida());	// el aldeano creado reparo el cuartel
		
	}
	
	@Test 
	public void test08IniciarJuegoInicializaPlazaCentralConstruidaJugador2() {
		
		
		Juego juego = new Juego();
		juego.iniciarJuego();
		
		Arquero arquero = new Arquero(12, 12);
		Cuartel cuartel = new Cuartel(10, 10, 11, 11);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		arquero.atacar(cuartel, new Posicion (11,11));
				
		Posicion posicionPlaza = new Posicion (50,43); //con (fila, columna)
		Aldeano aldeano = (Aldeano)juego.obtenerPosicionableEn(posicionPlaza).crearUnidad('A');
		
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
		
		assertEquals(250, cuartel.getVida());	
		
	}
	
}
