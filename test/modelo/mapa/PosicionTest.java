//Prueba2
package modelo.mapa;

import static org.junit.Assert.*;

import org.junit.Test;

public class PosicionTest {
	
	@Test
	public void creoPosicionesIgualesYSonIguales() {

		Posicion posicion1 = new Posicion (1,1);
		Posicion posicion2 = new Posicion (1,1);

		assertEquals(posicion1, posicion2);
	}
}
