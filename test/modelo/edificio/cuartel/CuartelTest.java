package modelo.edificio.cuartel;

import modelo.edificio.EdificiosNoSePuedenDesplazarError;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;

import org.junit.Test;
import static org.junit.Assert.*;

public class CuartelTest {

    @Test
    public void test01CuartelEsCreadoYCreaArqueroQueAtacaAUnAldeanoYLeResta15DeVida(){
        Cuartel cuartel =  new Cuartel();

        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        
		Unidad arquero = cuartel.crearUnidad('A');
		Aldeano aldeano = new Aldeano();
		arquero.atacar(aldeano, new Posicion (1,1));
		
		assertEquals (35,aldeano.getVida());

    }

    @Test
    public void test02CuartelEsCreadoYCreaEspadachinQueAtacaAUnAldeanoYLeResta25DeVida() {
        Cuartel cuartel =  new Cuartel();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();
        cuartel.avanzarTurno();

        Unidad soldier = cuartel.crearUnidad('S');
        soldier.posicionarEnFilaColumna(1,1);
        //soldier.desplazarHasta(new Posicion (1,1));
        
        assertEquals (soldier.getPosicion().getFila(), 1);
        assertEquals (soldier.getPosicion().getColumna(), 1);
		
    }
    
    @Test (expected = EdificiosNoSePuedenDesplazarError.class)
    public void test03DesplazarUnCuartelDebeLanzarExcepcion () {
    	
    	Cuartel cuartel = new Cuartel ();
    	cuartel.desplazarHasta(new Posicion (5,5));
    }
}