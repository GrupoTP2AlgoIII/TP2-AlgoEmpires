package modelo.ataque;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.cuartel.Cuartel;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.armaDeAsedio.ArmaDeAsedio;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioDesmontadaException;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioDesmontandoseException;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontadaException;
import modelo.unidad.armaDeAsedio.ArmaDeAsedioMontandoseException;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

public class AtaqueTest {

	@Test
	public void test01AtacarUnaUnidadDentroDelRangoDeAlcance () {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		Arquero arquero = new Arquero (5, 5, primerJugador);
		Espadachin espadachin = new Espadachin (7,7, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arquero, 5, 5);
		segundoJugador.agregarPosicionableEnFilaColumna (espadachin, 7, 7);
		arquero.atacar(espadachin, new Posicion (7,7));
		
		//el espadachin inicia con vida = 100
		//el ataque del arquero le resta 15 a la vida del espadachin
		assertEquals (espadachin.getVida(), 85);
		
	}

	@Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
	public void test02AtacarUnaUnidadFueraDelRangoDeAlcanceLanzaExcepcion () {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		Arquero arquero = new Arquero (5, 5, primerJugador);
		Espadachin espadachin = new Espadachin (15,15, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arquero, 5, 5);
		segundoJugador.agregarPosicionableEnFilaColumna (espadachin, 15, 15);

		arquero.atacar(espadachin, new Posicion (15,15));
		
	}
	
	@Test(expected = AtacandoEnPosicionFueraDelAlcanceError.class) 
	public void test03ArmaDeAsedioAtacaAUnArqueroFueraDelRangoDeAlcanceLanzaExcepcion () {
		
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		Arquero arquero = new Arquero (40, 40, primerJugador);
		ArmaDeAsedio arma = new ArmaDeAsedio (5,5, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arquero, 5, 5);
		segundoJugador.agregarPosicionableEnFilaColumna (arma, 7, 7);
		
		arma.montar();
		arma.avanzarTurno();

		arma.atacar(arquero);
		
	}

	@Test
	public void test04ArqueroAtacaACuartelYTodoElCuartelPerteneceAlRangoDeAlcanceDelArquero ()  {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		Arquero arquero = new Arquero (5, 5, primerJugador);
		Cuartel cuartel = new Cuartel (7,4, 8, 5, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arquero, 5, 5);
		segundoJugador.agregarPosicionableEnFilaColumna (cuartel, 7, 4);
		
		arquero.atacar(cuartel, new Posicion (7,4));
		
		//el cuartel inicialmente tiene 240 de vida
		//el arquero le resta 10 de vida
		assertEquals (cuartel.getVida(), 240);
	}
	
