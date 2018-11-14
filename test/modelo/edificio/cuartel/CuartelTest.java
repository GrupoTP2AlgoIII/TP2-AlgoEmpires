package modelo.edificio.cuartel;

import modelo.unidad.Unidad;
import modelo.unidad.arquero.Arquero;
import modelo.unidad.espadachin.Espadachin;
import org.junit.Test;
import static org.junit.Assert.*;

public class CuartelTest {

    @Test
    public void test01CuartelEsCreadoYCreaArquero() {
        Cuartel cuartel =  new Cuartel(450);

		Unidad arquero = cuartel.crearArquero();
		boolean retorno = false;
		if(arquero != null) {
			retorno = true;
		}	
		assertEquals (false,retorno);

    }

    @Test
    public void test02CuartelEsCreadoYCreaEspadachin() {
        Cuartel cuartel =  new Cuartel(450);

        Espadachin soldier = cuartel.crearEspadachin();
        assertEquals(soldier.getClass(),  (Espadachin.class));
    }
}