package modelo.unidad.aldeano;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ataque.ArmaDeAsedioDesmontadaNoPuedeAtacarError;
import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.edificio.Edificio;
import modelo.edificio.EdificioOcupadoException;
import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.arquero.Arquero;

public class ConstruccionTest {

	int vidaCuartel = 450;
	int vidaCuartelDaniado = 400;
	
	@Test(expected=EdificioOcupadoException.class)
	public void test01CreoUnCuartelYComoEstaEnConstruccionCrearArqueroDevuelveException() throws EdificioOcupadoException {
		Cuartel cuartel = new Cuartel();
		
		cuartel.crearArquero();
	}
	
	@Test
	public void test02CreoUnCuartelYComoEstaConstruidoCrearArqueroDevuelveElArqueroCreadoYAtacarAldeanoLeResta15DeVida() throws AldeanoNoPuedeAtacarError, AtacandoEnPosicionFueraDelAlcanceError, ArmaDeAsedioDesmontadaNoPuedeAtacarError {
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
		
		plaza.crearAldeano();

	}
	
	@Test
	public void test04CreoUnaPlazaCentralYComoEstaConstruidaCrearAldeanoDevuelveElAdeanoCreadoYRepararCuartelDaniadoLoRepara() throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		PlazaCentral plaza = new PlazaCentral();
		Edificio cuartel = new Cuartel(7,4,8,5);
		Arquero arquero = new Arquero(5,5);
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		arquero.atacar(cuartel);	//le resta 10 de vida
		
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
		aldeano.construirCuartel();
		int cero = 0;
		int oroGenerado = 0;
		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (cero,oroGenerado);
	}
	
	@Test
	public void test06CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador1YGetTurnosConstruccionDeCuartel1Devuelve2(){
		Jugador jugador1 = new Jugador(new Mapa(),"Jorge");
		Jugador jugador2 = new Jugador(new Mapa(),"Jorge");
		
		Edificio cuartel1 = jugador1.construirCuartel(1,1);
		jugador2.construirCuartel(1,1);
		
		jugador1.avanzarTurno();
		
		assertEquals (2,(cuartel1.getTurnosConstruccion()));
			
	}

	@Test
	public void test07CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador2YGetTurnosConstruccionDeCuartel2Devuelve2(){
		Jugador jugador1 = new Jugador(new Mapa(),"Jorge");
		Jugador jugador2 = new Jugador(new Mapa(),"Jorge");
		
		jugador1.construirCuartel(1,1);
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
	public void test09CreoUnAldeanoQueConstruyaUnaPlazaCentralYComoEstaConstruidaCreoUnAldeanoQueReparaUnCuartelDaniadoRestaurandoSuVidaA250() throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		Aldeano aldeano = new Aldeano();
		Arquero arquero = new Arquero(5,5);
		PlazaCentral plaza = (PlazaCentral) aldeano.construirPlazaCentral();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		Aldeano otroAldeano = (Aldeano)plaza.crearAldeano();
		
		
		Edificio cuartelDaniado = new Cuartel(7,4,8,5);
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		arquero.atacar(cuartelDaniado);
		
		otroAldeano.reparar(cuartelDaniado);
		cuartelDaniado.avanzarTurno();
		
		assertEquals (250,cuartelDaniado.getVida());
		
	}
	
	
	@Test
	public void test10CreoUnAldeanoYComoTerminoDeRepararDevuelve20() throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		
		Aldeano aldeano = new Aldeano();
		Arquero arquero = new Arquero(5,5);
		Edificio cuartel = new Cuartel(7,4,8,5);
		int oroGenerado;
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		arquero.atacar(cuartel);
		aldeano.reparar(cuartel);
		aldeano.avanzarTurno();

		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (20,oroGenerado);
	}
	
	@Test
	public void test11CreoUnCuartelCon200DeVidaYComoEstaReparadoGetVidaDevuelve250() throws AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = new Cuartel(7,4,8,5);
		Arquero arquero = new Arquero(5,5);
		
		cuartel.avanzarTurno();		//construccion cuartel - 3 turnos
		cuartel.avanzarTurno();	    //construccion cuartel - 3 turnos	
		cuartel.avanzarTurno();		//construccion cuartel - 3 turnos
		
		arquero.atacar(cuartel);
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
		
	
		assertEquals (250,cuartel.getVida());
	}
	
	@Test
	public void test12CreoUnAldeanoQueConstruyaUnCuartelYComoEstaConstruidoCreaUnArqueroQueAtacaUnAldeanoRestandole15DeVida() throws AldeanoNoPuedeAtacarError, AtacandoEnPosicionFueraDelAlcanceError, ArmaDeAsedioDesmontadaNoPuedeAtacarError {
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
		Jugador jugador1 = new Jugador(new Mapa(),"Jorge");
		Jugador jugador2 = new Jugador(new Mapa(),"Jorge");
		
		jugador1.construirCuartel(1,1);
		Edificio cuartel2 = jugador2.construirCuartel(1,1);
		
		jugador1.avanzarTurno();
		
		assertEquals (3,cuartel2.getTurnosConstruccion());
	}
	
	@Test(expected=AldeanoOcupadoException.class)
	public void test14CreoUnAldeanoYComoEstaOcupadoConstruirCuartelDevuelveException() throws AldeanoOcupadoException, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		Aldeano aldeano = new Aldeano();
		Edificio cuartelDaniado = new Cuartel(7,4,8,5);
		Arquero arquero = new Arquero(5,5);
		
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		
		
		arquero.atacar(cuartelDaniado);
		aldeano.reparar(cuartelDaniado);
		aldeano.construirCuartel();
	}
	
	@Test(expected=AldeanoOcupadoException.class)
	public void test15CreoUnAldeanoYComoEstaOcupadoRepararCuartelDevuelveException() throws AldeanoOcupadoException, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
		Aldeano aldeano = new Aldeano();
		Edificio cuartelDaniado = new Cuartel(7,4,8,5);
		Edificio otroCuartelDaniado = new Cuartel(2,7,3,8);
		Arquero arquero = new Arquero(5,5);
		
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		otroCuartelDaniado.avanzarTurno();
		otroCuartelDaniado.avanzarTurno();
		otroCuartelDaniado.avanzarTurno();
		
		arquero.atacar(cuartelDaniado);
		arquero.atacar(otroCuartelDaniado);

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
