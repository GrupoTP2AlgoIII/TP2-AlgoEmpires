package modelo.unidad;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.jugador.PosicionOcupadaError;
import modelo.mapa.Mapa;

public class PoblacionTest {

	@Test
	public void test01CreoUnJugadorYAgregoTresAldeanosYGetPoblacionDevuelve3() throws PosicionFueraDelMapaError, PosicionOcupadaError {
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Jugador jugador = new Jugador(mapa,"Pablo");
		Posicionable plaza = new PlazaCentral();
		
		//construccion plaza 3 turnos
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();

		plaza.posicionarEnFilaColumna(1,1);
		jugador.agregarPosicionableEnFilaColumna(plaza,1,1);
		
		//creo 3 aldeanos
		jugador.crearAldeano(plaza.getPosicion());
		jugador.crearAldeano(plaza.getPosicion());
		jugador.crearAldeano(plaza.getPosicion());
		
		assertEquals (3,jugador.getPoblacion());
		
	}

}
