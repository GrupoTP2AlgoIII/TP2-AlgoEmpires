package modelo.edificio.castillo;

import modelo.edificio.EdificiosNoSePuedenDesplazarError;
import modelo.edificio.plazaCentral.PlazaCentral;
import modelo.mapa.Mapa;
import modelo.mapa.Posicion;
import modelo.unidad.Posicionable;
import modelo.unidad.Unidad;
import modelo.unidad.espadachin.Espadachin;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
    public void test02CastilloAtacaEnemigosEnSuRango(){
    	
    	Mapa mapa = new Mapa();
    	    	
    	mapa.posicionarEnFilaColumna(new Espadachin(), 8, 8);
    	mapa.ponerEdificioDesdeHasta(new PlazaCentral(0), 8, 4, 9, 5);
    	
    	ArrayList<Posicionable> atacables = new ArrayList<Posicionable>();
    	atacables.add(mapa.obtenerPosicionableEn(new Posicion(8,8)));
    	atacables.add(mapa.obtenerPosicionableEn(new Posicion(8,4)));
    	
    	mapa.ponerEdificioDesdeHasta(new Castillo(0), 4, 4, 7, 7);
    	Castillo castillo = (Castillo) mapa.obtenerPosicionableEn(new Posicion(4,4));
    	castillo.setAtacables(atacables);
    	castillo.atacarEnemigosAlAlcance();
    	
    	assertEquals(80, mapa.obtenerPosicionableEn(new Posicion(8,8)).getVida());
    	assertEquals(430, mapa.obtenerPosicionableEn(new Posicion(8,4)).getVida()); 	
	    	
    }
    
    @Test (expected = EdificiosNoSePuedenDesplazarError.class )
    public void test03DesplazarCastilloDebeLanzarExcepcion () {
    	
    	Castillo castillo = new Castillo ();
    	castillo.desplazarHasta(new Posicion (5,5));
    	
    }
    
}