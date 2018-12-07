package modelo.juego;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.edificio.Edificio;
import modelo.edificio.cuartel.Cuartel;
import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;

public class JuegoTest {

	@Test // Como son inicializados sin estar ocupados devuelven 20 de oro
	public void test01IniciarJuegoInicializaAldeanosJugador1()  {
		
		Juego juego = new Juego("Pedro", "Maria");

		for (int i = 6; i <= 8; i++) {
			Posicion posicion = new Posicion (8, i);
			assertEquals(20, juego.obtenerPosicionableEn(posicion).avanzarTurno());
		}
		
	}
	
	@Test
	public void test02IniciarJuegoInicializaAldeanosJugador2()  {
		
		Juego juego = new Juego("Pedro", "Maria");
		
		for (int j = 43; j <= 45; j++) {
			Posicion posicion = new Posicion (43, j);
			assertEquals(20, juego.obtenerPosicionableEn(posicion).avanzarTurno());
		}
	}
	
	@Test
	public void test03IniciarJuegoInicializaCastilloJugador1() {
		
		Juego juego = new Juego("Pedro", "Maria");
		Posicion posicionCastillo = new Posicion (4,4);
		juego.crearUnidadPropia(posicionCastillo, 'A');
		
		
		Unidad armaAsedio = (Unidad)juego.obtenerPosicionableEn(new Posicion (5,8));
		
		assertEquals(150, armaAsedio.getVida());		

	}
	
	@Test
	public void test04IniciarJuegoInicializaCastilloJugador2() {
		
		Juego juego = new Juego("Pedro", "Maria");
		juego.avanzarTurno();
		Posicion posicionCastillo = new Posicion (44,44);
		juego.crearUnidadPropia(posicionCastillo, 'A');
		Unidad armaAsedio = (Unidad)juego.obtenerPosicionableEn(new Posicion (45,48));
		
		assertEquals(150, armaAsedio.getVida());
	}
	
	@Test
	public void test05IniciarJuegoInicializaPlazaCentralJugador1() {
		
		Juego juego = new Juego("Pedro", "Maria");

		Posicion posicionPlaza = new Posicion (9,7);
		Posicion posicionAldeano = new Posicion (8,6);
		juego.crearEdificioPropio(posicionAldeano, posicionPlaza, 'P');
		juego.avanzarTurno();
		juego.avanzarTurno();
		juego.avanzarTurno();
		juego.avanzarTurno();
		
		juego.crearUnidadPropia(posicionPlaza, 'A');
		Unidad aldeanoCreado = (Unidad)juego.obtenerPosicionableEn(new Posicion (10,9));
		
		assertEquals(50, aldeanoCreado.getVida());
		
	}
	
	@Test
	public void test06IniciarJuegoInicializaPlazaCentralJugador2() {
		
		Juego juego = new Juego("Pedro", "Maria");
		
		Posicion posicionPlaza = new Posicion (2,8);
		
		juego.crearUnidadPropia(posicionPlaza, 'A');
		Aldeano aldeano = (Aldeano) juego.obtenerPosicionableEn(new Posicion (3,8));
		
		assertEquals(50, aldeano.getVida());
		
	}
	
	@Test //Verifica que no hay que pasar de turno para crear aldeano
	public void test07IniciarJuegoInicializaPlazaCentralConstruidaJugador1()  {
		
		Juego juego = new Juego("Pedro", "Maria");
		//juega pedro
		Posicion posicionAldeanoJugador1 = new Posicion (8,6);
		Posicion posicionCuartelJugador1 = new Posicion (9,7);
		juego.crearEdificioPropio(posicionAldeanoJugador1, posicionCuartelJugador1, 'C');
		juego.avanzarTurno();
		//juega maria
		Posicion posicionAldeanoJugador2 = new Posicion (43,43);
		Posicion posicionCuartelJugador2 = new Posicion (44,44);
		juego.crearEdificioPropio(posicionAldeanoJugador2, posicionCuartelJugador2, 'C');
		juego.avanzarTurno();
		//juega pedro
		juego.avanzarTurno();
		//juega maria
		juego.avanzarTurno();
		//juega pedro
		juego.crearUnidadPropia(posicionCuartelJugador1, 'A');
		juego.avanzarTurno();
		//juega maria
		juego.avanzarTurno();
		//juega Pedro
				
		Posicion posicionPlazaJugador1 = new Posicion (2,9);
		juego.crearUnidadPropia(posicionPlazaJugador1, 'A');
	
		Aldeano aldeano = (Aldeano)juego.obtenerPosicionableEn(new Posicion (3,9));
		
		Cuartel cuartelJugador1 = (Cuartel)juego.obtenerPosicionableEn(posicionCuartelJugador1);
		
		aldeano.reparar(cuartelJugador1);
		cuartelJugador1.avanzarTurno();
		
		assertEquals(250, cuartelJugador1.getVida());	// el aldeano creado reparo el cuartel
		
	}