	@Test
	public void test05EspadachinAtacaAPlazaCentralQueSoloDosPosicionesPertenecesAlRangoDeAlcanceDelEspadachin () {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		Espadachin espadachin = new Espadachin (5, 5, primerJugador);
		PlazaCentral plazaCentral = new PlazaCentral (5, 6, 6, 7, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(espadachin, 5, 5);
		segundoJugador.agregarPosicionableEnFilaColumna (plazaCentral, 5, 6);
		
		espadachin.atacar(plazaCentral, new Posicion (5,6));
		
		//la plaza inicia con vida = 450
		//espadachin resta 15 de vida
		assertEquals (plazaCentral.getVida(), 435);
	}

	@Test (expected = AtacandoEnPosicionFueraDelAlcanceError.class)
	public void test06ArqueroAtacaAPlazaCentralFueraDelRangoDeAlcance ()  {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		Arquero arquero = new Arquero (5, 5, primerJugador);
		PlazaCentral plazaCentral = new PlazaCentral (10, 4, 11, 5, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arquero, 5, 5);
		segundoJugador.agregarPosicionableEnFilaColumna (plazaCentral, 10, 4);
		

		arquero.atacar(plazaCentral, new Posicion (10,4));
	}
	
	@Test (expected = ArmaDeAsedioDesmontadaException.class)
	public void test08AtacarConArmaDeAsedioDesmontadaDebeLanzarExcepcion ()  {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		ArmaDeAsedio arma = new ArmaDeAsedio (6, 8, primerJugador);
		Cuartel cuartel = new Cuartel (5, 5, 6, 6, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 6, 8);
		segundoJugador.agregarPosicionableEnFilaColumna (cuartel, 5, 5);
		
		//el arma inicia desmontada
		arma.atacar(cuartel, new Posicion (5,5));
	}
	
	@Test (expected = ArmaDeAsedioMontandoseException.class)
	public void test09MontarArmaDeAsedioYAtacarEnElMismoTurnoDebeLanzarExcepcion () {
	
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		ArmaDeAsedio arma = new ArmaDeAsedio (6, 8, primerJugador);
		Cuartel cuartel = new Cuartel (5, 5, 6, 6, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 6, 8);
		segundoJugador.agregarPosicionableEnFilaColumna (cuartel, 5, 5);
		
		arma.montar ();
		arma.atacar(cuartel, new Posicion (5,5));
	}
	
	@Test
	public void test10MoverArmaDeAsedioDesmontadaHaciaLaDerecha () {
		
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		arma.avanzarTurno();
		//arma desmontada
		arma.desplazarHasta(new Posicion (6,9));
		assertEquals (arma.getPosicion().getFila(),6);
		assertEquals (arma.getPosicion().getColumna(),9);
	
	}
	
	@Test (expected = ArmaDeAsedioMontadaException.class)
	public void test11MoverArmaDeAsedioMontadaHaciaDebeLanzarExcepcion () {
		
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		arma.montar();
		arma.avanzarTurno();
		arma.desplazarHasta(new Posicion (6,9));
		
	}
	
	@Test (expected = ArmaDeAsedioDesmontandoseException.class)
	public void test12MoverArmaDeAsedioDesmontandoseHaciaDebeLanzarExcepcion () {
		
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		arma.montar();
		arma.avanzarTurno();
		arma.desarmar();
		arma.desplazarHasta(new Posicion (6,9));
		
	}
	
	@Test (expected = ArmaDeAsedioDesmontandoseException.class)
	public void test13AtacarConArmaDeAsedioDesmontandoseDebeLanzarExcepcion () {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		ArmaDeAsedio arma = new ArmaDeAsedio (6, 8, primerJugador);
		Cuartel cuartel = new Cuartel (5, 5, 6, 6, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 6, 8);
		segundoJugador.agregarPosicionableEnFilaColumna (cuartel, 5, 5);
		
		arma.montar();
		arma.avanzarTurno();
		arma.desarmar();
		arma.atacar(cuartel, new Posicion (5,5));
		
	}

	@Test
	public void test14MoverArmaDeAsedioLuegoDeDesmontarla() {
		
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		arma.montar();
		arma.avanzarTurno();
		arma.desarmar();
		arma.avanzarTurno();
		arma.desplazarHasta(new Posicion(6,9));
		assertEquals (arma.getPosicion().getFila(),6);
		assertEquals (arma.getPosicion().getColumna(),9);

		
	}
	
	@Test (expected = ArmaDeAsedioMontandoseException.class)
	public void test15MoverArmaDeAsedioMontandoseHaciaDebeLanzarExcepcion() {
		
		ArmaDeAsedio arma = new ArmaDeAsedio (6,8);
		arma.montar();
		arma.desplazarHasta(new Posicion(6,9));
		
	}
	
	@Test 
	public void test16AtacarConArmaDeAsedioMontada() {
		
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "Lucas", "Juan");
		Jugador segundoJugador = new Jugador (mapa, "Juan", "Lucas");
		ArmaDeAsedio arma = new ArmaDeAsedio (6, 8, primerJugador);
		Cuartel cuartel = new Cuartel (10, 10, 11, 11, segundoJugador);
		primerJugador.agregarPosicionableEnFilaColumna(arma, 6, 8);
		segundoJugador.agregarPosicionableEnFilaColumna (cuartel, 11, 11);
		
		arma.montar();
		arma.avanzarTurno();
		arma.atacar(cuartel, new Posicion (11,11));
		
		assertEquals (cuartel.getVida(),175);
		
		
	}
	
}
