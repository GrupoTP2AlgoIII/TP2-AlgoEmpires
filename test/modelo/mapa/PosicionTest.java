//Prueba2
package modelo.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class PosicionTest {
	
	@Test
	public void test01creoPosicionesIgualesYSonIguales() {

		Posicion posicion1 = new Posicion (1,1);
		Posicion posicion2 = new Posicion (1,1);

		assertEquals(posicion1, posicion2);
	}
	
	@Test
	public void test02PosicionQuePerteneceALaCuadricula () {
		
		Posicion posicion = new Posicion (4,4);
		
		assertTrue (posicion.perteneceALaCuadricula(new Posicion (3,3), 1, 1));
	}
	
	@Test
	public void test03PosicionQuePerteneceALaCuadricula () {
		
		Posicion posicion = new Posicion (4,4);
		
		assertTrue (posicion.perteneceALaCuadricula(new Posicion (3,4), 1, 1));
	}
	
	@Test
	public void test04PosicionQuePerteneceALaCuadricula () {
		
		Posicion posicion = new Posicion (4,4);
		
		assertTrue (posicion.perteneceALaCuadricula(new Posicion (5,5), 1, 1));
	}
	
	@Test
	public void test05PosicionQueNoPerteneceALaCuadricula () {
		
		Posicion posicion = new Posicion (4,4);
		
		assertFalse (posicion.perteneceALaCuadricula(new Posicion (6,3), 1, 1));
	}
	
	@Test
	public void test06PosicionQueNoPerteneceALaCuadricula () {
		
		Posicion posicion = new Posicion (4,4);
		
		assertFalse (posicion.perteneceALaCuadricula(new Posicion (3,6), 1, 1));
	}
	
	@Test
	public void test07PosicionQueNoPerteneceALaCuadricula () {
		
		Posicion posicion = new Posicion (4,4);
		
		assertFalse (posicion.perteneceALaCuadricula(new Posicion (2,3), 1, 1));
	}
	
	@Test
	public void test08PosicionQueNoPerteneceALaCuadricula () {
		
		Posicion posicion = new Posicion (4,4);
		
		assertFalse (posicion.perteneceALaCuadricula(new Posicion (6,3), 1, 1));
	}
	
	@Test (expected = PosicionNoAdyacenteError.class)
	public void test09PosicionNoEsAdyacenteAOtraPosicion () {
		Posicion posicion = new Posicion (1,1);
		Posicion otraPosicion = new Posicion (1,3);
		posicion.comprobarAdyacencia(otraPosicion);
	}
	
	@Test (expected = PosicionNoAdyacenteError.class)
	public void test10PosicionNoEsAdyacenteAOtraPosicion () {
		Posicion posicion = new Posicion (1,1);
		Posicion otraPosicion = new Posicion (3,1);
		posicion.comprobarAdyacencia(otraPosicion);
	}
	
	@Test (expected = PosicionNoAdyacenteError.class)
	public void test11PosicionNoEsAdyacenteAOtraPosicion () {
		Posicion posicion = new Posicion (1,1);
		Posicion otraPosicion = new Posicion (5,5);
		posicion.comprobarAdyacencia(otraPosicion);
	}
}
