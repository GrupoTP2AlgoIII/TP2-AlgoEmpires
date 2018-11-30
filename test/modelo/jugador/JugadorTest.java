package modelo.jugador;

import static org.junit.Assert.*;

import modelo.edificio.cuartel.Cuartel;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.espadachin.Espadachin;
import org.junit.Test;

import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.MovimientosPorTurnoExcedidosError;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontadaNoPuedeDesplazarseError;
import modelo.jugador.PosicionOcupadaError;
import modelo.unidad.arquero.Arquero;
import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;

public class JugadorTest {


	@Test
	public void test01IniciarUnidadesDeUnJugadorCreaAldeanosCorrectamente() throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa, "Jorge");
		jugador.iniciarAldeanosDesde(5, 5);

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
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa, "Jorge");
		jugador.crearCastilloDesde(1, 1);

		Posicion posicionCastillo = new Posicion(4, 4);
		jugador.crearUnidad(posicionCastillo, 'A');

		assertSame(4, jugador.getPoblacion());

	}

	@Test
	public void test03IniciarPlazaCentralDeUnJugadorLaCreaCorrectamente() throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa, "Jorge");
		jugador.crearPlazaCentralDesde(1, 8);


		Posicion posicionPlaza = new Posicion(2, 9);
		jugador.crearUnidad(posicionPlaza, 'A');

		assertSame(4, jugador.getPoblacion());
	}

	@Test
	public void test04IniciarAldeanosDeUnJugadorLosCreaCorrectamente() throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa, "Jorge");
		jugador.iniciarAldeanosDesde(10, 10);

		assertSame(3, jugador.getPoblacion());
	}


	@Test(expected = PosicionDesocupadaError.class)
	public void test05DesplazarHaciaArribaPosicionDesocupadaArrojaError() throws MovimientosPorTurnoExcedidosError, PosicionDesocupadaError, PosicionOcupadaError, ArmaDeAsedioDesmontadaNoPuedeAtacarError, ArmaDeAsedioMontadaNoPuedeDesplazarseError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa, "nombre");
		jugador.posicionarDesdeEnHasta(10, 10, 11, 10);

	}


	@Test
	public void test05InicioElJuegoCreoDosJugadoresYCreoPlazaCentral() {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa, "Jorge");
		Jugador jugador2 = new Jugador(mapa, "Gaston");

		jugador.iniciarAldeanosPropiosDesde(5, 5);

		jugador2.iniciarAldeanosPropiosDesde(10, 10);


		Posicion posicion1 = new Posicion(5, 5);
		Posicion posicion2 = new Posicion(5, 6);
		Posicion posicion3 = new Posicion(5, 7);


		jugador.crearPlazaCentralPropiaDesde(1, 8);


		Posicion posicionPlaza = new Posicion(2, 9);

		jugador.crearUnidadPropia(posicionPlaza, 'A');

		Poblacion poblacion = jugador.obtenerPoblacion();


		assertEquals(poblacion.getCantidad(), 8);
	}


	@Test
	public void test06InicioElJuegoCreoDosJugadoresYCreoBatalla() {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa, "Jorge");
		Jugador jugador2 = new Jugador(mapa, "Gaston");

		jugador.iniciarAldeanosPropiosDesde(5, 5);

		jugador2.iniciarAldeanosPropiosDesde(10, 10);


		Posicion posicion1 = new Posicion(5, 5);
		Posicion posicion2 = new Posicion(5, 6);
		Posicion posicion3 = new Posicion(5, 7);
		Posicion posicion4 = new Posicion(6, 6);


		Posicion posicionDelAldeanoDeJugador2 = new Posicion(10, 10);


		jugador.crearPlazaCentralPropiaDesde(1, 8);

		jugador.construirEdificioPropio(posicion1, posicion4, 'C');


		Posicion posicionPlaza = new Posicion(2, 9);

		jugador.crearUnidadPropia(posicionPlaza, 'A');


		Posicionable cuartel = mapa.obtenerPosicionableEn(posicion4);


		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();


		Unidad arqueroDeJugador1 = cuartel.crearUnidadPropia('A', jugador);
		Posicionable aldeanoDeJugador2 = mapa.obtenerPosicionableEn(posicionDelAldeanoDeJugador2);

		arqueroDeJugador1.atacar(aldeanoDeJugador2);


		assertEquals(aldeanoDeJugador2.getVida(), 35);

	}
}

