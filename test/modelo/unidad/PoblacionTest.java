package modelo.unidad;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorSinOroException;
import modelo.jugador.JugadorSuperaTopePoblacionalException;
import modelo.jugador.PlazaCentralCrearAldeanoException;
import modelo.jugador.PosicionOcupadaError;
import modelo.mapa.Mapa;
import modelo.unidad.espadachin.Espadachin;

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
	
	@Test
	public void test02CreoUnJugadorCon3AldeanosMatoAUnAldeanoYGetPoblacionDevuelve2() throws PosicionFueraDelMapaError, PosicionOcupadaError {
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Espadachin espadachin = new Espadachin();
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
		Posicionable aldeano2 = jugador.crearAldeano(plaza.getPosicion());
		jugador.crearAldeano(plaza.getPosicion());
		
		espadachin.atacar(aldeano2);
		espadachin.atacar(aldeano2);
		jugador.actualizarPosicionables();
		
		assertEquals (2,jugador.getPoblacion());		
	}
	
	@Test
	public void test03CreoUnJugadorCon3AldeanosMatoAUnAldeanoYGetProduccionOroDevuelve40() throws PosicionFueraDelMapaError, PosicionOcupadaError {
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Espadachin espadachin = new Espadachin();
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
		Posicionable aldeano2 = jugador.crearAldeano(plaza.getPosicion());
		jugador.crearAldeano(plaza.getPosicion());
		
		espadachin.atacar(aldeano2);
		espadachin.atacar(aldeano2);
		jugador.actualizarPosicionables();
		
		assertEquals (40,jugador.getProduccionOro());
	}
	
	@Test(expected=JugadorSuperaTopePoblacionalException.class)
	public void test04CreoUnJugadorConMasDe50UnidadesYComoSuperaElTopePoblacionDevuelveException() throws PosicionFueraDelMapaError, PosicionOcupadaError {
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
		
		jugador.setPoblacion(50);
		jugador.crearAldeano(plaza.getPosicion());
			
	}
	
	@Test(expected=JugadorSinOroException.class)
	public void test05CreoUnJugadorSinOroYAlCrearUnAldeanoDevuelveException() throws PosicionFueraDelMapaError, PosicionOcupadaError {
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
		
		jugador.setOro(0);
		jugador.crearAldeano(plaza.getPosicion());
	}
	
	@Test(expected=PlazaCentralCrearAldeanoException.class)
	public void test06CreoUnCuartelYTratoDeCrearUnAldeanoDevuelveUnaException() throws PosicionFueraDelMapaError, PosicionOcupadaError {
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Jugador jugador = new Jugador(mapa,"Pablo");
		Posicionable cuartel = new Cuartel();
		
		//construccion plaza 3 turnos
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();

		cuartel.posicionarEnFilaColumna(1,1);
		jugador.agregarPosicionableEnFilaColumna(cuartel,1,1);
		
		jugador.crearAldeano(cuartel.getPosicion());
	}


}