	@Test 
	public void test08IniciarJuegoInicializaPlazaCentralConstruidaJugador2() {
		
		
		Juego juego = new Juego("Pedro", "Maria");
		
		//juega Pedro
		Posicion posicionUnAldeanoJugador1 = new Posicion (8, 6);
		Posicion posicionCuartelJugador1 = new Posicion (9, 7);
		juego.crearEdificioPropio(posicionUnAldeanoJugador1, posicionCuartelJugador1, 'C');
		
		juego.avanzarTurno();
		
		//juega Maria
		Posicion posicionUnAldeanoJugador2 = new Posicion (43,43);
		Posicion posicionCuartelJugador2 = new Posicion (42,42);
		juego.crearEdificioPropio(posicionUnAldeanoJugador2, posicionCuartelJugador2, 'C');
		
		juego.avanzarTurno();
		//juega Pedro
		juego.avanzarTurno();
		//juega Maria
		juego.avanzarTurno();
		//juega Pedro
		juego.crearUnidadPropia(posicionCuartelJugador1, 'A');
		juego.avanzarTurno();
		//juega Maria
		juego.avanzarTurno();
		//juega Pedro
		Arquero arquero = (Arquero)juego.obtenerPosicionableEn(new Posicion (10,9));
		arquero.posicionarEnFilaColumna(41, 42);
		juego.agregarUnidadEnFilaColumna(arquero, 41, 42);
		juego.atacar(41, 42, 42, 42);


		Aldeano aldeanoJugador2 = (Aldeano)juego.obtenerPosicionableEn(posicionUnAldeanoJugador2);
		Edificio cuartelJugador2 = (Edificio)juego.obtenerPosicionableEn(posicionCuartelJugador2);
		aldeanoJugador2.reparar(cuartelJugador2);
		cuartelJugador2.avanzarTurno();
		
		assertEquals(250, cuartelJugador2.getVida());	
		
	}
	
	@Test
	public void test08JuegoAgregaCuartelDesdeHastaYElCuartelCreaUnArqueroQueAvanzaUnaPosicion () {
		Mapa mapa = new Mapa ();
		Jugador primerJugador = new Jugador (mapa, "anto", "juan");
		Juego juego = new Juego ("anto", "juan");
		Cuartel cuartel = new Cuartel (1,1,2,2,primerJugador);
		juego.agregarEdificioDesdeHasta(cuartel, 1, 1, 2, 2);
		
		cuartel.avanzarTurno();
		cuartel.avanzarTurno ();
		cuartel.avanzarTurno();
		
		Unidad arquero = cuartel.crearUnidadPropia('A', primerJugador);
		arquero.posicionarEnFilaColumna(2, 3);
		arquero.desplazarHasta(new Posicion (2, 4));
		
		assertEquals (arquero.getPosicion().getFila(), 2);
		assertEquals (arquero.getPosicion().getColumna(), 4);
		
	}

