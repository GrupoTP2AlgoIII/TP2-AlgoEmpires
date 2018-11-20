package modelo.jugador;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.jugador.PosicionOcupadaError;
import modelo.edificio.castillo.Castillo;
import modelo.edificio.TamanioIncorrectoError;

public class JugadorTest {

	@Test
	public void test01IniciarUnidadesDeUnJugadorCreaAldeanosCorrectamente () throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa);
		jugador.iniciarUnidades();

		Posicion posicion1 = new Posicion (5,5);
		Posicion posicion2 = new Posicion (5,6);
		Posicion posicion3 = new Posicion (5,7);
		
		//Aldeano aldeano = new Aldeano();

		assertEquals(Aldeano.class, mapa.obtenerPosicionableEn(posicion1).getClass());
		assertEquals(Aldeano.class, mapa.obtenerPosicionableEn(posicion2).getClass());
		assertEquals(Aldeano.class, mapa.obtenerPosicionableEn(posicion3).getClass());
		
	}

	@Test
	public void test02IniciarCastilloDeUnJugadorCreaCastilloCorrectamente () throws PosicionFueraDelMapaError, PosicionOcupadaError, TamanioIncorrectoError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa);
		jugador.iniciarEdificios();

		for (int i = 1; i <= 4; i++){
			for (int j = 1; j <= 4; j++){
				Posicion posicion = new Posicion (i,j);
				assertEquals(Castillo.class, mapa.obtenerPosicionableEn(posicion).getClass());

			}
		}
	}

	@Test (expected = TamanioIncorrectoError.class)
	public void test03CrearCastilloDeMayorTamanioArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa);

		jugador.crearCastilloDesdeHasta(1,1,10,10);
	}

	@Test (expected = TamanioIncorrectoError.class)
	public void test04CrearCastilloIndicandoMalElTamanioArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa);

		// El tamanio es de 4x4, pero se debe indicar de izquierda a derecha y de abajo hacia arriba la ubicacion
		jugador.crearCastilloDesdeHasta(3,3,1,1);
	}

	@Test (expected = PosicionFueraDelMapaError.class)
	public void test05CrearCastilloFueraDelMapaArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa);
		
		jugador.crearCastilloDesdeHasta(-1,-1,2,2);
	}

	@Test (expected = PosicionOcupadaError.class)
	public void test06CrearCastilloEnPosicionOcupadaArrojaError() throws TamanioIncorrectoError, PosicionFueraDelMapaError, PosicionOcupadaError{

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador (mapa);		
		jugador.crearCastilloDesdeHasta(1,1,4,4); // Crea un castillo correctamente

		jugador.crearCastilloDesdeHasta(4,4,7,7); // Intenta colocar un castillo pero (4,4) esta ocupada
	}


}