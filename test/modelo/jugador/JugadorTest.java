package modelo.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.jugador.PosicionOcupadaError;
import modelo.edificio.castillo.Castillo;
import modelo.edificio.TamanioIncorrectoError;

public class JugadorTest {

	@Test
	public void iniciarUnidadesDeUnJugadorCreaAldeanosCorrectamente () throws PosicionFueraDelMapaError, PosicionOcupadaError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa);
		jugador.iniciarUnidades();

		Posicion posicion1 = new Posicion (5,5);
		Posicion posicion2 = new Posicion (5,6);
		Posicion posicion3 = new Posicion (5,7);
		
		Aldeano aldeano = new Aldeano();

		assertEquals(Aldeano.class, mapa.obtenerPosicionableEn(posicion1).getClass());
		assertEquals(Aldeano.class, mapa.obtenerPosicionableEn(posicion2).getClass());
		assertEquals(Aldeano.class, mapa.obtenerPosicionableEn(posicion3).getClass());
		
	}

		@Test
	public void iniciarCastilloDeUnJugadorCreaCastilloCorrectamente () throws PosicionFueraDelMapaError, PosicionOcupadaError, TamanioIncorrectoError {

		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();

		Jugador jugador = new Jugador(mapa);
		jugador.iniciarEdificios();

		for (int i = 1; i <= 4; i++){
			for (int j = 1; j <= 4; j++){
				Posicion posicion = new Posicion (i,j);
				assertEquals(Castillo.class, mapa.obtenerPosicionableEn(posicion).getClass());

			}
		}
	}
}