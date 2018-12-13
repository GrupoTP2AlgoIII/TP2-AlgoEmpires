package modelo.jugador;

import static org.junit.Assert.*;
import org.junit.Test;
import modelo.edificio.Edificio;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.mapa.PosicionNoAdyacenteError;
import modelo.unidad.AtacandoAUnAliadoError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.jugador.PosicionOcupadaError;

public class JugadorTest {


	@Test
	public void test01IniciarUnidadesDeUnJugadorCreaAldeanosCorrectamente() throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		
		Jugador jugador = new Jugador(mapa, "Jorge", "Maria");
		jugador.iniciarAldeanosPropiosDesde(5, 5);

		Posicion posicion1 = new Posicion(5, 5);
		Posicion posicion2 = new Posicion(5, 6);
		Posicion posicion3 = new Posicion(5, 7);

		// Devuelve 20 de oro al avanzar turno
		assertSame(20, mapa.obtenerPosicionableEn(posicion1).avanzarTurno());
		assertSame(20, mapa.obtenerPosicionableEn(posicion2).avanzarTurno());
		assertSame(20, mapa.obtenerPosicionableEn(posicion3).avanzarTurno());

	}

	@Test
	public void test02IniciarCastilloDeUnJugadorCreaCastilloCorrectamente() throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		
		Jugador jugador = new Jugador(mapa, "Jorge", "Maria");
		jugador.crearCastilloDesde(1, 1);
		jugador.iniciarAldeanosPropiosDesde(10, 8);
		Posicion posicionCastillo = new Posicion(4, 4);
		
		for (int i = 0; i < 5; ++i) {
			jugador.avanzarTurno();
		}
		jugador.crearUnidadPropia(posicionCastillo, 'A');

		assertSame(20, jugador.getPoblacion());

	}

	@Test
	public void test03IniciarPlazaCentralDeUnJugadorLaCreaCorrectamente() throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		
		Jugador jugador = new Jugador(mapa, "Jorge", "Maria");
		jugador.crearPlazaCentralPropiaDesde(1, 8);

		Posicion posicionPlaza = new Posicion(2, 9);
		jugador.crearUnidadPropia(posicionPlaza, 'A');

		assertSame(5, jugador.getPoblacion());
	}

	@Test
	public void test04IniciarAldeanosDeUnJugadorLosCreaCorrectamente() throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		
		Jugador jugador = new Jugador(mapa, "Jorge", "Maria");
		jugador.iniciarAldeanosPropiosDesde(10, 10);

		assertSame(3, jugador.getPoblacion());
	}
	
