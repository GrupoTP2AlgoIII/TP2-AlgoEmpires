package modelo.juego;

import static org.junit.Assert.*;

import org.junit.Test;

//import modelo.edificio.castillo.Castillo;
import modelo.edificio.cuartel.Cuartel;
//import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.mapa.Posicion;
import modelo.unidad.aldeano.Aldeano;
//import modelo.unidad.armaDeAsedio.ArmaDeAsedio;
import modelo.unidad.arquero.Arquero;

public class JuegoTest {

	@Test // Como son inicializados sin estar ocupados devuelven 20 de oro
	public void test01IniciarJuegoInicializaAldeanosJugador1()  {
		
		Juego juego = new Juego();
		juego.iniciarJuego();
		
		for (int i = 5; i <= 7; i++) {
			Posicion posicion = new Posicion (5, i);
			assertEquals(20, juego.obtenerPosicionableEn(posicion).avanzarTurno());
		}
		
	}
	
	@Test
	public void test02IniciarJuegoInicializaAldeanosJugador2()  {
		
		Juego juego = new Juego();
		juego.iniciarJuego();
		
		for (int i = 44; i <= 46; i++) {
			Posicion posicion = new Posicion (46, i);
			assertEquals(20, juego.obtenerPosicionableEn(posicion).avanzarTurno());
		}
	}
	
	@Test
	public void test03IniciarJuegoInicializaCastilloJugador1() {
		
		Juego juego = new Juego();
		juego.iniciarJuego();

		for (int i = 1; i <= 4; i++){
			for (int j = 1; j <= 4; j++){
				Posicion posicion = new Posicion (i,j);
				assertTrue(juego.obtenerPosicionableEn(posicion).estaOcupado());

			}
		}
	}
	
	@Test
	public void test04IniciarJuegoInicializaCastilloJugador2() {
		
		Juego juego = new Juego();
		juego.iniciarJuego();

		for (int i = 47; i <= 50; i++){
			for (int j = 47; j <= 50; j++){
				Posicion posicion = new Posicion (i,j);
				assertTrue(juego.obtenerPosicionableEn(posicion).estaOcupado());

			}
		}
	}
	
	@Test
	public void test05IniciarJuegoInicializaPlazaCentralJugador1() {
		
		Juego juego = new Juego();
		juego.iniciarJuego();

		for (int i = 1; i <= 2; i++){
			for (int j = 8; j <= 9; j++){
				Posicion posicion = new Posicion (i,j);
				assertTrue(juego.obtenerPosicionableEn(posicion).estaOcupado());

			}
		}
		
	}
	
	@Test
	public void test06IniciarJuegoInicializaPlazaCentralJugador2() {
		
		Juego juego = new Juego();
		juego.iniciarJuego();

		for (int i = 49; i <= 50; i++){
			for (int j = 42; j <= 43; j++){
				Posicion posicion = new Posicion (i,j);
				assertTrue(juego.obtenerPosicionableEn(posicion).estaOcupado());

			}
		}
		
	}
	
	@Test //Verifica que no hay que pasar de turno para crear aldeano
	public void test07IniciarJuegoInicializaPlazaCentralConstruidaJugador1()  {
		
		Juego juego = new Juego();
		juego.iniciarJuego();
		
		Arquero arquero = new Arquero(5,5);
		Cuartel cuartel = new Cuartel(3,3,4,4);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		arquero.atacar(cuartel); // le resta vida
				
		Posicion posicionPlaza = new Posicion (2,9);
		Aldeano aldeano = (Aldeano)juego.obtenerPosicionableEn(posicionPlaza).crearUnidad('A'); // se puede crear aldeano
		
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
		
		assertEquals(250, cuartel.getVida());	// el aldeano creado reparo el cuartel
		
	}
	
	@Test 
	public void test08IniciarJuegoInicializaPlazaCentralConstruidaJugador2() {
		
		
		Juego juego = new Juego();
		juego.iniciarJuego();
		
		Arquero arquero = new Arquero(12, 12);
		Cuartel cuartel = new Cuartel(10, 10, 11, 11);
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		cuartel.avanzarTurno();
		
		arquero.atacar(cuartel);
				
		Posicion posicionPlaza = new Posicion (50,43); //con (fila, columna)
		Aldeano aldeano = (Aldeano)juego.obtenerPosicionableEn(posicionPlaza).crearUnidad('A');
		
		aldeano.reparar(cuartel);
		cuartel.avanzarTurno();
		
		assertEquals(250, cuartel.getVida());	
		
	}
	
//	@Test 
//	public void test09IniciarJuegoInicializaCastilloConstruidoJugador1() throws PosicionFueraDelMapaError, PosicionOcupadaError, TamanioIncorrectoError, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
//		
//		
//		Juego juego = new Juego();
//		juego.iniciarJuego();
//		
//		PlazaCentral plazaCentral = new PlazaCentral();
//		Posicion posicionCastillo = new Posicion (2,2);
//				
//		Castillo castillo = (Castillo)juego.obtenerPosicionableEn(posicionCastillo);
//		ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio) castillo.crearArmaAsedio();
//		
//		armaDeAsedio.atacar(plazaCentral); // le resta 75 de vida y por defecto tiene 450
//		
//		assertEquals(375, plazaCentral.getVida());	
//		
//	}
//	
//	@Test 
//	public void test10IniciarJuegoInicializaCastilloConstruidoJugador2() throws PosicionFueraDelMapaError, PosicionOcupadaError, TamanioIncorrectoError, AtacandoEnPosicionFueraDelAlcanceError, AldeanoNoPuedeAtacarError {
//		
//		
//		Juego juego = new Juego();
//		juego.iniciarJuego();
//		
//		PlazaCentral plazaCentral = new PlazaCentral();
//		Posicion posicionCastillo = new Posicion (49,49);
//				
//		Castillo castillo = (Castillo)juego.obtenerPosicionableEn(posicionCastillo);
//		ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio) castillo.crearArmaAsedio();
//		
//		armaDeAsedio.atacar(plazaCentral); // le resta 75 de vida y por defecto tiene 450
//		
//		assertEquals(375, plazaCentral.getVida());	
//		
//	}
}
