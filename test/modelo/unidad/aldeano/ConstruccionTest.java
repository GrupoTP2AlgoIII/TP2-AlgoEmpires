package modelo.unidad.aldeano;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.Edificio;
import modelo.edificio.EdificioOcupadoException;
import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;

public class ConstruccionTest {

	int vidaCuartel = 450;
	int vidaCuartelDaniado = 400;
	
	@Test(expected=EdificioOcupadoException.class)
	public void test01CreoUnCuartelYComoEstaEnConstruccionCrearArqueroDevuelveException() throws EdificioOcupadoException {
		Cuartel cuartel = new Cuartel();
		
		Unidad arquero = cuartel.crearArquero();
	}
	
	@Test
	public void test02CreoUnCuartelYComoEstaConstruidoCrearArqueroDevuelveElArqueroCreadoYAtacarAldeanoLeResta15DeVida() {
		Cuartel cuartel = new Cuartel();
		Posicionable aldeano = new Aldeano();
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Unidad arquero = cuartel.crearArquero();
		
		arquero.atacar(aldeano);
		assertEquals (aldeano.getVida(),35);
		
	}
	
	@Test(expected=EdificioOcupadoException.class)
	public void test03CreoUnaPlazaCentralYComoEstaEnConstruccionCrearAldeanoDevuelveException() throws EdificioOcupadoException {
		PlazaCentral plaza = new PlazaCentral();
		
		Unidad aldeano = plaza.crearAldeano();

	}
	
	@Test
	public void test04CreoUnaPlazaCentralYComoEstaConstruidaCrearAldeanoDevuelveElAdeanoCreadoYRepararCuartelDaniadoLoRepara() {
		
		PlazaCentral plaza = new PlazaCentral();
		Edificio cuartel = new Cuartel();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		cuartel.restarVida(50);
		
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		Aldeano aldeano = (Aldeano)plaza.crearAldeano();
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
	
	
		assertEquals (cuartel.getVida(),250);
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
		
		Edificio cuartel1 = jugador1.construirCuartel(1,1);
		Edificio cuartel2 = jugador2.construirCuartel(1,1);
		
		jugador1.avanzarTurno();
		
		assertEquals (2,(cuartel1.getTurnosConstruccion()));
			
	}

	@Test
	public void test07CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador2YGetTurnosConstruccionDeCuartel2Devuelve2(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		Edificio cuartel1 = jugador1.construirCuartel(1,1);
		Edificio cuartel2 = jugador2.construirCuartel(1,1);
		
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
	public void test09CreoUnAldeanoQueConstruyaUnaPlazaCentralYComoEstaConstruidaCreoUnAldeanoQueReparaUnCuartelDaniadoRestaurandoSuVidaA250() {
		Aldeano aldeano = new Aldeano();
		PlazaCentral plaza = (PlazaCentral) aldeano.construirPlazaCentral();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		Aldeano otroAldeano = (Aldeano)plaza.crearAldeano();
		
		
		Edificio cuartelDaniado = new Cuartel();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.restarVida(50);
		
		otroAldeano.reparar(cuartelDaniado);
		cuartelDaniado.avanzarTurno();
		
		assertEquals (250,cuartelDaniado.getVida());
		
	}
	
	
	@Test
	public void test10CreoUnAldeanoYComoTerminoDeRepararDevuelve20() {
		
		
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = new Cuartel();
		int oroGenerado;
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		cuartel.restarVida(50);
		aldeano.reparar(cuartel);
		aldeano.avanzarTurno();

		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (20,oroGenerado);
	}
	
	@Test
	public void test11CreoUnCuartelCon200DeVidaYComoEstaReparadoGetVidaDevuelve250() {
		
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = new Cuartel();
		
		cuartel.avanzarTurno();		//construccion cuartel - 3 turnos
		cuartel.avanzarTurno();	    //construccion cuartel - 3 turnos	
		cuartel.avanzarTurno();		//construccion cuartel - 3 turnos
		
		cuartel.restarVida(50);
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
		
	
		assertEquals (250,cuartel.getVida());
	}
	
	@Test
	public void test12CreoUnAldeanoQueConstruyaUnCuartelYComoEstaConstruidoCreaUnArqueroQueAtacaUnAldeanoRestandole15DeVida() {
		Aldeano aldeano = new Aldeano();
		Cuartel cuartel = (Cuartel)aldeano.construirCuartel();	
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Unidad arquero = cuartel.crearArquero();
		arquero.atacar(aldeano);
		assertEquals (35,aldeano.getVida());
	}
	
	@Test
	public void test13CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador1YGetTurnosConstruccionDeCuartel2Devuelve3(){
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		Edificio cuartel1 = jugador1.construirCuartel(1,1);
		Edificio cuartel2 = jugador2.construirCuartel(1,1);
		
		jugador1.avanzarTurno();
		
		assertEquals (3,cuartel2.getTurnosConstruccion());
	}
	
	@Test(expected=AldeanoOcupadoException.class)
	public void test14CreoUnAldeanoYComoEstaOcupadoConstruirCuartelDevuelveException() throws AldeanoOcupadoException {
		Aldeano aldeano = new Aldeano();
		Edificio cuartelDaniado = new Cuartel();
		
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		
		cuartelDaniado.restarVida(50);
		aldeano.reparar(cuartelDaniado);
		aldeano.construirCuartel();
	}
	
	@Test(expected=AldeanoOcupadoException.class)
	public void test15CreoUnAldeanoYComoEstaOcupadoRepararCuartelDevuelveException() throws AldeanoOcupadoException {
		Aldeano aldeano = new Aldeano();
		Edificio cuartelDaniado = new Cuartel();
		Edificio otroCuartelDaniado = new Cuartel();
		
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		otroCuartelDaniado.avanzarTurno();
		otroCuartelDaniado.avanzarTurno();
		otroCuartelDaniado.avanzarTurno();
		
		cuartelDaniado.restarVida(50);
		otroCuartelDaniado.restarVida(50);
		aldeano.reparar(cuartelDaniado);
		aldeano.reparar(otroCuartelDaniado);
	}
	
	@Test(expected=EdificioOcupadoException.class)
	public void test15CreoUnCuartelYComoEstaEnConstruccionRepararCuartelDevuelveException() throws EdificioOcupadoException {
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = new Cuartel();
	
		aldeano.reparar(cuartel);
	}


}
