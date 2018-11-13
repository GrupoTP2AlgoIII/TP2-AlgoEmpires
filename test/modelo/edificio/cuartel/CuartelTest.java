package modelo.edificio.cuartel;

import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;
import org.junit.Test;
import static org.junit.Assert.*;

public class CuartelTest {

    @Test
    public void test01CuartelEsCreadoYCreaArquero() {
        Cuartel cuartel =  new Cuartel();
        cuartel.avanzarTurno();;
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        Arquero robin = cuartel.crearArquero();
        assertEquals(robin.getClass(),  (Arquero.class));

    }

    @Test
    public void test02CuartelEsCreadoYCreaEspadachin() {
        Cuartel cuartel =  new Cuartel();
        cuartel.avanzarTurno();;
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        Espadachin soldier = cuartel.crearEspadachin();
        assertEquals(soldier.getClass(),  (Espadachin.class));
    }
}