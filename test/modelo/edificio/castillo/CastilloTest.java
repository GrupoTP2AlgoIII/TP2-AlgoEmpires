package modelo.edificio.castillo;

import modelo.unidad.Unidad;
import org.junit.Test;

import static org.junit.Assert.*;

public class CastilloTest {

    @Test
    public void test01CrearCastilloYCreoArmaAsedio() {
        Castillo sanJorge = new Castillo();
        sanJorge.avanzarTurno();
        sanJorge.avanzarTurno();
        sanJorge.avanzarTurno();
        
        Unidad escorpion = sanJorge.crearArmaAsedio();
		boolean retorno = false;
		
		if(escorpion != null) {
			retorno = true;
		}	
		assertEquals (true,retorno);
    }
}