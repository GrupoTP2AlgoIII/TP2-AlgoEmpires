package modelo.unidad.aldeano;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.Edificio;
import modelo.edificio.EdificioOcupadoException;
import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.jugador.PosicionOcupadaError;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.PosicionFueraDelMapaError;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.arquero.Arquero;

public class ConstruccionTest {

	int vidaCuartel = 450;
	int vidaCuartelDaniado = 400;
	
	@Test(expected=EdificioOcupadoException.class)
	public void test01CreoUnCuartelYComoEstaEnConstruccionCrearArqueroDevuelveException() {
		Cuartel cuartel = new Cuartel();
		
		cuartel.crearUnidad('A');
	}

	/*

	// ESTA CLASE DEPENDE DEL ATAQUE Y DEBERIA MODIFICARSE PARA OBTENER EL JUGADOR. LA DEJO PARA DESPUES
	
	@Test
	public void test02CreoUnCuartelYComoEstaConstruidoCrearArqueroDevuelveElArqueroCreadoYAtacarAldeanoLeResta15DeVida()  {
		Cuartel cuartel = new Cuartel();
		Posicionable aldeano = new Aldeano();
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Unidad arquero = cuartel.crearUnidad('A');
		
		arquero.atacar(aldeano);
		assertEquals (aldeano.getVida(),35);
		
	}
	*/


	@Test(expected=EdificioOcupadoException.class)
	public void test03CreoUnaPlazaCentralYComoEstaEnConstruccionCrearAldeanoDevuelveException() {
		PlazaCentral plaza = new PlazaCentral();
		
		plaza.crearUnidad('A');

	}
	
	@Test
	public void test04CreoUnaPlazaCentralYComoEstaConstruidaCrearAldeanoDevuelveElAdeanoCreadoYRepararCuartelDaniadoLoRepara()  {
		
		PlazaCentral plaza = new PlazaCentral();
		Edificio cuartel = new Cuartel(7,4,8,5);
		Arquero arquero = new Arquero(5,5);
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		arquero.atacar(cuartel,new Posicion (7,4));	//le resta 10 de vida
		
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		Aldeano aldeano = (Aldeano)plaza.crearUnidad('A');
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
	
	
		assertEquals (cuartel.getVida(),250);
	}
	
	@Test
	public void test05CreoUnAldeanoYComoEstaConstruyendoAvanzarTurnoDevuelveCero() {
		Aldeano aldeano = new Aldeano();
		aldeano.construir('C');
		int cero = 0;
		int oroGenerado = 0;
		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (cero,oroGenerado);
	}


	@Test
	public void test06CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador1YGetTurnosConstruccionDeCuartel1Devuelve2() throws PosicionOcupadaError, PosicionFueraDelMapaError{
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Jugador jugador1 = new Jugador(mapa,"Jorge");
		Jugador jugador2 = new Jugador(mapa,"Pablo");
			
		
		Posicionable aldeano1 = new Aldeano();
		Posicionable aldeano2 = new Aldeano();
		aldeano1.posicionarEnFilaColumna(15,15);
		aldeano2.posicionarEnFilaColumna(25,25);
		jugador1.agregarPosicionableEnFilaColumna(aldeano1, 15, 15);
		jugador2.agregarPosicionableEnFilaColumna(aldeano2, 25, 25);
		mapa.posicionarEnFilaColumna(aldeano1, 15, 15);
		mapa.posicionarEnFilaColumna(aldeano2, 25, 25);
		
		Posicion posicionAldeano = new Posicion(15,15);
		Posicion posicionConstruccion = new Posicion(16,16);

		jugador1.construirEdificioPropio(posicionAldeano,posicionConstruccion,'C');

		Edificio cuartel = (Edificio) mapa.obtenerPosicionableEn(posicionConstruccion);
		jugador1.avanzarTurno();
		
		assertEquals (2,(cuartel.getTurnosConstruccion()));
		
		posicionAldeano = new Posicion(25,25);
		posicionConstruccion = new Posicion(26,26);
		jugador2.construirEdificioPropio(posicionAldeano,posicionConstruccion,'C');
		Edificio cuartel2 = (Edificio) mapa.obtenerPosicionableEn(posicionConstruccion);
		
		assertEquals (3,(cuartel2.getTurnosConstruccion()));
			
	}


