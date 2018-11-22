package modelo.edificio.cuartel;

import modelo.ataque.AtacandoEnPosicionFueraDelAlcanceError;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;
import modelo.unidad.aldeano.AldeanoNoPuedeAtacarError;

import org.junit.Test;
import static org.junit.Assert.*;

public class CuartelTest {

    @Test
    public void test01CuartelEsCreadoYCreaArqueroQueAtacaAUnAldeanoYLeResta15DeVida() throws AldeanoNoPuedeAtacarError, AtacandoEnPosicionFueraDelAlcanceError {
        Cuartel cuartel =  new Cuartel();

        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        
		Unidad arquero = cuartel.crearArquero();
		Aldeano aldeano = new Aldeano();
		arquero.atacar(aldeano);
		
		assertEquals (35,aldeano.getVida());

    }

    @Test
    public void test02CuartelEsCreadoYCreaEspadachinQueAtacaAUnAldeanoYLeResta25DeVida() throws AldeanoNoPuedeAtacarError, AtacandoEnPosicionFueraDelAlcanceError {
        Cuartel cuartel =  new Cuartel();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        Unidad soldier = cuartel.crearEspadachin();
		Aldeano aldeano = new Aldeano();
		soldier.atacar(aldeano);
		
		assertEquals (25,aldeano.getVida());
		
    }
}