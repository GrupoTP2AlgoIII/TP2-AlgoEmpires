package modelo.unidad.aldeano;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.Edificio;
import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;

public class ConstruccionTest {

	int vidaCuartel = 450;
	int vidaCuartelDaniado = 400;
	
	@Test
	public void test01CreoUnCuartelYComoEstaEnConstruccionCrearArqueroDevuelveFalse() {
		Cuartel cuartel = new Cuartel(vidaCuartel);
		
		Unidad arquero = cuartel.crearArquero();
		boolean retorno = false;
		if(arquero != null) {
			retorno = true;
		}	
		assertEquals (false,retorno);
	}
	
	@Test
	public void test02CreoUnCuartelYComoEstaConstruidoCrearArqueroDevuelveTrue() {
		Cuartel cuartel = new Cuartel(vidaCuartel);
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Unidad arquero = cuartel.crearArquero();
		boolean retorno = false;
		if(arquero != null) {
			retorno = true;
		}	
	
		assertEquals (true,retorno);
	}
	
	@Test
	public void test03CreoUnaPlazaCentralYComoEstaEnConstruccionCrearAldeanoDevuelveFalse() {
		PlazaCentral plaza = new PlazaCentral();
		
		
		Unidad aldeano = plaza.crearAldeano();
		boolean retorno = false;
		if(aldeano != null) {
			retorno = true;
		}	
	
		assertEquals (false,retorno);
	}
	
	@Test
	public void test04CreoUnaPlazaCentralYComoEstaConstruidaCrearAldeanoDevuelveTrue() {
		
		PlazaCentral plaza = new PlazaCentral();
		
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		Unidad aldeano = plaza.crearAldeano();
		boolean retorno = false;
		if(aldeano != null) {
			retorno = true;
		}	
	
	
		assertEquals (true,retorno);
	}
	
	@Test
	public void test05CreoUnAldeanoYComoEstaConstruyendoAvanzarTurnoDevuelveCero() {
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = aldeano.construirCuartel();
		int cero = 0;
		int oroGenerado = 0;
		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (cero,oroGenerado);
	}
	
	@Test
	public void test06CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador1YGetTurnosConstruccionDeCuartel1Devuelve2(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		Edificio cuartel1 = jugador1.construirCuartel();
		Edificio cuartel2 = jugador2.construirCuartel();
		
		jugador1.avanzarTurno();
		
		assertEquals (2,(cuartel1.getTurnosConstruccion()));
			
	}

	@Test
	public void test06CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador1YGetTurnosConstruccionDeCuartel2Devuelve3(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		Edificio cuartel1 = jugador1.construirCuartel();
		Edificio cuartel2 = jugador2.construirCuartel();
		
		jugador1.avanzarTurno();
		
		assertEquals (3,cuartel2.getTurnosConstruccion());
	}
	

	@Test
	public void test07CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador2YGetTurnosConstruccionDeCuartel2Devuelve2(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		Edificio cuartel1 = jugador1.construirCuartel();
		Edificio cuartel2 = jugador2.construirCuartel();
		
		jugador2.avanzarTurno();
		
		assertEquals (2,cuartel2.getTurnosConstruccion());
	}
	
	@Test
	public void test08CreoUnAldeanoAvanzarTurnoDevuelve20() {
		Aldeano aldeano = new Aldeano();
		int oroGenerado = 0;
		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (20,oroGenerado);
	}

	@Test
	public void test09CreoUnAldeanoYContruirPlazaCentralDevuelvePlazaCentral() {
		Aldeano aldeano = new Aldeano();
		Edificio plaza = aldeano.construirPlazaCentral();
		boolean valorEsperado = false;
		
		if(plaza != null) {
			valorEsperado = true;
		}
		
		assertEquals (true,valorEsperado);
	}
	
	
	@Test
	public void test10CreoUnAldeanoYComoTerminoDeRepararDevuelve20() {
		
		
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = new Cuartel(vidaCuartelDaniado);
		int oroGenerado;
		
		aldeano.reparar(cuartel);
		aldeano.avanzarTurno();
		aldeano.avanzarTurno();
		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (20,oroGenerado);
	}
	
	@Test
	public void test11CreoUnCuartelCon400DeVidaYComoEstaReparadoGetVidaDevuelve450() {
		
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = new Cuartel(vidaCuartelDaniado);
		
		cuartel.avanzarTurno();		//construccion cuartel - 3 turnos
		cuartel.avanzarTurno();	    //construccion cuartel - 3 turnos	
		cuartel.avanzarTurno();		//construccion cuartel - 3 turnos
		
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
	
		assertEquals (450,cuartel.getVida());
	}
	
	@Test
	public void test12CreoUnAldeanoYContruirCuartelDevuelveCuartel() {
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = aldeano.construirCuartel();
		boolean valorEsperado = false;
		
		if(cuartel != null) {
			valorEsperado = true;
		}
		
		assertEquals (true,valorEsperado);
	}
	


}