//	@Test(expected = PosicionDesocupadaError.class)
//	public void test05DesplazarHaciaArribaPosicionDesocupadaArrojaError() {
//
//		Mapa mapa = new Mapa();
//		
//		Jugador jugador = new Jugador(mapa, "nombre", "Maria");
//		//jugador.posicionarDesdeEnHasta(10, 10, 11, 10);
//		jugador.posicionarDesdeEnHasta(new Posicion(10,10),new Posicion(11,10));
//	}
	
	@Test(expected = PosicionNoPerteneceAJugadorException.class)
	public void test05DesplazarHaciaArribaPosicionDesocupadaArrojaError() {

		Mapa mapa = new Mapa();
		
		Jugador jugador = new Jugador(mapa, "nombre", "Maria");
		//jugador.posicionarDesdeEnHasta(10, 10, 11, 10);
		jugador.posicionarDesdeEnHasta(new Posicion(10,10),new Posicion(11,10));
	}

	@Test
	public void test06InicioElJuegoCreoDosJugadoresYCreoPlazaCentral() {

		Mapa mapa = new Mapa();
		
		Jugador jugador = new Jugador(mapa, "Jorge", "Gaston");
		
		jugador.iniciarAldeanosPropiosDesde(5, 5);

		Jugador jugador2 = jugador.jugadorSiguiente();
		
		jugador2.iniciarAldeanosPropiosDesde(10, 10);


//		Posicion posicion1 = new Posicion(5, 5);
//		Posicion posicion2 = new Posicion(5, 6);
//		Posicion posicion3 = new Posicion(5, 7);


		jugador.crearPlazaCentralPropiaDesde(1, 8);


		Posicion posicionPlaza = new Posicion(2, 9);

		jugador.crearUnidadPropia(posicionPlaza, 'A');

		Poblacion poblacion = jugador.obtenerPoblacion();


		assertEquals(poblacion.getCantidad(), 8);
	}


	@Test
	public void test07InicioElJuegoCreoDosJugadoresYCreoBatalla() {

		Mapa mapa = new Mapa();
		
		Jugador jugador = new Jugador(mapa, "Jorge", "Maria");
		jugador.crearCastilloDesde(17, 17);
		jugador.iniciarAldeanosPropiosDesde(5, 5);

		Jugador jugador2 = jugador.jugadorSiguiente();
		
		jugador2.iniciarAldeanosPropiosDesde(10, 10);

		Posicion posicion1 = new Posicion(5, 5);
		Posicion posicion4 = new Posicion(6, 6);

		Posicion posicionDelAldeanoDeJugador2 = new Posicion(10, 10);


		jugador.construirEdificioPropio(posicion1, posicion4, 'C');

		Edificio cuartel = (Edificio) mapa.obtenerPosicionableEn(new Posicion(7,7));


		cuartel.avanzarTurno();
		cuartel.actualizar();
		cuartel.avanzarTurno();
		cuartel.actualizar();
		cuartel.avanzarTurno();
		cuartel.actualizar();
		
		jugador.avanzarTurno();
		jugador.crearUnidadPropia(posicion4,'A');
		Posicionable arqueroDeJugador1 = mapa.obtenerPosicionableEn(new Posicion(7,8));
		Posicionable aldeanoDeJugador2 = mapa.obtenerPosicionableEn(posicionDelAldeanoDeJugador2);
		
		arqueroDeJugador1.atacar(aldeanoDeJugador2);

	}
	
	@Test
	public void test08CrearDosJugadoresEnemigosYObtenerSiguiente() {
		
		Mapa mapa = new Mapa();
				
		Jugador jugador1 = new Jugador(mapa, "Pedro", "Maria");		
		Jugador jugador2 = jugador1.jugadorSiguiente();
		
		
		assertEquals("Maria", jugador1.jugadorSiguiente().getNombre());
		assertEquals("Pedro", jugador2.jugadorSiguiente().getNombre());
		
		}
	
	@Test
	public void test09CrearDosJugadoresVerificandoAtaqueCastillo() {
		
		Mapa mapa = new Mapa();
				
		Jugador jugador1 = new Jugador(mapa, "Pedro", "Maria");	
		Jugador jugador2 = jugador1.jugadorSiguiente();
		
		Espadachin espadachin = new Espadachin(8,8);
		jugador2.agregarPosicionableEnFilaColumna(espadachin, 8, 8);		
		jugador1.crearCastilloDesde(4, 4);
		
		//Castillo castillo = (Castillo) jugador1.getPosicionable(new Posicion(4,4));
		jugador1.avanzarTurno();
		
		assertEquals(80, jugador2.getPosicionable(new Posicion(8,8)).getVida());
		
	}
	
	@Test (expected = AtacandoAUnAliadoError.class)
	public void test10IniciaElJuegoCreoDosJugadoresYHagoQueUnoAtaqueASuMismaUnidadLanzaExcepcion () {
		
		Mapa mapa = new Mapa();
		
		Jugador jugador = new Jugador(mapa, "Jorge", "Gaston");
		
		jugador.iniciarAldeanosPropiosDesde(5, 5);
		
		Jugador jugador2 = jugador.jugadorSiguiente();

		jugador2.iniciarAldeanosPropiosDesde(10, 10);


		Posicion posicion1 = new Posicion(5, 5);
//		Posicion posicion2 = new Posicion(5, 6);
//		Posicion posicion3 = new Posicion(5, 7);
		Posicion posicion4 = new Posicion(6, 6);


		Posicion posicionDelAldeanoDeJugador = new Posicion(5, 5);


		jugador.crearPlazaCentralPropiaDesde(1, 8);

		jugador.construirEdificioPropio(posicion1, posicion4, 'C');


		Posicion posicionPlaza = new Posicion(2, 9);

		jugador.crearUnidadPropia(posicionPlaza, 'A');


		Posicionable cuartel = mapa.obtenerPosicionableEn(posicion4);


		cuartel.avanzarTurno();
		cuartel.actualizar();
		cuartel.avanzarTurno();
		cuartel.actualizar();
		cuartel.avanzarTurno();
		cuartel.actualizar();


		Unidad arqueroDeJugador1 = cuartel.crearUnidadPropia('A', jugador);
		Posicionable aldeanoDeJugador = mapa.obtenerPosicionableEn(posicionDelAldeanoDeJugador);

		arqueroDeJugador1.atacar(aldeanoDeJugador);	
	}
	
	@Test (expected = PosicionNoAdyacenteError.class)
	public void test11PosicionarAUnaUnidadUbicadaEnUnaPosicionEnUnaPosicionNoAdyacenteDebeLanzarExcepcion ( ) {
		
		Mapa mapa = new Mapa ();
		Jugador jugador = new Jugador (mapa, "anto", "juan");
		Arquero arquero = new Arquero (1, 1, jugador);
		jugador.agregarPosicionableEnFilaColumna(arquero, 1, 1);
		//jugador.posicionarDesdeEnHasta(1, 1, 1, 3);
		jugador.posicionarDesdeEnHasta(new Posicion(1,1),new Posicion(1,3));
		
	}
	
	@Test (expected = PosicionNoAdyacenteError.class)
	public void test12PosicionarAUnaUnidadUbicadaEnUnaPosicionEnUnaPosicionNoAdyacenteDebeLanzarExcepcion ( ) {
		
		Mapa mapa = new Mapa ();
		Jugador jugador = new Jugador (mapa, "anto", "juan");
		Arquero arquero = new Arquero (5, 5, jugador);
		jugador.agregarPosicionableEnFilaColumna(arquero, 5, 5);
		//jugador.posicionarDesdeEnHasta(5, 5, 3, 5);
		jugador.posicionarDesdeEnHasta(new Posicion(5,5),new Posicion(3,5));
		
	}
	
	@Test (expected = PosicionNoAdyacenteError.class)
	public void test13PosicionarAUnaUnidadUbicadaEnUnaPosicionEnUnaPosicionNoAdyacenteDebeLanzarExcepcion ( ) {
		
		Mapa mapa = new Mapa ();
		Jugador jugador = new Jugador (mapa, "anto", "juan");
		Arquero arquero = new Arquero (5, 5, jugador);
		jugador.agregarPosicionableEnFilaColumna(arquero, 5, 5);
		//jugador.posicionarDesdeEnHasta(5, 5, 7, 5);
		jugador.posicionarDesdeEnHasta(new Posicion(5,5), new Posicion(7,5));
		
	}
	
	@Test (expected = PosicionNoAdyacenteError.class)
	public void test14PosicionarAUnaUnidadUbicadaEnUnaPosicionEnUnaPosicionNoAdyacenteDebeLanzarExcepcion ( ) {
		
		Mapa mapa = new Mapa ();
		Jugador jugador = new Jugador (mapa, "anto", "juan");
		Arquero arquero = new Arquero (5, 5, jugador);
		jugador.agregarPosicionableEnFilaColumna(arquero, 5, 5);
		//jugador.posicionarDesdeEnHasta(5, 5, 5, 3);
		jugador.posicionarDesdeEnHasta(new Posicion(5,5), new Posicion(5,3));
		
	}
	
	@Test
	public void test15ElCastilloAtacaASuAlrededor() {
		
		Mapa mapa = new Mapa();
		Jugador jugador = new Jugador(mapa, "Jorge", "Maria");
		jugador.crearCastilloDesde(4, 4);
		Jugador jugador2 = jugador.jugadorSiguiente();
		jugador2.iniciarAldeanosPropiosDesde(9, 4); // Crea aldeanos en (8,4), (8,5), (8,6) con 50 de vida
		//jugador.crearCastilloDesde(4, 4);		
		//jugador2.iniciarAldeanosPropiosDesde(8, 4); // Aca no funciona
		
		jugador.avanzarTurno(); // le resta 30 de vida a los aldeanos
		
		assertEquals(30, jugador2.getPosicionable(new Posicion(9,4)).getVida());
		//assertEquals(30, jugador2.getPosicionable(new Posicion(9,5)).getVida());
		//assertEquals(30, jugador2.getPosicionable(new Posicion(9,6)).getVida());
		
//		assertEquals(30, mapa.obtenerPosicionableEn(new Posicion(8,4)).getVida());
//		assertEquals(30, mapa.obtenerPosicionableEn(new Posicion(8,5)).getVida());
//		assertEquals(30, mapa.obtenerPosicionableEn(new Posicion(8,6)).getVida());
		
		
	}
}

