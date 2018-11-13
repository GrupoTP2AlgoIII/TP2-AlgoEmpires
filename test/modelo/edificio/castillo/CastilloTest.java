package modelo.edificio.castillo;

import modelo.unidad.armaDeAsedio.ArmaDeAsedio;
import org.junit.Test;

import static org.junit.Assert.*;

public class CastilloTest {

    @Test
    public void test01CrearCastilloYCreoArmaAsedio() {
        Castillo sanJorge = new Castillo();
        ArmaDeAsedio escorpion = sanJorge.crearArmaAsedio();
        assertEquals(escorpion.getClass(),  (ArmaDeAsedio.class));
    }
}