package modelo.edificio.castillo;

import modelo.jugador.Jugador;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.Unidad;
import modelo.unidad.aldeano.Aldeano;

import org.junit.Test;

import static org.junit.Assert.*;

public class CastilloTest {

    @Test
    public void test01CrearCastilloYCreoArmaAsedio() {
        Castillo sanJorge = new Castillo();
        sanJorge.avanzarTurno();
        sanJorge.avanzarTurno();
        sanJorge.avanzarTurno();
        
        Unidad escorpion = sanJorge.crearUnidad('A');
		boolean retorno = false;
		
		if(escorpion != null) {
			retorno = true;
		}	
		assertEquals (true,retorno);
    }
    
    @Test
    public void test02CastilloAtacaSoloEnemigos(){
    	
    	Mapa mapa = new Mapa();
    	mapa.iniciarMapaVacio();
    	
    	Jugador jugador1 = new Jugador(mapa, "ABC");
    	Jugador jugador2 = new Jugador(mapa, "XYZ");
    	
    	Castillo castillo = new Castillo (10,10,13,13);
    	jugador1.agregarEdificioDesdeHasta(castillo, 10, 10, 13, 13);
    	
    	Posicion posicionAldeano = new Posicion (14,14);
    	Aldeano aldeano = new Aldeano();
    	jugador1.agregarPosicionableEnFilaColumna(aldeano, 14, 14);
    	mapa.posicionarPosicionableEnPosicion(aldeano, posicionAldeano);
    	
    	
    	Aldeano aldeanoEnemigo = new Aldeano();
    	Posicion posicionAldeanoEnemigo = new Posicion (15,15);
    	jugador2.agregarPosicionableEnFilaColumna(aldeanoEnemigo, 15, 15);
    	mapa.posicionarPosicionableEnPosicion(aldeanoEnemigo, posicionAldeanoEnemigo);
    	    	
    	castillo.atacarEnemigosAlAlcance(mapa, jugador1.getPosicionables());
    	
    	assertEquals(50, aldeano.getVida());
    	assertEquals(30, aldeanoEnemigo.getVida());
    	
    	
    }
}