package modelo.unidad;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.unidad.aldeano.Aldeano;

public class ConstruccionTest {

	@Test
	public void test01CreoUnCuartelYComoEstaEnConstruccionCrearArqueroDevuelveFalse() {
		Cuartel cuartel = new Cuartel();
		
		boolean retorno = cuartel.crearArquero();

		
		assertEquals (false,retorno);
	}
	
	@Test
	public void test02CreoUnCuartelYComoEstaConstruidoCrearArqueroDevuelveTrue() {
		Cuartel cuartel = new Cuartel();
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		boolean retorno = cuartel.crearArquero();
	
		assertEquals (true,retorno);
	}
	
	@Test
	public void test03CreoUnaPlazaCentralYComoEstaEnConstruccionCrearAldeanoDevuelveFalse() {
		PlazaCentral plaza = new PlazaCentral();
		
		
		boolean retorno = plaza.crearAldeano();
	
		assertEquals (false,retorno);
	}
	
	@Test
	public void test04CreoUnaPlazaCentralYComoEstaConstruidaCrearAldeanoDevuelveTrue() {
		PlazaCentral plaza = new PlazaCentral();
		
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		boolean retorno = plaza.crearAldeano();
	
		assertEquals (true,retorno);
	}
	
	@Test
	public void test05CreoUnAldeanoYComoEstaConstruyendoAvanzarTurnoDevuelveCero() {
		Aldeano aldeano = new Aldeano();
		Cuartel cuartel = aldeano.construirCuartel();
		int cero = 0;
		int oroGenerado = 0;
		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (cero,oroGenerado);
	}
	
	@Test
	public void test06CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador1YGetTurnosConstruccionDeCuartel1Devuelve2(){
		Jugador jugadorActual = new Jugador();
		
		Cuartel cuartel1 = jugadorActual.construirCuartel();
		jugadorActual.avanzarTurno();
		Cuartel cuartel2 = jugadorActual.construirCuartel();
		
		assertEquals (2,cuartel1.getTurnosConstruccion());
			
	}
	
	@Test
	public void test06CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador1YGetTurnosConstruccionDeCuartel2Devuelve3(){
		Jugador jugadorActual = new Jugador();
		
		Cuartel cuartel1;
		Cuartel cuartel2;
		
		cuartel1 = jugadorActual.construirCuartel();
		jugadorActual.avanzarTurno();
		cuartel2 = jugadorActual.construirCuartel();
		
		assertEquals (3,cuartel2.getTurnosConstruccion());
	}
	

	@Test
	public void test07CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador2YGetTurnosConstruccionDeCuartel2Devuelve2(){
		Jugador jugadorActual = new Jugador();
		
		Cuartel cuartel1;
		Cuartel cuartel2;
		
		cuartel1 = jugadorActual.construirCuartel();
		jugadorActual.avanzarTurno();
		cuartel2 = jugadorActual.construirCuartel();
		jugadorActual.avanzarTurno();
		
		assertEquals (2,cuartel2.getTurnosConstruccion());
	}
	
	@Test
	public void test08CreoUnAldeanoAvanzarTurnoDevuelve20() {
		Aldeano aldeano = new Aldeano();
		int oroGenerado = 0;
		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (20,oroGenerado);
	}


}