	/*
	@Test
	public void test09JuegoAvanzaElTurnoYHaceQueElCastilloDelJugadorActualAtaqueAlArqueroAlAlcance () {
		Juego juego = new Juego ("anto", "juan");

		//jugador es anto
		juego.avanzarTurno();
		//ahora el jugador es juan
		Arquero arquero = new Arquero (4, 3);
		juego.agregarUnidadEnFilaColumna(arquero, 4, 3); //el arquero tiene 75 de vida
		juego.avanzarTurno();
		//jugador es anto
		juego.avanzarTurno();
		//el castillo de anto ubicado desde (4,4) deberia atacar al arquero de juan, le resta 20 de vida
		
		assertEquals (55, juego.obtenerPosicionableEn(new Posicion(4,3)).getVida());
		
	}
	*/
	
	
	/*
	@Test
	public void test10JuegoAvanzaElTurnoYHaceQueElCastilloDelJugadorActualAtaqueAlArqueroAlAlcance2 () {
		Juego juego = new Juego ("anto", "juan");

		//jugador es anto
		Arquero arquero = new Arquero(48,48);
		juego.agregarUnidadEnFilaColumna(arquero, 48, 48);
		juego.avanzarTurno();
		//ahora el jugador es juan
		juego.avanzarTurno(); //El castillo ataca al arquero porque esta al lado
		//jugador es anto
				
		assertEquals (55, juego.obtenerPosicionableEn(new Posicion(48,48)).getVida());
		
	}
	*/	
	
	@Test
	public void test11CrearCuartelesQueCreenArqueroYEspadachinDesplazarlosHastaQueSePuedanAtacarYAtacar () {
		
		Juego juego = new Juego ("anto", "carla");
		//juega anto
		juego.crearEdificioPropio(new Posicion (8,6), new Posicion (9,5), 'C');

		juego.avanzarTurno();
		//juega carla
		juego.avanzarTurno();
		//juega anto
		juego.avanzarTurno();
		//juega carla
		juego.avanzarTurno();
		//juega anto
		juego.crearUnidadPropia(new Posicion (9,5), 'A');
		juego.avanzarTurno();
		//juega carla
		juego.crearEdificioPropio(new Posicion (43,43), new Posicion(44,42), 'C');
		juego.avanzarTurno();
		juego.avanzarTurno();
		juego.avanzarTurno();
		juego.avanzarTurno();
		
		//juega carla
		juego.crearUnidadPropia(new Posicion (44,42), 'E');
		juego.desplazarUnidadDesdeHasta(45, 48, 44, 48);
		juego.avanzarTurno();
		
		//juega anto
		juego.desplazarUnidadDesdeHasta(10, 7, 11, 8);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(44, 48, 43, 48);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(11, 8, 12, 9);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(43, 48, 42, 47);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(12, 9, 13, 10);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(42, 47, 41, 46);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(13, 10, 14, 11);
		juego.avanzarTurno();
		//juega caela
		juego.desplazarUnidadDesdeHasta(41, 46, 40, 45);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(14, 11, 15, 12);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(40, 45, 39, 44);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(15, 12, 16, 13);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(39, 44, 38, 43);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(16, 13, 17, 14);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(38, 43, 37, 42);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(17, 14, 18, 15);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(37, 42, 36, 41);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(18, 15, 19, 16);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(36, 41, 35, 40);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(19, 16, 20, 17);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(35, 40, 34, 39);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(20, 17, 21, 18);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(34, 39, 33, 38);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(21, 18, 22, 19);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(33, 38, 32, 37);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(22, 19, 23, 20);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(32, 37, 31, 36);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(23, 20, 24, 21);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(31, 36, 30, 35);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(24, 21, 25, 22);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(30, 35, 29, 34);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(25, 22, 26, 23);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(29, 34, 28, 33);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(26, 23, 27, 24);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(28, 33, 27, 32);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(27, 24, 27, 25);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(27, 32, 27, 31);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(27, 25, 27, 26);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(27, 31, 27, 30);
		juego.avanzarTurno();
		//juego anto
		juego.desplazarUnidadDesdeHasta(27, 26, 27, 25);
		juego.avanzarTurno();
		//juega carla
		juego.desplazarUnidadDesdeHasta(27, 30, 27, 29);
		juego.avanzarTurno();
		//juega anto
		juego.desplazarUnidadDesdeHasta(27, 25, 27, 26);
		
		juego.atacar(27, 26, 27, 29);
		
		assertEquals (juego.obtenerPosicionableEn(new Posicion (27,29)).getVida(), 85);
		
		
		
	}
}