	@Test
	public void test07CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador2YGetTurnosConstruccionDeCuartel2Devuelve2() throws PosicionFueraDelMapaError, PosicionOcupadaError{
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Jugador jugador1 = new Jugador(mapa,"Jorge");
		Jugador jugador2 = new Jugador(mapa,"Pablo");
			
		
		Posicionable aldeano1 = new Aldeano();
		Posicionable aldeano2 = new Aldeano();
		aldeano1.posicionarEnFilaColumna(15,15);
		aldeano2.posicionarEnFilaColumna(5,5);
		jugador1.agregarPosicionableEnFilaColumna(aldeano1, 15, 15);
		jugador2.agregarPosicionableEnFilaColumna(aldeano2, 5, 5);
		mapa.posicionarEnFilaColumna(aldeano1, 15, 15);
		mapa.posicionarEnFilaColumna(aldeano2, 5, 5);
		
		Posicion posicionAldeano = new Posicion(15,15);
		Posicion posicionConstruccion = new Posicion(16,16);
				
		jugador1.construirEdificioPropio(posicionAldeano,posicionConstruccion,'C');
			
		Edificio cuartel = (Edificio) mapa.obtenerPosicionableEn(posicionConstruccion);
		jugador1.avanzarTurno();
		
		assertEquals (2,(cuartel.getTurnosConstruccion()));
		
		posicionAldeano = new Posicion(5,5);
		posicionConstruccion = new Posicion(6,6);
		jugador2.construirEdificioPropio(posicionAldeano,posicionConstruccion,'C');
		Edificio cuartel2 = (Edificio) mapa.obtenerPosicionableEn(posicionConstruccion);
		jugador2.avanzarTurno();
		
		assertEquals (2,(cuartel2.getTurnosConstruccion()));
	}

	
	@Test
	public void test08CreoUnAldeanoAvanzarTurnoDevuelve20() {
		Aldeano aldeano = new Aldeano();
		int oroGenerado = 0;
		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (20,oroGenerado);
	}

	@Test
	public void test09CreoUnAldeanoQueConstruyaUnaPlazaCentralYComoEstaConstruidaCreoUnAldeanoQueReparaUnCuartelDaniadoRestaurandoSuVidaA250()  {
		Aldeano aldeano = new Aldeano();
		Arquero arquero = new Arquero(5,5);
		PlazaCentral plaza = (PlazaCentral) aldeano.construir('P');
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		plaza.avanzarTurno();
		
		Aldeano otroAldeano = (Aldeano)plaza.crearUnidad('A');
		
		
		Edificio cuartelDaniado = new Cuartel(7,4,8,5);
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		arquero.atacar(cuartelDaniado, new Posicion (7,4));
		
		otroAldeano.reparar(cuartelDaniado);
		cuartelDaniado.avanzarTurno();
		
		assertEquals (250,cuartelDaniado.getVida());
		
	}
	
	
	@Test
	public void test10CreoUnAldeanoYComoTerminoDeRepararDevuelve20() {
		
		
		Aldeano aldeano = new Aldeano();
		Arquero arquero = new Arquero(5,5);
		Edificio cuartel = new Cuartel(7,4,8,5);
		int oroGenerado;
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		arquero.atacar(cuartel, new Posicion (7,4));
		aldeano.reparar(cuartel);
		aldeano.avanzarTurno();

		
		oroGenerado = aldeano.avanzarTurno();
	
		assertEquals (20,oroGenerado);
	}
	
