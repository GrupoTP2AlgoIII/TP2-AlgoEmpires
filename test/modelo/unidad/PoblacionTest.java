package modelo.unidad;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.jugador.JugadorSinOroException;
import modelo.jugador.JugadorSuperaTopePoblacionalException;
import modelo.jugador.PlazaCentralCrearAldeanoException;
import modelo.mapa.Mapa;

public class PoblacionTest {

	@Test
	public void test01CreoUnJugadorCon3AldeanosYAgregoTresAldeanosYGetPoblacionDevuelve6()  {
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
		
		assertEquals (6,jugador.getPoblacion());
		
	}
/*	PRUEBAS A CAMBIAR CUANDO ESTE IMPLEMENTADO EL PATRON DOUBLE DISPATCH PARA ATAQUES
	@Test
	public void test02CreoUnJugadorCon3AldeanosMatoAUnAldeanoYGetPoblacionDevuelve2() throws PosicionFueraDelMapaError, PosicionOcupadaError, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Espadachin espadachin = new Espadachin(5,5);
		Jugador jugador = new Jugador(mapa,"Pablo");
		Posicionable plaza = new PlazaCentral(1,1,2,2);
		
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
		
		//espadachin.atacar(aldeano2);
		//espadachin.atacar(aldeano2);
		
		jugador.atacar(posicionEspadachin,posicionAldeano);
		jugador.atacar(posicionEspadachin,posicionAldeano);

		jugador.actualizarPosicionables();
		
		assertEquals (5,jugador.getInventario().getPoblacion());		
	}
	
	@Test
	public void test03CreoUnJugadorCon3AldeanosMatoAUnAldeanoYGetProduccionOroDevuelve40() throws PosicionFueraDelMapaError, PosicionOcupadaError, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Espadachin espadachin = new Espadachin(5,5);
		Jugador jugador = new Jugador(mapa,"Pablo");
		Posicionable plaza = new PlazaCentral(1,1,2,2);
		
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
		
		assertEquals (100,jugador.getInventario().getProduccionOro());
	}
	
*/
	@Test(expected=JugadorSuperaTopePoblacionalException.class)
	public void test04CreoUnJugadorConMasDe50UnidadesYComoSuperaElTopePoblacionDevuelveException()  {
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Jugador jugador = new Jugador(mapa,"Pablo");
		Posicionable plaza = new PlazaCentral();
		
		//construccion plaza 3 turnos
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();

		plaza.posicionarEnFilaColumna(25,25);
		jugador.agregarPosicionableEnFilaColumna(plaza,25,25);
		
		jugador.crearAldeano(plaza.getPosicion());		//creo un aldeano para que produzca oro
		
		for(int i=0;i<100;i++)//produsco oro suficiente para crear mas de 50 aldeanos
			jugador.avanzarTurno();
		
		//jugador.getInventario().setPoblacion(50);
		while(1>0)
			jugador.crearAldeano(plaza.getPosicion());
			
	}
	
	@Test(expected=JugadorSinOroException.class)
	public void test05CreoUnJugadorYCreoAldeanosHastaQueArrojeException()  {
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Jugador jugador = new Jugador(mapa,"Pablo");
		Posicionable plaza = new PlazaCentral();
		
		//construccion plaza 3 turnos
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();

		plaza.posicionarEnFilaColumna(25,25);
		jugador.agregarPosicionableEnFilaColumna(plaza,25,25);
		
		while(1>0)//creo aldeanos hasta que el jugador se quede sin oro y arroje excepcion
		jugador.crearAldeano(plaza.getPosicion());
	}
	
	@Test(expected=PlazaCentralCrearAldeanoException.class)
	public void test06CreoUnCuartelYTratoDeCrearUnAldeanoDevuelveUnaException()  {
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
