package modelo.jugador;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.jugador.PosicionOcupadaError;
import modelo.edificio.TamanioIncorrectoError;

public class JugadorTest {
	

	@Test
	public void test01IniciarUnidadesDeUnJugadorCreaAldeanosCorrectamente () throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa,"Jorge");
		jugador.iniciarUnidades();

		Posicion posicion1 = new Posicion (5,5);
		Posicion posicion2 = new Posicion (5,6);
		Posicion posicion3 = new Posicion (5,7);
		
		// Devuelve 20 de oro al avanzar turno
		assertSame(20, mapa.obtenerPosicionableEn(posicion1).avanzarTurno());
		assertSame(20, mapa.obtenerPosicionableEn(posicion2).avanzarTurno());
		assertSame(20, mapa.obtenerPosicionableEn(posicion3).avanzarTurno());
		
	}
	
	// Tests para poner un castillo

	@Test
	public void test02IniciarCastilloDeUnJugadorCreaCastilloCorrectamente () throws PosicionFueraDelMapaError, PosicionOcupadaError, TamanioIncorrectoError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");
		jugador.crearCastilloDesdeHasta(1, 1, 4, 4);

		for (int i = 1; i <= 4; i++){
			for (int j = 1; j <= 4; j++){
				Posicion posicion = new Posicion (i,j);
				assertTrue(mapa.obtenerPosicionableEn(posicion).estaOcupado());

			}
		}
	}

	@Test (expected = TamanioIncorrectoError.class)
	public void test03CrearCastilloDeMayorTamanioArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");

		jugador.crearCastilloDesdeHasta(1,1,10,10);
	}

	@Test (expected = TamanioIncorrectoError.class)
	public void test04CrearCastilloIndicandoMalElTamanioArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");

		// El tamanio es de 4x4, pero se debe indicar de izquierda a derecha y de abajo hacia arriba la ubicacion
		jugador.crearCastilloDesdeHasta(3,3,1,1);
	}

	@Test (expected = PosicionFueraDelMapaError.class)
	public void test05CrearCastilloFueraDelMapaArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");
		
		jugador.crearCastilloDesdeHasta(-1,-1,2,2);
	}

	@Test (expected = PosicionOcupadaError.class)
	public void test06CrearCastilloEnPosicionOcupadaArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");		
		jugador.crearCastilloDesdeHasta(1,1,4,4); // Crea un castillo correctamente

		jugador.crearCastilloDesdeHasta(4,4,7,7); // Intenta colocar un castillo pero (4,4) esta ocupada
	}
	
	// Tests para poner una plaza central
	
	@Test
	public void test07IniciarPlazaCentralDeUnJugadorLaCreaCorrectamente () throws PosicionFueraDelMapaError, PosicionOcupadaError, TamanioIncorrectoError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");
		jugador.crearPlazaCentralDesdeHasta(1, 8, 2, 9);

		for (int i = 1; i <= 2; i++){
			for (int j = 8; j <= 9; j++){
				Posicion posicion = new Posicion (i,j);
				assertTrue(mapa.obtenerPosicionableEn(posicion).estaOcupado());

			}
		}
		
		Posicion posicion2 = new Posicion (20, 20);
		assertFalse(mapa.obtenerPosicionableEn(posicion2).estaOcupado());
	}

	@Test (expected = TamanioIncorrectoError.class)
	public void test08CrearPlazaCentralDeMayorTamanioArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");

		jugador.crearPlazaCentralDesdeHasta(5,5,9,9);
	}

	@Test (expected = TamanioIncorrectoError.class)
	public void test09CrearPlazaCentralIndicandoMalElTamanioArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");

		// El tamanio es de 2x2, pero se debe indicar de izquierda a derecha y de abajo hacia arriba la ubicacion
		jugador.crearCastilloDesdeHasta(10,10,9,9);
	}

	@Test (expected = PosicionFueraDelMapaError.class)
	public void test10CrearPlazaCentralFueraDelMapaArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");
		
		jugador.crearPlazaCentralDesdeHasta(-1,-1,0,0);
	}

	@Test (expected = PosicionOcupadaError.class)
	public void test11CrearPlazaCentralEnPosicionOcupadaArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa,"Jorge");		
		jugador.crearPlazaCentralDesdeHasta(1,1,2,2); // Crea una plaza central correctamente

		jugador.crearPlazaCentralDesdeHasta(2,2,3,3); // Intenta colocar una plaza central pero (2,2) esta ocupada
	}



}