	@Test
	public void test11CreoUnCuartelCon200DeVidaYComoEstaReparadoGetVidaDevuelve250() {
		
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = new Cuartel(7,4,8,5);
		Arquero arquero = new Arquero(5,5);
		
		cuartel.avanzarTurno();		//construccion cuartel - 3 turnos
		cuartel.avanzarTurno();	    //construccion cuartel - 3 turnos	
		cuartel.avanzarTurno();		//construccion cuartel - 3 turnos
		
		arquero.atacar(cuartel, new Posicion (7,4));
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
		
	
		assertEquals (250,cuartel.getVida());
	}
	
	@Test
	public void test12CreoUnAldeanoQueConstruyaUnCuartelYComoEstaConstruidoCreaUnArqueroQueAtacaUnAldeanoRestandole15DeVida() {
		Aldeano aldeano = new Aldeano();
		Cuartel cuartel = (Cuartel)aldeano.construir('C');	
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		Unidad arquero = cuartel.crearUnidad('A');
		arquero.atacar(aldeano, new Posicion (1,1));
		assertEquals (35,aldeano.getVida());
	}

	@Test
	public void test13CreoDosCuartelesConJugador1YJugador2YAvanzarTurnoJugador1YGetTurnosConstruccionDeCuartel2Devuelve3(){
		Mapa mapa = new Mapa();
		mapa.iniciarMapaVacio();
		Jugador jugador1 = new Jugador(mapa,"Jorge");
		Jugador jugador2 = new Jugador(mapa,"Pablo");
			
		
		Posicionable aldeano1 = new Aldeano();
		Posicionable aldeano2 = new Aldeano();
		aldeano1.posicionarEnFilaColumna(15,15);
		aldeano2.posicionarEnFilaColumna(5,5);
		jugador1.agregarPosicionableEnFilaColumna(aldeano1, 15, 15);
		jugador2.agregarPosicionableEnFilaColumna(aldeano2, 5, 5);
		mapa.posicionarEnFilaColumna(aldeano1, 15, 15);
		mapa.posicionarEnFilaColumna(aldeano2, 5, 5);
		
		Posicion posicionAldeano = new Posicion(15,15);
		Posicion posicionConstruccion = new Posicion(16,16);
				
		jugador1.construirEdificioPropio(posicionAldeano,posicionConstruccion,'C');
			
		Edificio cuartel = (Edificio) mapa.obtenerPosicionableEn(posicionConstruccion);
		jugador2.avanzarTurno();
		
		assertEquals (3,(cuartel.getTurnosConstruccion()));
		
	}
	
	@Test(expected=AldeanoOcupadoException.class)
	public void test14CreoUnAldeanoYComoEstaOcupadoConstruirCuartelDevuelveException() {
		Aldeano aldeano = new Aldeano();
		Edificio cuartelDaniado = new Cuartel(7,4,8,5);
		Arquero arquero = new Arquero(5,5);
		
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		cuartelDaniado.avanzarTurno();
		
		
		arquero.atacar(cuartelDaniado, new Posicion (7,4));
		aldeano.reparar(cuartelDaniado);
		aldeano.construir('C');
	}
	
	@Test(expected=AldeanoOcupadoException.class)
	public void test15CreoUnAldeanoYComoEstaOcupadoRepararCuartelDevuelveException()  {
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
		
		arquero.atacar(cuartelDaniado, new Posicion (7,4));
		arquero.atacar(otroCuartelDaniado, new Posicion (2,7));

		aldeano.reparar(cuartelDaniado);
		aldeano.reparar(otroCuartelDaniado);
	}
	
	@Test(expected=EdificioOcupadoException.class)
	public void test15CreoUnCuartelYComoEstaEnConstruccionRepararCuartelDevuelveException() {
		Aldeano aldeano = new Aldeano();
		Edificio cuartel = new Cuartel();
	
		aldeano.reparar(cuartel);
	}


}
